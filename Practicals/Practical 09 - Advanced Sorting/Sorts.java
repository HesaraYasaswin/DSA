/**
 * Software Technology 152
 * Class to hold various static sort methods.
 */
class Sorts {
  // bubble sort
  public static void bubbleSort(int[] A) {
    int i, ii; // Variables for loop indices
    int temp; // Temporary variable for swapping

    for (i = 0; i < A.length - 1; i++) { // Iterate over the array
      for (ii = 0; ii < A.length - i - 1; ii++) { // Compare adjacent elements
        if (A[ii] > A[ii + 1]) { // If the current element is greater than the next
          temp = A[ii]; // Swap the elements
          A[ii] = A[ii + 1];
          A[ii + 1] = temp;
        }
      }
    }
  }//bubbleSort()

  // selection sort
  public static void selectionSort(int[] A) {
    int i, ii, minI, temp; // Variables for loop indices and minimum index

    for (i = 0; i < A.length - 1; i++) { // Iterate over the array
      minI = i; // Assume the first unsorted element is the minimum
      for (ii = i + 1; ii < A.length; ii++) { // Find the minimum element in the remaining unsorted portion
        if (A[ii] < A[minI]) { // If a smaller element is found
          minI = ii; // Update the minimum index
        }
      }
      temp = A[minI]; // Swap the minimum element with the first unsorted element
      A[minI] = A[i];
      A[i] = temp;
    }
  }// selectionSort()

  // insertion sort
  public static void insertionSort(int[] A) {
    int i, ii, temp; // Variables for loop indices and temporary variable

    for (i = 1; i < A.length; i++) { // Iterate over the array starting from the second element
      ii = i;
      temp = A[ii];
      while (ii > 0 && A[ii - 1] > temp) { // Shift elements to the right to make space for the current element
        A[ii] = A[ii - 1];
        ii = ii - 1;
      }
      A[ii] = temp; // Place the current element in its correct position
    }
  }// insertionSort()

  // mergeSort - front-end for kick-starting the recursive algorithm
  public static void mergeSort(int[] A) {
    mergeSortRecurse(A, 0, A.length - 1);
  }//mergeSort()

  private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx) {
    if (leftIdx < rightIdx) { // If there are more than one elements
      int midIdx = (leftIdx + rightIdx) / 2; // Find the middle index
      mergeSortRecurse(A, leftIdx, midIdx); // Recursively sort the left half
      mergeSortRecurse(A, midIdx + 1, rightIdx); // Recursively sort the right half
      merge(A, leftIdx, midIdx, rightIdx); // Merge the sorted halves
    }
  }//mergeSortRecurse()

  private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx) {
    int leftSize = midIdx - leftIdx + 1; // Calculate the size of the left subarray
    int rightSize = rightIdx - midIdx; // Calculate the size of the right subarray

    int[] leftArray = new int[leftSize]; // Create a temporary array for the left subarray
    int[] rightArray = new int[rightSize]; // Create a temporary array for the right subarray

    for (int i = 0; i < leftSize; i++) { // Copy elements from the original array to the left subarray
      leftArray[i] = A[leftIdx + i];
    }
    for (int i = 0; i < rightSize; i++) { // Copy elements from the original array to the right subarray
      rightArray[i] = A[midIdx + 1 + i];
    }

    int i = 0, j = 0, k = leftIdx; // Initialize indices for merging

    while (i < leftSize && j < rightSize) { // Merge the left and right subarrays in sorted order
      if (leftArray[i] <= rightArray[j]) { // Compare elements from the left and right subarrays
        A[k] = leftArray[i]; // Place the smaller element in the original array
        i++;
      } else {
        A[k] = rightArray[j];
        j++;
      }
      k++;
    }

    while (i < leftSize) { // Copy any remaining elements from the left subarray
      A[k] = leftArray[i];
      i++;
      k++;
    }

    while (j < rightSize) { // Copy any remaining elements from the right subarray
      A[k] = rightArray[j];
      j++;
      k++;
    }
  }//merge()

  // quickSort - front-end for kick-starting the recursive algorithm
  public static void quickSort(int[] A) {
    quickSortRecurse(A, 0, A.length - 1);
  }//quickSort()

  private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx) {
    if (leftIdx < rightIdx) { // If there are more than one elements
      int pivotIdx = doPartitioning(A, leftIdx, rightIdx); // Partition the array and get the pivot index
      quickSortRecurse(A, leftIdx, pivotIdx - 1); // Recursively sort the left partition
      quickSortRecurse(A, pivotIdx + 1, rightIdx); // Recursively sort the right partition
    }
  }//quickSortRecurse()

  private static int doPartitioning(int[] A, int leftIdx, int rightIdx) {
    int pivot = A[leftIdx]; // Choose the leftmost element as the pivot
    int i = leftIdx + 1; // Start from the element next to the pivot

    for (int j = leftIdx + 1; j <= rightIdx; j++) { // Iterate over the subarray
      if (A[j] < pivot) { // If an element is smaller than the pivot
        int temp = A[i]; // Swap the element with the element at index i
        A[i] = A[j];
        A[j] = temp;
        i++;
      }
    }

    int temp = A[i - 1]; // Swap the pivot with the last element smaller than it
    A[i - 1] = A[leftIdx];
    A[leftIdx] = temp;

    return i - 1; // Return the pivot index
  }//doPartitioning

  public static void quickSortMedian3(int[] A) {
    quickSortMedian3Recurse(A, 0, A.length - 1);
  }//quickSortMedian3()

  private static void quickSortMedian3Recurse(int[] A, int leftIdx, int rightIdx) {
    if (leftIdx < rightIdx) { // If there are more than one elements
      int pivotIdx = doMedian3Partitioning(A, leftIdx, rightIdx); // Partition the array using median-of-three and get the pivot index
      quickSortMedian3Recurse(A, leftIdx, pivotIdx - 1); // Recursively sort the left partition
      quickSortMedian3Recurse(A, pivotIdx + 1, rightIdx); // Recursively sort the right partition
    }
  }//quickSortMedian3Recurse()

  private static int doMedian3Partitioning(int[] A, int leftIdx, int rightIdx) {
    int midIdx = (leftIdx + rightIdx) / 2; // Calculate the middle index
    int pivotIdx = medianOfThree(A, leftIdx, midIdx, rightIdx); // Find the index of the median element among the left, middle, and right elements
    int pivotValue = A[pivotIdx]; // Get the value of the pivot

    // Swap the pivot with the last element
    int temp = A[pivotIdx];
    A[pivotIdx] = A[rightIdx];
    A[rightIdx] = temp;

    int i = leftIdx;
    for (int j = leftIdx; j < rightIdx; j++) { // Iterate over the subarray
      if (A[j] < pivotValue) { // If an element is smaller than the pivot
        temp = A[i]; // Swap the element with the element at index i
        A[i] = A[j];
        A[j] = temp;
        i++;
      }
    }

    // Swap the pivot back to its correct position
    temp = A[i];
    A[i] = A[rightIdx];
    A[rightIdx] = temp;

    return i; // Return the pivot index
  }//doMedian3Partitioning()

  private static int medianOfThree(int[] A, int leftIdx, int midIdx, int rightIdx) {
    if ((A[leftIdx] >= A[midIdx] && A[leftIdx] <= A[rightIdx]) || (A[leftIdx] <= A[midIdx] && A[leftIdx] >= A[rightIdx])) {
      return leftIdx; // Return the index of the left element if it is the median
    } else if ((A[midIdx] >= A[leftIdx] && A[midIdx] <= A[rightIdx]) || (A[midIdx] <= A[leftIdx] && A[midIdx] >= A[rightIdx])) {
      return midIdx; // Return the index of the middle element if it is the median
    } else {
      return rightIdx; // Return the index of the right element if it is the median
    }
  }//medianOfThree()

  public static void quickSortRandom(int[] A) {
    quickSortRandomRecurse(A, 0, A.length - 1);
  }//quickSortRandom()

  private static void quickSortRandomRecurse(int[] A, int leftIdx, int rightIdx) {
    if (leftIdx < rightIdx) { // If there are more than one elements
      int pivotIdx = doRandomPartitioning(A, leftIdx, rightIdx); // Partition the array randomly and get the pivot index
      quickSortRandomRecurse(A, leftIdx, pivotIdx - 1); // Recursively sort the left partition
      quickSortRandomRecurse(A, pivotIdx + 1, rightIdx); // Recursively sort the right partition
    }
  }//quickSortRandomRecurse()

  private static int doRandomPartitioning(int[] A, int leftIdx, int rightIdx) {
    int randomIdx = (int) (Math.random() * (rightIdx - leftIdx + 1)) + leftIdx; // Generate a random index within the subarray
    int temp = A[randomIdx]; // Swap the randomly selected element with the last element
    A[randomIdx] = A[rightIdx];
    A[rightIdx] = temp;

    return doPartitioning(A, leftIdx, rightIdx); // Partition the array using the regular partitioning logic
  }//doRandomPartitioning()
}// Sorts class

