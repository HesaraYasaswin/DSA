public class DSAQueue {
	
	// Protected Classfields
    protected Object[] queue; // an array to hold the elements in the queue
    protected int count; // the number of elements in the queue
    
    // Class Constants
    private static final int DEFAULT_CAPACITY = 100; // the default capacity of the queue
    
    // Default constructor
    public DSAQueue() {
        queue = new Object[DEFAULT_CAPACITY]; // initialize the queue array with the default capacity
        count = 0; 
    }
    
    // Alternate constructor
    public DSAQueue(int maxCapacity) {
        queue = new Object[maxCapacity]; // initialize the queue array with the given capacity
        count = 0; 
    }
    
    // Accessor for count field
    public int getCount() {
        return count; 
    }
    
    // Accessor for empty field
    public boolean isEmpty() {
        return count == 0; 
    }
    
    // Accessor for full field
    public boolean isFull() {
        return count == queue.length; // returns true if the queue is full (count is equal to the length of the queue array), false otherwise
    }
    
    // Mutator for enqueue operation
    public void enqueue(Object value) {
        if (isFull()) {
            throw new RuntimeException("Queue overflow"); // throws an exception if the queue is full and cannot accept any more elements
        } else {
            queue[count] = value; // adds the new element to the end of the queue
            count++; 
        }
    }
    
    // Mutator for dequeue operation
    public Object dequeue() {
        Object frontVal = peek(); // gets the value at the front of the queue (the one being removed)
        for (int i = 0; i < count - 1; i++) {
            queue[i] = queue[i + 1]; // shifts all elements in the queue one position to the left to remove the front element
        }
        count--; 
        return frontVal; 
    }
    
    // Accessor for peek operation
    public Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow"); // throws an exception if the queue is empty and there is no front element to peek at
        } else {
            return queue[0]; // returns the value at the front of the queue (the first element in the queue array)
        }
    }
} 