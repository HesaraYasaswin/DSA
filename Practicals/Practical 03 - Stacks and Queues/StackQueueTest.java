import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackQueueTest {

    private DSAStack stack; // Declare an instance variable of type DSAStack
    private DSAQueue queue; // Declare an instance variable of type DSAQueue

    // This method is run before each test method and initializes the stack and queue.
    @Before
    public void setUp() {
        stack = new DSAStack(); 
        queue = new DSAQueue(); 
    }

    // DSAStack tests

    // This test checks if the push method of the stack works correctly.
    @Test
    public void testStackPush() {
        try {
            stack.push("a");
            stack.push("b");
            assertEquals(2, stack.getCount());
            System.out.println("testStackPush passed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This test checks if the push method of the stack throws an exception when the stack is full.
    @Test
    public void testStackPushFull() {
        try {
            for (int i = 0; i < 100; i++) {
                stack.push(i);
            }
            stack.push("a"); // should throw RuntimeException
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            System.out.println("testStackPushFull passed");
        }
    }

    // This test checks if the pop method of the stack works correctly.
    @Test
    public void testStackPop() {
        try {
            stack.push("a");
            stack.push("b");
            Object val = stack.pop();
            assertEquals("b", val);
            assertEquals(1, stack.getCount());
            System.out.println("testStackPop passed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This test checks if the pop method of the stack throws an exception when the stack is empty.
    @Test
    public void testStackPopEmpty() {
        try {
            stack.pop(); // should throw RuntimeException
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            System.out.println("testStackPopEmpty passed");
        }
    }

    // This test checks if the top method of the stack works correctly.
    @Test
    public void testStackTop() {
        try {
            stack.push("a");
            stack.push("b");
            Object val = stack.top();
            assertEquals("b", val);
            assertEquals(2, stack.getCount());
            System.out.println("testStackTop passed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This test checks if the top method of the stack throws an exception when the stack is empty.
    @Test
    public void testStackTopEmpty() {
        try {
            stack.top(); // should throw RuntimeException
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            System.out.println("testStackTopEmpty passed");
        }
    }

    // DSAQueue tests

    // This test checks if the enqueue method of the queue works correctly.
    @Test
    public void testQueueEnqueue() {
        try {
            queue.enqueue("a");
            queue.enqueue("b");
            assertEquals(2, queue.getCount());
            System.out.println("testQueueEnqueue passed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This test checks if the enqueue method of the queue throws an exception when the queue is full.
    @Test
    public void testQueueEnqueueFull() {
        try {
            for (int i = 0; i < 100; i++) {
                queue.enqueue(i);
            }
            queue.enqueue("a"); // should throw RuntimeException
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            System.out.println("testQueueEnqueueFull passed");
        }
    }

    @Test
    public void testQueueDequeue() {
        try {
            queue.enqueue("a");
            queue.enqueue("b");
            Object val = queue.dequeue();
            assertEquals("a", val);
            assertEquals(1, queue.getCount());
            System.out.println("testQueueDequeue passed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueueDequeueEmpty() {
        try {
            queue.dequeue(); // should throw RuntimeException
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            System.out.println("testQueueDequeueEmpty passed");
        }
    }

    @Test
    public void testQueuePeek() {
        try {
            queue.enqueue("a");
            queue.enqueue("b");
            Object val = queue.peek();
            assertEquals("a", val);
            assertEquals(2, queue.getCount());
            System.out.println("testQueuePeek passed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueuePeekEmpty() {
        try {
            queue.peek(); // should throw RuntimeException
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            System.out.println("testQueuePeekEmpty passed");
        }
    }
}