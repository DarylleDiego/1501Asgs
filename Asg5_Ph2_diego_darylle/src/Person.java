/*
 * basic methods  to create Person objects
 */
public class Person
{
	//declaring class variables
	private String nameLast;
	private String nameFirst;
	private char initial;
	private String department;
	private int numTelephone;
	
	//constructors
	
	/**
	 * default constructor
	 */
	public Person ()
	{
		
	}
	
	/**
	 * parametrized constructor
	 * 
	 * @param nFirst	Person's first name
	 * @param intl		Person's middle initial
	 * @param nLast		Person's last name
	 * @param depart	Department
	 * @param numTel	Telephone Number
	 */
	public Person (String nFirst, char intl, String nLast, String depart, int numTel)
	{
		nameLast = nLast;
		nameFirst = nFirst;
		initial = intl;
		department = depart;
		numTelephone = numTel;
	}
	
	//accessors
	
	/**
	 * last name accessor
	 * 
	 * @return	nameLast
	 */
	String getLastName()
	{
		return nameLast;
	}
	
	/**
	 * first name accessor
	 * 
	 * @return	nameFirst
	 */
	public String getFirstName()
	{
		return nameFirst;
	}
	
	/**
	 * middle name initial accessor
	 * 
	 * @return	initial
	 */
	public char getInitial()
	{
		return initial;
	}
	
	/**
	 * department accessor
	 * 
	 * @return	department
	 */
	public String getDepartment()
	{
		return department;
	}
	
	/**
	 * telephone number accessor
	 * 
	 * @return	numTelephone
	 */
	public int getTelephoneNum()
	{
		return numTelephone;
	}
	
	//mutators
	
	/**
	 * last name setter
	 * 
	 * @param nLast
	 */
	public void setLastName(String nLast)
	{
		nameLast = nLast;
	}
	
	/**
	 * first name setter
	 * 
	 * @param nFirst
	 */
	public void setFirstName(String nFirst)
	{
		nameFirst = nFirst;
	}
	
	/**
	 * middle name initial setter
	 * 
	 * @param intl
	 */
	public void setInitial(char intl)
	{
		initial = intl;
	}
	
	/**
	 * department setter
	 * 
	 * @param depart
	 */
	public void setDepartment(String depart)
	{
		department = depart;
	}
	
	/**
	 * telephone number setter
	 * 
	 * @param numTel
	 */
	public void setTelephoneNum(int numTel)
	{
		numTelephone = numTel;
	}
	
	//helper methods
	/**
	 * helps print first name, initial, 
	 * last name, department, and telephone number
	 * 
	 * @return	text
	 * 
	 */
	public String printName1()
	{
		String text;
		
		text = String.format("%-7s %1c. %-9s %-15s %-4d", nameFirst, initial, nameLast, department, numTelephone);
		
		return text;
	}
	
	/**
	 * helps print first name, initial, 
	 * last name and telephone number
	 * 
	 * @return
	 */
	public String printName2()
	{
		String text;
		
		text = String.format("%-7s %1c. %-9s %-4d", nameFirst, initial, nameLast, numTelephone);
		
		return text;
	}
	
	/**
	 * helps print employee data
	 * into a new file
	 * 
	 * @return	
	 */
	public String outPrint()
	{
		String text;
		
		text = String.format("%s %s %c %s %d %n", nameLast, nameFirst, initial, department, numTelephone);
		
		return text;
	}
}
