public interface Queue<T> {
    /**
     * Inserts the specified element into this queue.
     * @param element the element to add
     * @throws IllegalStateException if the element cannot be added due to capacity restrictions
     */
    void enqueue(T element);

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     * @return the head of the queue, or null if empty
     */
    T dequeue();

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     * @return the head of the queue, or null if empty
     */
    T peek();

    /**
     * Returns true if this queue contains no elements.
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this queue.
     * @return the size of the queue
     */
    int size();
}
