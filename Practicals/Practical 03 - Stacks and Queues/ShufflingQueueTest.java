public class ShufflingQueueTest {
	public static void main(String[] args) {
	    ShufflingQueue q = new ShufflingQueue(10); // create a new ShufflingQueue with a maximum capacity of 10

	    // enqueue some values
	    for (int i = 0; i < 10; i++) { 
	        q.enqueue(i); // enqueue each value (0 to 9) to the queue
	    }

	    // print the queue before shuffling
	    System.out.println("Queue before shuffling: " + q.toString()); // print the string representation of the queue before shuffling

	    // shuffle the queue
	    q.shuffle(); // shuffle the queue

	    // print the queue after shuffling
	    System.out.println("Queue after shuffling: " + q.toString()); // print the string representation of the queue after shuffling
	}
}