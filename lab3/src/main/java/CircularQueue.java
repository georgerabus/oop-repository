import java.util.NoSuchElementException;

public class CircularQueue<T> implements Queue<T>{

    private int front, rear, size;
    private T[] nums;

    public CircularQueue(int initialSize){
        this.front = this.rear = -1;
        this.size = initialSize;
        this.nums = (T[]) new Object[size];
    }

    @Override
    public void enqueue(T item) {
        if (isFull())
            resize();
        else if (isEmpty())
            front++;
        rear = (rear + 1) % nums.length;
        nums[rear] = item;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        T temp = nums[front];
        if (front == rear)
            front = rear = -1;
        else
            front = (front + 1) % nums.length;
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
        return (rear+1) % nums.length == front;
    }

    public void resize(){
        T[] tempArr = (T[]) new Object[nums.length * 2];
        int i = 0;
        int j = front;

        do {
            tempArr[i++] = nums[j];
            j = (j+1) % nums.length;
        } while (j != front);

        front = 0;
        rear = nums.length - 1;
        nums = tempArr;
    }
}
