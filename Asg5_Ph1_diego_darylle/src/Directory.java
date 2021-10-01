
public class Directory
{
	/**
	 * runs the person class
	 */
	public void run()
	{
		Person ruben = new Person("Ruben", 'B', "Yumol", "Marketing", 9876);
		
		System.out.println(ruben.printName1());
		System.out.println(ruben.printName2());
		System.out.println();
		
		Person darylle = new Person("Darylle Joshua", 'V', "Diego", "BCIS", 403);
		
		System.out.println(darylle.printName1());
		System.out.println(darylle.printName2());
		System.out.println();
		
		Person jasmin = new Person("Rida", 'J', "Haider", "Clown", 403);
		
		System.out.println(jasmin.printName1());
		System.out.println(jasmin.printName2());
		System.out.println();
	}
}
