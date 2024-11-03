import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DSALinkedList<T> implements Iterable<T>, Serializable {
    private DSAListNode head;
    private DSAListNode tail;

    // Inner class representing a node in the linked list
    private class DSAListNode implements Serializable {
        private Object value;  // The value held by this node
        private DSAListNode next;  // The next node in the linked list
        private DSAListNode prev;  // The previous node in the linked list

        // Constructor
        public DSAListNode(Object inValue) {
            value = inValue;
            next = null;
            prev = null;
        }

        // Getter and setter methods
        public Object getValue() {
            return value;
        }

        public void setValue(Object inValue) {
            value = inValue;
        }

        public DSAListNode getNext() {
            return next;
        }

        public void setNext(DSAListNode inNext) {
            next = inNext;
        }

        public DSAListNode getPrev() {
            return prev;
        }

        public void setPrev(DSAListNode inPrev) {
            prev = inPrev;
        }
    }

    // Constructor
    public DSALinkedList() {
        head = null;
        tail = null;
    }

    // Check if the linked list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Check if the linked list is full
    public boolean isFull() {
        // Linked lists cannot be full, so always return false
        return false;
    }

    // Insert a new node at the beginning of the linked list
    public void insertFirst(Object inValue) {
        DSAListNode newNode = new DSAListNode(inValue);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.setPrev(newNode);
        }
        newNode.setNext(head);
        head = newNode;
    }

    // Insert a new node at the end of the linked list
    public void insertLast(Object inValue) {
        DSAListNode newNode = new DSAListNode(inValue);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
    }

    // Return the value of the first node in the linked list
    public Object peekFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return head.getValue();
    }

    // Return the value of the last node in the linked list
    public Object peekLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return tail.getValue();
    }

    // Remove the first node in the linked list and return its value
    public Object removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        Object value = head.getValue();
        head = head.getNext();
        if (head == null) {
            tail = null;
        } else {
            head.setPrev(null);
        }
        return value;
    }

    // Remove the last node in the linked list and return its value
    public Object removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        Object value = tail.getValue();
        tail = tail.getPrev();
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null);
        }
        return value;
    }
    
    public Iterator<T> iterator() {
        // Return a new instance of DSALinkedListIterator to iterate over the linked list
        return (Iterator<T>) new DSALinkedListIterator();
    }

    // Private inner class that implements the Iterator interface for the linked list
    private class DSALinkedListIterator implements Iterator<Object> {
        private DSAListNode iterNext; // Stores the next element to be returned by the iterator
        
        public DSALinkedListIterator() {
            iterNext = head; // Set iterNext to the head of the linked list
        }
        
        public boolean hasNext() {
            // Return true if iterNext is not null, indicating that there is another element to iterate over
            return iterNext != null;
        }
        
        public Object next() {
            // Throw a NoSuchElementException if there are no more elements to iterate over
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            // Get the value of the current element and move iterNext to the next element
            Object value = iterNext.getValue();
            iterNext = iterNext.getNext();
            return value; // Return the value of the current element
        }
        
        public void remove() {
            // Throw an UnsupportedOperationException since remove is not supported by this implementation
            throw new UnsupportedOperationException("remove");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Iterate over the linked list using the iterator and append each element to the StringBuilder
        for (Object item : this) {
            sb.append(item.toString()).append(" ");
        }
        return sb.toString().trim(); // Return the StringBuilder as a string
    }
    

}


    

