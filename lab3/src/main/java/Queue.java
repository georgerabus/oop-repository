public interface Queue<T> {
   public void enqueue(T element);
   public T dequeue();
   public T peek();
   public boolean isEmpty();
   public boolean isFull();
   public void display();
}