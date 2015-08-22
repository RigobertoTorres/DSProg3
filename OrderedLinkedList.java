
/**
 * This Ordered Linked List will hold nodes and sort them using their compareTo method
 * 
 * @version 6/7/2015 
 */

public class OrderedLinkedList<T> extends LinkedList<T> implements OrderedListADT<T>
{
    
    
    public void add(T element)

    {
        LinearNode<T> nln = new LinearNode<T>(element);
        LinearNode<T> current;
        LinearNode<T> previous=null;
        if(count == 0)
        {
            head = tail = nln;
        }
        else //list is not empty
        {
            current = head;
            Comparable<T> cElement = (Comparable<T>)element;
            while(current != null && cElement.compareTo(current.getElement()) > 0)
           {
                previous = current;
                current = current.getNext();
            }
          
            if(current == head) //node belongs at head of list
            {
                nln.setNext(head);
                head = nln;
            }
            else
            {
                if(current == null) //node belongs at rear of list
                {
                    tail.setNext(nln);
                    tail = nln;
                }
                else //node belongs in interior of list
                {
                    previous.setNext(nln);
                    nln.setNext(current);
                }
            }
        }
        count++;
           
   }
 }