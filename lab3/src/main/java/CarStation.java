import java.util.List;

public class CarStation {
    public static void main(String[] args){
        Queue<Integer> queue = new CircularQueue<>(5);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        for (int number : numbers) {
            queue.enqueue(number);
        }

        System.out.println(queue.peek());
        queue.dequeue();
        System.out.println(queue.peek());
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.peek());

    }
}
