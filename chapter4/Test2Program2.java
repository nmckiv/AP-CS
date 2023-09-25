/**
 * 
 */
package chapter4;

/**
 * @author mckivergannp22
 *
 */
//Import scanner
import java.util.Scanner;
public class Test2Program2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Prepare scanner
		Scanner input = new Scanner(System.in);
		
		//Ask the user for a password
		System.out.print("Enter a password: ");
		String password = input.next();
		
		//Use either a 1 or 0 to say whether a condition is satisfied
		int length = 0;
		int specialChar = 0;
		int uppercase = 0;
		int lowercase = 0;
		int number = 0;
		
		//Test password length
		if (password.length() >= 8) {
			length = 1;
		}
		
		//Test for special characters
		if (password.contains("!") || (password.contains("@") || (password.contains("#") || (password.contains("$") || (password.contains("%") || (password.contains("&") || (password.contains("*")))))))) {
			specialChar = 1;
		}
		
		//Test for uppercase letters
		if (password.contains("A") || password.contains("B") || password.contains("C") || password.contains("D") || password.contains("E") || 
				password.contains("F") || password.contains("G") || password.contains("H") || password.contains("I") || password.contains("J") || 
				password.contains("K") || password.contains("L") || password.contains("M") || password.contains("N") || password.contains("O") ||
				password.contains("P") || password.contains("Q") || password.contains("R") || password.contains("S") || password.contains("T") || 
				password.contains("U") || password.contains("V") || password.contains("W") || password.contains("X") || password.contains("Y") || 
				password.contains("Z")) {
			uppercase = 1;
		}
		
		//Test for lowercase letters
		if (password.contains("a") || password.contains("b") || password.contains("c") || password.contains("d") || password.contains("e") || 
				password.contains("f") || password.contains("g") || password.contains("h") || password.contains("i") || password.contains("j") || 
				password.contains("k") || password.contains("l") || password.contains("m") || password.contains("n") || password.contains("o") ||
				password.contains("p") || password.contains("q") || password.contains("r") || password.contains("s") || password.contains("t") || 
				password.contains("u") || password.contains("v") || password.contains("w") || password.contains("x") || password.contains("y") || 
				password.contains("z")) {
			lowercase = 1;
		}
		
		//Test for numbers
		if (password.contains("1") || password.contains("2") || password.contains("3") || password.contains("4") || password.contains("5") || 
				password.contains("6") || password.contains("7") || password.contains("8") || password.contains("9") || password.contains("0")) {
			number = 1;
		}
		
		//Process results, and say whether the password is good or bad
		if ((length == 1) && (specialChar == 1) && (uppercase == 1) && (lowercase == 1) && (number == 1))
			System.out.println(password + " is a strong password");
		else {
			System.out.println(password + " is a weak password");
			
			//List why the password is weak
			if (length == 0)
				System.out.println("It should be at least 8 characters long");
			if (specialChar == 0)
				System.out.println("It should contain at least one special character (! @ # $ % & *)");
			if (uppercase == 0)
				System.out.println("It should contain at least one uppercase letter");
			if (lowercase == 0)
				System.out.println("It should contain at least one lowercase letter");
			if (number == 0)
				System.out.println("It should contain at least one number");
		}
			
		
			
		}
			

	}


