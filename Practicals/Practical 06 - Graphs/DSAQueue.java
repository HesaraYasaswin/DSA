public class DSAQueue<E> {
    private ListNode<E> head;
    private ListNode<E> tail;

    public DSAQueue() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void enqueue(E item) {
        ListNode<E> newNode = new ListNode<E>(item);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        E temp = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return temp;
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
}
