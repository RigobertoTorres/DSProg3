
/**
 * This is the Array Ordered List. As items are added, they are put in order.
 * 
 * @author Rigo Torres
 * @version 6/10/2015
 */
public class ArrayOrderedList<T> extends ArrayList implements ListADT
{
    private T[] arrList = (T[]) new Object[20000];
    private int rear;
    private int cursor;
    
    /**
     * Constructor for objects of class ArrayOrderedList
     * 
     * Initializes rear to 0
     */
    public ArrayOrderedList()
    {
        rear = 0;
    }
    
    /**
     * This method compares an element to the each element in the array list to determine where 
     * to add it.
     * 
     * @param element The element that will be added to the array
     */
    public void add(T element)
    {
        Comparable<T> cElem = (Comparable<T>) element;
        cursor = rear - 1;
        boolean smallestFlag = false;
        boolean largestFlag = false;
        
        //If the array is empty, the element is added
        if(isEmpty())
        {
            arrList[rear] = (T) cElem;
            
        }
        
        
        if(!isEmpty())
        {
            //This checks if the element is lesser than the first element of the array
            if(cElem.compareTo(arrList[0]) <= 0)
            {
                //If it is, the array is shifted back and the element is added to the beginning
                for(int x = rear; x > 0; x--)
                {
                    arrList[x] = arrList[x-1];
                }
                    
                arrList[0] = (T) cElem;   
                smallestFlag = true;
            }
            
            //This checks if the element is greater than the last element of the array
            if(cElem.compareTo(arrList[cursor]) >= 0)
            {
                //If it is, the element is added to the end of the array
                arrList[rear] = (T) cElem;
                largestFlag = true;
            }
            
            //While the element isn't smaller than the first, greater than the last and it's less 
            //than the last.... 
            while(!smallestFlag && !largestFlag && cElem.compareTo(arrList[cursor]) < 0)
            {
                cursor--;
                //If the element is greater than the next entry..
                if(cElem.compareTo(arrList[cursor]) >= 0)
                {
                    //Shift every element after the cursor
                    for(int x = rear; x > cursor; x--)
                    {
                        arrList[x] = arrList[x-1];
                    }
                
                    arrList[cursor + 1] = (T)cElem;
                    
                }
                
            }
        
        }
        
        
        rear++;
        
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
    
     /**
     * This method returns whether or not the array is empty or not
     * 
     * @return rear == 0 Returns true if the array is empty, false if it is not empty
     */
    public boolean isEmpty()
    {
        return rear == 0;
    }
}
