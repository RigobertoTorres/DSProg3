    //****************************************************************
    //  LinkedIterator.java       Authors: Lewis/Chase
    //
    //  Represents an iterator for a linked list of linear nodes.
    //****************************************************************
    
   
    import java.util.*;
    
    public class ArrayIterator<T> implements Iterator
    {
       private int count;  // the number of elements in the collection
       private int current;  // the current position
       private T[] arrList;
       //-------------------------------------------------------------
       //  Sets up this iterator using the specified items.
       //-------------------------------------------------------------
       public ArrayIterator (int collection, int size, T[] list)
       {
          current = collection;
          count = size;
          arrList = list;
       }
    
       //-------------------------------------------------------------
       //  Returns true if this iterator has at least one more element
       //  to deliver in the iteraion.
       //-------------------------------------------------------------
       public boolean hasNext()
       {
          return (current!= 0);
          
       }
    
       //-------------------------------------------------------------
       //  Returns the next element in the iteration. If there are no
       //  more elements in this itertion, a NoSuchElementException is
       //  thrown.
       //-------------------------------------------------------------
       public T next()
       {
          if (! hasNext())
             throw new NoSuchElementException();
    
          T result = arrList[current];
          current--;
          return result;
       }
    
       //-------------------------------------------------------------
       //  The remove operation is not supported.
       //-------------------------------------------------------------
       public void remove() throws UnsupportedOperationException
       {
          throw new UnsupportedOperationException();
       }
    }

