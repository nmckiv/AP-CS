/**
 * 
 */
package chapter2;

import java.util.Scanner;

/**
 * @author mckivergannp22
 *
 */
//Import the scanner
import java.util.Scanner;
public class Test1Program1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Prepare the scannner
		Scanner input = new Scanner(System.in);		
		
		//Ask the user for the number of minutes and define the minutes as an integer
		System.out.print("Enter the number of minutes: ");
		int minutes = input.nextInt();
		
		//Determine how many hours are in that number of minutes
		int hours = minutes / 60;
		
		//Calculate how many minutes remain when divided by 60
		int remainingMinutes = minutes % 60;
		
		//Print how many hours and minutes are in the original value
		System.out.print(minutes + " minutes is equal to " + hours + " hours and " + remainingMinutes + " minutes.");


	}

}
