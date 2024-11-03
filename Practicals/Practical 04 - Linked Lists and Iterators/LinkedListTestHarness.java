import java.util.Iterator;
import java.util.Scanner;

public class LinkedListTestHarness {

	public static void main(String[] args) {
	    // Creating a new instance of DSALinkedList class
	    DSALinkedList<String> linkedList = new DSALinkedList<>();

	    // Creating a new scanner object to read user input
	    Scanner scanner = new Scanner(System.in);

	    // Initializing choice to -1
	    int choice = -1;

	    // Loop until user enters 0 to exit
	    while (choice != 0) {
	        // Display menu of options
	        System.out.println("\nEnter your choice:");
	        System.out.println("0: Exit");
	        System.out.println("1: Add element to start of list");
	        System.out.println("2: Add element to end of list");
	        System.out.println("3: Remove element from start of list");
	        System.out.println("4: Remove element from end of list");
	        System.out.println("5: Display list");
	        System.out.println("6: Display list using iterator");

	        // Read user input and store it in choice variable
	        choice = scanner.nextInt();

	        // Consume newline character
	        scanner.nextLine();

	        // Switch case based on user input
	        switch (choice) {
	            case 0:
	                break;
	            case 1:
	                // Prompt user to enter element to add to start of list
	                System.out.print("Enter element to add to start of list: ");
	                String startElement = scanner.nextLine();

	                // Insert element at the start of the list
	                linkedList.insertFirst(startElement);

	                // Display message indicating element added to start of list
	                System.out.println("Element " + startElement + " added to start of list");
	                break;
	            case 2:
	                // Prompt user to enter element to add to end of list
	                System.out.print("Enter element to add to end of list: ");
	                String endElement = scanner.nextLine();

	                // Insert element at the end of the list
	                linkedList.insertLast(endElement);

	                // Display message indicating element added to end of list
	                System.out.println("Element " + endElement + " added to end of list");
	                break;
	            case 3:
	                // Remove element from start of list
	                String removedStart = (String) linkedList.removeFirst();

	                // If list is empty, display appropriate message
	                if (removedStart == null) {
	                    System.out.println("List is empty");
	                } else {
	                    // Otherwise, display message indicating element removed from start of list
	                    System.out.println("Element " + removedStart + " removed from start of list");
	                }
	                break;
	            case 4:
	                // Remove element from end of list
	                String removedEnd = (String) linkedList.removeLast();

	                // If list is empty, display appropriate message
	                if (removedEnd == null) {
	                    System.out.println("List is empty");
	                } else {
	                    // Otherwise, display message indicating element removed from end of list
	                    System.out.println("Element " + removedEnd + " removed from end of list");
	                }
	                break;
	            case 5:
	                // Display the list using toString() method
	                System.out.println("List: " + linkedList.toString());
	                break;
	            case 6:
	                // Display the list using iterator
	                System.out.print("List using iterator: ");
	                Iterator<String> iterator = linkedList.iterator();
	                while (iterator.hasNext()) {
	                    System.out.print(iterator.next() + " ");
	                }
	                System.out.println();
	                break;
	            default:
	                // Display message indicating invalid choice
                    System.out.println("Invalid choice");
            }
        }
    }
}