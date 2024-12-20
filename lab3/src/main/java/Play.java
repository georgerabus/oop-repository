public class Play {
    public static void main(String[] args) {
//        Semaphore semaphore = new Semaphore();
//        String generatorPath = "lab3/src/main/generator.py";
//        String readFolderPath = "lab3/src/main/queue";
//
//        Scheduler scheduler = new Scheduler(semaphore, generatorPath , readFolderPath);
//        scheduler.start();


        Semaphore semaphore = new Semaphore();
        String folderPath = "lab3/src/main/queue";
        semaphore.readFiles(folderPath);
        semaphore.handleCars();

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
