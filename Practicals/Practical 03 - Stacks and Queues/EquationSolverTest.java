import java.util.Scanner;

public class EquationSolverTest {
    public static void main(String[] args) {
        EquationSolver solver = new EquationSolver();
        // Creating an instance of Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompting to enter an equation
        System.out.print("Enter an equation: ");

        // Reading the user input as a String
        String equation = scanner.nextLine();

        // Parsing the infix equation into a postfix queue
        DSAQueue postfixQueue = solver._parseInfixToPostfix(equation);

        
        System.out.println("Postfix notation:");
        while (!postfixQueue.isEmpty()) {
            System.out.print(postfixQueue.dequeue() + " ");
        }
        System.out.println();

        // Solving the equation and printing the result
        double result = solver.solve(equation);
        System.out.println("Result: " + result);

        
        scanner.close();
    }
}