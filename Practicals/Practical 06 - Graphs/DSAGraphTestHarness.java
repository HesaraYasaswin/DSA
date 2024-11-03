import java.util.Scanner;

public class DSAGraphTestHarness {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DSAGraph graph = new DSAGraph(true);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add vertex");
            System.out.println("2. Add edge");
            System.out.println("3. Display graph as list");
            System.out.println("4. Display graph as matrix");
            System.out.println("5. Depth First Search");
            System.out.println("6. Breadth First Search");
            System.out.println("7. Quit");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.println("Enter vertex label:");
                String label = input.nextLine();
                graph.addVertex(label);
            } else if (choice == 2) {
                System.out.println("Enter source vertex label:");
                String label1 = input.nextLine();
                System.out.println("Enter target vertex label:");
                String label2 = input.nextLine();
                graph.addEdge(label1, label2);
            } else if (choice == 3) {
                graph.displayAsList();
            } else if (choice == 4) {
                graph.displayAsMatrix();
            } else if (choice == 5) {
                System.out.println("Enter the source vertex to start the Depth First Search:");
                String startVertex = input.nextLine();
                graph.depthFirstSearch();
            } else if (choice == 6) {
                System.out.println("Enter the source vertex to start the Breadth First Search:");
                String startVertex = input.nextLine();
                graph.breadthFirstSearch();
            } else if (choice == 7) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        
    }
}