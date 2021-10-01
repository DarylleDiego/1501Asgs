import java.util.Scanner;
/*
 * calculates interest amount
 */
public class Problem2 {
	public void run()
	{
		//declaring variables
		Scanner kb = new Scanner(System.in);
		String name;
		int acctNum;
		double acctBal;
		String strin;
		char type;
		double intAmt;
		final double CHEQ = 0.005;
		final double SAV = 0.0125;
		final double GIC = 0.0085;
		final double TFSA = 0.0075;
		final double INVALID = 0.0;
		
		//required user input
		System.out.print("Please enter account holder's name: ");
		name = kb.nextLine();
		System.out.print("Please enter account number: ");
		acctNum = kb.nextInt();
		System.out.print("Please enter account balance: $ ");
		acctBal = kb.nextDouble();
		System.out.println("Please enter account type: \nC - Chequing\nS - Savings\nG - Guaranteed Investment Certificate (GIC)\nT - Tax Free Savings Account (TFSA)");
		strin = kb.next();
		type = strin.toUpperCase().charAt(0);
		
		//processing
		System.out.println("\nAccount Name:    " + name);
		System.out.println("Account Number:  " + acctNum);
		System.out.format("Account Balance: $ %,.2f %n", acctBal);
		switch (type)
		{
		case 'C':
			intAmt = acctBal * CHEQ;
			System.out.println("Account Type:    Chequing");
			break;
		case 'S':
			intAmt = acctBal * SAV;
			System.out.println("Account Type:    Savings");
			break;
		case 'G':
			intAmt = acctBal * GIC;
			System.out.println("Account Type:    Guaranteed Investment Certificate");
			break;
		case 'T':
			intAmt = acctBal * TFSA;
			System.out.println("Account Type:    Tax Free Savings Account");
			break;
			default:
				System.out.println("Invalid Account Type");
				intAmt = INVALID;
		}
		System.out.format("%nInterest Amount: $ %,.2f", intAmt);
		System.out.println("\nThe program has ended");
		
	}

}
