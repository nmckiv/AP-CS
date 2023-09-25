/**
 * 
 */
package chapter3;

import javax.swing.JOptionPane;

/**
 * @author mckivergannp22
 *
 */
public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String StrNumber;
		int number;
		
		//Ask the user to enter a number
		StrNumber = JOptionPane.showInputDialog(null,"Enter a three digit integer: ",
				"Input Dialogue", JOptionPane.QUESTION_MESSAGE);
		
		//Make sure input is a three digit number
		number = Integer.parseInt(StrNumber);
		if (number > 999)
			//Display error message
			JOptionPane.showMessageDialog(null, "Invalid Input: "+number+" is not a three digit integer", "Invalid Input", JOptionPane.INFORMATION_MESSAGE);
		//If it is a three digit number, test if the first and third digits are equal
		else {
			if (StrNumber.charAt(0) == StrNumber.charAt(2))
			//Print that the number is a palindrome
			JOptionPane.showMessageDialog(null, number+" is a palindrome number", "Output Window", JOptionPane.INFORMATION_MESSAGE);
			else
				//Print that the number is not a palindrome
				JOptionPane.showMessageDialog(null, number+" is not a palindrome number", "Output Window", JOptionPane.INFORMATION_MESSAGE);
		
		

	}

}}
