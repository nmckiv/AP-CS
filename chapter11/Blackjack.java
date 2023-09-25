package chapter11;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack {
	public static Vector<Player> players = new Vector<Player>();//Vector of players
	public static Vector<Player> players2 = new Vector<Player>();//Identical vector used to preserve all players when the vector used in gameplay is altered
	
	//Creates a dealer object with one 52 card deck and a hand size of 5
	static Dealer dealer = new Dealer(5, 1);
	
	
	public static void main(String[] args) {
		int handSize = 5;//Max hand size
		Scanner input = new Scanner(System.in);
		
		//Add the dealer to the player lists first
		players.add(dealer);
		players2.add(dealer);
		
		//Asks the user for number of players, their names, and how many rounds
		System.out.println("Welcome to Blackjack");
		delay(2000);
		System.out.println();
		System.out.print("Enter how many players: ");
		int num = input.nextInt();
		System.out.println();
		for (int x = 0; x < num; x++) {
			System.out.print("Player " + (x + 1) + " name: ");
			String name = input.next();
			System.out.println();
			Player player = new Player(name, handSize);//Creates player objects with a hand size of 5
			//Add each player to both vectors
			players.add(player);
			players2.add(player);
			
			//Give each player $500 to start with
			players.get(x + 1).winnings = 500;
		}
		
		
		System.out.println();
		delay(2000);
		System.out.print("How many rounds? ");
		int rounds = input.nextInt();
		System.out.println();
		
//Multiple round play starts here
	for (int a = 0; a < rounds; a++) {
		clearScreen();
		System.out.println("Round " + (a + 1));//prints the round number ahead of each round
		delay(3000);
		clearScreen();
		collectBets();
		
		
		//Deals initial two cards
		for (int x = 0; x < players.size(); x++) {
			players.get(x).hand.add(dealer.dealCard());
		}
		for (int x = 0; x < players.size(); x++) {
			players.get(x).hand.add(dealer.dealCard());
		}
		
		//Creates a boolean list to be filled with values representing whether any player has a natural
		ArrayList<Boolean> roundResults = new ArrayList<Boolean>();
		
		//Below is code that can be used to give any card to any player to test various scenarios (especially useful for the ace processing methods)
		
//		players.get(0).hand.set(0, new Card(1, 1));
//		players.get(0).hand.set(1, new Card(1, 11));
//		players.get(3).hand.set(0, new Card(1, 1));
//		players.get(3).hand.set(1, new Card(1, 11));
//		players.get(5).hand.set(0, new Card(1, 1));
//		players.get(5).hand.set(1, new Card(2, 11));
		
		//Utilizes checkBlackjack method, which determines whether any player has a natural, and assigns the results to roundResults
		roundResults = checkBlackjack(true);
		
		clearScreen();
		System.out.println("The first two cards have been dealt");
		delay(2000);
		System.out.println();
		printTable(true);
		System.out.println();
		int number = roundResults.size();//Indicates number of players including the dealer
		
		//The following code processes the results of the initial deal
		for (int x = 1; x < roundResults.size(); x++) {
			//Evaluates to true if the dealer has a natural
			if (roundResults.get(0)) {
				System.out.println("The dealer has a natural!");
				delay(5000);
				System.out.println();
				//Now check whether any players have naturals
				for (int y = 1; y < number; y++) {
					//If the given player doesn't have a natural, they lose the bet
					if (!roundResults.get(y)) {
						System.out.println(players.get(y).name + " has lost the bet");
						players.get(y).bet = 0;
						players.remove(y);
						roundResults.remove(y);
						y--;
						number--;
						delay(4000);
						System.out.println();
						
					}
					//If the player does have a natural, they win twice their bet
					else {
						System.out.println(players.get(y).name + " has matched the natural and wins twice the bet");
						players.get(y).bet *= 2;
						players.get(y).winnings += players.get(y).bet;
						players.remove(y);
						roundResults.remove(y);
						y--;
						number--;
						delay(4000);
						System.out.println();
					}
				}
				break;
			}
			//The following evaluates to true if the dealer does not have a natural but a player does
			else if (!roundResults.get(0) && roundResults.get(x)) {
				for (int y = x; y < number; y++) {
					if (roundResults.get(y)) {
						System.out.println("Blackjack! " + players.get(y).name + " has won two-and-a-half times the bet");
						players.get(y).bet *= 2.5;
						players.get(y).winnings += players.get(y).bet;
						players.remove(players.get(y));
						roundResults.remove(y);
						y--;
						number--;
						delay(5000);
						System.out.println();
					}
				}
				break;
			}
			//Evaluates to true of nobody has a natural
			else if (x == roundResults.size() - 1) {
				System.out.println("There are no naturals");
				delay(5000);
				System.out.println();
			}
		}
		
		//Only play the round if the dealer doesn't have a natural.  Otherwise, the round ends
		if (!roundResults.get(0)) {
			//Enacts the method to play the round
			playRound();
		}
		//Calls the method to display each players winnings for the round
		showWinnings();
		delay(5000);
		clearScreen();
		
		//Reset the deck and each players hand before the next round
		dealer = new Dealer(5, 1);
		for (int x = 0; x < players.size();) {
			players.remove(0);
		}
		players.add(dealer);
		players2.set(0, dealer);
		for (int x = 1; x < players2.size(); x++) {
			for (int y = 0; y < players2.get(x).hand.size();) {
				players2.get(x).hand.remove(0);
			}
			players.add(players2.get(x));
		}
//		dealer.deck.shuffle();
}		
	}
	
	//Method to print 100 blank lines to clear the screen
	public static void clearScreen() {
		for (int x = 0; x < 100; x++) {
			System.out.println();
		}
	}
	
	//Method to add a variable delay
	public static void delay(long length) {
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() < start + length);
	}
	
	//Method to print out the final results of each round
	//Tells each player how much they won and how much they have now
	public static void showWinnings() {
		delay(2000);
		clearScreen();
		System.out.println("=================Results===================");
		delay(2000);
		System.out.println();
		for (int x = 1; x < players2.size(); x++) {
			System.out.println(players2.get(x).name + " won $" + players2.get(x).bet + " and now has $" + players2.get(x).winnings);
			System.out.println();
		}
		
		//If a player loses all their money, they can no longer place bets and are removed from the game
		for (int x = 1; x < players2.size(); x++) {
			if (players2.get(x).winnings == 0) {
				System.out.println(players2.get(x).name + " lost all their money.");
				System.out.println(players2.get(x).name + " is out of the game.");
				players2.remove(x);
				x--;
			}
		}
	}
	
	//Method to ask each player how much they want to bet and remove that amount from their bank
	public static void collectBets() {
		Scanner input = new Scanner(System.in);
		for (int x = 1; x < players.size(); x++) {
			double bet;
			//Mechanism to prevent players from betting more money than they have
			while (1 > 0) {
				System.out.print(players.get(x).name + ", you have $" + players.get(x).winnings + ".  How much would you like to bet?  Enter your amount: ");
				bet = input.nextInt();
				if (bet <= players.get(x).winnings) {
					break;
				}
				System.out.println();
				System.out.println("You don't have that much money.  Please enter a bet you can afford");
				delay(2000);
				System.out.println();
			}
				
			System.out.println();
			players.get(x).winnings -= bet;
			players.get(x).bet = bet;
		}
	}
	
	//Method to play the round
	public static void playRound() {
		Scanner input = new Scanner(System.in);
		
		//Loop repeats for each players turn
		for (int x = 1; x < players.size(); x++) {
			clearScreen();
			System.out.println(players.get(x).name + "'s turn");
			delay(2000);
			System.out.println();
			printTable(true);//Prints the table so the player can see their current hand
			while ((!checkBust(players.get(x))) && (players.get(x).hand.size() < 5)) {
				System.out.println();
				
				//Asks the user to stand or hit
				System.out.print("Would you like to stand or hit? Enter 1 to stand or 2 to hit: ");
				delay(2000);
				int choice = input.nextInt();
				System.out.println();
				
				//To be enacted if the player hits
				if (choice == 2) {
					Card newCard = dealer.dealCard();//Deals the player a new card
					System.out.print("Your new card is a "); newCard.printCard(); System.out.println();
					players.get(x).hand.add(newCard);
					delay(2000);
					System.out.println();
					printTable(true);
					delay(2000);
				}
				
				//To be enacted if the player stands
				else if (choice == 1) {
					System.out.println("Your turn is over");
					delay(2000);
					System.out.println();
					break;//Breaks the loop to move on to the next player
				}
			}
			
			//To be enacted if the player's new card makes them bust
			if (checkBust(players.get(x))) {
				System.out.println();
				System.out.println("Bust! Your total is over 21, you have lost the bet");
				players.get(x).bet = 0;
				players.remove(x);//Removes the player from the table because they are out fo the round
				x--;
				delay(2000);
				System.out.println();
			}
			
			//To be enacted if the player already has 5 cards in their hand, meaning they cannot draw
			else if (players.get(x).hand.size() >= 5) {
				System.out.println("Your hand is already full.  You cannot draw a new card");
				delay(2000);
			}
			System.out.println();
			
		}//End player turns
		
		clearScreen();
		
		//Begins the end sequence for the round
		
		//To be enacted if the dealer's second card has not yet been revealed
		if (players.get(0).hand.get(0).getValue() != 1 && players.get(0).hand.get(0).getValue() != 10 &&players.get(0).hand.get(0).getValue() != 11 &&players.get(0).hand.get(0).getValue() != 12 &&players.get(0).hand.get(0).getValue() != 13) {
			System.out.println("All players have been served.  The dealer's last card will be revealed.");
		}
		delay(2000);
		System.out.println();
		printTable();
		delay(2000);
		System.out.println();
		
		//To be enacted if the dealer's total is between 17 and 21
		if (getTotal(players.get(0)) > 16 && getTotal(players.get(0)) < 22) {
			System.out.println("The dealer's hand will stand");
			delay(2000);
		}
		
		//To be enacted if the dealer's hand is below 17
		//Have the dealer draw a new card
		else {
			while (getTotalWithAces(players.get(0), 17, 21) == -1 && players.get(0).hand.size() < 5) {
				System.out.println("The dealer's hand does not stand.  The dealer must draw another card.");
				delay(2000);
				System.out.println();
				players.get(0).addCard(dealer.dealCard());
				printTable();
				System.out.println();
			}
		}
		
		//To be enacted if the dealer busts
		if (getTotalWithAces(players.get(0), 17, 21) > 21) {
			System.out.println("The dealer has bust!  All remaining players win twice their bet!");
			delay(2000);
			System.out.println();
			for (int x = 1; x < players.size(); x++) {
				players.get(x).bet *= 2;
				players.get(x).winnings += players.get(x).bet;
			}
		}
		
		//To be enacted if the dealer's hand is between 17 and 21
		else {
			System.out.println("The dealer's total is " + getTotalWithAces(players.get(0), 17, 21));
			delay(2000);
			System.out.println();
			System.out.println("All remaining players with a total higher than " + getTotalWithAces(players.get(0), 17, 21) + " win their bet");
			delay(2000);
			System.out.println();
			
			//The following code goes through each remaining player and tells whether they won or lost
			for (int x = 1; x < players.size(); x++) {
				int total = 0;
				System.out.println(players.get(x).name + ". ");
				delay(2000);
				System.out.println();
//				for (int y = 0; y < players.get(x).hand.size(); y++) {
//					total += cardToValue(players.get(x).hand.get(y), false);
//				}
				total = findBestTotal(players.get(x));
				System.out.println("Your total is " + total);
				delay(2000);
				System.out.println();
				if (total > getTotalWithAces(players.get(0), 17, 21) && total < 22) {
					System.out.println("Congratulations, you have won twice your bet!");
					delay(2000);
					System.out.println();
					players.get(x).bet *= 2;
					players.get(x).winnings += players.get(x).bet;
				}
				else {
					System.out.println("Sorry, you lost your bet");
					players.get(x).bet = 0;
					delay(2000);
					System.out.println();
				}
			}
		}
	}
	
	//Revised and improved method to find best combination of 1's and 11's for any player
	public static int findBestTotal(Player player) {
		int aceCount = 0;//To represent the number of aces
		ArrayList<Integer> possibilities = new ArrayList<>();//List to contain all possible totals
		ArrayList<Integer> aceIndexes = new ArrayList<Integer>();//List to contain indexes of the aces in the players hand
		
		//Counts the number of aces and records where they exist in the hand
		for (int x = 0; x < player.hand.size(); x++) {
			if (player.hand.get(x).getValue() == 1) {
				aceIndexes.add(x);
				aceCount++;
			}
		}
		
		//The following code determines every possible total depending on how many aces a player has
		//Because only 4 aces at the most can be in a players hand, the method is simply brute-forced to accommodate for 1, 2, 3, or 4, aces
		if (aceCount == 0) {
			return getTotal(player);
		}
		else if (aceCount == 1) {
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(0)).setValue(15);
			possibilities.add(getTotal(player));
		}
		else if (aceCount == 2) {
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(0)).setValue(15);
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(1)).setValue(15);
			possibilities.add(getTotal(player));
		}
		else if (aceCount == 3) {
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(0)).setValue(15);
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(1)).setValue(15);
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(2)).setValue(15);
			possibilities.add(getTotal(player));
		}
		else if (aceCount == 4) {
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(0)).setValue(15);
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(1)).setValue(15);
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(2)).setValue(15);
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(3)).setValue(15);
			possibilities.add(getTotal(player));
		}
		int num = possibilities.get(possibilities.size() - 1);//Smallest value in the possibilities list
		
		//Removes every possibility that is over 21
		for (int x = 0; x < possibilities.size(); x++) {
			if (possibilities.get(x) > 21) {
				possibilities.remove(x);
				x--;
			}
		}
		
		//The following code finds the largest remaining possibility
		int max = 0;
		for (int x = 0; x < possibilities.size(); x++) {
			if (possibilities.get(x) > max) {
				max = possibilities.get(x);
			}
		}
		
		//Resets the value of every ace card to 1
		for (int x = 0; x < aceCount; x++) {
			player.hand.get(aceIndexes.get(x)).setValue(1);
		}
		
		//Returns max if any values remain in possibilities
		if (max != 0) {
			return max;
		}
		
		//If no values remain in possibilities (meaning they were all over 21), return the smallest
		return num;
	}
	
	//Old method to find best combination of 1's and 11's
	//Only utilized for the dealer
	public static int getTotalWithAces(Player player, int min, int max) {
		int aceCount = 0;
		ArrayList<Integer> possibilities = new ArrayList<Integer>();
		ArrayList<Integer> aceIndexes = new ArrayList<Integer>();
		for (int x = 0; x < player.hand.size(); x++) {
			if (player.hand.get(x).getValue() == 1) {
				aceIndexes.add(x);
				aceCount++;
			}
		}
		if (aceCount == 0 && getTotal(player) > 16) {
			return getTotal(player);
		}
		else if (aceCount == 0) {
			return -1;
		}
		else if (aceCount == 1) {
			player.hand.get(aceIndexes.get(0)).setValue(15);
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(0)).setValue(1);
			possibilities.add(getTotal(player));
		}
		else if (aceCount == 2) {
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(0)).setValue(15);
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(1)).setValue(15);
			possibilities.add(getTotal(player));
		}
		else if (aceCount == 3) {
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(0)).setValue(15);
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(1)).setValue(15);
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(2)).setValue(15);
			possibilities.add(getTotal(player));
		}
		else if (aceCount == 4) {
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(0)).setValue(15);
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(1)).setValue(15);
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(2)).setValue(15);
			possibilities.add(getTotal(player));
			player.hand.get(aceIndexes.get(3)).setValue(15);
			possibilities.add(getTotal(player));
		}
		Collections.sort(possibilities);
		if (possibilities.get(0) > 21) {
			return possibilities.get(0);
		}
		for (int x = 0; x < possibilities.size(); x++) {
			if (possibilities.get(x) < min || possibilities.get(x) > max) {
				possibilities.remove(x);
			}
		}
		
		if (possibilities.contains(21)) {
			return 21;
		}
		else if (possibilities.contains(20)) {
			return 20;
		}
		else if (possibilities.contains(19)) {
			return 19;
		}
		else if (possibilities.contains(18)) {
			return 18;
		}
		else if (possibilities.contains(17)) {
			return 17;
		}
		return -1;
		
	}
	
	//Method to calculate a players total after aces have been converted to 1's or 11's
	//A value of 1 indicates an ace counting for 11, and 15 indicates an ace counting for 1
	public static int getTotal(Player player) {
		int total = 0;
		for (int x = 0; x < player.hand.size(); x++) {
			switch (player.hand.get(x).getValue()) {
			case 1: total += 11; break;//Represents an ace counting for 11
			case 2: total += 2; break;
			case 3: total += 3; break;
			case 4: total += 4; break;
			case 5: total += 5; break;
			case 6: total += 6; break;
			case 7: total += 7; break;
			case 8: total += 8; break;
			case 9: total += 9; break;
			case 10: total += 10; break;
			case 11: total += 10; break;
			case 12: total += 10; break;
			case 13: total += 10; break;
			case 15: total += 1; break;//Represents an ace counting for 1
			}
		}
		return total;
	}
	
	//Method to print out the table
	//This method is overloaded so it can be specified whether the dealers second card should be revealed or not
	public static void printTable(boolean firstRound) {
		if (firstRound ) {
			//Prints a header of the players names
			for (int x = 0; x < players.size(); x++) {
				System.out.print("\t" + players.get(x).name + "\t\t");
			}
			System.out.println();
			
			//Prints each players hand, with -------------------- indicating an empty space
			for (int x = 0; x < 6; x++) {
				for (int y = 0; y < players.size(); y++) {
					if (x == 5) {
						if (y == 0) {
							//To be enacted if the dealer's first card is an ace or 10 card, meaning both cards must be revealed
							if (players.get(0).hand.get(0).getValue() == 1 || players.get(0).hand.get(0).getValue() == 10 || players.get(0).hand.get(0).getValue() == 11 || players.get(0).hand.get(0).getValue() == 12 || players.get(0).hand.get(0).getValue() == 13) {
								System.out.print("Total: " + findBestTotal(players.get(y)) + "\t\t  ");
							}
							else {
								System.out.print("Total: ??\t\t  ");
							}
						}
						else {
							System.out.print("Total: " + findBestTotal(players.get(y)) + "\t\t  ");
						}
					}
					else {
					try {
						if ((y == 0 && x == 1) && !(players.get(0).hand.get(0).getValue() == 1 || players.get(0).hand.get(0).getValue() == 10 || players.get(0).hand.get(0).getValue() == 11 || players.get(0).hand.get(0).getValue() == 12 || players.get(0).hand.get(0).getValue() == 13 )) {	
							
								System.out.print("???????????????          ");
						}
						else {
							players.get(y).hand.get(x).printCard();
							System.out.print(" ");
						}
					}
					catch (Exception e) {
						System.out.print("---------------          ");
					}
				}
				}
				System.out.println();
			}
		}
		
	}
	
	//Overloaded method
	//Exactly the same as method above, except this one always prints all dealer cards
	public static void printTable() {
		for (int x = 0; x < players.size(); x++) {
			System.out.print("\t" + players.get(x).name + "\t\t");
		}
		System.out.println();
		for (int x = 0; x < 6; x++) {
			for (int y = 0; y < players.size(); y++) {
				if (x == 5) {
					System.out.print("Total: " + findBestTotal(players.get(y)) + "\t\t  ");

				}
				else {
				try {
					players.get(y).hand.get(x).printCard();
					System.out.print(" ");
				}
				catch (Exception e) {
					System.out.print("---------------          ");
				}
			}
			}
			System.out.println();
		}
	}
	public static void printTable(Player player) {
		for (int x = 0; x < player.hand.size(); x++) {
			System.out.println(player.hand.get(x).strValue() + " of " + player.hand.get(x).strSuit());
		}
	}
	
	//Method to check for naturals with first two cards
	public static ArrayList<Boolean> checkBlackjack(boolean firstRound) {
		ArrayList<Boolean> results = new ArrayList<Boolean>();
		int total = 0;
		for (int x = 0; x < players.size(); x++) {
			for (int y = 0; y < players.get(x).hand.size(); y++) {
				total += cardToValue(players.get(x).hand.get(y), firstRound);
			}
			if (total == 21) {
				results.add(true);
			}
			else {
				results.add(false);
			}
			total = 0;
		}
		return results;
	}
	
//	Method to check if a player busts with all aces counting as 1's
	public static boolean checkBust(Player player) {
		int total = 0;
		for (int x = 0; x < player.hand.size(); x++) {
			int value = player.hand.get(x).getValue();
			if (value == 1) {
				total += 1;
			}
			else if (value == 2) {
				total += 2;
			}
			else if (value == 3) {
				total += 3;
			}
			else if (value == 4) {
				total += 4;
			}
			else if (value == 5) {
				total += 5;
			}
			else if (value == 6) {
				total += 6;
			}
			else if (value == 7) {
				total += 7;
			}
			else if (value == 8) {
				total += 8;
			}
			else if (value == 9) {
				total += 9;
			}
			else if (value == 10) {
				total += 10;
			}
			else if (value == 11) {
				total += 10;
			}
			else if (value == 12) {
				total += 10;
			}
			else if (value == 13) {
				total += 10;
			}
		}
		if (total > 21) {
			return true;
		}
		return false;
	}
	
	//Method to return the value of a particular card
	//Counts all aces as 11, is only used to check initial deal
	public static int cardToValue(Card card, boolean first) {
		Scanner input = new Scanner(System.in);
		if (first) {
			switch (card.getValue()) {
			case 1: return 11;//Automatically counts an ace as an 11 for the initial deal when checking for naturals
			case 2: return 2;
			case 3: return 3;
			case 4: return 4;
			case 5: return 5;
			case 6: return 6;
			case 7: return 7;
			case 8: return 8;
			case 9: return 9;
			case 10: return 10;
			case 11: return 10;
			case 12: return 10;
			case 13: return 10;
			}
		}
		else {
			switch (card.getValue()) {
			case 1: delay(2000); System.out.print("Would you like to count this ace as a 1 or 11? Enter your choice: ");  delay(2000);
			int num = input.nextInt();
			if (num == 1) {return 1;}
			else if (num == 11) {return 11;}
			break;
			case 2: return 2;
			case 3: return 3;
			case 4: return 4;
			case 5: return 5;
			case 6: return 6;
			case 7: return 7;
			case 8: return 8;
			case 9: return 9;
			case 10: return 10;
			case 11: return 10;
			case 12: return 10;
			case 13: return 10;
			}
		}
		
		return 0;
	}

}
