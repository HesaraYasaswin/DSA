public class DSACircularQueue extends DSAQueue {
    private int front; 
    private int rear; 
    
    // Default constructor
    public DSACircularQueue() {
        super(); // call the default constructor of the parent class
        front = 0;
        rear = 0; 
    }
    
    // Alternate constructor
    public DSACircularQueue(int maxCapacity) {
        super(maxCapacity); // call the alternate constructor of the parent class with the specified max capacity
        front = 0; 
        rear = 0; 
    }
    
    // Mutator for enqueue operation
    public void enqueue(Object value) {
        if (isFull()) { // check if the queue is full
            throw new RuntimeException("Queue overflow"); // throw an exception if the queue is full
        } else {
            queue[rear] = value; // add the value to the rear of the queue
            rear = (rear + 1) % queue.length; // update the rear index to the next circular position
            count++; 
        }
    }
    
    // Mutator for dequeue operation
    public Object dequeue() {
        Object frontVal = peek(); // get the front value of the queue
        queue[front] = null; // remove the front value from the queue
        front = (front + 1) % queue.length; // update the front index to the next circular position
        count--; 
        return frontVal; 
    }
    
    // Accessor for peek operation
    public Object peek() {
        if (isEmpty()) { // check if the queue is empty
            throw new RuntimeException("Queue underflow"); // throw an exception if the queue is empty
        } else {
            return queue[front]; // return the front value of the queue
        }
    }
}