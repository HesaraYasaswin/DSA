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
  }//mergeSort()

  private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx) 
  {
  }//mergeSortRecurse()

  private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx) 
  {
  }//merge()

  // quickSort - front-end for kick-starting the recursive algorithm
  public static void quickSort(int[] A) {
  }//quickSort()

  private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx) {
  }//quickSortRecurse()

}// Sorts class

