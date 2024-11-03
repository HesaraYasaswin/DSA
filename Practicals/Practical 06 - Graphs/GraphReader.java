import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GraphReader {

    public static void main(String[] args) {
        String[] filenames = {"prac6_1.al", "prac6_2.al"};
        boolean isDirected = false;
        for (String filename : filenames) {
            DSAGraph graph = new DSAGraph(isDirected);
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] vertices = line.split(" ");
                    graph.addEdge(vertices[0], vertices[1]);
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
            System.out.println("Graph from " + filename + ":");
            graph.displayAsList();
            graph.displayAsMatrix();

            Scanner input = new Scanner(System.in);
            System.out.println("Please choose a traversal algorithm:");
            System.out.println("1. Depth-first search");
            System.out.println("2. Breadth-first search");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Depth-first search:");
                    graph.depthFirstSearch();
                    break;
                case 2:
                    System.out.println("Breadth-first search:");
                    graph.breadthFirstSearch();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }

            System.out.println();
        }
    }
}