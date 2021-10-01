import java.util.Scanner;
/*
 * simulates ratio of boys to girls born
 */
public class Problem2 {
	public void run()
	{
		//declaring variables
		Scanner kb = new Scanner(System.in);
		int count;
		int run;
		double numBoys;
		double numGirls;
		int numMothers;
		double childRatio;
		double ranDom;
		boolean childBorn;
		final int RUN = 10;
		final int TOTALMOTHERS = 10000;
		final int BASE1 = 0;
		final int BASE2 = 1;
		final double FACTOR = 0.5;
		
		//welcome message
		System.out.println("Welcome to the child birth simulation");
		
		//header output
		System.out.println("\nRun# Boys      Girls     B:G");

		//processing
		count = BASE1;
		while (count <= RUN)
		{
			numBoys = BASE1;
			numGirls = BASE1;
			numMothers = BASE2;
			while (numMothers <= TOTALMOTHERS)
			{
				childBorn = Math.random() < FACTOR;
				if(childBorn)
				{
					numBoys++;
				}
				else
				{
					numGirls++;
					numMothers++;
				}
			}
			childRatio = numBoys / numGirls;
			
			System.out.format("%2d   %,6.0f    %,6.0f    %1.0f:%1.5f%n", count, numBoys, numGirls, childRatio, childRatio);
			count++;
		}
		System.out.println("\nThe simulation has ended");
		System.out.println("Thank you!!");
	}
}
