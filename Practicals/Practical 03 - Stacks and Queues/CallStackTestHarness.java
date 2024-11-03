import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CallStackTestHarness {

	// Test method for recursive factorial calculation
	@Test
	public void test_factorial_rcsv() {
	    // Create a CallStack object
	    CallStack cStack = new CallStack();

	    // Call factorial_rcsv method with an argument of 5
	    int result = cStack.factorial_rcsv(5);

	    // Verify that the result is correct
	    assertEquals(120, result);
	}

	// Test method for iterative factorial calculation
	@Test
	public void test_factorial_itr() {
	    // Create a CallStack object
	    CallStack cStack = new CallStack();

	    // Call factorial_itr method with an argument of 5
	    int result = cStack.factorial_itr(5);

	    // Verify that the result is correct
	    assertEquals(120, result);
	}

}