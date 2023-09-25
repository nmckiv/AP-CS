/**
 * 
 */
package chapter5;

/**
 * @author mckivergannp22
 *
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class LoanAmortizationTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Prepare scanner
		Scanner input = new Scanner(System.in);
		
		//Define decimal format
		DecimalFormat df = new DecimalFormat("###.00");
		
		//Initiate variables
		double principal, interest, monthlyPayment;
		int years;
		
		//Obtain user input
		System.out.println("Enter the loan amount: ");
		principal = input.nextDouble();
		
		System.out.println("Enter the number of years to spend paying back this loan: ");
		years = input.nextInt();
		
		System.out.println("Enter the annual interest rate: ");
		
		//Convert annual interest rate to monthly interest rate
		interest = (input.nextDouble() / 1200);
		
		//Calculate monthly payment
		monthlyPayment = principal * interest / (1 - Math.pow((1 / (1 + interest)), (years * 12)));
		
		//Print headers
		System.out.println("Loan Amount:             $" + principal);
		System.out.println("Number of Years:         " + years);
		System.out.println("Annual Interest Rate:    " + interest * 1200 + "%");
		System.out.println("Monthly Payment:         $" + df.format(monthlyPayment));
		System.out.println();
		System.out.println();
		System.out.println("Month            Interest Payment       Principle Payment     Balance Remaining");
		System.out.println();
		
		//Print one row per month with each months payment details
		for (int months = 1; months < years * 12 + 1; months++) {
			
			//calculate how much of the monthly payment goes towards the interest
			double interestPayment = principal * interest;
			
			//calculate how much of the monthly payment goes towards the principal
			double principalPayment = monthlyPayment - interestPayment;
			
			//Recalculate new amount after adding in interest
			principal = ((principal + principal * interest) - monthlyPayment);
			
			//Print each row, with slightly different formatting depending on how many digits the month number consists of to keep the rows straight
			
			//For the final month, subtract the normal monthly payment and add on the remaining balance to be paid to pay it all off at once
			if (months == years * 12) {
				System.out.println(months + "   \t\t$" + df.format(interestPayment) + "\t\t\t$" + df.format(principalPayment + principal) + "\t\t\t$0.00");
			}
			else if (months < 10){
				System.out.println(months + "   \t\t$" + df.format(interestPayment) + "\t\t\t$" + df.format(principalPayment) + "\t\t\t$" + df.format(principal));
			}
			else if (months > 10 && months < 100){
				System.out.println(months + "   \t\t$" + df.format(interestPayment) + "\t\t\t$" + df.format(principalPayment) + "\t\t\t$" + df.format(principal));
			}
			else if (months > 100 && months < 1000){
				System.out.println(months + "   \t\t$" + df.format(interestPayment) + "\t\t\t$" + df.format(principalPayment) + "\t\t\t$" + df.format(principal));
			}
		
			
		}
		
		
		
		
	}
	

}
