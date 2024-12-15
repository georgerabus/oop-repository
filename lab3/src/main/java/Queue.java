public interface Queue<T> {
   void enqueue(T element);
   T dequeue();
   T peek();
   boolean isEmpty();
   boolean isFull();
   int size();
   void display();
}