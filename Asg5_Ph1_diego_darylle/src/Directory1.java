import java.util.*;
/*
 *	A processor class that assigns values and creates an array list using Person class methods
 */
public class Directory1
{
	//declaring class variables
	private ArrayList <Person> people = new ArrayList <Person> ();
	
	/**
	 * runs to print an array list
	 */
	public void run()
	{
		loadData();
		printList1();
		System.out.println();
		printList2();
	}
	
	/**
	 * assigns values to objects
	 */
	public void loadData()
	{
		Person ruben = new Person("Ruben", 'B', "Yumol", "Marketing", 9876);
		Person darylle = new Person("Darylle Joshua", 'V', "Diego", "BCIS", 403);
		Person jasmin = new Person("Rida", 'J', "Haider", "Clown", 403);
		
		people.add(ruben);
		people.add(darylle);
		people.add(jasmin);
	}
	
	/**
	 * first printing method
	 */
	public void printList1()
	{	
		for (int i = 0; i < people.size(); i++)
		{
			System.out.println(people.get(i).printName1());
		}
	}
	
	/**
	 * second printing method
	 */
	public void printList2()
	{
		for (int i = 0; i < people.size(); i++)
		{
			System.out.println(people.get(i).printName2());
		}
	}
}
