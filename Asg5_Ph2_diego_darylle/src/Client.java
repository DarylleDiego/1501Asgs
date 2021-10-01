import java.io.*;
import java.util.*;
/**
 * This is the interface that the user will use to process the Directory
 * 
 * @author  
 * 
 */
public class Client
{
	public static String strNg;
	public static char optChoice;
	public static String lastName;
	public static String dePart;
	public static void main (String [] args) throws FileNotFoundException
	{
		// define necessary variables here
        Scanner kb = new Scanner(System.in);
		Directory test = new Directory();
        test.run();
        boolean stop = false;
        
        // processing the program
        showMenu();
        System.out.print("\nSelect menu option > ");
        strNg = kb.next();
        optChoice = strNg.toUpperCase().charAt(0);
        
        while (!stop)
        { 
        	switch (optChoice)
        	{
        		case ('P'):
        			test.menuP();
        		break;
        		case ('L'):
            		System.out.print("Please enter a last name > ");
            		lastName = kb.next();
        			test.menuL(lastName);
        		break;
        		case ('R'):
        			System.out.print("Please enter a department > ");
            		dePart = kb.next();
        			test.menuR(dePart);
        		break;
        		case ('C'):
        			System.out.print("Please enter a last name > ");
            		lastName = kb.next();
        			test.menuC(lastName);
        		break;
        		case('A'):
        			System.out.print("Enter an employee last name > ");
            		lastName = kb.next();
        			test.menuA(lastName);
        		break;
        		case('D'):
        			System.out.print("Enter an employee last name > ");
            		lastName = kb.next();
        			test.menuD(lastName);
        		break;
        		case ('E'):
        			stop = true;
        			String outFile;
        			System.out.print("Enter the new file with no extensions > ");
        			outFile = kb.next();
        			outFile = outFile + ".txt";
        			test.menuE(outFile);
        		break;
        		default:
        			System.out.println("This option is not valid.");
        	}
        	
        	if (stop != true)
        	{
        		System.out.print("\nSelect another menu option > ");
        		strNg = kb.next();
        		optChoice = strNg.toUpperCase().charAt(0);
        	}
        }
        
        //end program
        System.out.println ("Thank you for using the Directory System");
	}
	
	/**
     *  The Directory processing menu
     */
    public static void showMenu()
    {
        System.out.println("\nMENU:");
        System.out.println("P - Print the entire directory");
        System.out.println("L - Look up a person's number");
        System.out.println("R - Create a report with a department phone list");
        System.out.println("C - Change a listing");
        System.out.println("A - Add  new Listing");
        System.out.println("D - Delete a listing");
        System.out.println();
        System.out.println("E - Exit");
    }
}
