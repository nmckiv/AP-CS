/**
 * 
 */
package chapter2;




/**
 * @author mckivergannp22
 *
 */
import java.util.Scanner;

public class Investment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Prepare input scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the investment amount in dollars:");
		//Define the input as a variable called principal
		double principal = input.nextDouble();
		//Repeat with the interest rate and duration
		System.out.print("Enter the annual interest rate:");
		double yearlyInterest = input.nextDouble();
		//Calculate monthly interest from yearly interest and define a variable
		double monthlyInterest = yearlyInterest / 1200;
		System.out.print("Enter the duration in years");
		double duration = input.nextDouble();
		//Calculate final investment amount and define it as a variable
		double finalAmount = principal * Math.pow((1 + monthlyInterest), (duration * 12));
		//Print final amount with two decimal places
		System.out.println("Your investment will be worth $" + (double)((int)(finalAmount * 100)) / 100);
		
	}

}

