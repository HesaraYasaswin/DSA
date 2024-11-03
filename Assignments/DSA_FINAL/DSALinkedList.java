// Adapted from code previously submitted for COMP1002 Practical 5

import java.util.*;
import java.io.*;

public class DSALinkedList implements Iterable, Serializable
{
    class DSAListNode implements Serializable
    {

        private Object value;
            
        private DSAListNode prev, next;
            


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



    class DSALinkedListIterator implements Iterator, Serializable
    {

        private DSAListNode iterNext;
            


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
                    
                iterNext = iterNext.getNext();
                    
            }

            return value;
        }


        public void remove()
        {
            throw new UnsupportedOperationException( "Not supported" );
        }
    }



    private DSAListNode head, tail;
        


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


    public String toString()
    {
        String listString;
        Iterator iter = iterator();

        if( isEmpty() )
        {
            listString = "[]";
        }
        else
        {
            listString = "[ " + iter.next();
            while( iter.hasNext() )
            {
                listString += ", " + iter.next().toString();
            }
            listString += " ]";
        }

        return listString;

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
    
    public int getCount()
    {
        int count = 0;

        for( Object o : this )
        {
            count++;
        }

        return count;
    }


    public boolean removeNode(Object value, int count) {
        if (isEmpty()) {
            return false;
        }

        DSAListNode prevNode = null;
        DSAListNode currentNode = head;

        while (currentNode != null) {
            if (currentNode.getValue().equals(value)) {
                if (prevNode == null) { 
                    head = currentNode.getNext();
                    if (currentNode == tail) { 
                        tail = null;
                    }
                } else { 
                    prevNode.setNext(currentNode.getNext());
                    if (currentNode == tail) { 
                        tail = prevNode;
                    }
                }

                count--;
                return true;
            }

            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }

        return false;
    }


    public boolean hasNode( Object inValue )
    {
        DSAListNode currNode;
        boolean retValue = false;

        if( !isEmpty() )
        {
            currNode = head;
            while( currNode != null && !retValue )
            {
                if( currNode.value.equals( inValue ) )
                {
                    retValue = true;
                }

                currNode = currNode.next;
            }
        }

        return retValue;
    }

    public Iterator iterator()
    {
        return new DSALinkedListIterator( this );
    }


    public boolean contains(Object value) {
        DSAListNode currentNode = head;

        while (currentNode != null) {
            if (currentNode.getValue().equals(value)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }

        return false;
    }


	public DSALinkedList.DSAListNode getHead() {
		return head;
	}



}