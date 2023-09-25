package chapter10;
import java.util.Scanner;
public class TestCasino {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//Create scanner
		
		//Obtain card input from the user
		int suit;
		int value;
		System.out.print("Enter a number between 1 and 4: ");
		suit = input.nextInt();
		System.out.print("Enter a number between 1 and 13: ");
		value = input.nextInt();
		
		//Create two cards, one random and another from the users specifications
		Card card1 = new Card(suit, value);
		Card card2 = new Card();
		
		//Display message with card info
		System.out.println("The card you entered was the " + card1.strValue() + " of " + card1.strSuit());
		System.out.println("The randomly generated was the " + card2.strValue() + " of " + card2.strSuit());
	}
}
