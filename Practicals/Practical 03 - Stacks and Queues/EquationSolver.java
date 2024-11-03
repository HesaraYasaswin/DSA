import java.util.*;

public class EquationSolver {
    public double solve(String equation) {
        DSAQueue postfixQueue = _parseInfixToPostfix(equation);
        return _evaluatePostfix(postfixQueue);
    }

 // method that parses an infix notation equation into postfix notation
    DSAQueue _parseInfixToPostfix(String equation) {
        DSAQueue postfixQueue = new DSAQueue(); // create a new queue to store the postfix notation
        DSAStack operatorStack = new DSAStack(); // create a new stack to store operators temporarily
        String[] tokens = equation.split(" "); // split the equation into tokens separated by spaces

        for (String token : tokens) {
            char firstChar = token.charAt(0); // get the first character of the token

            switch (firstChar) {
                case '+':
                case '-':
                case '*':
                case '/':
                    // if the token is an operator, and there are operators at the top of the stack with higher precedence, pop them and enqueue them
                    while (!operatorStack.isEmpty() && _precedenceOf(firstChar) <= _precedenceOf((char) operatorStack.top())) {
                        postfixQueue.enqueue(operatorStack.pop());
                    }
                    operatorStack.push(firstChar); // push the current operator onto the stack
                    break;
                case '(':
                    operatorStack.push(firstChar); // push an opening parenthesis onto the stack
                    break;
                case ')':
                    // if the token is a closing parenthesis, pop operators from the stack and enqueue them until an opening parenthesis is reached
                    while (!operatorStack.isEmpty() && (char) operatorStack.top() != '(') {
                        postfixQueue.enqueue(operatorStack.pop());
                    }
                    operatorStack.pop(); // pop the opening parenthesis from the stack
                    break;
                default:
                    postfixQueue.enqueue(Double.valueOf(token)); // if the token is a number, enqueue it
                    break;
            }
        }

        // after all tokens are processed, pop any remaining operators from the stack and enqueue them
        while (!operatorStack.isEmpty()) {
            postfixQueue.enqueue(operatorStack.pop());
        }

        return postfixQueue; // return the postfix notation queue
    }

    // method that evaluates a postfix notation queue and returns the result
    double _evaluatePostfix(DSAQueue postfixQueue) {
        DSAStack operandStack = new DSAStack(); 

        while (!postfixQueue.isEmpty()) {
            Object item = postfixQueue.dequeue(); // dequeue an item from the postfix notation queue

            if (item instanceof Double) { // if it's a number, push it onto the operand stack
                operandStack.push(item);
            } else { // if it's an operator, pop two operands from the stack, execute the operation, and push the result onto the stack
                double op2 = (double) operandStack.pop();
                double op1 = (double) operandStack.pop();
                double result = _executeOperation((char) item, op1, op2);

                operandStack.push(result);
            }
        }

        return (double) operandStack.pop(); // return the final result (which should be the only item left on the stack)
    }

    // private helper method that returns the precedence of an operator
    private int _precedenceOf(char theOp) {
        int precedence;

        switch (theOp) {
            case '+':
            case '-':
                precedence = 1;
                break;
            case '*':
            case '/':
                precedence = 2;
                break;
            default:
                precedence = -1;
                break;
        }

        return precedence;
    }

    // private helper method that executes an operation on two operands and returns the result
    private double _executeOperation(char op, double op1, double op2) {
        double result;

        switch (op) {
            case '+':
                result = op1 + op2;
                break;
            case '-':
                result = op1 - op2;
                break;
            case '*':
                result = op1 * op2;
                break;
            case '/':
                result = op1 / op2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }

        return result;
    }

    // main method for testing purposes
    public static void main(String[] args) {
        EquationSolver solver = new EquationSolver(); // create a new instance of EquationSolver
        String equation = "2 + 8 / ( 3 * 2 ) - 4"; // set the infix notation equation to solve
        System.out.println("Equation: " + equation); 
        System.out.println("Result: " + solver.solve(equation)); 
    }
}
