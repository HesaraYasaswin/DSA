// Source: https://www.geeksforgeeks.org/convert-given-decimal-number-into-a-base-n-number/

import java.util.Scanner;

public class DecimalToBaseN {
    public static void main(String[] args) {
        // Prompt the user to enter the decimal number and the base
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the decimal number to convert: ");
        int decimal = sc.nextInt();
        System.out.print("Enter the base to convert to (between 2 and 16): ");
        int base = sc.nextInt();
        sc.close();
        
        // Convert the decimal number to the specified base using the recursive algorithm
        String result = decimalToBaseN(decimal, base);
        
        // Print the result
        System.out.println(decimal + " in base " + base + " is " + result);
    }
    
    // This method implements the recursive algorithm for converting a decimal number to any base between 2 and 16
    public static String decimalToBaseN(int decimal, int base) {
        // Base case: if the decimal number is 0, return an empty string
        if (decimal == 0) {
            return "";
        }
        
        // Recursive case: convert the quotient and append the remainder to the result
        int quotient = decimal / base;
        int remainder = decimal % base;
        String result = decimalToBaseN(quotient, base);
        if (remainder < 10) {
            result += Integer.toString(remainder);
        } else {
            result += (char) ('A' + remainder - 10);
        }
        return result;
    }
}