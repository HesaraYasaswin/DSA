import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class HeapSortTestHarness {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an option:");
        System.out.println("1. Sort an array of random numbers");
        System.out.println("2. Load numbers from a file");
        int option = scanner.nextInt();

        DSAHeapEntry[] arr;
        switch (option) {
            case 1:
                System.out.println("Enter the length of the array:");
                int length = scanner.nextInt();
                arr = generateRandomArray(length);
                break;
            case 2:
                try {
                    arr = HeapSort.readArrayFromFile("RandomNames7000.csv");
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                    return;
                }
                break;
            default:
                System.out.println("Invalid option");
                return;
        }

        System.out.println("Before sorting:");
        HeapSort.displayArray(arr);
        HeapSort.heapSort(arr);
        System.out.println("After sorting:");
        HeapSort.displayArray(arr);
    }

    public static DSAHeapEntry[] generateRandomArray(int length) {
        Random rand = new Random();
        DSAHeapEntry[] arr = new DSAHeapEntry[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new DSAHeapEntry(rand.nextInt(length), "Value " + i);
        }
        return arr;
    }
}