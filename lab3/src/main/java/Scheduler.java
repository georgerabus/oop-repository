import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private final Semaphore semaphore;
    private final String folderPath;
    private final String generatorPath;
    private boolean generatorFinished;
    private final ScheduledExecutorService scheduler;
    private final Set<String> processedFiles;

    public Scheduler(Semaphore semaphore, String generatorPath, String folderPath) {
        this.semaphore = semaphore;
        this.folderPath = folderPath;
        this.generatorPath = generatorPath;
        this.generatorFinished = false;
        this.scheduler = Executors.newScheduledThreadPool(2);
        this.processedFiles = new HashSet<>();
    }

    public void start() {
        scheduleGeneratorTask();
        scheduleReaderTask();
        addShutdownHook();
    }

    private synchronized void setGeneratorFinished(boolean value) {
        this.generatorFinished = value;
    }

    private synchronized boolean isGeneratorFinished() {
        return this.generatorFinished;
    }

    private void scheduleGeneratorTask() {
        Runnable generateTask = () -> {
            try {
                System.out.println("\n[Generator] Running Python generator...");
                ProcessBuilder processBuilder = new ProcessBuilder("python3", generatorPath);
                processBuilder.inheritIO(); // output python script to the console
                Process process = processBuilder.start();
                process.waitFor();
                setGeneratorFinished(true);
                System.out.println("[Generator] Finished generating files.");
            } catch (Exception e) {
                System.err.println("[Error] Failed to run Python generator: " + e.getMessage());
                setGeneratorFinished(true);
            }
        };
        scheduler.schedule(generateTask, 0, TimeUnit.SECONDS);
    }

    private void scheduleReaderTask() {
        Runnable readTask = () -> {
            File folder = new File(folderPath);
            File[] files = folder.listFiles((_, name) -> name.endsWith(".json"));

            if (isGeneratorFinished()) {
                if (files == null || allFilesProcessed(files)) {
                    System.out.println("[Reader] No new files to process. Stopping reader task.");
                    scheduler.shutdown();
                    return;
                }
            }

            if (files == null || files.length == 0) {
                System.out.println("[Reader] No new files to process.");
                return;
            }

            File[] unprocessed = Arrays.stream(files)
                    .filter(f -> !processedFiles.contains(f.getName()) && isFileReady(f))
                    .toArray(File[]::new);

            if (unprocessed.length == 0) {
                return;
            }

            semaphore.readFiles(folderPath);

            File[] allSemaphoreFiles = semaphore.files;
            File[] filteredFiles = Arrays.stream(allSemaphoreFiles)
                    .filter(f -> !processedFiles.contains(f.getName()))
                    .toArray(File[]::new);

            semaphore.files = filteredFiles;

            if (filteredFiles.length > 0) {
                semaphore.handleCars();

                for (File f : filteredFiles) {
                    processedFiles.add(f.getName());
                }
            }
        };

        scheduler.scheduleAtFixedRate(readTask, 1, 1, TimeUnit.SECONDS);
    }

    private boolean allFilesProcessed(File[] files) {
        for (File file : files) {
            if (!processedFiles.contains(file.getName())) {
                return false;
            }
        }
        return true;
    }

    private boolean isFileReady(File file) {
        return file.length() > 0 && file.lastModified() < System.currentTimeMillis() - 500;
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
        System.out.println("Total consumption: Electric - " + semaphore.getElectricConsumption() + ", Gas - " + semaphore.getGasConsumption());
    }
}
