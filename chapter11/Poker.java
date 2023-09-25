package chapter11;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Poker {
	//Class declaration/initialization
	public static Vector<Player> players = new Vector<>();//Array of players
	public static Vector<Player> players2 = new Vector<>();//Used to reset players after each round
	public static ArrayList<Player> winners = new ArrayList<>();//Array of winners
	public static Dealer dealer;
	public static Scanner input = new Scanner(System.in);
	public static double pot;
	public static double currentBet;
	public static double ante;
	public static DecimalFormat df = new DecimalFormat("####0.00");
	
	public static void main(String[] args) {
		System.out.println("Welcome to Poker");
		delay(2000);
		System.out.println();
		
		//Get number of players
		System.out.print("How many players? (4 max): ");
		int numOfPlayers = getNum(2, 4);//Special method to ensure a valid input
		System.out.println();
		
		//Create poker object with correct number of players
		Poker poker = new Poker(numOfPlayers);		
		
		//Loop continues to play round after round until fewer than two players wish to play again
		while (1 > 0) {
			delay(3000);
			clearScreen();
			printTable(false);//Prints initial table after deal
			delay(3000);
			playFirstRound();//Plays the round of betting
			clearScreen();
			delay(3000);
			
			//If more than one player has not folded, do a showdown
			if (players.size() > 1) {
				draw();
				showDown();
			}
			
			//If only one player remains, they automatically win
			else if (players.size() == 1) {
				System.out.println(players.get(0).name + " is the only remaining player and wins the pot!");
				players.get(0).winnings += pot;
				winners.add(players.get(0));
			}
			
			//If no players remain, nobody wins
			else {
				System.out.println("All players have folded, and nobody wins the pot");
			}
			delay(5000);
			clearScreen();
			delay(2000);
			showWinnings();//Displays the final results of the round
			delay(3000);
			replay();//Prepares for another round
		}
	}
	
	//Poker object constructor
	public Poker(int numOfPlayers) {
		dealer = new Dealer();
		pot = 0;
		currentBet = 0;
		ante = 10;
		
		//Creates each player, asks for their name, and gives them $500 initially
		for (int x = 0; x < numOfPlayers; x++) {
			Player player = new Player();
			player.winnings = 500;
			System.out.print("Player " + (x + 1) + ", enter your name: ");
			player.name = input.next();
			System.out.println();
			
			//Adds these players to both arrayLists
			players.add(player);
			players2.add(player);
		}
		//Deal each player 5 cards
		dealCards(5);
		delay(2000);
		//Deducts the ante
		System.out.println("The ante is $10.  This amount has been deducted from your banks.");
		for (int x = 0; x < numOfPlayers; x++) {
			players.get(x).winnings -= ante;
			pot += ante;
		}
	}
	
	//Special recursive method to handle invalid input types
	public static double getBet(Player player) {
		Scanner scanner = new Scanner(System.in);
		double bet;
		try {
			bet = scanner.nextDouble();
			if (bet < 0) {
				System.out.println();
				System.out.print("Invalid input: please enter a positive amount: ");
				return getBet(player);
			}
			else if (bet > player.winnings) {
				System.out.println();
				System.out.print("You don't have that much money.  Enter an amount you can afford: ");
				return getBet(player);
			}
		}
		catch (Exception e){
			//Calls getBet again if there is an exception
			System.out.println();
			System.out.print("invalid input: please enter a valid amount: ");
			return getBet(player);
		}
		return bet;
	}
	
	//Special recursive method similar to above, designed to only accept integers between specified min and max
	public static int getNum(int min, int max) {
		Scanner scanner = new Scanner(System.in);
		int num;
		try {
			num = scanner.nextInt();
			if (num < min || num > max) {
				System.out.println();
				System.out.print("invalid input: please enter a number between " + min + " and  " + max + ": ");
				return getNum(min, max);
			}
		}
		catch (Exception e) {
			System.out.println();
			System.out.print("invalid input: please enter a number between " + min + " and  " + max + ": ");
			return getNum(min, max);
		}
		return num;
	}
	
	//Method to prepare for another round
	public static void replay() {
		//Creates a new dealer with a new shuffled deck
		dealer = new Dealer();
		
		//Terminates the program if fewer than 2 players still have money left
		if (players2.size() < 2) {
			System.out.println("We don't have enough people remaining to play again");
			System.out.println();
			System.out.println("Thanks for playing!");
			System.exit(0);
		}
		clearScreen();
		delay(2000);
		
		//Asks each player if they want to play again
		System.out.println("Who wants to play again?");
		delay(2000);
		System.out.println();
		for (int x = 0; x < players2.size(); x++) {
			Player player = players2.get(x);
			if (player.winnings < 10) {
				//Doesn't allow a player to play again if they can't pay the $10 ante
				System.out.println(player.name + ", you don't have enough money to get into another game");
				players2.remove(x);
				x--;
				delay(3000);
				break;
			}
			else {
				//Asks the player if they want to play again
				System.out.print(player.name + ", would you like to play again?  Enter Y or N: ");
				while (1 > 0) {
					String choice = input.next();
					if (choice.equalsIgnoreCase("Y")) {
						break;
					}
					else if (choice.equalsIgnoreCase("N")) {
						players2.remove(x);
						x--;
						break;
					}
					//Handles bad input
					System.out.println();
					System.out.print("Invalid input: Enter Y to play again or N to leave the game: ");
				}
			}
			System.out.println();
		}
		
		//Terminates the program if fewer than 2 players still want to play
		if (players2.size() < 2) {
			System.out.println();
			System.out.println("We don't have enough people remaining to play");
			System.out.println();
			System.out.println("Thanks for playing!");
			System.exit(0);
		}
		
		//Resets everything for a new round here
		players = players2;//Copies returning players back into the players array
		winners = new ArrayList<>();
		pot = 0;
		currentBet = 0;
		replaceHands(5);//Replaces each players hand with 5 new cards
		delay(2000);
		clearScreen();
		delay(2000);
		
		//Deducts the ante again and plays another round
		System.out.println("The ante is $10.  This amount has been deducted from your banks.");
		for (int x = 0; x < players.size(); x++) {
			players.get(x).winnings -= ante;
			pot += ante;
		}
		delay(2000);
	}
	
	//Method to handle a showdown
	public static void showDown() {
		ArrayList<Integer> handRanks = new ArrayList<>();
		System.out.println("We have a showdown!  ");
		delay(2000);
		System.out.println();
		for (int x = 0; x < players.size(); x++) {
			System.out.print(players.get(x).name + ", ");
		}
		System.out.println("reveal your hands!");
		delay(3000);
		System.out.println();
		printTable(true);
		delay(5000);
		System.out.println();
		sort(players);//Sorts each player according to the ranks of their hands
		Player last = players.get(players.size() - 1);//This player has the highest ranking hand
		
		//Adds every players hand ranks to the arrayList
		for (int x = 0; x < players.size(); x++) {
			handRanks.add(evaluateHand(players.get(x)));
		}
		System.out.println();
		
		//If the highest ranking hand only occurs once, that player wins
		if (Collections.frequency(handRanks, evaluateHand(last)) == 1) {
			System.out.println(last.name + " has the highest ranking hand and wins the pot!");
			winners.add(last);
		}
		
		//If the highest ranking hand equals 1 and occurs for every player, they all have high cards
		else if((Collections.frequency(handRanks, evaluateHand(last)) == players.size() && evaluateHand(last) == 1)) {
			System.out.println("All players have high cards.");
			delay(3000);
			System.out.println();
			sortHighCard(players);//Sorts every player according to their highest card
			last = players.get(players.size() - 1);//Player with the highest card
			for (int x = 0; x < handRanks.size(); x++) {
				//Fill arraylist with highest cards
				handRanks.set(x, findHighCard(players.get(x)));
			}
			//If the highest ranking card only occurs once, that player wins
			if (Collections.frequency(handRanks, findHighCard(last)) == 1) {
				System.out.println(players.get(players.size() - 1).name + " has the highest card and wins the pot!");
				winners.add(last);
			}
			
			//Otherwise, there is a tie for highest card
			else {
				System.out.println("There is a " + Collections.frequency(handRanks, findHighCard(last)) + "-way tie for highest card.");
				delay(3000);
				System.out.println();
				System.out.print("The pot will be split between ");
				//Determines which players possess the highest card and adds them to winners
				for (int x = 0; x < players.size(); x++) {
					Player current = players.get(x);
					if (evaluateHand(current) == evaluateHand(last)) {
						winners.add(current);
						if (x != players.size() - 1) {
							System.out.print(current.name);
							System.out.print(", ");
						}
						else {
							System.out.print("and ");
							System.out.print(current.name);
							System.out.print(".");
						}
					}
				}
			}
		}
		//Otherwise, there is a tie for highest hand
		else {
			System.out.println("There is a " + (Collections.frequency(handRanks, evaluateHand(last))) + "-way tie for highest ranking hand");
			delay(3000);
			System.out.println();
			System.out.print("The pot will be split between ");
			//Determines which players possess the highest card and adds them to winners
			for (int x = 0; x < players.size(); x++) {
				Player current = players.get(x);
				if (evaluateHand(current) == evaluateHand(last)) {
					winners.add(current);
					if (x != players.size() - 1) {
						System.out.print(current.name);
						System.out.print(", ");
					}
					else {
						System.out.print("and ");
						System.out.print(current.name);
						System.out.print(".");
					}
				}
			}
		}
		System.out.println();
		delay(3000);
		distributePot();//Distributes the pot
	}
	
	//Method to divide the pot among the winner(s)
	public static void distributePot() {
		System.out.println();
		int winnerNum = winners.size();
		double payout = pot / winnerNum;
		Player winner = winners.get(0);
		//If one player won
		if (winnerNum == 1) {
			System.out.println(winner.name + " wins " + "$" + df.format(pot));
			winner.winnings += payout;
		}
		//If multiple players tied
		else {
			for (int x = 0; x < winnerNum; x++) {
				Player current = winners.get(x);
				current.winnings += payout;
				if (x == winnerNum - 1) {
					System.out.print(" and ");
					System.out.print(current.name + " each win $" + (payout));
				}
				else {
					System.out.print(current.name);
					if (winnerNum != 2) {
						System.out.print(",");
					}
				}
			}
			System.out.println();
		}
	}
	
	//Method to print a players hand
	public static void printHand(Player player) {
		for (int x = 0; x < player.hand.size(); x++) {
			System.out.print((x + 1) + ". "); player.hand.get(x).printCard();
			System.out.println();
		}
	}
	
	//Method where each player can select which cards to replace
	public static void draw() {
		ArrayList<Integer> cardsToReplace;
		int numReplaced;
		int replace;//Index of card to replace
		
		//Loop repeats replacement process for each player
		for (int x = 0; x < players.size(); x++) {
			numReplaced = 0;
			cardsToReplace = new ArrayList<>();
			System.out.println(players.get(x).name + ", this is your hand: ");
			System.out.println();
			printHand(players.get(x));
			System.out.println();
			System.out.print("Enter the number of a card you would like to replace, or enter 0 to pass: ");
			replace = getNum(0, 5);
			System.out.println();
				while (replace != 0) {//0 indicates the player is done
					cardsToReplace.add(replace);
					System.out.println("Card #" + replace + " will be replaced in your hand.");
					numReplaced++;
					System.out.println();
					
					//No more than three cards can be replaced
					if (numReplaced == 3) {
						System.out.println("You can only replace 3 cards");
						delay(2000);
						System.out.println();
						break;
					}
					System.out.print("Enter another card you would like to replace, or enter 0 to finish: ");
					
					//Infinite loop to process invalid input
					while (1 > 0) {
						replace = getNum(0, 5);//Ensures a numerical input
						
						//Prevents a player from entering the same card twice
						if (cardsToReplace.contains(replace)) {
							System.out.println("You cannot replace a card twice");
							System.out.println();
							System.out.println("Enter the number of a card you would like to replace, or enter 0 to pass: ");
						}
						else {
							break;
						}
					}
					System.out.println();
				}
				
			//Replaces every card the player wished to replace
			for (int y = 0; y < cardsToReplace.size(); y++) {
				players.get(x).hand.set(cardsToReplace.get(y) - 1, dealer.dealCard());
			}
			if (cardsToReplace.size() > 0) {
				System.out.println("Here is your new hand:");
				delay(3000);
				System.out.println();
				printHand(players.get(x));
				delay(7000);
			}
			else {
				delay(3000);
			}
			
			clearScreen();
		}
	}
	
	//Method to play round of betting
	public static void playFirstRound() {
		boolean betMade = false;//Indicates whether a bet has been made
		int choice;
		double bet;
		double raise;
		
		//Goes through each player and asks them what they want to do
		for (int x = 0; x < players.size(); x++) {
			Player player = players.get(x);
			clearScreen();
			System.out.println(players.get(x).name + "'s turn:");
			delay(3000);
			System.out.println();
			printTable(players.get(x));
			delay(2000);
			System.out.println();
			
			//If no bet has been placed yet
			if (!betMade) {
				//Ask the player what they want to do
				System.out.print(players.get(x).name + ", would you like to (1) check, (2) bet, or (3) fold? ");
				choice = getNum(1, 3);//Ensures the player chooses a number between 1 and 3
				
				//Process the choice the player makes
				switch(choice) {
				case 1: break;
				case 2: System.out.println(); System.out.print("How much would you like to bet? Enter your amount: $");
				bet = getBet(players.get(x));
				
				//Deducts the bet from the player and adds it to the pot
				pot += bet; 
				players.get(x).winnings -= bet;
				currentBet = bet;
				betMade = true;
				break;
				case 3: players.remove(x); x--; break;
				}
			}
			
			//If a bet has been placed
			else {
				//If the player does not have enough money to match the current bet, they are automatically folded
				if (player.winnings < currentBet) {
					System.out.println(player.name + ", you do not have enough money to make a bet, so you are out of this round.");
					choice = 3;
					delay(3000);
				}
				//Otherwise, they are free to call, raise, or fold
				else {
					System.out.print(players.get(x).name + ", would you like to (1) call, (2) raise, or (3) fold? ");
					choice = getNum(1, 3);//Ensures the player chooses a number between 1 and 3
				}
				
				//Process the choice the player makes
				switch(choice) {
				case 1: players.get(x).winnings -= currentBet; pot += currentBet; break;
				case 2: System.out.println(); System.out.print("How much would you like to raise by? Enter your amount: $");
				players.get(x).winnings -= currentBet;//Deducts the current bet
				raise = getBet(players.get(x));
				players.get(x).winnings += currentBet;//Returns the current bet
				
				//Deducts the raise plus the bet anmd adds it to the pot
				pot += (currentBet + raise); players.get(x).winnings -= (currentBet + raise);
				currentBet += raise;
				break;
				case 3: players.remove(x); x--; break;
				}
			}
			delay(4000);
			System.out.println();
		}
	}
	
	//Sorts players by highest card in their hand
	public static void sortHighCard(Vector<Player> players) {
		Player player;
		int index;
		for (int x = 0; x < players.size(); x++) {
			player = players.get(x);
			index = x;
			for (int y = x + 1; y < players.size(); y++) {
				if (findHighCard(players.get(y)) < findHighCard(player)) {
					player = players.get(y);
					index = y;
				}
			}
			players.set(index, players.get(x));
			players.set(x, player);
		}
	}
	
	//returns the highest card in a players hand
	public static int findHighCard(Player player) {
		int max = 0;
		for (int x = 0; x < player.hand.size(); x++) {
			if (player.hand.get(x).getValue() > max && player.hand.get(x).getValue() != 1) {
				max = player.hand.get(x).getValue();
			}
			else if (player.hand.get(x).getValue() == 1) {
				max = 14;
			}
		}
		return max;
	}
	
	//Sorts players by highest ranking hand
	public static void sort(Vector<Player> players) {
		Player player;
		int index;
		for (int x = 0; x < players.size(); x++) {
			player = players.get(x);
			index = x;
			for (int y = x + 1; y < players.size(); y++) {
				if (evaluateHand(players.get(y)) < evaluateHand(player)) {
					player = players.get(y);
					index = y;
				}
			}
			players.set(index, players.get(x));
			players.set(x, player);
		}
	}
	
	//Sorts an arrayList of Integer objects
	public static void sort(ArrayList<Integer> values) {
		int num;
		int index;
		for (int x = 0; x < values.size(); x++) {
			num = values.get(x);
			index = x;
			for (int y = x + 1; y < values.size(); y++) {
				if (values.get(y) < num) {
					num = values.get(y);
					index = y;
				}
			}
			values.set(index, values.get(x));
			values.set(x, num);
		}
	}
	
	//Returns the string equivalent of a hand's integer rank
	public static String evaluateHandStr(int num) {
		switch(num) {
		case 1: return "High Card";
		case 2: return "One Pair";
		case 3: return "Two Pair";
		case 4: return "Three of a Kind";
		case 5: return "Straight";
		case 6: return "Flush";
		case 7: return "Full House";
		case 8: return "Four of a Kind";
		case 9: return "Straight Flush";
		case 10: return "Royal Flush";
		}
		return "error";
	}
	
	//Returns a players hand rank in string form
	public static String evaluateHandStr(Player player) {
		int num = evaluateHand(player);
		switch(num) {
		case 1: return "High Card";
		case 2: return "One Pair";
		case 3: return "Two Pair";
		case 4: return "Three of a Kind";
		case 5: return "Straight";
		case 6: return "Flush";
		case 7: return "Full House";
		case 8: return "Four of a Kind";
		case 9: return "Straight Flush";
		case 10: return "Royal Flush";
		}
		return "error";
	}
	
	//Method to determine the rank of a hand
	public static int evaluateHand(Player player) {
//		Hierarchy:
//		1. High card
//		2. One pair
//		3. Two pair
//		4. Three of a kind
//		5. Straight
//		6. Flush
//		7. Full house
//		8. Four of a Kind
//		9. Straight Flush
//		10. Royal Flush
		
		//Creates arrayLists containing every suit and value in the player's hand
		ArrayList<Integer> suits = new ArrayList<>();
		ArrayList<Integer> values = new ArrayList<>();
		for (int x = 0; x < player.hand.size(); x++) {
			suits.add(player.hand.get(x).getSuit());
			values.add(player.hand.get(x).getValue());
		}
		sort(values);//Sorts the values arrayList for easier processing
		
		//First checks for any kind of flush by checking the suit of each card
		if (suits.get(0) == suits.get(1) && suits.get(1) == suits.get(2) && suits.get(2) == suits.get(3) && suits.get(3) == suits.get(4)) {
			//Determine what type of flush
			if (values.contains(1) && values.contains(10) && values.contains(11) && values.contains(12) && values.contains(13)) {
				return 10;//Royal flush
			}
			else if (values.get(4) - values.get(0) == 4) {
				return 9;//Straight flush
			}
			else {
				return 6;//Flush
			}
		}
		
		//Checks for a straight
		//Checks difference between first and last card == 4 and then ensures no two cards are the same
		else if (values.get(4) - values.get(0) == 4 && values.get(0) != values.get(1) && values.get(1) != values.get(2) && values.get(2) != values.get(3) && values.get(3) != values.get(4)) {
			return 5;//Straight
		}
		//Ace can count as a 14 as well
		else if (values.get(0) == 1 && values.get(1) == 10 && values.get(2) == 11 && values.get(3) == 12 && values.get(4) == 13) {
			return 5;//Straight
		}
		
		//Checks for full house by looking for 3 and 2, and then 2 and 3
		else if (Collections.frequency(values, values.get(0)) == 3) {
			for (int x = 0; x < values.size(); x++) {
				if (Collections.frequency(values, values.get(x)) == 2) {
					return 7;//Full House
				}
			}
		}
		else if (Collections.frequency(values, values.get(0)) == 2) {
			for (int x = 0; x < values.size(); x++) {
				if (Collections.frequency(values, values.get(x)) == 3) {
					return 7;//Full House
				}
			}
		}
		
		//Checks for 3 and 4 of a kind by checking the frequency of every card value
		for (int x = 0; x < values.size(); x++) {
			if (Collections.frequency(values, values.get(x)) == 3) {
				return 4;//Three of a kind
			}
			else if (Collections.frequency(values, values.get(x)) == 4) {
				return 8;//Four of a kind
			}
		}
		
			//Checks for a two pair
			//First finds a pair and then looks for a different pair
			for (int x = 0; x < values.size(); x++) {
				if (Collections.frequency(values, values.get(x)) == 2) {
					for (int y = 0; y < values.size(); y++) {
						if ((Collections.frequency(values, values.get(y)) == 2) && (values.get(y) != values.get(x))) {
							return 3;//Two pair
						}
					}
					//If no second pair is found then there is only one pair
					return 2;//One pair
				}
			}		
		//If nothing above worked, then the player has a high card
		//Resets values and suits for next player
		for (int x = 0; x < values.size();) {
			values.remove(x);
			suits.remove(x);
		}
		return 1;//high card
	}
	
	//Method to print final results of the round
	public static void showWinnings() {
		System.out.println("=================Results===================");
		delay(2000);
		Player player;
		int winnerNum = winners.size();
		for (int x = 0; x < players2.size(); x++) {
			player = players2.get(x);
			System.out.println();
			//If the player won something in the round
			if (winners.contains(player)) {
				System.out.println((players2.get(x)).name + " has won $" + df.format((pot / winners.size())) + " and now has $" + player.winnings);
			}
			//If the player ran out of money
			else if (player.winnings == 0){
				System.out.println(player.name + " lost this round, ran out of money, and is out of the game :(");
				players2.remove(x);
				x--;
			}
			//If the player didn't win this round but has money left
			else {
				System.out.println(player.name + " lost this round and now has $" + player.winnings + " remaining");
			}
			delay(2000);
		}
	}
	
	//Method to print the table with only one player's cards visible
	public static void printTable(Player player) {
		System.out.println("Pot:\t$" + df.format(pot));
		System.out.println();
		System.out.println("Bet:\t$" + df.format(currentBet));
		System.out.println();
		for (int x = 0; x < players.size(); x++) {
			System.out.print(players.get(x).name + "\t\t\t\t");
		}
		System.out.println();
		System.out.println();
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < players.size(); y++) {
				Player one = players.get(y);
				int num = players.indexOf(player);
				if (y == num) {			
						one.getCard(x).printCard();
				}
				else {
					System.out.print("?????????????????");
				}
				for (int z = 0; z < 17 - (one.getCard(x).suitLength() + one.getCard(x).valueLength()); z++) {
					System.out.print(" ");
				}
				System.out.print("\t\t");
			}
			System.out.println();
		}
		System.out.println();
		for (int x = 0; x < players.size(); x++) {
			double bank = players.get(x).winnings;
			System.out.print("Bank: $" + df.format(bank) + "\t\t\t");
		}
		delay(2000);
		System.out.println();
		System.out.println();
		System.out.println("You have a " + evaluateHandStr(evaluateHand(player)));
	}
	
	//Prints the table with either every players hands revealed or no players hands revealed
	public static void printTable(boolean showCards) {
		System.out.println("Pot:\t$" + df.format(pot));
		System.out.println();
		for (int x = 0; x < players.size(); x++) {
			System.out.print(players.get(x).name + "\t\t\t\t");
		}
		System.out.println();
		System.out.println();
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < players.size(); y++) {
				// gets each player
				Player one = players.get(y);
				if (showCards) {	
					// gets and prints card
						one.getCard(x).printCard();
				}
				else {
					System.out.print("?????????????????");
				}
				for (int z = 0; z < 17 - (one.getCard(x).suitLength() + one.getCard(x).valueLength()); z++) {
					System.out.print(" ");
				}
				System.out.print("\t\t");
			}
			System.out.println();
		}
		System.out.println();
		if (!showCards) {
			for (int x = 0; x < players.size(); x++) {
				double bank = players.get(x).winnings;
				System.out.print("Bank: $" + df.format(bank) + "\t\t\t");
			}
		}
		System.out.println();
		if (showCards) {
			System.out.println();
			for (int x = 0; x < players.size(); x++) {
				Player one = players.get(x);
				System.out.print(evaluateHandStr(one));
				for (int y = 0; y < 17 - evaluateHandStr(one).length(); y++) {
					System.out.print(" ");
				}
				System.out.print("\t\t");
			}
		}
	}
	
	//Method to deal a specified number cards to each player
	public void dealCards(int numOfCards) {
		for (int a = 0; a < numOfCards; a++) {
			for (int x = 0; x < players.size(); x++) {
				players.get(x).hand.add(dealer.dealCard());
			}
		}
	}
	
	//Method to replace every player' hands with a specified number of cards
	public static void replaceHands(int numOfCards) {
		for (int a = 0; a < numOfCards; a++) {
			for (int x = 0; x < players.size(); x++) {
				players.get(x).hand.set(a, dealer.dealCard());
			}
		}
	}
	
	//Method to delay the program for a given number of milliseconds
	public static void delay(long length) {
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() < start + length);
	}
	
	//Method to print 100 lines to simulate clearing the screen
	public static void clearScreen() {
		for (int x = 0; x < 100; x++) {
			System.out.println();
		}
	}

}
