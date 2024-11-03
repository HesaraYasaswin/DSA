import java.util.Scanner;

public class TestHarness {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum size of the heap: ");
        int maxSize = scanner.nextInt();

        DSAHeap heap = new DSAHeap(maxSize);

        while (true) {
            System.out.println("\n1. Add item to heap");
            System.out.println("2. Remove item from heap");
            System.out.println("3. Display heap contents");
            System.out.println("4. Test trickleUp() method");
            System.out.println("5. Test trickleDown() method");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter the priority of the item: ");
                    int priority = scanner.nextInt();
                    System.out.print("Enter the value of the item: ");
                    String value = scanner.next();
                    DSAHeapEntry entry = new DSAHeapEntry(priority, value);
                    heap.add(entry);
                    System.out.println("Item added to heap.");
                    break;

                case 2:
                    DSAHeapEntry removed = heap.remove();
                    System.out.println("\nRemoved item: " + removed.getPriority() + ", " + removed.getValue());
                    break;

                case 3:
                    heap.display();
                    break;

                case 4:
                    System.out.print("\nEnter the index of the item to test trickleUp(): ");
                    int index = scanner.nextInt();
                    heap.trickleUp(index);
                    System.out.println("Item trickled up.");
                    break;

                case 5:
                    System.out.print("\nEnter the index of the item to test trickleDown(): ");
                    index = scanner.nextInt();
                    heap.trickleDown(index);
                    System.out.println("Item trickled down.");
                    break;

                case 6:
                    System.out.println("Exiting program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}