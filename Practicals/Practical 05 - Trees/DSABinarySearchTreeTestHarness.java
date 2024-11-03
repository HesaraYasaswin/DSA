import java.util.Scanner;

public class DSABinarySearchTreeTestHarness {
    public static void main(String[] args) {
        DSABinarySearchTree<Integer> tree = new DSABinarySearchTree<>();
        Scanner input = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Enter a command (insert, delete, find, min, max, height, balance, inorder, preorder, postorder, exit):");
            String command = input.next();

            switch (command) {
                case "insert":
                    System.out.println("Enter an integer value to insert:");
                    int insertValue = input.nextInt();
                    tree.insert(insertValue);
                    System.out.println(insertValue + " inserted.");
                    break;

                case "delete":
                    System.out.println("Enter an integer value to delete:");
                    int deleteValue = input.nextInt();
                    tree.delete(deleteValue);
                    System.out.println(deleteValue + " deleted.");
                    break;

                case "find":
                    System.out.println("Enter an integer value to find:");
                    int findValue = input.nextInt();
                    boolean found = tree.find(findValue);
                    if (found) {
                        System.out.println(findValue + " found.");
                    } else {
                        System.out.println(findValue + " not found.");
                    }
                    break;

                case "min":
                    Integer minValue = tree.min();
                    if (minValue == null) {
                        System.out.println("Tree is empty.");
                    } else {
                        System.out.println("Minimum value: " + minValue);
                    }
                    break;

                case "max":
                    Integer maxValue = tree.max();
                    if (maxValue == null) {
                        System.out.println("Tree is empty.");
                    } else {
                        System.out.println("Maximum value: " + maxValue);
                    }
                    break;

                case "height":
                    int height = tree.height();
                    System.out.println("Height: " + height);
                    break;

                case "balance":
                    double balance = tree.balance();
                    System.out.println("Balance: " + balance);
                    break;

                case "inorder":
                    System.out.print("Inorder traversal: ");
                    tree.inorder();
                    break;

                case "preorder":
                    System.out.print("Preorder traversal: ");
                    tree.preorder();
                    break;

                case "postorder":
                    System.out.print("Postorder traversal: ");
                    tree.postorder();
                    break;

                case "exit":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }

        input.close();
    }
}