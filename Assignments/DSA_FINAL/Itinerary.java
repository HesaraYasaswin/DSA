import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Itinerary {
    private static final int SIZE = 1000;

    private DSALinkedList[] adjacencyList;  // adjacency list from the graph
    private String[] locationArea; // location map from the graph
    private int Vertices;    // vertices from the graph
    
    
    private class area { //inner class 
        private int destination; 
        private double distance;

        public area(int destination, double distance) {
            this.destination = destination;
            this.distance = distance;
        }

        public int getDestination() { 
            return destination;
        }

        public double getDistance() {
            return distance;
        }
    }

    public Itinerary(int Vertices) { 
        this.Vertices = Vertices;
        adjacencyList = new DSALinkedList[Vertices];  // create a array of linked list
        locationArea = new String[Vertices];
        for (int i = 0; i < Vertices; i++) {
            adjacencyList[i] = new DSALinkedList(); // initialize
        }
    }

    public void addEdge(int source, int destination, double distance) {
        area edge = new area(destination, distance);  // create a new edge with the destination and distance
        adjacencyList[source].insertLast(edge);  // if the graph is undirected
        adjacencyList[destination].insertLast(new area(source, distance)); 
    }

    public void planItinerary() { // plan the graph from the current point to the destination(shortest distance)
        double[] distances = new double[Vertices];
        int[] prevVertices = new int[Vertices]; 
        boolean[] visited = new boolean[Vertices];

        for (int i = 0; i < Vertices; i++) {
            distances[i] = SIZE;
            prevVertices[i] = -1;  
        }

        for (int startVertex = 0; startVertex < Vertices; startVertex++) { 
            for (int i = 0; i < Vertices; i++) {
                visited[i] = false;
            }
            distances[startVertex] = 0;

            for (int i = 0; i < Vertices - 1; i++) {
                int minVertex = MinimumDistance(distances, visited);
                visited[minVertex] = true;

                DSALinkedList neighbors = adjacencyList[minVertex];
                for (Object obj : neighbors) {
                    area edge = (area) obj;
                    int destination = edge.getDestination();
                    double distance = edge.getDistance();

                    if (!visited[destination] && distances[minVertex] != SIZE && distances[minVertex] + distance < distances[destination]) 
                    {
                        distances[destination] = distances[minVertex] + distance;
                        prevVertices[destination] = minVertex;  
                    }
                }
            }

            print(startVertex, prevVertices);
        }
    }

    private int MinimumDistance(double[] distances, boolean[] visited) { 
        int minVertex = -1;
        double minDistance = SIZE;

        for (int i = 0; i < Vertices; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minVertex = i;
                minDistance = distances[i];
            }
        }

        return minVertex;
    }
    


    private void print(int startVertex, int[] previousVertices) { 
        System.out.println("Itinerary from " + locationArea[startVertex] + ":");

        for (int i = 0; i < Vertices; i++) {
            if (i != startVertex) {
                System.out.print(locationArea[startVertex] + " -> ");
                ShortestPath(i, previousVertices);                
                System.out.println();
            }
        }
    }

    private void ShortestPath(int destination, int[] previousVertices) {  
        DSALinkedList path = new DSALinkedList();
        int vertex = destination;

        while (vertex != -1) {
            path.insertFirst(vertex);
            vertex = previousVertices[vertex];
        }

        Iterator iter = path.iterator();
        while (iter.hasNext()) {
            System.out.print(locationArea[(int) iter.next()] + " ");
        }
    }



    public void loadFile(String filename) {   // the input file is loaded
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length >= 3) {
                    int source = parts[0].charAt(0) - 'A';
                    int destination = parts[1].charAt(0) - 'A';
                    double distance = Double.parseDouble(parts[2]);
                    addEdge(source, destination, distance);
                    locationArea[source] = parts[0];
                    locationArea[destination] = parts[1];
                }
            }
        } catch (IOException e) {  // throws exception
            e.printStackTrace();
        }
    }


}