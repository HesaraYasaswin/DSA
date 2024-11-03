public class DSACircularQueueTest {
    public static void main(String[] args) {
        DSACircularQueue queue = new DSACircularQueue(5);
        
        // Enqueue some values to the queue
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");
        
        // Attempt to enqueue one more value, which should throw an exception
        try {
            queue.enqueue("F");
        } catch (RuntimeException e) {
            // Catch and print the exception message
            System.out.println("Caught exception: " + e.getMessage());
        }
        
        // Peek at the front value of the queue
        System.out.println("Front value: " + queue.peek());
        
        // Dequeue some values from the queue
        System.out.println("Dequeued value: " + queue.dequeue());
        System.out.println("Dequeued value: " + queue.dequeue());
        
        // Enqueue some more values to the queue
        queue.enqueue("F");
        queue.enqueue("G");
        
        // Dequeue all remaining values from the queue
        while (!queue.isEmpty()) {
            System.out.println("Dequeued value: " + queue.dequeue());
        }
        
        // Attempt to dequeue one more value, which should throw an exception
        try {
            queue.dequeue();
        } catch (RuntimeException e) {
            // Catch and print the exception message
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}