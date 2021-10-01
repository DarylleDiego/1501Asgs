import java.util.Scanner;
/*
 * This program calculates projectile motion based on speed and angle of velocity
 */
public class Problem3 {
	public void run()
	{
		//declaring variables
		Scanner kb = new Scanner(System.in);
		double IniSp;
		double AngleDeg;
		double AngleRad;
		double Time;
		double MaxHt;
		double Range;
		double CrdQtrH;
		double CrdQtrV;
		double CrdHalfH;
		double CrdHalfV;
		double CrdThrdH;
		double CrdThrdV;
		final double Gravity = 9.8;
		final double CrdBeg = 0.0;
		final double TimeQtr = 1.0/4.0;
		final double TimeHalf = 1.0/2.0;
		final double TimeThrd = 3.0/4.0;
		final double FACTOR1 = 2.0;
		final double FACTOR2 = 1.0/2.0;
		final double DegtoRad = Math.PI/180.0;
		
		//request user to input data
		System.out.print("Enter the Initial Speed:      ");
		IniSp = kb.nextDouble();
		System.out.print("Enter the Angle of Launch:    ");
		AngleDeg = kb.nextDouble();
		System.out.format("\nInitial Speed:       %,4.1f meters/sec", IniSp);
		System.out.format("\nAngle of Launch:     %,4.1f degrees %n", AngleDeg);
		
		//processing
		AngleRad = AngleDeg * DegtoRad;
		Time = FACTOR1 * IniSp * Math.sin(AngleRad)/Gravity;
		MaxHt = Math.pow(IniSp * Math.sin(AngleRad), FACTOR1)/(FACTOR1 * Gravity);
		Range = Math.pow(IniSp, FACTOR1) * Math.sin(FACTOR1 * AngleRad)/Gravity;
		CrdQtrH = IniSp * Math.cos(AngleRad) * (TimeQtr * Time);
		CrdQtrV = IniSp * Math.sin(AngleRad) * (TimeQtr * Time) - FACTOR2 * Gravity * Math.pow(TimeQtr * Time, FACTOR1);
		CrdHalfH = IniSp * Math.cos(AngleRad) * (TimeHalf * Time);
		CrdHalfV = IniSp * Math.sin(AngleRad) * (TimeHalf * Time) - FACTOR2 * Gravity * Math.pow(TimeHalf * Time, FACTOR1);
		CrdThrdH = IniSp * Math.cos(AngleRad) * (TimeThrd * Time);
		CrdThrdV = IniSp * Math.sin(AngleRad) * (TimeThrd * Time) - FACTOR2 * Gravity * Math.pow(TimeThrd * Time, FACTOR1);
		
		//printing output
		System.out.format("\nTime of Flight:     %,5.1f secs", Time);
		System.out.format("\nMaximum Height:     %,5.1f meters", MaxHt);
		System.out.format("\nHorizontal Range:   %,5.1f meters %n", Range);
		System.out.println("\nProjectile Flight Path Coordinates:\n");
		System.out.format("Beginning Time:     (%,-6.1f, %,-6.1f) %n", CrdBeg, CrdBeg);
		System.out.format("One Quarter Time:   (%,-6.1f, %,-6.1f)", CrdQtrH, CrdQtrV);
		System.out.format("\nOne Half Time:      (%,-6.1f, %,-6.1f)", CrdHalfH, CrdHalfV);
		System.out.format("\nThree Quarter Time: (%,-6.1f, %,-6.1f)", CrdThrdH, CrdThrdV);
		System.out.format("\nFull Time:          (%,-6.1f, %,-6.1f)", Range, CrdBeg);
	}

}
