import java.util.Scanner;

public class UnitTestDSALinkedList {
    public static void main(String[] args) {
        DSALinkedList list = new DSALinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Insert item at top of list");
            System.out.println("2. Insert item at end of list");
            System.out.println("3. Remove item from top of list");
            System.out.println("4. Remove item from end of list");
            System.out.println("5. Remove any specific item");
            System.out.println("6. does the list contain the item?");
            System.out.println("7. count of items in list");
            System.out.println("8. display the list");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to insert at the top: ");
                    String value1 = scanner.nextLine();
                    list.insertFirst(value1);
                    break;
                case 2:
                    System.out.print("Enter the value to insert at the end: ");
                    String value2 = scanner.nextLine();
                    list.insertLast(value2);
                    break;
                case 3:
                    try {
                        Object removed1 = list.removeFirst();
                        System.out.println("the Removed item from the top is : " + removed1);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        Object removed2 = list.removeLast();
                        System.out.println("the Removed item from the end is: " + removed2);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Enter the value to remove: ");
                    String value3 = scanner.nextLine();
                    boolean removed3 = list.removeNode(value3, 1);
                    if (removed3) {
                        System.out.println("Item removed ");
                    } else {
                        System.out.println("Item not found");
                    }
                    break;
                case 6:
                    System.out.print("Enter the value to search in the list: ");
                    String value4 = scanner.nextLine();
                    boolean contains = list.hasNode(value4);
                    if (contains) {
                        System.out.println("List contains the specific item");
                    } else {
                        System.out.println("List does not contain the specific item");
                    }
                    break;
                case 7:
                    int count = list.getCount();
                    System.out.println("the number of items in the list: " + count);
                    break;
                case 8:
                    System.out.println("List: " + list.toString());
                    break;
                case 9:
                    System.out.println("Exit");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }

            System.out.println(); 
        }
    }
}