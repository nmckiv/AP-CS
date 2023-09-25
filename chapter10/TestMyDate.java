package chapter10;

import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class TestMyDate {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//Gets input from the user about the two custom dates
		System.out.print("Enter the milliseconds elapsed between your date and epoch: ");
		long time = input.nextLong();
		System.out.println();
		System.out.println("Enter the day, month, and year of your second date: ");
		System.out.println();
		System.out.print("Day: ");
		int day = input.nextInt();
		System.out.println();
		System.out.print("Month: ");
		int month = input.nextInt();
		System.out.println();
		System.out.print("Year: ");
		int year = input.nextInt();
		System.out.println();
		
		//Creates three date objects
		MyDate date1 = new MyDate();
		MyDate date2 = new MyDate(time);
		MyDate date3 = new MyDate(day, month, year);
		System.out.println();
		
		//Asks the user what time zone to change todays date to
		System.out.println("These times are all in Eastern Standard Time.  Which time zone would you like to change your date to?");
		System.out.println();
		System.out.println("1. Stockholm");
		System.out.println();
		System.out.println("2. Cairo");
		System.out.println();
		System.out.println("3. Hong Kong");
		System.out.println();
		System.out.print("Enter the number of your choice here: ");
		int choice = input.nextInt();
		System.out.println();
		//Changes the time zone
		if (choice == 1) {
			TimeZone zone = TimeZone.getTimeZone("Europe/Stockholm");
			date1.changeTimeZone(zone);
		}
		else if (choice == 2) {
			TimeZone zone = TimeZone.getTimeZone("Africa/Cairo");
			date1.changeTimeZone(zone);
		}
		else if (choice == 3) {
			TimeZone zone = TimeZone.getTimeZone("Asia/Hong_Kong");
			date1.changeTimeZone(zone);
		}
		
		//Prints todays date with the new time zone
		date1.printDate();
	}
}
