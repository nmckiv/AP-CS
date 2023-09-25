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
public class TelephoneNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Prepare the scanner
		Scanner input = new Scanner(System.in);
		
		//Ask the user for a letter
		System.out.print("Enter a letter: ");
		String letter = input.nextLine();
		
		
		//Determine where the letter would be on a telephone
		if ((letter.compareToIgnoreCase("a") == 0) || (letter.compareToIgnoreCase("b") == 0) || (letter.compareToIgnoreCase("c") == 0))
			System.out.print("The corresponding telephone number is 2");
		else if ((letter.compareToIgnoreCase("d") == 0) || (letter.compareToIgnoreCase("e") == 0) || (letter.compareToIgnoreCase("f") == 0))
			System.out.print("The corresponding telephone number is 3");
		else if ((letter.compareToIgnoreCase("g") == 0) || (letter.compareToIgnoreCase("h") == 0) || (letter.compareToIgnoreCase("i") == 0))
			System.out.print("The corresponding telephone number is 4");
		else if ((letter.compareToIgnoreCase("j") == 0) || (letter.compareToIgnoreCase("k") == 0) || (letter.compareToIgnoreCase("l") == 0))
			System.out.print("The corresponding telephone number is 5");
		else if ((letter.compareToIgnoreCase("m") == 0) || (letter.compareToIgnoreCase("n") == 0) || (letter.compareToIgnoreCase("o") == 0))
			System.out.print("The corresponding telephone number is 6");
		else if ((letter.compareToIgnoreCase("p") == 0) || (letter.compareToIgnoreCase("q") == 0) || (letter.compareToIgnoreCase("r") == 0) || (letter.compareToIgnoreCase("s") == 0))
			System.out.print("The corresponding telephone number is 7");
		else if ((letter.compareToIgnoreCase("t") == 0) || (letter.compareToIgnoreCase("u") == 0) || (letter.compareToIgnoreCase("v") == 0))
			System.out.print("The corresponding telephone number is 8");
		else if ((letter.compareToIgnoreCase("w") == 0) || (letter.compareToIgnoreCase("x") == 0) || (letter.compareToIgnoreCase("y") == 0) || (letter.compareToIgnoreCase("z") == 0))
			System.out.print("The corresponding telephone number is 9");
		else
			System.out.println("Invalid input - Please enter a single letter");

	}

}
