import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private final Semaphore semaphore;
    private final String folderPath;
    private final String generatorPath;
    private boolean generatorFinished;
    private final ScheduledExecutorService scheduler;

    public Scheduler(Semaphore semaphore, String generatorPath, String folderPath) {
        this.semaphore = semaphore;
        this.folderPath = folderPath;
        this.generatorPath = generatorPath;
        this.generatorFinished = false;
        this.scheduler = Executors.newScheduledThreadPool(2);
    }

    public void start() {
        scheduleGeneratorTask();
        scheduleReaderTask();
        addShutdownHook();
    }

    private void scheduleGeneratorTask() {
        Runnable generateTask = () -> {
            try {
                System.out.println("\n[Generator] Running Python generator...");
                ProcessBuilder processBuilder = new ProcessBuilder("python3", generatorPath);
                processBuilder.inheritIO(); // output python script to the console
                Process process = processBuilder.start();
                process.waitFor();
                synchronized (this) {
                    generatorFinished = true;
                }
                System.out.println("[Generator] Finished generating files.");
            } catch (Exception e) {
                System.err.println("[Error] Failed to run Python generator: " + e.getMessage());
                synchronized (this) {
                    generatorFinished = true;
                }
            }
        };
        scheduler.schedule(generateTask, 0, TimeUnit.SECONDS);
    }

    private void scheduleReaderTask() {
        Runnable readTask = () -> {
            File folder = new File(folderPath);
            File[] files = folder.listFiles((_, name) -> name.endsWith(".json"));

            boolean isGeneratorDone;
            synchronized (this) {
                isGeneratorDone = generatorFinished;
            }

            // Check if the generator is finished and no more files are present
            if (isGeneratorDone && (files == null || files.length == 0)) {
                System.out.println("[Reader] No more files to process. Stopping reader task.");
                scheduler.shutdown();
                return;
            }

            // Process files if present
            if (files == null || files.length == 0) {
                System.out.println("[Reader] No new files to process.");
                return;
            }

            for (File file : files) {
                // Skip already processed files
                if (file.getName().endsWith(".processed")) {
                    continue;
                }


                semaphore.readFiles(folderPath);
                semaphore.handleCars();


                // Rename the file to mark it as processed
                File processedFile = new File(file.getParent(), file.getName() + ".processed");
                if (file.renameTo(processedFile)) {
                    System.out.println("[Reader] Processed and renamed file: " + file.getName());
                } else {
                    System.err.println("[Reader] Failed to rename file: " + file.getName());
                }
            }
        };

        scheduler.scheduleAtFixedRate(readTask, 1, 1, TimeUnit.SECONDS);
    }


    private void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                    scheduler.shutdownNow();
                }
                displayFinalStatistics();
            } catch (InterruptedException e) {
                scheduler.shutdownNow();
            }
        }));
    }

    private void displayFinalStatistics() {
        System.out.println("\n=== Final Statistics ===");
        System.out.println("Total cars recharged with electricity: " + ElectricStation.getCount());
        System.out.println("Total cars refueled with gas: " + GasStation.getCount());
        System.out.println("Total passengers types: People - " + semaphore.getPeoplePassengers() + ", Robots - " + semaphore.getRobotsPassengers());
        System.out.println("Total passengers dine preference: Dining - " + CarStation.getDining() + ", Not Dining - " + CarStation.getNot_dining());
        System.out.println("Total people served: " + PeopleDinner.getCount());
        System.out.println("Total robots served: " + RobotsDinner.getCount());
        System.out.println("Total consumption: Electric - " + semaphore.getElectricConsumption() + ", Gas - " + semaphore.getGasConsumption());
    }
}
