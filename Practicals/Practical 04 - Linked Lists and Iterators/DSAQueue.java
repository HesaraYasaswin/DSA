import java.util.Iterator;

public class DSAQueue<E> implements Iterable<E> {
    private DSALinkedList<E> list;

    public DSAQueue() {
        list = new DSALinkedList<E>();
    }

    public void enqueue(E value) {   // Adds an element to the end of the queue
        list.insertLast(value);
    }

    public E dequeue() { // Removes and returns the element at the front of the queue
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (E) list.removeFirst();
    }

    public E peek() { // Returns the element at the front of the queue without removing it
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (E) list.peekFirst();
    }

    public boolean isEmpty() { // Checks if the queue is empty
        return list.isEmpty();
    }

    @Override
    public Iterator<E> iterator() { // Returns an iterator over the elements in the queue, in the order they would be dequeued
        return list.iterator();
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        // Traverse the linked list from front to back and append each item to the StringBuilder
        Iterator<E> iter = list.iterator();
        while (iter.hasNext())
        {
            sb.append(iter.next().toString()).append(" ");
        }

        return sb.toString();
    }
}
