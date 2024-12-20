import java.util.ArrayList;
import java.util.Comparator;

public class PriorityQueue<T> implements Queue<T> {
    private ArrayList<Node> heap;
    private Comparator<T> comparator;
    private int maxSize;
    private long insertionCounter; // To keep track of insertion order

    // A private inner class that stores the item and its insertion order
    private class Node {
        T item;
        long order; // smaller means inserted earlier

        Node(T item, long order) {
            this.item = item;
            this.order = order;
        }
    }

    // Comparator that first uses the user-provided comparator,
    // then falls back on insertion order if tie
    private Comparator<Node> nodeComparator = (n1, n2) -> {
        int cmp = comparator.compare(n1.item, n2.item);
        if (cmp == 0) {
            // If items are "equal" by the given comparator, use insertion order
            return Long.compare(n1.order, n2.order);
        }
        return cmp;
    };

    public PriorityQueue(int maxSize, Comparator<T> comparator) {
        this.maxSize = maxSize;
        this.comparator = comparator;
        this.heap = new ArrayList<>();
        this.insertionCounter = 0;
    }

    @Override
    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Priority Queue is full");
        }
        Node node = new Node(item, insertionCounter++);
        heap.add(node);
        heapifyUp(heap.size() - 1);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty");
        }
        Node root = heap.get(0);
        Node lastElement = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }

        return root.item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty");
        }
        return heap.get(0).item;
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public boolean isFull() {
        return heap.size() >= maxSize;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (nodeComparator.compare(heap.get(index), heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int leftChild, rightChild, smallest;

        while (true) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            smallest = index;

            if (leftChild < heap.size() &&
                    nodeComparator.compare(heap.get(leftChild), heap.get(smallest)) < 0) {
                smallest = leftChild;
            }

            if (rightChild < heap.size() &&
                    nodeComparator.compare(heap.get(rightChild), heap.get(smallest)) < 0) {
                smallest = rightChild;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        Node temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
