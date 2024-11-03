// Adapted from code previously submitted for COMP1002 Practical 6

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DSAQueue<E> implements Iterable<E> {
    private Node<E> front; // front of the queue
    private Node<E> back; // back of the queue
    private int count; 

    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public DSAQueue() {
        front = null;
        back = null;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getCount() {
        return count;
    }

    public void enqueue(E item) {
        Node<E> newNode = new Node<E>(item, null);
        if (isEmpty()) {
            front = newNode;
        } else {
            back.next = newNode;
        }
        back = newNode;
        count++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E item = front.item;
        front = front.next;
        count--;
        if (isEmpty()) {
            back = null;
        }
        return item;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.item;
    }

    public void clear() {
        front = null;
        back = null;
        count = 0;
    }

    public Iterator<E> iterator() {
        return new QueueIterator(front);
    }

    private class QueueIterator implements Iterator<E> {
        private Node<E> current;

        public QueueIterator(Node<E> front) {
            current = front;
        }

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}