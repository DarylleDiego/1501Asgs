import java.util.Scanner;
/*
 * determines student grade
 */
public class Problem1 {
	public void run()
	{
		//declaring variables
		Scanner kb = new Scanner(System.in);
		String name;
		double mrkAvg;
		final int PERF = 100;
		final double A = 80.00;
		final double B = 70.00;
		final double C = 60.00;
		final double D = 50.00;
		final double F = 0.00;
		
		//request user to input data
		System.out.print("Please enter student name: ");
		name = kb.nextLine();
		System.out.print("Please enter student's mark average: ");
		mrkAvg = kb.nextDouble();
		System.out.println("\nStudent Name:   " + name);
		System.out.println("Earned Marks:   " + mrkAvg);
		
		if (mrkAvg <= PERF && mrkAvg >= F)
		{
			if (mrkAvg >= A)
			{
			System.out.println("Letter Grade:   A");
			}
			else if (mrkAvg >= B)
			{
				System.out.println("Letter Grade:   B");
			}
			else if (mrkAvg >= C)
			{
				System.out.println("Letter Grade:   C");
			}
			else if (mrkAvg >= D)
			{
				System.out.println("Letter Grade:   D");
			}
			else
			{
				System.out.println("Letter Grade:   F");
			}
		}
		else
		{
			System.out.println("The inputted mark of " + mrkAvg + " for student " + name + " is not valid.");
			System.out.println("No letter grade is given.");
		}
	}
	

}
