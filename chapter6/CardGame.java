/**
 * 
 */
package chapter6;

/**
 * @author mckivergannp22
 *
 */
//Import dialog boxes
import javax.swing.JOptionPane;

public class CardGame {

	/**
	 * @param args
	 */
	
			
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Prompt the user to select a card
		
		//Define variables used for strings
		String strrank, strsuit;
		String strCompRank = null;
		String strCompSuit = null;
		
		//Define variables used for numerical processing
		int rank, suit, compRank, compSuit;
		int score = 0, compScore = 0;
		
		//Play the card game five times
		for (int x = 0; x < 5; x++) {
			
		//Have the user enter a card, turn the strings into integers	
		strrank = JOptionPane.showInputDialog(null,"Enter the rank of the card (1 - 13) ",
				"Input Rank", JOptionPane.QUESTION_MESSAGE);
		rank = Integer.parseInt(strrank);
		
		strsuit = JOptionPane.showInputDialog(null,"Enter the suit of the card (1 for diamonds, two for hearts, three for spades, four for clubs) ",
				"Input Suit", JOptionPane.QUESTION_MESSAGE);
		suit = Integer.parseInt(strsuit);
		
		//Generate a random card to be played by the computer
		compRank = generateCardRank();
		compSuit = generateCardSuit();
		
		//Redefine each string in the way it should be printed
		switch (compRank) {
		case 1: strCompRank = "Ace"; break;
		case 2: strCompRank = "Two"; break;
		case 3: strCompRank = "Three"; break;
		case 4: strCompRank = "Four"; break;
		case 5: strCompRank = "Five"; break;
		case 6: strCompRank = "Six"; break;
		case 7: strCompRank = "Seven"; break;
		case 8: strCompRank = "Eight"; break;
		case 9: strCompRank = "Nine"; break;
		case 10: strCompRank = "Ten"; break;
		case 11: strCompRank = "Jack"; break;
		case 12: strCompRank = "Queen"; break;
		case 13: strCompRank = "King"; break;
		}
		
		switch (rank) {
		case 1: strrank = "Ace"; break;
		case 2: strrank = "Two"; break;
		case 3: strrank = "Three"; break;
		case 4: strrank = "Four"; break;
		case 5: strrank = "Five"; break;
		case 6: strrank = "Six"; break;
		case 7: strrank = "Seven"; break;
		case 8: strrank = "Eight"; break;
		case 9: strrank = "Nine"; break;
		case 10: strrank = "Ten"; break;
		case 11: strrank = "Jack"; break;
		case 12: strrank = "Queen"; break;
		case 13: strrank = "King"; break;
		}
		
		switch (compSuit) {
		case 1: strCompSuit = "\u2666"; break;
		case 2: strCompSuit = "\u2665"; break;
		case 3: strCompSuit = "\u2660"; break;
		case 4: strCompSuit = "\u2663"; break;
		}
		
		switch (suit) {
		case 1: strsuit = "\u2666"; break;
		case 2: strsuit = "\u2665"; break;
		case 3: strsuit = "\u2660"; break;
		case 4: strsuit = "\u2663"; break;
		}
		
		//Show the user what cards the cards are
		JOptionPane.showMessageDialog(null, "The computer chose the " + strCompRank + " of " + strCompSuit + ", and you picked the " + strrank + " of " + strsuit, "Card Game", JOptionPane.INFORMATION_MESSAGE);
		
		//If the cards are exactly the same, redo the round
		if (rank == compRank && suit == compSuit) {
			x -= 1;
			JOptionPane.showMessageDialog(null, "There has been a tie.  This round will not count", "Card Game", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			
		//Utilize compare cards class to play the game
		boolean result = compareCards(rank, suit, compRank, compSuit);
		
		//Tell the user who won and keep a tally of the total scores
		if (result == true) {
			compScore += 1;
			JOptionPane.showMessageDialog(null, "The computer wins this round", "Card Game", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (result == false) {
			score += 1;
			JOptionPane.showMessageDialog(null, "You win this round", "Card Game", JOptionPane.INFORMATION_MESSAGE);
		}
		}
		
		//Show the total scores after each round
		JOptionPane.showMessageDialog(null, "Score:      You: " + score + "      Computer: " + compScore, "Card Game", JOptionPane.INFORMATION_MESSAGE);

	}
		
	//After five rounds, show the user who won the game
	if (compScore > score) {
		JOptionPane.showMessageDialog(null, "The computer has won the game", "Card Game", JOptionPane.INFORMATION_MESSAGE);
	}
	
	else if (compScore < score) {
		
		JOptionPane.showMessageDialog(null, "You have won the game", "Card Game", JOptionPane.INFORMATION_MESSAGE);
	}

	}

//Generate a random number 1-4 to represent the suit of a card
public static int generateCardSuit() {
	int compSuit;
	compSuit = 1 + (int) (Math.random() * 4);
	return compSuit;
}

//Generate a random number 1-13 to represent the rank of a card
public static int generateCardRank() {
	int compRank;
	compRank = 1 + (int) (Math.random() * 13);
	return compRank;
}

public static boolean compareCards(int rank, int suit, int compRank, int compSuit) {
	//Play game with created cards
	//A return of true indicates that the computer won, while false indicates that the user won
	
	if (compSuit == 1 || compSuit == 2) {
		if (compRank > rank) {
			return true;
		}
		else if (compRank < rank) {
			return false;
		}
		else if ((compRank == rank) && ((((compSuit == 1) || (compSuit == 2)) && ((suit == 3) || (suit == 4))) || (((compSuit == 3) || (compSuit == 4)) && ((suit == 1) || (suit == 2))))) {
			if ((compSuit == 1) || (compSuit == 2)) {
				return true;
			}
			else if ((suit == 1) || (suit == 2)) {
				return false;
			}
		}
		else {
			if ((compSuit == 2) || (compSuit == 3)) {
				return true;
			}
			else {
				return false;
			}
		}
		}
	else if (compSuit == 3 || compSuit == 4) {
		if (compRank < rank) {
			return true;
		}
		else if (compRank > rank) {
			return false;
		}
		else if ((compRank == rank) && ((((compSuit == 1) || (compSuit == 2)) && ((suit == 3) || (suit == 4))) || (((compSuit == 3) || (compSuit == 4)) && ((suit == 1) || (suit == 2))))) {
			if ((compSuit == 1) || (compSuit == 2)) {
				return true;
			}
			else if ((suit == 1) || (suit == 2)) {
				return false;
			}
		}
		else {
			if ((compSuit == 2) || (compSuit == 3)) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	return false;

	}

}
