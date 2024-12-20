import java.util.NoSuchElementException;

public class LinearQueue<T> implements Queue<T>{

    private int front, rear, size;
    private T[] nums;

    public LinearQueue(int size){
        this.front = this.rear = -1;
        this.size = size;
        this.nums = (T[]) new Object[size];
    }

    @Override
    public void enqueue(T item) {
        if (isFull())
            throw new IllegalStateException();
        if (isEmpty())
            front++;
        nums[++rear] = item;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        T temp = nums[front];
        if (front == rear)
            front = rear = -1;
        else
            front++;
        return temp;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return nums[front];
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public boolean isFull() {
        return rear == nums.length -1;
    }
}
