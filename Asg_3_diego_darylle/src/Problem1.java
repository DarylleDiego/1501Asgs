import java.util.Scanner;
/*
 * determines yearly depreciation and ending book value of each asset
 */
public class Problem1 {
	public void run()
	{
		//declaring variables
		Scanner kb = new Scanner(System.in);
		int assetNo;
		double inPurchasePrice;
		double useLife;
		double salvageVal;
		double dblDeclineRt;
		double pctDeclineRt;
		int numYears;
		double yearlyDepr;
		double accumDepr;
		double bookVal;
		double salvBookVal;
		String strIn;
		char answer;
		int count;
		final double ZERO = 0.0;
		final int BASE1 = 1;
		final int BASE2 = 2;
		final int BASE3 = 100;
		final double FACTOR1 = 1.0;
		final double FACTOR2 = 2.0;
		final double FACTOR3 = 1.5;
		
		//input
		System.out.print("Enter Y to start: " );
		strIn = kb.next();
		answer = strIn.toUpperCase().charAt(0);
		
		//processing
		while(answer == 'Y')
		{
			//input
			System.out.print("\nEnter the asset number > ");
			assetNo = kb.nextInt();
			System.out.print("Enter the initial purchase price > $ ");
			inPurchasePrice = kb.nextDouble();
			System.out.print("Enter the asset's useful life > ");
			useLife = kb.nextDouble();
			System.out.print("Enter the estimated salvage value > $ ");
			salvageVal = kb.nextDouble();
			System.out.print("Enter the number of years of use > ");
			numYears = kb.nextInt();
			
			//processing
			pctDeclineRt = (BASE1 / useLife) * BASE2 * BASE3;
			System.out.println("\nAsset No: " + assetNo);
			System.out.format("Initial Purchase Price:  $ %,11.2f%n", inPurchasePrice);
			System.out.println("Useful Life:             " + useLife + " years");
			System.out.format("Salvage Value:           $ %-,11.2f%n", salvageVal);
			System.out.format ("Double Declining Rate:   %2.0f%%%n", pctDeclineRt);
			System.out.println("Number of Years:         " + numYears + " years\n");
			System.out.println("Year      Yearly         Accumulated    Book");
			System.out.println("          Depreciation   Depreciation   Value\n");
			count = BASE1;
			bookVal = inPurchasePrice;
			accumDepr = ZERO;
			while(count <= numYears)
			{			
				salvBookVal = bookVal;
				dblDeclineRt = (FACTOR1 / useLife) * FACTOR2;
				yearlyDepr = bookVal * dblDeclineRt;
				bookVal = bookVal - yearlyDepr;
				
				if(bookVal < salvageVal)
				{
					yearlyDepr = salvBookVal - salvageVal;
					bookVal = salvageVal;
				}
				accumDepr = accumDepr + yearlyDepr;
				System.out.format (" %2d       %,9.2f     %,10.2f      %,9.2f%n", count, yearlyDepr, accumDepr, bookVal);
				count = count + BASE1;
			}
			System.out.print("\nEnter Y to start another asset or enter N to end: ");
			strIn = kb.next();
			answer = strIn.toUpperCase().charAt(0);
		}
		if (answer == 'N')
		{
			System.out.println("\nThe program has ended");
		}
		else
		{
			System.out.println("\nInvalid Input");
		}
	}
}	