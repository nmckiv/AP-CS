/**
 * 
 */
package chapter4;

import javax.swing.JOptionPane; // dialog boxes
/**
 * @author mckivergannp22
 *
 */
public class Test2Program1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Pick a card, any card!  Press OK to pick a card.", "Pick A Card!", JOptionPane.INFORMATION_MESSAGE);
		//Generate a random integer that corresponds to rank
		int rankNum = (1 + ((int)(Math.random() * 13)));
		//Generate a random integer that corresponds to suit
		int suitNum = (1 + ((int)(Math.random() * 4)));
		
		//Use a switch statement to process the number rank and define the corresponding string for the rank
		String rank = null;
		switch (rankNum) {
		case 1: rank = "Ace"; break;
		case 2: rank = "two"; break;
		case 3: rank = "three"; break;
		case 4: rank = "four"; break;
		case 5: rank = "five"; break;
		case 6: rank = "six"; break;
		case 7: rank = "seven"; break;
		case 8: rank = "eight"; break;
		case 9: rank = "nine"; break;
		case 10: rank = "ten"; break;
		case 11: rank = "Jack"; break;
		case 12: rank = "Queen"; break;
		case 13: rank = "King"; break;
		}
		
		//Use a switch statement to process the suit number and define the corresponding string for the suit
		String suit = null;
		switch (suitNum) {
		case 1: suit = "Spades"; break;
		case 2: suit = "Clubs"; break;
		case 3: suit = "Hearts"; break;
		case 4: suit = "Diamonds"; break;
		}
		
		//Print the output
		JOptionPane.showMessageDialog(null, "Your card is the " + rank + " of " + suit, "Pick A Card!", JOptionPane.INFORMATION_MESSAGE);
		

	}

}
