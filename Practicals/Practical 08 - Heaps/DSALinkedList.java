import java.util.*;
import java.io.*;

public class DSALinkedList implements Iterable, Serializable
{
    private class DSAListNode implements Serializable
    {

        private Object value;
            // The value of the list node
        private DSAListNode prev, next;
            // References to the previous and next nodes in the list


        public DSAListNode( Object inValue )
        {
            value = inValue;
            prev = null;
            next = null;
        }

 
        public Object getValue()
        {
            return value;
        }


        public DSAListNode getPrev()
        {
            return prev;
        }


        public DSAListNode getNext()
        {
            return next;
        }


        public void setValue( Object inValue )
        {
            value = inValue;
        }


        public void setPrev( DSAListNode inListNode )
        {
            prev = inListNode;
        }


        public void setNext( DSAListNode inListNode )
        {
            next = inListNode;
        }
    }



    private class DSALinkedListIterator implements Iterator, Serializable
    {

        private DSAListNode iterNext;
            // Iteration cursor


        public DSALinkedListIterator( DSALinkedList linkedList )
        {
            iterNext = linkedList.head;
        }


        public boolean hasNext()
        {
            return iterNext != null;
        }


        public Object next()
        {
            Object value;

            if( iterNext == null )
            {
                value = null;
            }
            else
            {
                value = iterNext.getValue();
                    //Get the value in the node
                iterNext = iterNext.getNext();
                    //Ready for subsequent calls to next()
            }

            return value;
        }


        public void remove()
        {
            throw new UnsupportedOperationException( "Not supported" );
        }
    }


    private DSAListNode head, tail;
        // References to the head and tail list nodes


    public DSALinkedList()
    {
        head = null;
        tail = null;
    }


    public boolean isEmpty()
    {
        boolean empty = false;

        empty = head == null;

        return empty;
    }

    public Object peekFirst()
    {
        Object nodeValue;

        if( isEmpty() )
        {
            throw new IllegalArgumentException( "List is empty" );
        }
        else
        {
            nodeValue = head.getValue();
        }

        return nodeValue;
    }


    public Object peekLast()
    {
        Object nodeValue;

        if( isEmpty() )
        {
            throw new IllegalArgumentException( "List is empty" );
        }
        else
        {
            nodeValue = tail.getValue();
        }

        return nodeValue;
    }

    public void insertFirst( Object inValue )
    {
        DSAListNode newNd = new DSAListNode( inValue );

        if( isEmpty() )
        {
            head = newNd;
            tail = newNd;
        }
        else
        {
            // Set the current head to the next of the new node, and set the
            // head to the new node
            newNd.setNext( head );
            head.setPrev( newNd );
            head = newNd;
        }
    }


    public void insertLast( Object inValue )
    {
        DSAListNode newNd = new DSAListNode( inValue );

        if( isEmpty() )
        {
            head = newNd;
            tail = newNd;
        }
        else
        {
            tail.setNext( newNd );
            newNd.setPrev( tail );
            tail = newNd;
        }
    }


    public Object removeFirst()
    {
        Object nodeValue;

        if( isEmpty() )
        {
            throw new IllegalArgumentException( "List is empty" );
        }
        else if( head.getNext() == null )
        {
            nodeValue = head.getValue();
            head = null;
            tail = null;
        }
        else
        {
            nodeValue = head.getValue();
            head = head.getNext();
        }

        return nodeValue;
    }

    public Object removeLast()
    {
        Object nodeValue;

        if( isEmpty() )
        {
            throw new IllegalArgumentException( "List is empty" );
        }
        else if( tail.getPrev() == null )
        {
            nodeValue = tail.getValue();
            head = null;
            tail = null;
        }
        else
        {
            nodeValue = tail.getValue();
            tail.getPrev().setNext( null );
            tail = tail.getPrev();
        }

        return nodeValue;
    }

    public Iterator iterator()
    {
        return new DSALinkedListIterator( this );
    }
}