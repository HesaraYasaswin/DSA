import java.util.Scanner;

public class UnitTestDSAQueue {
    public static void main(String[] args) {
        DSAQueue<String> queue = new DSAQueue<>();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Enqueue an item");
            System.out.println("2. Dequeue an item");
            System.out.println("3. Peek the front item");
            System.out.println("4. Check if the queue is empty");
            System.out.println("5. Get the count of the items");
            System.out.println("6. Clear");
            System.out.println("7. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.println("Enter an item to enqueue:");
                    String item = scanner.nextLine();
                    queue.enqueue(item);
                    System.out.println("Item enqueued: " + item);
                    break;
                case 2:
                    if (!queue.isEmpty()) {
                        String dequeuedItem = queue.dequeue();
                        System.out.println("the item is dequeued: " + dequeuedItem);
                    } else {
                        System.out.println("Queue is empty");
                    }
                    break;
                case 3:
                    if (!queue.isEmpty()) {
                        String frontItem = queue.peek();
                        System.out.println("the front item: " + frontItem);
                    } else {
                        System.out.println("Queue is empty");
                    }
                    break;
                case 4:
                    System.out.println("Is the queue empty? " + queue.isEmpty());
                    break;
                case 5:
                    System.out.println("Count of items in the queue: " + queue.getCount());
                    break;
                case 6:
                    queue.clear();
                    System.out.println("Queue cleared.");
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid option");
            }

            System.out.println(); 
        }

        scanner.close();
    }
}