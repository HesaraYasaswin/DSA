import java.util.InputMismatchException;
import java.util.Scanner;

public class Q4 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        // Prompt the user to select a conversion method
        Scanner sc = new Scanner(System.in);
        System.out.println("Select a conversion method:");
        System.out.println("1. Factorial");
        System.out.println("2. Fibonacci");
        System.out.println("3. Greatest Common Denominator");
        System.out.println("4. Decimal to Base N");
        int choice = sc.nextInt();
        
        // Call the selected conversion method
        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter a non-negative integer: ");
                    int n1 = sc.nextInt();
                    if (n1 < 0) {
                        throw new IllegalArgumentException("Input must not be negative");
                    }
                    long result1 = calcNFactorial(n1);
                    System.out.println(n1 + "! = " + result1);
                    break;
                case 2:
                    System.out.print("Enter a non-negative integer: ");
                    int n2 = sc.nextInt();
                    if (n2 < 0) {
                        throw new IllegalArgumentException("Input must not be negative");
                    }
                    long result2 = calcNFibonacci(n2);
                    System.out.println("Fibonacci(" + n2 + ") = " + result2);
                    break;
                case 3:
                    System.out.print("Enter two non-negative integers separated by a space: ");
                    int m = sc.nextInt();
                    int n3 = sc.nextInt();
                    if (m < 0 || n3 < 0) {
                        throw new IllegalArgumentException("Inputs must not be negative");
                    }
                    long result3 = calcGCD(m, n3);
                    System.out.println("GCD(" + m + ", " + n3 + ") = " + result3);
                    break;
                case 4:
                    System.out.print("Enter a non-negative integer: ");
                    int decimal = sc.nextInt();
                    if (decimal < 0) {
                        throw new IllegalArgumentException("Input must not be negative");
                    }
                    System.out.print("Enter the base to convert to (between 2 and 16): ");
                    int base = sc.nextInt();
                    if (base < 2 || base > 16) {
                        throw new IllegalArgumentException("Base must be between 2 and 16");
                    }
                    String result4 = decimalToBaseN(decimal, base);
                    System.out.println(decimal + " in base " + base + " is " + result4);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid choice");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input must be an integer");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        sc.close();
    }
    
    
    // Factorial
    public static long calcNFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * calcNFactorial(n - 1);
        }
    }
    
    // Fibonacci
    public static long calcNFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return calcNFibonacci(n - 1) + calcNFibonacci(n - 2);
        }
    }
    
    // Greatest Common Denominator
    public static long calcGCD(long m, long n) {
        if (n == 0) {
            return m;
        } else {
            return calcGCD(n, m % n);
        }
    }
   // Decimal to Base N
    public static String decimalToBaseN(int decimal, int base) {
        if (decimal == 0) {
            return "0";
        } else {
            String digits = "0123456789ABCDEF";
            String result = "";
            while (decimal > 0) {
                int digit = decimal % base;
                result = digits.charAt(digit) + result;
                decimal /= base;
            }
            return result;
        }
    }
}