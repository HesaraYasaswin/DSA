import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class Q3TestHarness {

    private DSAStack stack;
    private DSAQueue queue;
    private DSACircularQueue circularQueue;

    // Set up the data structures before running each test
    @Before
    public void setUp() {
        stack = new DSAStack();
        queue = new DSAQueue();
        circularQueue = new DSACircularQueue(5);
    }

    // Tests for DSAStack

    // Test stack push operation
    @Test
    public void testStackPush() {
        stack.push("a");
        stack.push("b");
        assertEquals(2, stack.getCount());
        System.out.println("testStackPush PASSED");
    }

    // Test push operation when stack is full
    @Test(expected = RuntimeException.class)
    public void testStackPushFull() {
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        stack.push("a"); // should throw RuntimeException
        System.out.println("testStackPushFull PASSED");
    }

    // Test stack pop operation
    @Test
    public void testStackPop() {
        stack.push("a");
        stack.push("b");
        Object val = stack.pop();
        assertEquals("b", val);
        assertEquals(1, stack.getCount());
        System.out.println("testStackPop PASSED");
      }

    // Test pop operation when stack is empty
    @Test(expected = RuntimeException.class)
    public void testStackPopEmpty() {
        stack.pop(); // should throw RuntimeException
        System.out.println("testStackPopEmpty PASSED");
    }

    // Test stack top operation
    @Test
    public void testStackTop() {
        stack.push("a");
        stack.push("b");
        Object val = stack.top();
        assertEquals("b", val);
        assertEquals(2, stack.getCount());
        System.out.println("testStackTop PASSED");
    }

    // Test top operation when stack is empty
    @Test(expected = RuntimeException.class)
    public void testStackTopEmpty() {
        stack.top(); // should throw RuntimeException
        System.out.println("testStackTopEmpty PASSED");
    }

    // Tests for DSAQueue

    // Test queue enqueue operation
    @Test
    public void testQueueEnqueue() {
        queue.enqueue("a");
        queue.enqueue("b");
        assertEquals(2, queue.getCount());
        System.out.println("testQueueEnqueue PASSED");
    }

    // Test enqueue operation when queue is full
    @Test(expected = RuntimeException.class)
    public void testQueueEnqueueFull() {
        for (int i = 0; i < 100; i++) {
            queue.enqueue(i);
        }
        queue.enqueue("a"); // should throw RuntimeException
        System.out.println("testQueueEnqueueFull PASSED");
    }

    // Test queue dequeue operation
    @Test
    public void testQueueDequeue() {
        queue.enqueue("a");
        queue.enqueue("b");
        Object val = queue.dequeue();
        assertEquals("a", val);
        assertEquals(1, queue.getCount());
        System.out.println("testQueueDequeue PASSED");
    }

    // Test dequeue operation when queue is empty
    @Test(expected = RuntimeException.class)
    public void testQueueDequeueEmpty() {
        queue.dequeue(); // should throw RuntimeException
        System.out.println("testQueueDequeueEmpty PASSED");
    }

    // Test queue peek operation
    @Test
    public void testQueuePeek() {
        queue.enqueue("a");
        queue.enqueue("b");
        Object val = queue.peek();
        assertEquals("a", val);
        assertEquals(2, queue.getCount());
        System.out.println("testQueuePeek PASSED");
    }

    // Test peek operation when queue is empty
    @Test(expected = RuntimeException.class)
    public void testQueuePeekEmpty() {
        queue.peek(); // should throw RuntimeException
        System.out.println("testQueuePeekEmpty PASSED");
    }

    // Tests for DSACircularQueue

    // Test circular queue enqueue operation
    @Test
    public void testCircularQueueEnqueue() {
        circularQueue.enqueue("a");
        circularQueue.enqueue("b");
        assertEquals(2, circularQueue.getCount());
        System.out.println("testCircularQueueEnqueue PASSED");
    }

    // Test enqueue operation when circular queue is full
    @Test(expected = RuntimeException.class)
    public void testCircularQueueEnqueueFull() {
        for (int i = 0; i < 5; i++) {
            circularQueue.enqueue(i);
        }
        circularQueue.enqueue("a"); // should throw RuntimeException
        System.out.println("testCircularQueueEnqueueFull PASSED");
    }

    // Test circular queue dequeue operation
    @Test
    public void testCircularQueueDequeue() {
        circularQueue.enqueue("a");
        circularQueue.enqueue("b");
        Object val = circularQueue.dequeue();
        assertEquals("a", val);
        assertEquals(1, circularQueue.getCount());
        System.out.println("testCircularQueueDequeue PASSED");
    }

    // Test dequeue operation when circular queue is empty
    @Test(expected = RuntimeException.class)
    public void testCircularQueueDequeueEmpty() {
        circularQueue.dequeue(); // should throw RuntimeException
        System.out.println("testCircularQueueDequeueEmpty PASSED");
    }

    // Test circular queue peek operation
    @Test
    public void testCircularQueuePeek() {
        circularQueue.enqueue("a");
        circularQueue.enqueue("b");
        Object val = circularQueue.peek();
        assertEquals("a", val);
        assertEquals(2, circularQueue.getCount());
        System.out.println("testCircularQueuePeek PASSED");
    }

    // Test peek operation when circular queue is empty
    @Test(expected = RuntimeException.class)
    public void testCircularQueuePeekEmpty() {
        circularQueue.peek(); // should throw RuntimeException
        System.out.println("testCircularQueuePeekEmpty PASSED");
    }
}
