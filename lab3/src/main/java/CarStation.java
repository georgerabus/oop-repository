import java.util.List;

public class CarStation {
    public static void main(String[] args){
        Queue<testObj> queue = new PriorityQueue<>(7, new ObjectComparator());
        List<testObj> numbers = List.of(
                new testObj("Gas", "People"),
                new testObj("Electric", "Robots"),
                new testObj("Electric", "Robots"),
                new testObj("Electric", "People"),
                new testObj("Gas", "People"),
                new testObj("Gas", "Robots"),
                new testObj("Gas", "People")
                );

        for (testObj number : numbers) {
            queue.enqueue(number);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
