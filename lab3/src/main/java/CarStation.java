import java.util.List;
public class CarStation {
    public static void main(String[] args){
        String priorityFuel = "Electric";
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

        Refuelable gasstation = new GasStation();
        Refuelable electricstation = new GasStation();
        Dineable peopledinner = new PeopleDinner();
        Dineable rpbptsdinner = new PeopleDinner();

        gasstation.refuel("1");
        peopledinner.serveDinner("1", "no");
        peopledinner.serveDinner("2", "yes");
        peopledinner.serveDinner("3", "no");
        peopledinner.serveDinner("4", "yes");



        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
