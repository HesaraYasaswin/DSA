import java.util.Iterator;
import java.util.NoSuchElementException;

public class DSALinkedList<E> implements Iterable<E> {
    private ListNode<E> head;
    private ListNode<E> tail;
    private int count;

    public DSALinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void insertFirst(E item) {
        ListNode<E> newNode = new ListNode<E>(item);
        if (isEmpty()) {
            tail = newNode;
        }
        newNode.setNext(head);
        head = newNode;
        count++;
    }

    public void insertLast(E item) {
        ListNode<E> newNode = new ListNode<E>(item);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        count++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        E temp = head.getData();
        if (head == tail) {
            tail = null;
        }
        head = head.getNext();
        count--;
        return temp;
    }

    public Iterator<E> iterator() {
        return new ListIterator<E>(head);
    }

    private static class ListNode<E> {
        private E data;
        private ListNode<E> next;

        public ListNode(E data) {
            this.data = data;
            next = null;
        }

        public E getData() {
            return data;
        }

        public ListNode<E> getNext() {
            return next;
        }

        public void setNext(ListNode<E> next) {
            this.next = next;
        }
    }

    private static class ListIterator<E> implements Iterator<E> {
        private ListNode<E> current;

        public ListIterator(ListNode<E> head) {
            current = head;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E temp = current.getData();
            current = current.getNext();
            return temp;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public boolean contains(DSAGraphNode node) {
        for (E item : this) {
            if (item.equals(node)) {
                return true;
            }
        }
        return false;
    }

    public int getCount() {
        return count;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            ListNode<E> current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            tail = current;
            tail.setNext(null);
        }
        count--;
    }

    public DSAGraphNode getLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty");
        }
        return (DSAGraphNode) tail.getData();
    }
}