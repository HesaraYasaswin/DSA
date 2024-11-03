import java.util.Random;

public class ShufflingQueue extends DSAQueue {
    private Random rand; // declare a Random object

    public ShufflingQueue() {
        super(); // call the constructor of the superclass
        rand = new Random(); // initialize the Random object
    }

    public ShufflingQueue(int maxCapacity) {
        super(maxCapacity); // call the constructor of the superclass with a specified maximum capacity
        rand = new Random(); // initialize the Random object
    }

    public void shuffle() {
        for (int i = count - 1; i > 0; i--) { // loop through the queue from the end to the beginning
            int j = rand.nextInt(i + 1); // pick a random index between 0 and i (inclusive)
            Object temp = queue[i]; // temporarily store the element at index i
            queue[i] = queue[j]; // move the element at index j to index i
            queue[j] = temp; // move the element originally at index i to index j
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // create a StringBuilder object to build the string representation of the queue
        for (int i = 0; i < count; i++) { // loop through the queue from the front to the end
            int front = 0; // initialize the front of the queue to 0
			sb.append(queue[(front + i) % queue.length]).append(" "); // append the element at the current index to the StringBuilder, taking into account wraparound if necessary
        }
        return sb.toString(); // convert the StringBuilder to a String and return it
    }
}