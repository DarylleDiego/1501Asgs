import java.util.Scanner;
/*
 * This program converts total number of seconds into hours, minutes, and seconds.
 */
public class Problem1 {
	public void run ()
	{
		//declaring variables
		Scanner kb = new Scanner(System.in);
		int TotalSec;
		int NumHour;
		int NumMin;
		int NumSec;
		final int FACTOR1 = 3600;
		final int FACTOR2 = 60;
		
		//request user to input data
		System.out.print("Total number of seconds:   ");
		TotalSec = kb.nextInt();
		
		//processing
		NumHour = TotalSec/FACTOR1;
		NumMin = (TotalSec%FACTOR1)/FACTOR2;
		NumSec = (TotalSec%FACTOR1)%FACTOR2;
		
		//printing output
		System.out.println("\nThis is equivalent to:");
		System.out.println("\tnumber of hours:   " + NumHour);
		System.out.println("\tnumber of minutes: " + NumMin);
		System.out.println("\tnumber of seconds: " + NumSec);
	}

}
