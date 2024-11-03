// Source: https://en.wikipedia.org/wiki/Euclidean_algorithm

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        // Prompt the user to enter the two numbers whose GCD is to be found
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();
        sc.close();
        
        // Calculate the GCD using the Euclidean algorithm
        int gcd = euclideanAlgorithm(num1, num2);
        
        // Print the result
        System.out.println("The GCD of " + num1 + " and " + num2 + " is " + gcd);
    }
    
    // This method implements the Euclidean algorithm recursively to find the GCD of two numbers
    public static int euclideanAlgorithm(int num1, int num2) {
        // Base case: if one of the numbers is 0, return the other number
        if (num2 == 0) {
            return num1;
        }
        
        // Recursive case: find the GCD of the smaller number and the difference between the two numbers
        int remainder = num1 % num2;
        return euclideanAlgorithm(num2, remainder);
    }
}