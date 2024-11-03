import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HeapSort {

	public static void main(String[] args) {
        try {
            DSAHeapEntry[] arr = readArrayFromFile("RandomNames7000.csv");
            System.out.println("Before sorting:");
            displayArray(arr);
            heapSort(arr);
            System.out.println("After sorting:");
            displayArray(arr);
            writeArrayToFile("SortedNames.csv", arr);
            System.out.println("Sorted array written to file: SortedNames.csv");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void heapSort(DSAHeapEntry[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(arr, 0, i);

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void heapify(DSAHeapEntry[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l].getPriority() > arr[largest].getPriority())
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r].getPriority() > arr[largest].getPriority())
            largest = r;

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void swap(DSAHeapEntry[] arr, int i, int j) {
        DSAHeapEntry temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void displayArray(DSAHeapEntry[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getPriority() + "\t" + arr[i].getValue());
        }
    }
    
    public static void writeArrayToFile(String filename, DSAHeapEntry[] arr) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < arr.length; i++) {
            writer.write(arr[i].getPriority() + "," + arr[i].getValue());
            writer.newLine();
        }
        writer.close();
    }

    public static DSAHeapEntry[] readArrayFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<DSAHeapEntry> list = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(","); // split on comma
            int priority = Integer.parseInt(parts[0]); // convert first element to integer
            String value = parts[1]; // second element is the value
            list.add(new DSAHeapEntry(priority, value));
        }

        reader.close();

        DSAHeapEntry[] array = new DSAHeapEntry[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}