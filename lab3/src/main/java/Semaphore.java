import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Semaphore {
    private File[] files;

    private final CarStation station1;
    private final CarStation station2;
    private final CarStation station3;
    private final CarStation station4;

    private int electricConsumption = 0;
    private int gasConsumption = 0;
    private int peoplePassengers = 0;
    private int robotsPassengers = 0;

    public Semaphore() {

        // At first, I thought all the cars go in a single queue
//      String priorityFuel = "Electric";
//      String priorityDining = "People";
//      Queue<Car> queue = new PriorityQueue<>(30, new ObjectComparator(priorityFuel, priorityDining));

        Queue<Car> queue1 = new LinearQueue<>(30);
        Queue<Car> queue2 = new LinearQueue<>(30);
        Queue<Car> queue3 = new LinearQueue<>(30);
        Queue<Car> queue4 = new LinearQueue<>(30);

        this.station1 = new CarStation(queue1, new GasStation(), new PeopleDinner());
        this.station2 = new CarStation(queue2, new GasStation(), new RobotsDinner());
        this.station3 = new CarStation(queue3, new ElectricStation(), new PeopleDinner());
        this.station4 = new CarStation(queue4, new ElectricStation(), new RobotsDinner());
    }

    public void handleCars() {
        ObjectMapper objectMapper = new ObjectMapper();

        for (File file : files) {
            try {
                String content = Files.readString(file.toPath());
                Car carObj = objectMapper.readValue(content, Car.class);

                // distributing the cars
                if (carObj.getType().equals("GAS") && carObj.getPassengers().equals("PEOPLE")) {
                    station1.addCar(carObj);
                    System.out.println("added car " + carObj.getId() + " to station 1");
                } else if (carObj.getType().equals("GAS") && carObj.getPassengers().equals("ROBOTS")) {
                    station2.addCar(carObj);
                    System.out.println("added car " + carObj.getId() + " to station 2");
                } else if (carObj.getType().equals("ELECTRIC") && carObj.getPassengers().equals("PEOPLE")) {
                    station3.addCar(carObj);
                    System.out.println("added car " + carObj.getId() + " to station 3");
                } else if (carObj.getType().equals("ELECTRIC") && carObj.getPassengers().equals("ROBOTS")) {
                    station4.addCar(carObj);
                    System.out.println("added car " + carObj.getId() + " to station 4");
                }

                // consumption calculation
                if (carObj.getType().equals("ELECTRIC")) {
                    electricConsumption += carObj.getConsumption();
                } else if (carObj.getType().equals("GAS")) {
                    gasConsumption += carObj.getConsumption();
                }

                // passengers types count calculation
                if (carObj.getPassengers().equals("PEOPLE")) {
                    peoplePassengers++;
                } else if (carObj.getPassengers().equals("ROBOTS")) {
                    robotsPassengers++;
                }

            } catch (IOException e) {
                throw new RuntimeException("Failed to read or parse file: " + file.getName(), e);
            }
        }
        station1.serveCars();
        station2.serveCars();
        station3.serveCars();
        station4.serveCars();
    }

    public void readFiles(String folderPath) {
        File folder = new File(folderPath);
        this.files = folder.listFiles((_, name) -> name.endsWith(".json"));
        if (files == null || files.length == 0) {
            throw new RuntimeException("No JSON files found in folder: " + folderPath);
        }
    }

    public int getElectricConsumption(){
        return electricConsumption;
    }

    public int getGasConsumption(){
        return gasConsumption;
    }

    public int getPeoplePassengers(){
        return peoplePassengers;
    }

    public int getRobotsPassengers(){
        return robotsPassengers;
    }
}
