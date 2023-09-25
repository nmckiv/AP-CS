/**
 * 
 */
package chapter4;

/**
 * @author mckivergannp22
 *
 */
//Import the scanner
import java.util.Scanner;
public class Initials {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Prepare the scanner
		Scanner input = new Scanner(System.in);
		
		
		
		//Ask the user for their full name
		System.out.print("Enter your full name: ");
		String name = input.nextLine();
		
		//Find the location of the middle, and last initials
			//finds the location of the first space, adds 1 to find the location of the middle initial
		int m = (name.indexOf(' ') + 1);
		
		//finds the location of the last space, adds 1 to find the location of the last initial
		int l = (name.lastIndexOf(' ') + 1);
		
		//Print first, middle, and last initials using the indexes
		//The first initial's index is 0
		System.out.println("Your initials are " + name.charAt(0) + "." + name.charAt(m) + "." + name.charAt(l) + ".");
		
		
		
		

	}

}
