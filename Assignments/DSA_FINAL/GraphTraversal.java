import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GraphTraversal {
    private int Vertices;  // vertices in the graph
    private int Edges;     // edges in the graph
    private int[][] uavData;  // UAV data for each location
    private DSALinkedList[] adjacencyList;

    
    
    class Edge  //inner class
    {
        private int vertex;    // vertex index
        private double weight; // weight index

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

    public GraphTraversal(String locationFile, String uavDataFile) 
    {
        loadtheLocationfile("location.txt"); // Loads the location file
        loadtheUAVfile("UAVdata.txt");       // Loads the UAV data file
    }

    private void loadtheLocationfile(String filename) // load location from file 
    {
        Scanner scanner = null; 
        try {
            scanner = new Scanner(new File(filename)); // load location from file
        } catch (FileNotFoundException e) {   // exception occurred
            e.printStackTrace();
        }

        this.Vertices = scanner.nextInt(); // get vertices
        this.Edges = scanner.nextInt(); // get edges
        scanner.nextLine(); 
        
       
        this.adjacencyList = new DSALinkedList[this.Vertices];   
        for (int i = 0; i < this.Vertices; i++) {
            this.adjacencyList[i] = new DSALinkedList();
        }

        
        for (int i = 0; i < this.Edges; i++) {  
            String startVertex = scanner.next();
            String endVertex = scanner.next();
            double weight = scanner.nextDouble();

            int startIndex = getIdx(startVertex);
            int endIndex = getIdx(endVertex);

            this.adjacencyList[startIndex].insertLast(new Edge(endIndex, weight));  // add edge to the list of edges 
            this.adjacencyList[endIndex].insertLast(new Edge(startIndex, weight));  
        }

        scanner.close();
    }
    
    
    private int getIdx(String vertex) {  // get the index
        char c = vertex.charAt(0);
        int index = c - 'A';
        return index;
    }

    private void loadtheUAVfile(String filename)  // load the UAV file
    {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
        } catch (FileNotFoundException e) { // exception
            e.printStackTrace();
        }

        this.uavData = new int[this.Vertices][3]; // initializing the UAV data

        do {
        	
            String location = scanner.next();      // reads the location,temperature,humidity,wind speed
            int temperature = scanner.nextInt();  
            int humidity = scanner.nextInt();      
            int windSpeed = scanner.nextInt();     

            int locationIdx = location.charAt(0) - 'A'; // location to index conversion

            this.uavData[locationIdx][0] = temperature;  // stores the UAV data
            this.uavData[locationIdx][1] = humidity;     
            this.uavData[locationIdx][2] = windSpeed;    
       
        } while (scanner.hasNext());

        scanner.close();
    }

    public void breathfirstsearch(String startLocation, String endLocation) // perfroms bfs for the shortes path
    {
        int startVertex = startLocation.charAt(0) - 'A'; 
        int endVertex = endLocation.charAt(0) - 'A';     

        boolean[] visited = new boolean[this.Vertices]; // to keep track of visited vertices
        int[] parent = new int[this.Vertices];          

        DSAQueue<Integer> queue = new DSAQueue<>(); // Create a queue for BFS
        queue.enqueue(startVertex);                 // Enqueue the start vertex
        visited[startVertex] = true;                // Mark the start as visited

        do {
        	
            int currentVertex = queue.dequeue(); // Dequeue a vertex from the queue

            if (currentVertex == endVertex) 
            {
                
                DSALinkedList path = new DSALinkedList();  // backtrack to find the path
                int vertex = endVertex;
                
                do {  
                    path.insertFirst(vertex); //insert the vertex
                    vertex = parent[vertex];  // move it to the parent
                } while (vertex != startVertex);
                
                path.insertFirst(startVertex); // insert the start vertex

                
                System.out.print("the Shortest Path (BFS) is : ");  // Print the shortest path
                for (Object object : path) {
                    int pathVertex = (int) object;
                    System.out.print((char) ('A' + pathVertex) + " "); // convert the index to its asked location
                }
                System.out.println();
                return;
            }

            DSALinkedList list = this.adjacencyList[currentVertex]; // get the adj list for the current vertex
            for (Object object : list) {
                Edge edge = (Edge) object;          // get the adjacent vertex and the edge
                int adjacentVertex = edge.getVertex(); 

                if (!visited[adjacentVertex]) 
                {
                    visited[adjacentVertex] = true;  // marked true for the visited vertex
                    parent[adjacentVertex] = currentVertex;
                    queue.enqueue(adjacentVertex); // enqueue the vertex
                }
            }
        } while (!queue.isEmpty());

        
        System.out.println("Error! the path is not found");  // error message shown
    }

    public void depthfirstsearch(String startLocation) 
    {
        int startVertex = startLocation.charAt(0) - 'A'; // Convert the start location label to an index

        boolean[] visited = new boolean[this.Vertices]; // Keep track of visited vertices 

        System.out.print("the DFS traversal for this specific location is : ");
        dfs(startVertex, visited);
        System.out.println();

        
    }

    private void dfs(int vertex, boolean[] visited) 
    {
        visited[vertex] = true;        // the vertex is visited

        System.out.print((char) ('A' + vertex) + " "); // print as a character

        DSALinkedList list = this.adjacencyList[vertex];
        for (Object object : list)        
        {
            Edge edge = (Edge) object;       // get the adjacent edges and vertexes
            int adjacentVertex = edge.getVertex();

            if (!visited[adjacentVertex]) 
            {
                dfs(adjacentVertex, visited);  // call the function recursively
            }
        }
    }
    
    public void insert(String location, int temperature, int humidity, int windSpeed)  // inserting a new node
    {
        int newIdx =Vertices;
        Vertices++;

        
        DSALinkedList[] newAdjacencyList = new DSALinkedList[Vertices];
        int[][] newUAV = new int[Vertices][3];

        for (int i = 0; i < Vertices - 1; i++) {
            newAdjacencyList[i] = adjacencyList[i];
            newUAV[i] = uavData[i];
        }

        newAdjacencyList[newIdx] = new DSALinkedList();
        newUAV[newIdx][0] = temperature;
        newUAV[newIdx][1] = humidity;
        newUAV[newIdx][2] = windSpeed;

        adjacencyList = newAdjacencyList;
        uavData = newUAV;
    }


     
    public void delete(String location) // deleting a specific location
    {
        int vertex = location.charAt(0) - 'A'; 

        if (vertex >= 0 && vertex < Vertices) {
            
            for (int i = 0; i < Vertices; i++) {
                DSALinkedList list = adjacencyList[i];

                
                if (list.contains(vertex)) // Check if the vertex exists
                {
                    list.removeNode(vertex, i);  // Remove vertex
                }
            }

           
            for (int i = vertex; i < Vertices - 1; i++)   // Remove vertex from uavData
            {
                uavData[i] = uavData[i + 1];
            }

            
            DSALinkedList[] newAdjacencyList = new DSALinkedList[Vertices - 1];  // Shrink the arrays
            int[][] newUAV = new int[Vertices - 1][3];

            for (int i = 0; i < Vertices - 1; i++) {
                if (i < vertex) {
                    newAdjacencyList[i] = adjacencyList[i];
                    newUAV[i] = uavData[i];
                } else {
                    newAdjacencyList[i] = adjacencyList[i + 1];
                    newUAV[i] = uavData[i + 1];
                }
            }

            adjacencyList = newAdjacencyList;
            uavData = newUAV;

            Vertices--;
        }
    }
    
    public void search(String location) // search for a specific vertex
    {
        int vertex = location.charAt(0) - 'A'; // Convert the location label to an index

        boolean valid = false;
        do {
            if (vertex >= 0 && vertex < Vertices) {
                System.out.println("Location: " + location);
                System.out.println("Temperature: " + uavData[vertex][0] + " degrees Celsius");
                System.out.println("Humidity: " + uavData[vertex][1] + " percentage");
                System.out.println("Wind Speed: " + uavData[vertex][2] + " km/h");
                valid = true;
            } else {
                System.out.println("ERROR! The location is not found: " + location);

            }
        } while (!valid);
    }

    public void print(String location)  // print the location and its UAV data for the specified location
    {
        int vertex = location.charAt(0) - 'A'; // Convert the location label to an index
        int[] data = this.uavData[vertex];  // looks for the UAV data

        System.out.println("the UAV Data for this Location is " + location + ":");    // print the specific data according to the user input
        System.out.println("Temperature: " + data[0] + " degrees Celsius");
        System.out.println("Humidity: " + data[1] + " percentage");
        System.out.println("Wind Speed: " + data[2] + " km/h");
    }

}
                