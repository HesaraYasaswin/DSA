import java.util.ArrayList;

public class CallStack {
    private ArrayList<String> callStack;

 // Constructor to initialize the callStack ArrayList
    public CallStack() {
        callStack = new ArrayList<String>();
    }

    // Recursive method to calculate the factorial of n
    public int factorial_rcsv(int n) {
        // Method call pushed to stack
        callStack.add("factorial_rcsv(" + n + ")");

        int result = 1;
        if (n == 0) {
            result = 1;
        } else {
            result = n * factorial_rcsv(n - 1);
        }

        // callStack.pop()
        
        System.out.println("factorial_rcsv(" + n + ") = " + result);
        return result;
    }

    // Iterative method to calculate the factorial of n
    public int factorial_itr(int n) {
        // Method called pushed to stack
        callStack.add("factorial_itr(" + n + ")");

        int result = 1;
        for (int i = n; i > 1; i--) {
            result *= i;
        }

        // callStack.pop()
        System.out.println("factorial_itr(" + n + ") = " + result);
        return result;
    }

    // Method to display the call stack
    public void display_call_stack() {
        // If call stack is empty, print a message and return
        if (callStack.isEmpty()) {
            System.out.println("Call stack is empty.");
            return;
        }

        // Print the call stack in reverse order
        System.out.println("Call stack:");
        for (int i = callStack.size() - 1; i >= 0; i--) {
            System.out.println(callStack.get(i));
        }
    }

    // Main method to test the CallStack class
    public static void main(String[] args) {
        CallStack cStack = new CallStack();
        cStack.factorial_rcsv(5);
        cStack.factorial_itr(5);
        cStack.display_call_stack();
    }
}