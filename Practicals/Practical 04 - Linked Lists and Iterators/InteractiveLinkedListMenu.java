import java.io.*;
import java.util.Scanner;

public class InteractiveLinkedListMenu {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    // Create a new empty linked list
	    DSALinkedList<String> list = new DSALinkedList<String>();
	    
	    while (true) {
	        // Print out menu options
	        System.out.println("\nPlease choose an option:");
	        System.out.println("(a) InsertFirst/InsertLast on the list");
	        System.out.println("(b) RemoveFirst/RemoveLast on the list");
	        System.out.println("(c) Display the list");
	        System.out.println("(d) Write a serialized file");
	        System.out.println("(e) Read a serialized file");
	        System.out.println("(f) Exit");
	        
	        // Get user input for menu choice
	        String choice = sc.nextLine();
	        
	        switch (choice) {
	            case "a":
	                // Get user input for string to add to list
	                System.out.println("Please enter a string to add to the list:");
	                String str = sc.nextLine();
	                // Get user input for where to add string in list
	                System.out.println("(1) InsertFirst or (2) InsertLast?");
	                String option = sc.nextLine();
	                // Insert string into list based on user choice
	                if (option.equals("1")) {
	                    list.insertFirst(str);
	                } else if (option.equals("2")) {
	                    list.insertLast(str);
	                } else {
	                    System.out.println("Invalid option.");
	                }
	                break;
	                
	            case "b":
	                // Get user input for which end of the list to remove from
	                System.out.println("(1) RemoveFirst or (2) RemoveLast?");
	                String option2 = sc.nextLine();
	                // Remove string from list based on user choice
	                if (option2.equals("1")) {
	                    list.removeFirst();
	                } else if (option2.equals("2")) {
	                    list.removeLast();
	                } else {
	                    System.out.println("Invalid option.");
	                }
	                break;
	            
	            case "c":
	                // Display contents of the list using iterator
	                System.out.println("List:");
	                for (String s : list) {
	                    System.out.println(s);
	                }
	                break;
	                
	            case "d":
	                // Get user input for filename to save list to
	                System.out.println("Please enter a filename to save the list to:");
	                String filename = sc.nextLine();
	                try {
	                    // Create ObjectOutputStream to write list to file
	                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
	                    out.writeObject(list);
	                    out.close();
	                    System.out.println("List saved to " + filename);
	                } catch (IOException e) {
	                    System.out.println("Error writing to file: " + e.getMessage());
	                }
	                break;
	                
	            case "e":
	                // Get user input for filename to load list from
	                System.out.println("Please enter a filename to load the list from:");
	                String filename2 = sc.nextLine();
	                try {
	                    // Create ObjectInputStream to read list from file
	                    ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename2));
	                    list = (DSALinkedList<String>)in.readObject();
	                    in.close();
	                    System.out.println("List loaded from " + filename2);
	                } catch (IOException e) {
	                    System.out.println("Error reading from file: " + e.getMessage());
	                } catch (ClassNotFoundException e) {
	                    System.out.println("Error: class not found.");
	                }
	                break;
	            
	            case "f":
	                // Exit the program
	                System.exit(0);
	                
	            default:
	                // User entered an invalid menu option
                    System.out.println("Invalid option.");
            }
        }
    }

}