import java.util.Iterator;



public class DSAQueue implements Iterable
{
    private DSALinkedList queue;
    
    public DSAQueue() {
        this.queue = new DSALinkedList();
    }
    
    public int getCount() {
        int n = 0;
        final Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            ++n;
        }
        return n;
    }
    
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }
    
    public void enqueue(final Object o) {
        this.queue.insertLast(o);
    }
    
    public Object dequeue() {
        return this.queue.removeFirst();
    }
    
    public Object peek() {
        return this.queue.peekFirst();
    }
    
    @Override
    public Iterator iterator() {
        return this.queue.iterator();
    }
}