/**
 * 
 */
package chapter2;

/**
 * @author mckivergannp22
 *
 */
//Import the scanner
import java.util.Scanner;
public class Test1Program2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Prepare the scannner
		Scanner input = new Scanner(System.in);
		//Ask the user for a base value
		System.out.print("Enter a base value: ");
		double base = input.nextDouble();
		
		//Ask the user for an exponent value
		System.out.print("Enter an exponent value: ");
		double exponent = input.nextDouble();
		
		//Raise the base to the power and define the answer
		double answer = Math.pow(base, exponent);
		
		//Print the answer
		System.out.print(base + " raised to the power of " + exponent + " equals " + answer);
	}

}
