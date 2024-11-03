import java.util.*;

public class TestHarness
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Test DSAStack using DSALinkedList
        System.out.println("Testing DSAStack using DSALinkedList:");
        DSAStack stack = new DSAStack();

        // Loop to push items onto the stack
        while (true)
        {
            System.out.print("Enter an item to push onto the stack (or q to quit): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("q"))
            {
                break;
            }

            // Push the item onto the stack and print the stack
            stack.push(input);
            System.out.println("Stack: " + stack);
        }

        // Loop to pop items from the stack
        System.out.println("Popping items from stack:");
        while (!stack.isEmpty())
        {
            // Pop an item from the stack and print it, along with the current stack
            System.out.println("Popped: " + stack.pop());
            System.out.println("Stack: " + stack);
        }

        // Test DSAQueue using DSALinkedList
        System.out.println("\nTesting DSAQueue using DSALinkedList:");
        DSAQueue queue = new DSAQueue();

        // Loop to enqueue items into the queue
        while (true)
        {
            System.out.print("Enter an item to enqueue onto the queue (or q to quit): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("q"))
            {
                break;
            }

            // Enqueue the item and print the queue
            queue.enqueue(input);
            System.out.println("Queue: " + queue);
        }

        // Loop to dequeue items from the queue
        System.out.println("Dequeuing items from queue:");
        while (!queue.isEmpty())
        {
            // Dequeue an item from the queue and print it, along with the current queue
            System.out.println("Dequeued: " + queue.dequeue());
            System.out.println("Queue: " + queue);
        }
    }
}