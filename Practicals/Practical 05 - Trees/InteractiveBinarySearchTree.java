import java.io.*;
import java.util.*;

public class InteractiveBinarySearchTree {
    private static Scanner input = new Scanner(System.in);
    private static DSABinarySearchTree<Integer> tree = new DSABinarySearchTree<>();

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            System.out.println("\nBinary Search Tree Menu");
            System.out.println("-----------------------");
            System.out.println("1. Insert a value");
            System.out.println("2. Read from a CSV file");
            System.out.println("3. Read from a serialized file");
            System.out.println("4. Display the tree");
            System.out.println("5. Write to a CSV file");
            System.out.println("6. Write to a serialized file");
            System.out.println("7. Quit");

            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    int value = getIntInput("Enter a value to insert: ");
                    tree.insert(value);
                    break;
                case 2:
                    String filename = getStringInput("Enter the name of the CSV file to read from: ");
                    readFromCSV(filename);
                    break;
                case 3:
                    filename = getStringInput("Enter the name of the serialized file to read from: ");
                    readFromSerialized(filename);
                    break;
                case 4:
                    System.out.println("Choose a traversal method:");
                    System.out.println("1. Inorder");
                    System.out.println("2. Preorder");
                    System.out.println("3. Postorder");
                    int traversalChoice = getIntInput("Enter your choice: ");
                    displayTree(traversalChoice);
                    break;
                case 5:
                    filename = getStringInput("Enter the name of the CSV file to write to: ");
                    System.out.println("Choose a traversal method:");
                    System.out.println("1. Inorder");
                    System.out.println("2. Preorder");
                    System.out.println("3. Postorder");
                    traversalChoice = getIntInput("Enter your choice: ");
                    writeToCSV(filename, traversalChoice);
                    break;
                case 6:
                    filename = getStringInput("Enter the name of the serialized file to write to: ");
                    writeToSerialized(filename);
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private static int getIntInput(String message) {
        int value = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print(message);
                value = Integer.parseInt(input.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Try again.");
            }
        }
        return value;
    }

    private static String getStringInput(String message) {
        System.out.print(message);
        return input.nextLine();
    }

    private static void readFromCSV(String filename) {
        try (Scanner fileInput = new Scanner(new File(filename))) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                int value = Integer.parseInt(line);
                tree.insert(value);
            }
            System.out.println("Tree built from CSV file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    
    private static void readFromSerialized(String filename) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            tree = (DSABinarySearchTree<Integer>) objectInputStream.readObject();
            System.out.println("Tree built from serialized file.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading from serialized file.");
        }
    }

    private static void displayTree(int traversalChoice) {
        switch (traversalChoice) {
            case 1:
                System.out.println("Inorder Traversal:");
                tree.inorder();
                break;
            case 2:
                System.out.println("Preorder Traversal:");
                tree.preorder();
                break;
            case 3:
                System.out.println("Postorder Traversal:");
                tree.postorder();
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                break;
        }
    }
    
    private static void writeToCSV(String filename, int traversalChoice) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            List<Integer> values = new ArrayList<>();
            switch (traversalChoice) {
                case 1:
                    tree.inorder();
                    break;
                case 2:
                    tree.preorder();
                    break;
                case 3:
                    tree.postorder();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    return;
            }
            for (int value : values) {
                writer.println(value);
            }
            System.out.println("Tree written to CSV file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }



    private static void writeToSerialized(String filename) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(tree);
            System.out.println("Tree written to serialized file.");
        } catch (IOException e) {
            System.out.println("Error writing to serialized file.");
        }
    }
}