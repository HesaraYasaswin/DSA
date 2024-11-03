import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {

    private int Vertices;   // vertices for the graph
    private int Edges;      // edges for the graph
    private DSALinkedList[] adjacencyList;  // adjacency list
    
    
    private class Edge {   // inner class
        private int vertex;
        private double weight;    // weight for the edge

        public Edge(int vertex, double weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int getVertex() {
            return this.vertex;
        }

        public double getWeight() {
            return this.weight;
        }
    }
    
    public Graph(String filename, char startVertex) {   // method for graph reader
        Scanner scanner = null;    // reads the location.txt
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {  // exception thrown when not found
            e.printStackTrace();
        }

        this.Vertices = scanner.nextInt();  // number of vertices are read here
        this.Edges = scanner.nextInt();     // the number of edges are read here                                                                
        this.adjacencyList = new DSALinkedList[this.Vertices];   //adjacency list 
        for (int i = 0; i < this.Vertices; i++) {
            this.adjacencyList[i] = new DSALinkedList();  
        }

        int startIndex = startVertex - 'A'; // start vertex index 

                                                
        for (int i = 0; i < this.Edges; i++) {   // read the edges and add them to the adjacencylist
            String start = scanner.next();
            String end = scanner.next();
            double weight = scanner.nextDouble();
            
            
            int startIdx = start.charAt(0) - startVertex;  // converting the vertex labels
            int endIdx = end.charAt(0) - startVertex;
            
            
            this.adjacencyList[startIdx].insertLast(new Edge(endIdx, weight));  // assuming it is a undirected graph
            this.adjacencyList[endIdx].insertLast(new Edge(startIdx, weight));
        }

        scanner.close();
    }

    public void AdjacencyList(char startVertex) {  // prints the adjacency list
        
        int startIndex = startVertex - 'A';

        for (int i = 0; i < this.Vertices; i++) {
            System.out.print((char) (startVertex + i) + " -> ");  // prints the vertex
            DSALinkedList list = this.adjacencyList[i];
            for (Object object : list) {
                Edge edge = (Edge) object;
                System.out.print((char) (startVertex + edge.getVertex()) + " "); 
            }
            System.out.println();
        }
    }

    public class DSAGraphNode {  // inner class
        private String label;
        
        private boolean visited;
    
        public DSAGraphNode(String label) {
            this.label = label;
            
            visited = false;
        }
    
        public String getLabel() {
            return label;
        }
    
        public void addAdjacent(DSAGraphNode node) {
            
        }
    
        public void setVisited(boolean b) {
            visited = b;
        }
    
        public boolean isVisited() {
            return visited;
        }
    }

} 