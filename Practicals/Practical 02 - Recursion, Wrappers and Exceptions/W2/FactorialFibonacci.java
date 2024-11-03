import java.util.Scanner;

public class FactorialFibonacci {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);
        // Prompt the user to enter a value for n
        System.out.print("Enter a value for n: ");
        // Read the user's input as an integer and store it in variable n
        int n = input.nextInt();

        // Call the factorialIterative function with n and store the result in variable factorialIterative
        long factorialIterative = factorialIterative(n);      
        System.out.println("Factorial of " + n + " (iterative): " + factorialIterative);

        // Call the factorialRecursive function with n and store the result in variable factorialRecursive
        long factorialRecursive = factorialRecursive(n);
        System.out.println("Factorial of " + n + " (recursive): " + factorialRecursive);

        // Call the fibonacciIterative function with n and store the result in variable fibonacciIterative
        long fibonacciIterative = fibonacciIterative(n);
        System.out.println("Fibonacci number at index " + n + " (iterative): " + fibonacciIterative);

        // Call the fibonacciRecursive function with n and store the result in variable fibonacciRecursive
        long fibonacciRecursive = fibonacciRecursive(n);
        System.out.println("Fibonacci number at index " + n + " (recursive): " + fibonacciRecursive);
    }

    // Iterative function to calculate factorial of a number
    public static long factorialIterative(int n) {
        long result = 1;
        // Loop through all integers from 2 to n (inclusive)
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Recursive function to calculate factorial of a number
    public static long factorialRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            // If n is greater than 1, recursively call the factorialRecursive function with n - 1 and multiply it by n
            return n * factorialRecursive(n - 1);
        }
    }
    // Iterative function to calculate Fibonacci number at a given index
    public static long fibonacciIterative(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            long fib0 = 0;
            long fib1 = 1;
            long fib = 0;
            for (int i = 2; i <= n; i++) {
                fib = fib0 + fib1;
                fib0 = fib1;
                fib1 = fib;
            }
            return fib;
        }
    }

    // Recursive function to calculate Fibonacci number at a given index
    public static long  fibonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }
}