import java.util.Iterator;

public class DSAStack<E> implements Iterable<E>
{
    private DSALinkedList<E> list; // the linked list used to store the elements

    public DSAStack()
    {
        list = new DSALinkedList<E>(); // initialize 
    }

    public void push(E value)  // Pushes an element onto the top of the stack.
    {
        list.insertFirst(value);  // add the value to the front of the linked list
    }

    public E pop()  // Removes and returns the element at the top of the stack.
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("Stack is empty");
        }

        return (E) list.removeFirst(); // remove and return the first element in the linked list
    }

    public E peek() // Returns the element at the top of the stack without removing it.
    {
        if (isEmpty())
        {
            throw new IllegalArgumentException("Stack is empty");
        }

        return (E) list.peekFirst(); // return the first element in the linked list without removing
    }

    public boolean isEmpty() // Determines if the stack is empty.
    {
        return list.isEmpty();
    }

    public Iterator<E> iterator() // Returns an iterator over the elements in the stack.
    {
        return list.iterator(); // return an iterator over the linked list
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        // Traverse the linked list from top to bottom and append each item to the StringBuilder
        for (Object item : list)
        {
            sb.append(item.toString()).append(" ");
        }

        return sb.toString();
    }
}
