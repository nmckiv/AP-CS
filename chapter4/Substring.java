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
public class Substring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Prepare the scanner
		Scanner input = new Scanner(System.in);
		
		//Ask the user for two strings
		System.out.print("Enter a string: ");
		String string1 = input.nextLine();
		
		System.out.print("Enter another string: ");
		String string2 = input.nextLine();
		
		//Test the second string to see if it is a substring of the first
		if (string1.contains(string2))
			//If it is, say so
			System.out.println("The second string is a substring of the first");
		else
			//If it's not, say so
			System.out.println("The second string is not a substring of the first");
		
		
		

	}

}
