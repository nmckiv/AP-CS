/**
 * 
 */
package chapter6;

/**
 * @author mckivergannp22
 *
 */
import java.util.Scanner;
public class BettingGame {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int cash = 500;//Initial amount of money the user has
		System.out.print("You have $" + cash + ".  How much would you like to bet? $");
		int bet = input.nextInt();//First bet the user makes
		
		//Prevents the user from betting more than they have
		while (cash - bet < 0) {
				System.out.print("You can't bet money you don't have.  Enter a bet you can afford: $");
				bet = input.nextInt();
			}
		
		cash = playGame(cash, bet);//Plays game until the user runs out of money or quits
		
		//Ending message
		System.out.println("You have finished with $" + cash);
		System.out.println("Thanks for playing!");

	}
	
	//Method to play game
	public static int playGame(int cash, int bet) {
		Scanner input = new Scanner(System.in);
		
		//Variables to be used as temporary value holders
		int x = 1;
		String again = "";
		
		//To be repeated only while the user has money available
		while (cash > 0) {
			cash -= bet; //Takes the bet out of the users bank
			cash = (makeGuess(bet, cash)); //Have the user make a guess
			
			//Special return value indicating the user ran out of money (return value of -1)
			if (cash == -1) {
				
				//Tell the user they ran out of money and stop the game
				System.out.println("You ran out of money :(");
				cash = 0;
				break;
			}
			
			//Special return value indicating the user elected to quit during the guessing (negative cash value other than -1)
			if (cash < 0 && cash != -1) {
				System.out.println("You have chosen to exit the guessing, and have lost $" + (bet * 2));
				cash = cash * -1;  //Resets cash to actual value
				cash -= bet; //Removes the bet amount again because quitting causes the user to lose twice the bet
				
				//To be enacted if this additional deduction causes the user to run out of money
				if (cash < 0) {
					cash = 0;
					System.out.println("You ran out of money :(");
					break;
				}
			}
			
			//End of the round of guessing
			System.out.println("You now have $" + cash);
			
			//Ask the user to play again.  If an invalid input is entered, they will be asked again continually until a n, N, y, or Y is entered
			while (x > 0) {
			System.out.println("Would you like to play again? (Y/N)");
			again = input.next();
			if (again.equals("N") || again.equals("n")) {
				return cash;
			}
			else if (again.equals("Y") || again.equals("y")) {
				break;
			}
				}
			
			//Display the same screen as the beginning of the game and ask for a new bet amount
			System.out.print("You have $" + cash + ".  How much would you like to bet? $");
			bet = input.nextInt();
			
			//Prevents the user from betting more than they have
			while (cash - bet < 0) {
					System.out.print("You can't bet money you don't have.  Enter a bet you can afford: $");
					bet = input.nextInt();
				}
		}
		
		//When the entire game is done, returns the final cash value to the main method
		return cash;
	}
	
	//Generates a random number between 1 and 200
	public static int generateNumber() {
		int num = (int) (Math.random() * 200) + 1;
		return num;
	}
	
	//Method for making a guess
	public static int makeGuess(int bet, int cash) {
		int guess;
		int num = generateNumber();
		Scanner input = new Scanner(System.in);
		System.out.println("You have 6 guesses remaining.  Enter your guesses below");
		
		//To be repeated up to six times
		for (int attempt = 1; attempt <= 6; attempt++) {
			cash -= 10;//Attempts cost $10 each
			
			//If the user runs out of money, return this special value
			if (cash < 0) {
				return (-1);
			}
			
			//Print the attempt number and ask for a guess
			System.out.print(attempt + ".  ");
			guess = input.nextInt();
			
			//If the user enters 0, indicating they wish to exit, return -cash as a special value
			if (guess == 0) {
				return (cash * -1);
			}
			
			//To be enacted if the user guesses correctly in three attempts or less, giving them a bonus
			System.out.println();
			if (guess == num && attempt <= 3) {
				System.out.println("Correct!");
				System.out.println("BONUS!  You got it in half the tries!  Your winnings are doubled!");
				System.out.println("You have won $" + (bet * 2));
				cash += bet * 3;
				return cash;
			}
			
			//To be enacted if the user guesses correctly in 4-6 attempts
			else if (guess == num && attempt > 3) {
				System.out.println("Correct!");
				System.out.println("You have won $" + (bet));
				cash += bet * 2;
				return cash;
			}
			
			//If the user guesses wrong, tell them if they are too high or too low
			else if (guess > num) {
				System.out.println("That is too high");
			}
			else if (guess < num) {
				System.out.println("That is too low");
			}
		}
		cash = moreAttempts(bet, cash, num);
		
		//Activated if a special value of negative cash is returned in moreAttempts class, indicating the user lost the bet after taking additional attempts
		if (cash > 100000) {
			System.out.println("You have lost the bet");
			cash = cash / 100000;//Returns the actual value of remaining cash after the lost bet
		}
		
		//After the game is over, return the users final amount of cash to the main method
		return cash;
	}
	public static int moreAttempts(int bet, int cash, int num) {
		Scanner input = new Scanner(System.in);
		
		int cost = 20;//Initial cost of an additional attempt, to be doubled with each subsequent attempt
		int guess;//guess the user makes
		int attempt = 7;//Initial number of attempts after the first six
		String again;//Input indicating whether the user wants to continue
		int spent = 60;//Amount of money spent on attempts
		int x = 1;//Number greater than 0 to be used for an infinite loop
		
		//Infinite loop to continue as long as the user wants to keep taking attempts
		while (x > 0) {
			System.out.println("would you like to have another attempt for $" + cost + "? (Y/N)");
			again = input.next();
			
			//Terminate the loop if the user doesn't want another attempt
			if (again.equals("N") || again.equals("n")) {
				break;
			}
			
			//To be enacted if the user wants another attempt
			else if (again.equals("Y") || again.equals("y")) {
				
				//Prevents the user from spending more money on attempts than they bet, which is not allowed
				if (spent >= bet) {
					System.out.println("You have already spent more on attempts than you have bet.  You are not allowed to have any more attempts.");
					break;
				}
			
				//Prevents the user from taking another attempt which they cannot afford
				if (cash - cost < 0) {
				System.out.println("You cannot afford another attempt");
				break;
			}
			cash -= cost;//Deducts the cost of the attempt from the users bank
			
			//Allows user to make an attempt just like in the makeGuess method
			System.out.print(attempt + ".  ");
			guess = input.nextInt();
			
			//To be enacted if the user enters the exit code of 0
			if (guess == 0) {
				return (cash * -1);//Returns a special value for cash indicating the user used the exit code
			}
			System.out.println();
			
			//If the user guesses correctly, return their winnings
			if (guess == num) {
				System.out.println("Correct!");
				System.out.println("You have won $" + (bet));
				cash += bet * 2;
				return cash;
			}
			
			//If the user guesses incorrectly, say whether their guess was too high or too low
			else if (guess > num) {
				System.out.println("That is too high");
			}
			else if (guess < num) {
				System.out.println("That is too low");
			}
			
			attempt++;//Increment attempt
			spent += cost;//Add the cost of the attempt to the amount spent
			cost *= 2;//Double the cost with each attempt
			
			}
		}
		return (cash * 100000);//If the user never guesses the correct answer, return a special value of cash * 100000 to the makeGuess method indicating so
		//The probability of the user accumulating over $100000 are very slim, making this special return value viable
	}
	

}
