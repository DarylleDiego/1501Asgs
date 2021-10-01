import java.util.Scanner;
/*
 * calculates points based on life
 */
public class Problem3 {
	public void run()
	{
		//declaring variables
		Scanner kb = new Scanner(System.in);
		int numAdultCar;
		int numChildCar;
		int numAdultCrs;
		int numChildCrs;
		int carPts;
		int crsPts;
		int diff1;
		int diff2;
		String strIn;
		char choice;
		final int ADPTS = 100;
		final int CHPTS = 145;
		final int TC = 20;
		
		//request user input
		System.out.print("Please enter the number of adults in the car > ");
		numAdultCar = kb.nextInt();
		System.out.print("Please enter the number of children in the car > ");
		numChildCar = kb.nextInt();
		System.out.print("Please enter the number of adults on the crosswalk > ");
		numAdultCrs = kb.nextInt();
		System.out.print("Please enter the number of children on the crosswalk > ");
		numChildCrs = kb.nextInt();
		
		//processing algorithms
		carPts = (numAdultCar * ADPTS) + (numChildCar * CHPTS);
		crsPts = (numAdultCrs * ADPTS) + (numChildCrs * CHPTS);
		diff1 = carPts - crsPts;
		diff2 = crsPts - carPts;
		
		if (carPts > crsPts)
		{
			if (diff1 > TC)
			{
				System.out.println("\nThe group that was sacrificed:  Crosswalk Occupants");
				System.out.println("The number of adults sacrificed was: " + numAdultCrs);
				System.out.println("The number of children sacrificed was: " + numChildCrs);
			}
			else
			{
				System.out.println("\nChoose who gets to live.\nC - Car Occupants\nW - Crosswalk Occupants");
				strIn = kb.next();
				choice = strIn.toUpperCase().charAt(0);
				if (choice == 'C')
				{
					System.out.println("\nThe group that was sacrificed:  Crosswalk Occupants");
					System.out.println("The number of adults sacrificed was: " + numAdultCrs);
					System.out.println("The number of children sacrificed was: " + numChildCrs);
				}
				else if (choice == 'W')
				{
					System.out.println("\nThe group that was sacrificed:  Car Occupants");
					System.out.println("The number of adults sacrificed was: " + numAdultCar);
					System.out.println("The number of children sacrificed was: " + numChildCar);
				}
				else
				{
					System.out.println("This is an invalid input");
				}
			}	
			
		}		
		else
		{
			if (diff2 > TC)
			{
				System.out.println("\nThe group that was sacrificed:  Car Occupants");
				System.out.println("The number of adults sacrificed was: " + numAdultCar);
				System.out.println("The number of children sacrificed was: " + numChildCar);
			}
			else
			{
				System.out.println("\nChoose who gets to live.\nC - Car Occupants\nW - Crosswalk Occupants");
				strIn = kb.next();
				choice = strIn.toUpperCase().charAt(0);
				if (choice == 'C')
				{
					System.out.println("\nThe group that was sacrificed:  Crosswalk Occupants");
					System.out.println("The number of adults sacrificed was: " + numAdultCrs);
					System.out.println("The number of children sacrificed was: " + numChildCrs);
				}
				else if (choice == 'W')
				{
					System.out.println("\nThe group that was sacrificed:  Car Occupants");
					System.out.println("The number of adults sacrificed was: " + numAdultCar);
					System.out.println("The number of children sacrificed was: " + numChildCar);
				}
				else
				{
					System.out.println("This is an invalid input");
				}
			}
		}
		System.out.println("The program has ended");
	}

}
