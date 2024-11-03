// Adapted from code previously submitted for COMP1002 Practical 8
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class Node 
{
    private String location; // The location of the node
    private int riskLevel;  // The risk level of the node

    public Node(String location, int riskLevel) {
        this.location = location;
        this.riskLevel = riskLevel;
    }

    public String getLocation() {
        return location; 
    }

    public int getRisk() {
        return riskLevel; 
    }
   
}

public class Heap {
    private static final int SIZE = 10;

    Node[] heapArr; // stores the nodes in the heap
    int heapSize; // size of the heap

    public Heap() // constructor 
    {
        heapArr = new Node[SIZE]; // Initialize to the maximum size
        heapSize = 0;  
    }

    public boolean isEmpty() { // checks if it is empty
        return heapSize == 0; 
    }

    public void insert(Node node) { // inserts node into heap
        if (heapSize >= SIZE) 
        { 
            throw new IllegalStateException("the heap is full"); // exception if heap is full
        }

        heapArr[heapSize] = node; // Insert the new node at the end of the array
        trickleUp(heapSize); // trickling up
        heapSize++; 
    }

    public Node Max()  // returns the maximum value 
    {
        if (isEmpty()) { 
            throw new IllegalStateException("the heap is empty"); // exception if heap is empty
        }

        Node max = heapArr[0]; // Store the max
        heapSize--; 
        heapArr[0] = heapArr[heapSize]; // Replace the root with the last node in the array
        trickleDown(0, heapArr[0]); // trickling down

        return max; 
    }

    public void updateNode(Node oldNode, Node newNode) // updating the array
    {
        int idx = findIdx(oldNode); // Find the index of the old node in the array
        if (idx != -1) { // If the old node is found
            heapArr[idx] = newNode; // Replace the old node with the new node

            if (newNode.getRisk() > oldNode.getRisk()) 
            {
                trickleUp(idx); // If the new node has a higher risk level, trickle it up
            } else {
                trickleDown(idx, newNode); // if not trickle it down
            }
        }
    }
    
    private void swap(int idx1, int idx2) // a swap method was created 
    {
        Node temp = heapArr[idx1]; // to Swap two nodes in the array
        heapArr[idx1] = heapArr[idx2];
        heapArr[idx2] = temp;
    }

    private void trickleUp(int idx) 
    {
        int parent = getParentIdx(idx); // Get the index of the parent node

        do { 
            swap(idx, parent); // Swap the current node with its parent
            idx = parent; // Update the current index to be the parent index
            parent = getParentIdx(idx); // Get the new parent index
        } while (idx > 0 && heapArr[idx].getRisk() > heapArr[parent].getRisk());
    }

    private void trickleDown(int idx, Node node) 
    {
        int maxChild;

        while (idx < heapSize) {
        	int rightChild = getRightChildIdx(idx); // index of the right child and the left child
            int leftChild = getLeftChildIdx(idx); // index of the left child and the right child
            

            if (leftChild < heapSize) {
                if (rightChild < heapSize && heapArr[rightChild].getRisk() > heapArr[leftChild].getRisk()) {
                    maxChild = rightChild; // if risk high choose rightchild
                } else {
                    maxChild = leftChild; // or else the left child
                }

                if (heapArr[idx].getRisk() < heapArr[maxChild].getRisk()) {
                    swap(idx, maxChild);    // Swap the current node with the maximum child
                    idx = maxChild;      // Update the current index to be the maximum child index
                } else {
                    break; // If the current node is already greater than both children then break
                }
            } else {
                break; // if no children
            }
        }
    }



    private int getLeftChildIdx(int idx) 
    {
        return (2 * idx + 1); // Calculation for the left child node index
    }

    private int getRightChildIdx(int idx) 
    {
        return (2 * idx + 2); // Calculation for the right child node index
    }
    
    private int getParentIdx(int idx) 
    {
        return ((idx - 1) / 2); // Calculation for the parent node index
    }

    

    private int findIdx(Node node) // to Find the node index
    {
        for (int i = 0; i < heapSize; i++) { 
            if (heapArr[i].equals(node)) 
            {
                return i; // Return the index if the node is found
            }
        }
        return -1; // if not return -1
    }



    private static void readUAV(Heap heap, String fileName) 
    {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");  // Split the line into data fields
                if (data.length == 4) {   // the line should have the expected fields
                    String location = data[0];
                    int temperature = Integer.parseInt(data[1]);
                    int humidity = Integer.parseInt(data[2]);
                    int windSpeed = Integer.parseInt(data[3]);

                    int riskLevel = calculateRisk(temperature, humidity, windSpeed); // risk level is calculated
                    Node node = new Node(location, riskLevel); // Create a new node
                    heap.insert(node); // insert to heap
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // exception
        }
    }

    private static int calculateRisk(int temperature, int humidity, int windSpeed) 
    {
        int riskLevel = 0;
        
        
        if (temperature >= 33 || humidity < 30 || windSpeed > 55) {
            riskLevel = 3; // risk level is high
        } else if ((temperature >= 25 && temperature <= 32) || (humidity >= 31 && humidity <= 50) || (windSpeed >= 41 && windSpeed <= 55)) {
            riskLevel = 2; // risk level is medium
        } else {
            riskLevel = 1; // if it is not high or medium then it is low
        }
        return riskLevel; // Return the risk level
    }
    

}
