import java.util.List;
public class CarStation {
    public static void main(String[] args){
        String priorityFuel = "Gas";
        String priorityDining = "People";

        Queue<testObj> queue = new PriorityQueue<>(7, new ObjectComparator(priorityFuel, priorityDining));
        List<testObj> numbers = List.of(
                new testObj(1,"Gas", "People", "yes"),
                new testObj(2,"Electric", "Robots", "no"),
                new testObj(3, "Electric", "Robots", "yes"),
                new testObj(4,"Electric", "People","no" ),
                new testObj(5, "Gas", "People", "no"),
                new testObj(6, "Gas", "Robots", "no"),
                new testObj(7,"Gas", "People", "yes")
                );

        for (testObj number : numbers) {
            queue.enqueue(number);
        }

        GasStation station = new GasStation();
        station.refuel("1");

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
