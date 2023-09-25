/**
 * 
 */
package chapter3;

/**
 * @author mckivergannp22
 *
 */
//Import the scanner
import java.util.Scanner;
public class EvenOrOdd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Prepare the scanner
		Scanner input = new Scanner(System.in);
		
		//Ask the user for a number
		System.out.print("Enter an integer: ");
		
		//Define entered number
		int number = input.nextInt();
		
		//Determine whether the number is even and use the result to define a boolean
		boolean status = (number % 2 == 0);
		
		System.out.println("Is " + number + " even?  " + status);
	}

}
