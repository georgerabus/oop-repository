public class Play {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore();
        String generatorPath = "lab3/src/main/generator.py";
        String readFolderPath = "lab3/src/main/queue";

        Scheduler scheduler = new Scheduler(semaphore, generatorPath , readFolderPath);
        scheduler.start();
    }
}
