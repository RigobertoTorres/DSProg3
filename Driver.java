
/**
 * This driver tests the Array Ordered list and times how long it takes to add/sort all the entries
 * 
 * @author Rigo Torres
 * @version 6/10/2015
 */
import java.util.*;
import java.io.*;
import java.util.Calendar;
public class Driver
{
    public static void main(String []args) throws IOException
    {
        String fileName;
        Scanner input = new Scanner(System.in);
        
        //Get file name
        System.out.println("Hello and welcome, please enter the name of the file you'd iike to use");
        fileName = input.nextLine();
        
        //Open file and gets beginning time
        Scanner fileInput = new Scanner(new File(fileName));
        long before = Calendar.getInstance().getTimeInMillis();
        
        //Creates the array ordered list
        ArrayOrderedList<String> ordList = new ArrayOrderedList<String>();
        
        //Adds each line to the list
        while(fileInput.hasNext())
        {
            ordList.add(fileInput.nextLine());
        }
        
        //Gets ending time and calculates the time it took
        long after = Calendar.getInstance().getTimeInMillis();
        
        
        
        
        System.out.println(ordList.toString());
        double time = (after - before);
        System.out.println("\n\nThe Array Ordered List took " + time + " milliseconds to complete");
        
        
        
        
    }
}
