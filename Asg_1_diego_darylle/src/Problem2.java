import java.util.Scanner;
/*
 * This program calculates the net pay depending on the number of hours worked and the pay rate per hour
 */
public class Problem2 {
	public void run()
	{
		//declaring variables
		Scanner kb = new Scanner(System.in);
		double HoursWork;
		double PayRate;
		double GrossPay;
		double GovDed;
		double PerDed;
		double PenCont;
		double TotDed;
		double NetPay;
		final double GovFactor = 0.15;
		final double PerFactor = 0.10;
		final double PenFactor = 0.05;
		final double Neg = -1;
		//request user to input data
		System.out.print("Number of Hours Worked:   ");
		HoursWork = kb.nextDouble();
		System.out.print("Pay Rate per Hour:\t  ");
		PayRate = kb.nextDouble();
		
		//processing
		System.out.println("\nPayroll Report");
		GrossPay = HoursWork * PayRate;
		System.out.format("  Gross Pay\t\t\t\t$  %,8.2f", GrossPay);
		GovDed = GrossPay * GovFactor * Neg;
		PerDed = GrossPay * PerFactor * Neg;
		PenCont = (GrossPay + PerDed) * PenFactor * Neg;
		TotDed = (GovDed + PerDed + PenCont);
		NetPay = GrossPay + TotDed;
		
		//printing the output
		System.out.println("\n  Deductions:");
		System.out.format("\tGovernment:   $ %(,8.2f", GovDed);
		System.out.format("\n\tPersonal:     $ %(,8.2f", PerDed);
		System.out.format("\n\tPension:      $ %(,8.2f", PenCont);
		System.out.format("\n  Total Deductions\t\t\t$   %(,8.2f", TotDed);
		System.out.format("\n  Net Pay\t\t\t\t$  %(,8.2f", NetPay);
	}

}
