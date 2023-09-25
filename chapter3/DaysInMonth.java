/**
 * 
 */
package chapter3;

import javax.swing.JOptionPane;

/**
 * @author mckivergannp22
 *
 */
public class DaysInMonth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String StrYear;
		String StrMonth;
		int year;
		int month;
		
		//Ask the user for a year, and parse input to an integer
		StrYear = JOptionPane.showInputDialog(null,"Enter a year: ",
				"Input Dialogue", JOptionPane.QUESTION_MESSAGE);
		year = Integer.parseInt(StrYear);
			
		
		//Ask the user for a month, and parse input into an integer
		StrMonth = JOptionPane.showInputDialog(null,"Enter a number representing a month in that year (for example, march would be 3): ",
				"Input Dialogue", JOptionPane.QUESTION_MESSAGE);
		month = Integer.parseInt(StrMonth);
		
		//Print the number of days in that month
		switch (month) {
		case 1: JOptionPane.showMessageDialog(null, "January "+year+" has 31 days", "Output Window", JOptionPane.INFORMATION_MESSAGE); break;
		//If the month is February, determine if the year is a leap year
		case 2: //If the year is evenly divisible by 400, it is a leap year and february has 29 days
				if (year % 400 == 0)
					JOptionPane.showMessageDialog(null, "February "+year+" has 29 days", "Output Window", JOptionPane.INFORMATION_MESSAGE);
				//If the year is evenly divisible by 100 and not 400, it is not a leap year and february has 28 days
				else if (year % 100 == 0)
					JOptionPane.showMessageDialog(null, "February "+year+" has 28 days", "Output Window", JOptionPane.INFORMATION_MESSAGE);
				//If the year is evenly divisible by 4 and not 100, it is a leap year and february has 29 days
				else if (year % 4 == 0)
					JOptionPane.showMessageDialog(null, "February "+year+" has 29 days", "Output Window", JOptionPane.INFORMATION_MESSAGE);
				//If none of these conditions are true, it is not a leap year and february has 28 days
				else
					JOptionPane.showMessageDialog(null, "February "+year+" has 28 days", "Output Window", JOptionPane.INFORMATION_MESSAGE);
		break;
		case 3: JOptionPane.showMessageDialog(null, "March "+year+" has 31 days", "Output Window", JOptionPane.INFORMATION_MESSAGE); break;
		case 4: JOptionPane.showMessageDialog(null, "April "+year+" has 30 days", "Output Window", JOptionPane.INFORMATION_MESSAGE); break;
		case 5: JOptionPane.showMessageDialog(null, "May "+year+" has 31 days", "Output Window", JOptionPane.INFORMATION_MESSAGE); break;
		case 6: JOptionPane.showMessageDialog(null, "June "+year+" has 30 days", "Output Window", JOptionPane.INFORMATION_MESSAGE); break;
		case 7: JOptionPane.showMessageDialog(null, "July "+year+" has 31 days", "Output Window", JOptionPane.INFORMATION_MESSAGE); break;
		case 8: JOptionPane.showMessageDialog(null, "August "+year+" has 31 days", "Output Window", JOptionPane.INFORMATION_MESSAGE); break;
		case 9: JOptionPane.showMessageDialog(null, "September "+year+" has 30 days", "Output Window", JOptionPane.INFORMATION_MESSAGE); break;
		case 10: JOptionPane.showMessageDialog(null, "October "+year+" has 31 days", "Output Window", JOptionPane.INFORMATION_MESSAGE); break;
		case 11: JOptionPane.showMessageDialog(null, "November "+year+" has 30 days", "Output Window", JOptionPane.INFORMATION_MESSAGE); break;
		case 12: JOptionPane.showMessageDialog(null, "December "+year+" has 31 days", "Output Window", JOptionPane.INFORMATION_MESSAGE); break;
		//If a number other than 1-12 is assigned to month, print an error message
		default: JOptionPane.showMessageDialog(null, month+" Is not a number between 1 and 12", "Output Window", JOptionPane.INFORMATION_MESSAGE); break;
		
		
		}
		
		
		
		

	}
}


