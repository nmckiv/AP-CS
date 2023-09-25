/**
 * 
 */
package chapter3;

//Import decimal
import java.text.DecimalFormat;
import java.util.Scanner;

//Import dialog boxes
import javax.swing.JOptionPane;

/**
 * @author mckivergannp22
 *
 */

public class DeductionsCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Declare decimal format
		DecimalFormat df = new DecimalFormat("####.00");
		
		//Declare variables and data types
		String name;
		String StrHours;
		String StrPayRate;
		double hours, payRate, grossPay, socialSecurity, retirement, takeHomePay;
		
		//Declare health deduction as a constant
		final double HEALTH = 56.50;
		
		//Ask the user for their name
		name = JOptionPane.showInputDialog(null,"Enter your name: ",
				"Input Dialogue", JOptionPane.QUESTION_MESSAGE);

		//Ask user how many hours they work
		StrHours = JOptionPane.showInputDialog(null,"Enter the number of hours you work per week: ",
				"Input Dialogue", JOptionPane.QUESTION_MESSAGE);
		
		//Parse hours into a number
		hours = Double.parseDouble(StrHours);
		
		//Ask the user for their pay rate
		StrPayRate = JOptionPane.showInputDialog(null,"Enter your hourly pay rate: ",
				"Input Dialogue", JOptionPane.QUESTION_MESSAGE);
		
		//Parse pay rate into a number
		payRate = Double.parseDouble(StrPayRate);
		
		
		
		//Multiply overtime hours by 1.5
		if (hours > 40)
			hours = 40 + (hours - 40) * 1.5;
		
		
		//Calculate gross pay, deductions for retirement, and social security
		grossPay = hours * payRate;
		socialSecurity = grossPay * 0.075;
		retirement = grossPay * 0.08;
		
		//Calculate final pay after deductions
		takeHomePay = grossPay - socialSecurity - retirement - HEALTH;
		
		//Print everything with dialog boxes
		JOptionPane.showMessageDialog(null, "Gross Pay:                   $"+df.format(grossPay)+"\n Deductions: \n            Healthcare:        $"+df.format(HEALTH)+"\n            Social Security: $"
		+df.format(socialSecurity)+"\n            Retirement: 	        $"+df.format(retirement)+"\n --------------------------------------------- \n Take Home Pay:           $"+df.format(takeHomePay)
		, name+" Pay Summary", JOptionPane.INFORMATION_MESSAGE);
		
			
		

	}

}
