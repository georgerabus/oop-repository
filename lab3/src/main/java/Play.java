import java.util.List;
public class Play {
    public static void main(String[] args){
        String priorityFuel = "Electric";
        String priorityDining = "People";

        Queue<Car> queue1 = new PriorityQueue<>(30, new ObjectComparator(priorityFuel, priorityDining));
        Queue<Car> queue2 = new PriorityQueue<>(30, new ObjectComparator(priorityFuel, priorityDining));
        Queue<Car> queue3 = new PriorityQueue<>(30, new ObjectComparator(priorityFuel, priorityDining));
        Queue<Car> queue4 = new PriorityQueue<>(30, new ObjectComparator(priorityFuel, priorityDining));

        CarStation station1 = new CarStation(queue1, new GasStation(), new PeopleDinner());
        CarStation station2 = new CarStation(queue2, new GasStation(), new RobotsDinner());
        CarStation station3 = new CarStation(queue3, new ElectricStation(), new PeopleDinner());
        CarStation station4 = new CarStation(queue4, new ElectricStation(), new RobotsDinner());

        List<Car> cars = List.of(
                new Car(1, "Gas", "People", "yes"),
                new Car(2, "Electric", "Robots", "no"),
                new Car(3, "Electric", "Robots", "yes"),
                new Car(4, "Electric", "People","no" ),
                new Car(5, "Gas", "People", "no"),
                new Car(6, "Gas", "Robots", "no"),
                new Car(7, "Gas", "People", "yes")
                );

        station1.addCar(cars.get(0));
        System.out.println(cars.get(0));
//        station4.addCar(cars.get(1));
        station4.addCar(cars.get(2));
        System.out.println(cars.get(2));
//        station3.addCar(cars.get(3));
//        station1.addCar(cars.get(4));
//        station2.addCar(cars.get(5));
//        station1.addCar(cars.get(6));

        station1.serveCars();
//        station2.serveCars();
//        station3.serveCars();
        station4.serveCars();

        System.out.println("=== Final Statistics ===");
        System.out.println("Total people served: " + PeopleDinner.getCount());
        System.out.println("Total robots served: " + RobotsDinner.getCount());
        System.out.println("Total cars refueled with gas: " + GasStation.getCount());
        System.out.println("Total cars recharged with electricity: " + ElectricStation.getCount());

    }
}

//        for (Car car : cars) {
//            carStation.addCar(car);
//        }
//        carStation.serveCars();
