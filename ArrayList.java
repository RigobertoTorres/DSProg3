
/**
 * The ArrayList will hold elements in an array and has methods to add remove these elements
 * 
 * @author Rigo Torres
 * @version 6/10/2015
 */
public class ArrayList<T> implements ListADT<T>
{
    private T[] arrList = (T[]) new Object[20000];
    private int rear;
    
    /**
     * Constructor for objects of class ArrayList
     * 
     * Initializes rear to 0
     */
    public ArrayList()
    {
        rear = 0;
    }
    
    /**
     * The removeFirst method removes and returns the first element in the array list
     * 
     * @return result This is the first element in the array 
     */
    public T removeFirst()
    {
        if(isEmpty())
        {
            throw new EmptyListException("The list is empty");
        }
        else
        {
            //Saves the first element
            T result = arrList[0];
            //Moves the other elements down
            for(int i = 0; i < arrList.length - 1; i++)
            {
                arrList[i] = arrList[i + 1];
            }
            rear--;
            return result;
        }
        
        
    }
    
    /**
     * The removeLast method removes and returns the last element in the array
     * 
     * @return result This is the last element in the array 
     */
    public T removeLast()
    {
        if(isEmpty())
        {
            throw new EmptyListException("The list is empty");
        }
        else
        {
            //Saves the last element
            T result = arrList[arrList.length - 1];
            rear--;
            
            return result;
        }
    }
    
    /**
     * The remove method takes in an element and compares it to the elements in the array using the equals
     * method and then returns it
     * 
     * @param element This is the element that is passed into the method and that is compared to the elements of the array
     * @return result This is the element that equals the parameter
     */
    public T remove(T element)
    {
        if(isEmpty())
        {
            throw new EmptyListException("The list is empty");
        }
        else
        {
            boolean found = false;
            int sub = 0;
            T result = null;
            for(int i = 0; i < arrList.length; i++)
            {
                if(element.equals(arrList[i]))
                {
                    found = true;
                    sub = i;
                }
            }
            
            if(found == false)
            {
                throw new ElementNotFoundException("Element not found");
            }
            if(found == true)
            { 
                result = arrList[sub];
            }
            
            for(int x = sub; x < arrList.length - 1; x++)
            {
                arrList[x] = arrList[x + 1];
            }
            
            rear--;
            
            return result;
        }
    }
    
    /**
     * This method returns the first element of the array without changing it
     * 
     * @return arrList[0] This is the first element of the array that is returned
     */
    public T first()
    {
        return arrList[0];
    }
    
    /**
     * This method returns the last element of the array without changing it
     * 
     * @return arrList[rear] This is the last element of the array that is returned
     */
    public T last()
    {
        return arrList[rear];
    }
    
    /**
     * This method takes in an element and compares it to each element in the array to see if the element exists
     * within the arrray.
     * 
     * @param targetElement This is the element that the method will be checking for in the array
     * 
     * @return found This is the boolean that is returned. True if the element is found in the array. False if the element isn't found in the array
     */
    public boolean contains(T targetElement)
    {
        boolean found = false;
        
        for(int i = 0; i < arrList.length; i++)
        {
            if(targetElement.equals(arrList[i]))
            {
                found = true;
                
            }
        }
        
        return found;
    }
    
    /**
     * This method returns whether or not the array is empty or not
     * 
     * @return rear == 0 Returns true if the array is empty, false if it is not empty
     */
    public boolean isEmpty()
    {
        return rear == 0;
    }
    
    /**
     * This method returns the size of the array list
     * 
     * @return rear The amount of elements in the array
     */
    public int size()
    {
        return rear;
    }
    
    /**
     * This method creates an iterator and returns it
     * 
     * @return it This is the iterator that is created and returned
     */
    public ArrayIterator iterator()
    {
        ArrayIterator it = new ArrayIterator(rear,arrList.length,arrList);
        
        return it;
    }
    
    /**
     * This method returns a concatenated string representation of the array list
     * 
     * @return result The concatenated string representation of the array list
     */
    public String toString()
    {
        String result = "";
        for(int i = 0; i < rear; i++)
        {
            result += arrList[i] + "\n";
        }
        
        return result;
    }
}
