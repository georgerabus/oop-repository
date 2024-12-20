import java.util.List;
public class Play {
    public static void main(String[] args){
        String priorityFuel = "Electric";
        String priorityDining = "People";

        Queue<Car> queue = new PriorityQueue<>(30, new ObjectComparator(priorityFuel, priorityDining));

        CarStation carStation = new CarStation(queue);

        List<Car> cars = List.of(
                new Car(1, "Gas", "People", "yes"),
                new Car(2, "Electric", "Robots", "no"),
                new Car(3, "Electric", "Robots", "yes"),
                new Car(4, "Electric", "People","no" ),
                new Car(5, "Gas", "People", "no"),
                new Car(6, "Gas", "Robots", "no"),
                new Car(7, "Gas", "People", "yes")
                );

        for (Car car : cars) {
            carStation.addCar(car);
        }
        carStation.serveCars();
    }
}
