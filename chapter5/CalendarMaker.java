/**
 * 
 */
package chapter5;

/**
 * @author mckivergannp22
 *
 */
import java.util.Scanner;
public class CalendarMaker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Prepare scanner
		Scanner input = new Scanner(System.in);
		
		//Obtain user input and define variables
		System.out.print("Enter a year: ");
		int year = input.nextInt();
		
		System.out.print("Enter a number corresponding to the first day of that year (Sunday would be 1, Monday would be 2, etc.): ");
		
		//Finalize the first day of the year
		final int FIRSTDAY = input.nextInt();
		
		//Tell the user how to move back and forth
		System.out.println("Enter 1 to move forward");
		
		//Determine whether the year is a leap year
		boolean leapYear = false;
		if (year % 400 == 0) {
			leapYear = true;
		}
		else if (year % 100 == 0) {
			leapYear = false;
		}
		else if (year % 4 == 0) {
			leapYear = true;
		}
		
		//Define variables for month name, and number of days in each month
		String strMonth = null;
		int days = 0;
		
		
		//Assign values to these variables depending on month number entered and leap year status
		int firstDay = FIRSTDAY;
		
		//Repeat the loop as long as the month is in between 0 and 11
		for (int month = 1; month < 12 && month > 0;) {
			
			//Define name of month, number of days in month, and first day for that month
			for (int m = 1; m < 30; m++);
			System.out.println();
			
			//If it is a leap year
			if (leapYear == true) {
				switch (month) {
				case 1: strMonth = "January"; days = 31; break;
				case 2: strMonth = "February"; days = 29; if ((firstDay + 31) % 7 != 0) {
					firstDay = (firstDay + 31) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 3: strMonth = "March"; days = 31; if ((firstDay + 60) % 7 != 0) {
					firstDay = (firstDay + 60) % 7; break;
				}
				else {
					firstDay = 7; break;
				}

				case 4: strMonth = "April"; days = 30; if ((firstDay + 91) % 7 != 0) {
					firstDay = (firstDay + 91) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 5: strMonth = "May"; days = 31; if ((firstDay + 121) % 7 != 0) {
					firstDay = (firstDay + 121) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 6: strMonth = "June"; days = 30; if ((firstDay + 152) % 7 != 0) {
					firstDay = (firstDay + 152) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 7: strMonth = "July"; days = 31; if ((firstDay + 182) % 7 != 0) {
					firstDay = (firstDay + 182) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 8: strMonth = "August"; days = 31; if ((firstDay + 213) % 7 != 0) {
					firstDay = (firstDay + 213) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 9: strMonth = "September"; days = 30; if ((firstDay + 244) % 7 != 0) {
					firstDay = (firstDay + 244) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 10: strMonth = "October"; days = 31; if ((firstDay + 274) % 7 != 0) {
					firstDay = (firstDay + 274) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 11: strMonth = "November"; days = 30; if ((firstDay + 305) % 7 != 0) {
					firstDay = (firstDay + 305) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 12: strMonth = "December"; days = 31; if ((firstDay + 335) % 7 != 0) {
					firstDay = (firstDay + 335) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				}
			}
			
			//If it was not a leap year
			else {
				switch (month) {
				case 1: strMonth = "January"; days = 31; break;
				case 2: strMonth = "February"; days = 28; if ((firstDay + 31) % 7 != 0) {
					firstDay = (firstDay + 31) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 3: strMonth = "March"; days = 31; if ((firstDay + 59) % 7 != 0) {
					firstDay = (firstDay + 59) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 4: strMonth = "April"; days = 30; if ((firstDay + 90) % 7 != 0) {
					firstDay = (firstDay + 90) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 5: strMonth = "May"; days = 31; if ((firstDay + 120) % 7 != 0) {
					firstDay = (firstDay + 120) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 6: strMonth = "June"; days = 30; if ((firstDay + 151) % 7 != 0) {
					firstDay = (firstDay + 151) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 7: strMonth = "July"; days = 31; if ((firstDay + 181) % 7 != 0) {
					firstDay = (firstDay + 181) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 8: strMonth = "August"; days = 31; if ((firstDay + 212) % 7 != 0) {
					firstDay = (firstDay + 212) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 9: strMonth = "September"; days = 30; if ((firstDay + 243) % 7 != 0) {
					firstDay = (firstDay + 243) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 10: strMonth = "October"; days = 31; if ((firstDay + 273) % 7 != 0) {
					firstDay = (firstDay + 273) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 11: strMonth = "November"; days = 30; if ((firstDay + 304) % 7 != 0) {
					firstDay = (firstDay + 304) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 12: strMonth = "December"; days = 31; if ((firstDay + 334) % 7 != 0) {
					firstDay = (firstDay + 334) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				}
				
			}
			
			System.out.println();
			System.out.println();
			System.out.println("          " + strMonth);
			System.out.println("----------------------------------------");
			System.out.println("Sun Mon Tue Wed Thu Fri Sat");
			
			//Print the correct number of spaces at the beginning of each month
			for (int k = 1; k < firstDay; k++) {
				System.out.print("    ");
			}
			
			//Print each day, and skip to a new line when necessary
			for (int i = 1; i < days + 1; i++) {
				
				
				System.out.print(" ");
				if (i < 10) {
					System.out.print(i + "  ");
				}
				else {
					System.out.print(i + " ");
				}
				if ((i + firstDay - 1) % 7 == 0) {
					System.out.println();
				}

			}
			
			//Increment month to advance to the new month
			month += 1;
			
			//Redefine the first day as the first day of the year, and repeat code to display second month
			firstDay = FIRSTDAY;
			
			
			if (leapYear == true) {
				switch (month) {
				case 1: strMonth = "January"; days = 31; break;
				case 2: strMonth = "February"; days = 29; if ((firstDay + 31) % 7 != 0) {
					firstDay = (firstDay + 31) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 3: strMonth = "March"; days = 31; if ((firstDay + 60) % 7 != 0) {
					firstDay = (firstDay + 60) % 7; break;
				}
				else {
					firstDay = 7; break;
				}

				case 4: strMonth = "April"; days = 30; if ((firstDay + 91) % 7 != 0) {
					firstDay = (firstDay + 91) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 5: strMonth = "May"; days = 31; if ((firstDay + 121) % 7 != 0) {
					firstDay = (firstDay + 121) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 6: strMonth = "June"; days = 30; if ((firstDay + 152) % 7 != 0) {
					firstDay = (firstDay + 152) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 7: strMonth = "July"; days = 31; if ((firstDay + 182) % 7 != 0) {
					firstDay = (firstDay + 182) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 8: strMonth = "August"; days = 31; if ((firstDay + 213) % 7 != 0) {
					firstDay = (firstDay + 213) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 9: strMonth = "September"; days = 30; if ((firstDay + 244) % 7 != 0) {
					firstDay = (firstDay + 244) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 10: strMonth = "October"; days = 31; if ((firstDay + 274) % 7 != 0) {
					firstDay = (firstDay + 274) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 11: strMonth = "November"; days = 30; if ((firstDay + 305) % 7 != 0) {
					firstDay = (firstDay + 305) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 12: strMonth = "December"; days = 31; if ((firstDay + 335) % 7 != 0) {
					firstDay = (firstDay + 335) % 7; break;
				}
				else {
					firstDay = 7; break;
				}				
				}
			}
			else {
				switch (month) {
				case 1: strMonth = "January"; days = 31; break;
				case 2: strMonth = "February"; days = 28; if ((firstDay + 31) % 7 != 0) {
					firstDay = (firstDay + 31) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 3: strMonth = "March"; days = 31; if ((firstDay + 59) % 7 != 0) {
					firstDay = (firstDay + 59) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 4: strMonth = "April"; days = 30; if ((firstDay + 90) % 7 != 0) {
					firstDay = (firstDay + 90) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 5: strMonth = "May"; days = 31; if ((firstDay + 120) % 7 != 0) {
					firstDay = (firstDay + 120) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 6: strMonth = "June"; days = 30; if ((firstDay + 151) % 7 != 0) {
					firstDay = (firstDay + 151) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 7: strMonth = "July"; days = 31; if ((firstDay + 181) % 7 != 0) {
					firstDay = (firstDay + 181) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 8: strMonth = "August"; days = 31; if ((firstDay + 212) % 7 != 0) {
					firstDay = (firstDay + 212) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 9: strMonth = "September"; days = 30; if ((firstDay + 243) % 7 != 0) {
					firstDay = (firstDay + 243) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 10: strMonth = "October"; days = 31; if ((firstDay + 273) % 7 != 0) {
					firstDay = (firstDay + 273) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 11: strMonth = "November"; days = 30; if ((firstDay + 304) % 7 != 0) {
					firstDay = (firstDay + 304) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				case 12: strMonth = "December"; days = 31; if ((firstDay + 334) % 7 != 0) {
					firstDay = (firstDay + 334) % 7; break;
				}
				else {
					firstDay = 7; break;
				}
				}
				
			}
			
			System.out.println();
			System.out.println();
			System.out.println("          " + strMonth);
			System.out.println("----------------------------------------");
			System.out.println("Sun Mon Tue Wed Thu Fri Sat");
			
			//Print out second month just like the first
			for (int k = 1; k < firstDay; k++) {
				System.out.print("    ");
			}
			for (int i = 1; i < days + 1; i++) {
				
				System.out.print(" ");
				if (i < 10) {
					System.out.print(i + "  ");
				}
				else {
					System.out.print(i + " ");
				}
				if ((i + firstDay - 1) % 7 == 0) {
					System.out.println();
				}

			}
			
			//Reset month to its original value
			month -= 1;
			
			//Reset firstDay to the first day of the year
			firstDay = FIRSTDAY;
				
			
				
			//Use an integer to indicate whether to move back or forward
			System.out.println();
			System.out.println();
			System.out.print("Enter 1 to move forward, or 2 to go back: ");
			int move = input.nextInt();
			
			//Print enough lines to bump existing text out of console window
			for (int g = 1; g < 30; g++) {
				System.out.println();
			}
		
			//Increment or decrement the month number according to the user's wishes
			if (move == 1) {
				month += 1;
			}
			else if (move == 2) {
				month -= 1;
			}
			
			
			
			

	}

}
}
