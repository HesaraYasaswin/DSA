public class DSAStack {
    private Object[] stack;  // array to store the elements in the stack
    private int count;      
    private static final int DEFAULT_CAPACITY = 100;  // default capacity of the stack
    
    // Default constructor
    public DSAStack() {
        stack = new Object[DEFAULT_CAPACITY];  // create new array with default capacity
        count = 0;  // initialize count to 0
    }
    
    // Alternate constructor
    public DSAStack(int maxCapacity) {
        stack = new Object[maxCapacity];  // create new array with given maximum capacity
        count = 0;  // initialize count to 0
    }
    
    // Accessor for count field
    public int getCount() {
        return count;  
    }
    
    // Accessor for empty field
    public boolean isEmpty() {
        return count == 0;  
    }
    
    // Accessor for full field
    public boolean isFull() {
        return count == stack.length;  
    }
    
    // Mutator for push operation
    public void push(Object value) {
        if (isFull()) {  // if the stack is already full
            throw new RuntimeException("Stack overflow");  // throw a runtime exception with an error message
        } else {  
            stack[count] = value;  // add the value to the top of the stack (at index count)
            count++;  
        }
    }
    
    // Mutator for pop operation
    public Object pop() {
        Object topVal = top();  // get the top value of the stack
        count--; 
        return topVal; 
    }
    
    // Accessor for top operation
    public Object top() {
        if (isEmpty()) {  
            throw new RuntimeException("Stack underflow");  // throw a runtime exception with an error message
        } else {  
            return stack[count - 1];  // return the value at the top of the stack (at index count - 1)
        }
    }
    
    // Display method to show the contents of the stack
    public void display() {
        System.out.print("Stack (top to bottom): ");  // print a message 
        for (int i = count - 1; i >= 0; i--) {  // iterate through the stack from the top to the bottom
            System.out.print(stack[i] + " ");  // print the value at each index, separated by a space
        }
        System.out.println();  // print a newline character to move to the next line
    }

}


