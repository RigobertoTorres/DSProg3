
/**
 * This driver tests the Ordered Linked List and times how long it takes to add/sort all the entries
 * 
 * @author Rigo Torres
 * @version 6/10/2015
 */
import java.util.*;
import java.io.*;
public class Driver2
{
    public static void main(String []args) throws IOException
    {
        Scanner input = new Scanner(System.in);
        String fileName;
        Scanner fileInput;
        String element;
        int subscript;
        
        //Create an array of ordered linked lists, one for each letter of the alphabet
        OrderedLinkedList[] ordList = new OrderedLinkedList[26]; 
        for(int i = 0; i < ordList.length; i++)
        {
            ordList[i] = new OrderedLinkedList();
        }
        
        //Get file name
        System.out.println("Please enter the name of the file that you wish to use");
        fileName = input.nextLine();
        
        //Open file and get starting time
        fileInput = new Scanner(new File(fileName));
        long before = Calendar.getInstance().getTimeInMillis();
        
        //Adds each element to their respective ordered list
        while(fileInput.hasNext())
        {
            element = fileInput.nextLine();
            
            subscript = ((element.toUpperCase()).charAt(0)) - 'A';
            ordList[subscript].add(element);
        }
        
        //Prints all the elements
        System.out.println("Ok, now the elements will be printed by their first letter\n");
        for(int x = 0; x < ordList.length; x++)
        {
            System.out.println(ordList[x].toString() + "\n\n");
        }
        
        //Gets endingn time and calculate the time it took
        long after = Calendar.getInstance().getTimeInMillis();
        long time = after - before;

        System.out.println("\n\nThe Ordered Linked List took " + time + " milliseconds to complete");
    }
}
