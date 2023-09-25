/**
 * 
 */
package chapter5;

/**
 * @author mckivergannp22
 *
 */
//import dialog boxes
import javax.swing.JOptionPane;
public class SlotMachine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		JOptionPane.showMessageDialog(null, "Do you want to play slots?  Press OK to play!", "Slots Game", JOptionPane.INFORMATION_MESSAGE);
		
		//define how many tokens the user starts with
		int tokens = 100;
		
		//Use an integer to allow the user to press play
		int play = 0;
		
		//Terminate the game when tokens goes below 0
		while (tokens > 0) {
			
			//Ask the user if they would like to play
			String strplay = JOptionPane.showInputDialog(null, "You have " + tokens + " tokens remaining.  Would you like to play?  Enter 1 to play, or press cancel to quit.",
					 "Slots Game", JOptionPane.QUESTION_MESSAGE);
			play = Integer.parseInt(strplay);
			if (play == 1) {
				
				//Remove two tokens from the bank to play
				tokens -= 2;
				
				//Randomly select an integer between 1 and 3 to determine which symbols are drawn
				int intsymbol1 = ((int) (Math.random() * 3)) + 1;
				int intsymbol2 = ((int) (Math.random() * 3)) + 1;
				int intsymbol3 = ((int) (Math.random() * 3)) + 1;
				
				
				//Use integers to define the strings that are the symbols
				String symbol1 = null, symbol2 = null, symbol3 = null;
				
				if (intsymbol1 == 1) {
					symbol1 = "!";
				}
				else if (intsymbol1 == 2) {
					symbol1 = "#";
				}
				else if (intsymbol1 == 3) {
					symbol1 = "$";
				}
				if (intsymbol2 == 1) {
					symbol2 = "!";
				}
				else if (intsymbol2 == 2) {
					symbol2 = "#";
				}
				else if (intsymbol2 == 3) {
					symbol2 = "$";
				}
				if (intsymbol3 == 1) {
					symbol3 = "!";
				}
				else if (intsymbol3 == 2) {
					symbol3 = "#";
				}
				else if (intsymbol3 == 3) {
					symbol3 = "$";
				}
				
				//Define the number of tokens won and a string message telling the user how much they won or if they lost
				//Add their winnings to the token bank
				String winnings = null;
				if (intsymbol1 == 1 && intsymbol2 == 1 && intsymbol3 == 1) {
					winnings = "Congratulations, you won 4 tokens!";
					tokens += 4;
				}
				else if (intsymbol1 == 2 && intsymbol2 == 2 && intsymbol3 == 2) {
					winnings = "Congratulations, you won 8 tokens!";
					tokens += 8;
				}
				else if (intsymbol1 == 3 && intsymbol2 == 3 && intsymbol3 == 3) {
					winnings = "Congratulations, you won 12 tokens!";
					tokens += 12;
				}
				else {
					winnings = "Sorry, you lost";
				}
				
				//Show the user the symbols, tell them if they won, and how many tokens they won
				JOptionPane.showMessageDialog(null, "[" + symbol1 + "] [" + symbol2 + "] [" + symbol3 + "]\n" + winnings, "Slots Game", JOptionPane.INFORMATION_MESSAGE);
				
				//Tell the user if their tokens drop below 100
				if (tokens < 1) {
					JOptionPane.showMessageDialog(null, "You're all out of tokens", "Slots Game", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			
			//If a number other than 1 is entered, display an error message
			else {
				JOptionPane.showMessageDialog(null, "Invalid input: Please enter 1 to play, or cancel to quit", "Slots Game", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

}
