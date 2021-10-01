import java.util.Scanner;
/*
 * Determines wage type
 * and calculates net pay
 * of any # of employees
 */
public class Problem1 {
	private Scanner kb = new Scanner (System.in);
	
	/**
	 * The run() method of the class
	 */
	public void run()
	{
		int employNo;
		
		welcomeMessage();
		
		employNo = employeeNo();
		
		validNum(employNo);
		
		moreEmployees(employNo);
		
		goodbyeMessage();
	}
	
	/**
	 * Welcomes user to program
	 */
	public void welcomeMessage()
	{
		System.out.println("Welcome to Wage-Pay Calculator.");
	}
	
	/**
	 * requests input of employee #
	 * 
	 * @return  Employee #
	 */
	public int employeeNo()
	{
		int employeeNo;
		System.out.print("\nPlease enter the employee number or enter '0' or a negative # to terminate > ");
		employeeNo = kb.nextInt();
		
		return employeeNo;
	}
	
	/**
	 * checks if called 
	 * employee # is valid 
	 * 
	 * @param	employeeNo	Employee #
	 */
	public void validNum(int employeeNo)
	{
		final int ZERO = 0;
		final int MIN = 100000;
		final int MAX = 999999;
		
		if (employeeNo <= ZERO)
		{
			System.out.println("Program Termination.");
		}
		else if(employeeNo < MIN || employeeNo > MAX)
		{
			System.out.print("\nInvalid Employee Number. Incorrect # of digits.");
		}
		else
		{	
			wageType(employeeNo);
		}
	}
	
	/**
	 * Third digit is taken from
	 * employee # in order to 
	 * indicate wage type.
	 * Net pay is calculated after
	 * wage type is determined.
	 * 
	 * @param employeeNo	Employee #
	 */
	public void wageType (int employeeNo)
	{
		String strIn = String.valueOf(employeeNo);
		char digit;
		double grossPay;
		double totDeduct;
		double netPay;
		final char C_ZERO = '0';
		final char TWO = '2';
		final char FOUR = '4';
		final char SIX = '6';
		final char EIGHT = '8';
		
		digit = strIn.charAt(3);
		if (digit == C_ZERO || digit == TWO || digit == FOUR || digit == SIX || digit == EIGHT)
		{
			grossPay = hourlyGross();
			totDeduct = hourDeduct(grossPay);
			
		}
		else
		{
			grossPay = commissionGross();
			totDeduct = commissionDeduct(grossPay);
		}
		
		netPay = grossPay - totDeduct;
		
		System.out.println("\nEmployee Number:     " + strIn);
		System.out.format ("Gross Pay:           $ %6.2f", grossPay);
		System.out.format ("%nDeductions:          $ %6.2f", totDeduct);
		System.out.format ("%nNet Pay:             $ %6.2f", netPay);
	}
	
	/**
	 * calculates gross pay
	 * if employeeNo is hourly.
	 * requests input of
	 * pay rate and work hours.
	 * 
	 * @return	grossAmt	Gross Pay of hourly wage
	 */
	public double hourlyGross()
	{
		double grossAmt;
		double payRate;
		int workHours;
		final int TERMINATE = 0;
		final int OT = 45;
		final double PREMIUM = 1.6;
		
		System.out.print("\nEnter the hourly wage rate > $ ");
		payRate = kb.nextDouble();
		System.out.print("Enter the number of hours worked for the week > ");
		workHours = kb.nextInt();
		
		grossAmt = payRate * workHours;
		if (workHours < TERMINATE)
		{
			System.out.println("Invalid Work Hours");
		}
		else if(workHours > OT)
		{
			grossAmt = payRate * OT + payRate * (workHours - OT) * PREMIUM;
		}
		else
		{
			grossAmt = payRate * workHours;
		}
		
		return grossAmt;
	}
	
	/**
	 * Calculates total deductions
	 * of hourly gross pay.
	 * 
	 * @param hourlyGross	Gross Pay of hourly wage
	 * @return	deductAmt	Total deducted amount
	 */
	public double hourDeduct(double hourlyGross)
	{
		double deductAmt;
		final int DEDUCT = 200;
		final int DEDUCT1 = 400;
		final double FACTOR = 0.10;
		final double FACTOR1 = 0.15;
		final double FACTOR2 = 0.20;
		
		if (hourlyGross > DEDUCT1)
		{
			deductAmt = DEDUCT * FACTOR + DEDUCT * FACTOR1 + (hourlyGross - DEDUCT1) * FACTOR2;
		}
		else if (hourlyGross > DEDUCT)
		{
			deductAmt = DEDUCT * FACTOR + (hourlyGross - DEDUCT) * FACTOR1;
		}
		else
		{
			deductAmt = hourlyGross * FACTOR;
		}
		
		return deductAmt;
	}
	
	/**
	 * calculates gross pay
	 * if employee wage is commission.
	 * requests base salary
	 * and total sales
	 * 
	 * @return	grossAmt	Gross Pay of commission wage
	 */
	public double commissionGross()
	{
		double grossAmt;
		double baseSal;
		double hardwareSales;
		double softwareSales;
		double otherSales;
		final double COMM = 0.05;
		final double COMM1 = 0.15;
		final double COMM2 = 0.10;
		
		System.out.print("\nEnter the base salary > $ ");
		baseSal = kb.nextDouble();
		System.out.print("Enter the hardware sales > $ ");
		hardwareSales = kb.nextDouble();
		System.out.print("Enter the software sales > $ ");
		softwareSales = kb.nextDouble();
		System.out.print("Enter other products sales > $ ");
		otherSales = kb.nextDouble();
		
		grossAmt = baseSal + (COMM * hardwareSales) + (COMM1 * softwareSales) + (COMM2 * otherSales);
		
		return grossAmt;
	}
	
	/**
	 * Calculates total deductions
	 * of commission gross pay.
	 * 
	 * @param commissionGross	Gross Pay of commission wage
	 * @return	deductAmt	Total deducted amount
	 */
	public double commissionDeduct(double commissionGross)
	{
		double deductAmt;
		final int DEDUCT = 200;
		final int DEDUCT1 = 400;
		final double FACTOR = 0.10;
		final double FACTOR1 = 0.15;
		final double FACTOR2 = 0.20;
		
		if (commissionGross > DEDUCT1)
		{
			deductAmt = DEDUCT * FACTOR + DEDUCT * FACTOR1 + (commissionGross - DEDUCT1) * FACTOR2;
		}
		else if (commissionGross > DEDUCT)
		{
			deductAmt = DEDUCT * FACTOR + (commissionGross - DEDUCT) * FACTOR1;
		}
		else
		{
			deductAmt = commissionGross * FACTOR;
		}
		
		return deductAmt;
	}
	
	/**
	 * Allows user to input
	 * another employee #.
	 * Terminates if '0' or
	 * negative # is entered.
	 * 
	 * @param employeeNo	Employee #
	 * @return	none
	 */
	public void moreEmployees(int employeeNo)
	{
		int employNo = employeeNo;
		final int TERMINATE = 0;
		
		while (employNo > TERMINATE)
		{
			System.out.print("\n\nPlease enter another employee # or enter '0' or a negative # to terminate > ");
			employNo = kb.nextInt();
			validNum(employNo);
		}
	}
	
	/**
	 * Indicates program has been terminated
	 */
	public void goodbyeMessage()
	{
		System.out.println("\nThank you for using Wage-Pay Calculator!!");
	}

}
