import java.io.*;
import java.util.*;
/**
 * The Directory contains the names. department, and telephone numbers
 * 
 * @author Darylle Diego
 *
 */
public class Directory
{
    // Declare the ArrayList
    private ArrayList <Person> employees = new ArrayList <Person> ();
    private Scanner kb = new Scanner (System.in);
    private String strIn;
    private char answer;
    private final int ZERO = 0;
    private final int FALSE = -1;
    /**
     * loads data into the array list
     * 
     * @throws FileNotFoundException
     */
    public void run() throws FileNotFoundException
    {
    	String lastName;
    	String firstName;
    	String initial;
    	String department;
    	int numTelephone;
    	char convertIni;
    	
    	File inFile;
    	Scanner in;
    	String fileName;
    	
    	System.out.print("Enter the file name with no extensions > ");
    	fileName = kb.next();
    	fileName = fileName + ".txt";
    	
    	inFile = new File (fileName);
    	in = new Scanner (inFile);
    	
    	while (in.hasNext())
    	{
    		lastName = in.next();
    		firstName = in.next();
    		initial = in.next();
    		department = in.next();
    		numTelephone = in.nextInt();
    		
    		convertIni = initial.toUpperCase().charAt(ZERO);
    		Person loadData = new Person(firstName, convertIni, lastName, department, numTelephone);
    		employees.add(loadData);
    	}
    	in.close();
    }
    
    // methods to process the information required by the menu
    
    /**
     * prints the array list
     */
    public void menuP()
    {
    	System.out.println("\nName                 Department      Telephone Number");
    	
    	for (int i = 0; i < employees.size(); i++)
    	{
    		System.out.println(employees.get(i).printName1());
    	}
    }
    
    /**
     * searches employee data using the last name input
     * 
     * @param lastName	The employee last name
     */
    public void menuL(String lastName)
    {	
    	int i;
    	boolean found = false;
    	
    	i = ZERO;
    	while (i < employees.size() && !found)
    	{
    		String checkName = employees.get(i).getLastName();
    		
    		if (lastName.equalsIgnoreCase(checkName))
    		{	
    			found = true;
    			System.out.println("\nName                 Department      Telephone Number");
    			System.out.println(employees.get(i).printName1());
    		}
    		else
    		{
    			if(i == employees.size() - 1)
    			{
    				System.out.println("The employee's last name was not found.");
    			}
    		}
    		
    		i++;
    	}
    }
    
    /**
     * Prints all employees from a department
     * 
     * @param dePart	The department
     */
    public void menuR(String dePart)
    {
    	String searchDep;
    	int employeesInDep = ZERO;
    	
    	for (int i = ZERO; i < employees.size(); i++)
    	{
    		searchDep = employees.get(i).getDepartment();
    		if (dePart.equalsIgnoreCase(searchDep))
    		{
    			employeesInDep = employeesInDep + 1;
    			if (employeesInDep == 1)
    			{
    				System.out.println("\n" + searchDep + " Department");
    				System.out.println("Name                 Telephone Number");
    			}
    			System.out.println(employees.get(i).printName2());
    		}
    	}
    	if (employeesInDep == ZERO)
    	{
    		System.out.println("Department is not found.");
    	}
    }
    
    /**
     * Changes an employee's info
     * 
     * @param lastName	The last name
     */
    public void menuC(String lastName)
    {
    	String printInfo;
    	char changeInfo;
    	final int MIN = 1000;
    	final int MAX = 9999;
    	
    	int i;
    	boolean found = false;
    	
    	i = ZERO;
    	while (i < employees.size() && !found)
    	{
    		String checkName = employees.get(i).getLastName();
    		printInfo = employees.get(i).printName1();
    		
    		if (lastName.equalsIgnoreCase(checkName))
    		{
    			found = true;
    			System.out.println("Name                 Department     Telephone Number");
    			System.out.println(employees.get(i).printName1());
    			System.out.println("\nSelect one of the following prompts:");
    			System.out.println("D - Change department");
    			System.out.println("P - Change phone number");
    			System.out.println("B - Change both");
    			System.out.print("Prompt > ");
    			strIn = kb.next();
    			changeInfo = strIn.toUpperCase().charAt(ZERO);
    			
    			if (changeInfo == 'D')
    			{
    				String newDep;
    				
    				System.out.print("Set the new department > ");
    				newDep = kb.next();
    				
    				employees.get(i).setDepartment(newDep);
    				
    				System.out.println("Name                 Department      Telephone Number");
    				System.out.println(employees.get(i).printName1());
    			}
    			else if (changeInfo == 'P')
    			{
    				int newTelNum;
    				
    				System.out.print("Set a new 4 digit telephone number > ");
    				newTelNum = kb.nextInt();
    				
    				if (newTelNum >= MIN && newTelNum <= MAX) 
    				{
    					employees.get(i).setTelephoneNum(newTelNum);
    					System.out.println("Name                 Department      Telephone Number");
    					System.out.println(employees.get(i).printName1());
    				}
    				else
    				{
    					System.out.println("Invalid amount of digits.");
    				}

    			}
    			else if (changeInfo == 'B')
    			{
    				String newDep;
    				int newTelNum;
    				
    				System.out.print("Set the new department > ");
    				newDep = kb.next();
    				System.out.print("Set a new 4 digit telephone number > ");
    				newTelNum = kb.nextInt();
    				
    				employees.get(i).setDepartment(newDep);
    				employees.get(i).setTelephoneNum(newTelNum);
    				
    				System.out.println("Name                 Department      Telephone Number");
    				System.out.println(employees.get(i).printName1());
    			}
    			else
    			{
    				System.out.println("Command is invalid.");
    			}
    		}
    		i++;
    	}
    	if (found == false)
    	{
    		System.out.println("Employee name was not found.");
    	}
    }
    
    /**
     * Adds a new employee
     * 
     * @param newLast	The new employee's last name
     */
    public void menuA(String newLast)
    {
    	String newFirst;
    	String newDep;
    	int newTelNum;
    	int i;
    	int index;
    	int ndx;
    	boolean found = false;
		
    	i = ZERO;
    	index = checkList(newLast);
		while (i < employees.size() && !found)
		{
    		
    		if (index >= ZERO)
    		{
    			found = true;
    			System.out.println("The employee is already in the file.");
    		}
    		i++;
    	}
		if (found == false)
		{
			System.out.print("Enter an employee first name > ");
			newFirst = kb.next();
			System.out.print("Enter the initial > ");
			strIn = kb.next();
			answer = strIn.toUpperCase().charAt(0);
			System.out.print("Enter the department > ");
			newDep = kb.next();
			System.out.print("Enter the phone number > ");
			newTelNum = kb.nextInt();
			Person newPer = new Person(newFirst, answer, newLast, newDep, newTelNum);
			
			ndx = checkOrder(newLast);
			
			if (ndx >= ZERO) 
			{
				employees.add(ndx, newPer);
			}
			else
			{
				int lastN;
				lastN = employees.size();
				employees.add(lastN, newPer);
			}
		}
		
    }
    
    /**
     * Removes an employee from the list
     * 
     * @param lastName	The employee last name
     */
    public void menuD(String lastName)
    {
    	int index;
    	int i;
    	boolean found = false;
		
    	i =  ZERO;
    	while (i < employees.size() && !found)
    	{
    		index = checkList(lastName);
    		
    		if (index >= ZERO)
    		{
    			found = true;
    			employees.remove(index);
    			System.out.println("The employee has been removed.");
    		}
    		i++;
    	}
		if (found == false)
		{
			System.out.println("The employee was not found.");
		}
    }
    
    /**
     * Ends the program and saves to new file
     * 
     * @param newFile					Inputted new file name
     * @throws FileNotFoundException
     */
    public void menuE(String newFile) throws FileNotFoundException
    {
    	PrintWriter out = new PrintWriter(newFile);
    	
    	for (Person printAll: employees)
    	{
    		out.print(printAll.outPrint());
    	}
    	
    	out.close();
    }
    
    // helper methods
    
    /**
     * searches the list to verify the last name
     * 
     * @param 	newLast	Inputted last name
     * @return	ndx		Helps determine validity
     */
    public int checkList(String newLast)
    {
    	String nLast;
    	int ndx = FALSE;
    	int i;
    	boolean found = false;
    	
    	i = ZERO;
    	while (i < employees.size() && !found)
    	{
    		nLast = employees.get(i).getLastName();
    		
    		if (newLast.equalsIgnoreCase(nLast))
    		{
    			found = true;
    			ndx = i;
    		}
    		i++;
    	}
    	return ndx;
    }
    
    /**
     * Checks the alphabetical order
     * 
     * @param 	newLast	Inputed last name
     * @return	ndx		Helps determine validity
     */
    public int checkOrder(String newLast)
    {
    	
    	int ndx = FALSE;
    	int i;
    	boolean found = false;
    	String checkLast;
    	
    	i = ZERO;
		while (i < employees.size() && !found)
		{
			checkLast = employees.get(i).getLastName();
			int compare = newLast.compareToIgnoreCase(checkLast);
			
			if(compare <= ZERO)
			{
				found = true;
				ndx = i;
			}
			i++;
		}
    	return ndx;
    }
}
