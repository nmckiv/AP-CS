package chapter10;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MyDate {
	public int day;
	public int month;
	public int year;
	public int dayOfWeek;
	public int hour;
	public int minute;
	public TimeZone zone = TimeZone.getTimeZone("America/New_York");
	public GregorianCalendar calendar;
	
	//Default constructor to make a date object representing todays date
	public MyDate() {
		calendar = new GregorianCalendar();
		calendar.setTimeZone(zone);
		day = calendar.get(calendar.DAY_OF_MONTH);
		month = calendar.get(calendar.MONTH);
		year = calendar.get(calendar.YEAR);
		dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
		hour = calendar.get(calendar.HOUR_OF_DAY);
		minute = calendar.get(calendar.MINUTE);
		printDate();
	}
	
	//Constructor to create a date object for a given number of milliseconds since epoch
	public MyDate(long timeElapsed) {
		calendar = setDate(timeElapsed);
		calendar.setTimeZone(zone);
		day = calendar.get(calendar.DAY_OF_MONTH);
		month = calendar.get(calendar.MONTH);
		year = calendar.get(calendar.YEAR);
		dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
		hour = calendar.get(calendar.HOUR_OF_DAY);
		minute = calendar.get(calendar.MINUTE);
		printDate();
	}
	
	//Constructor to create a date object for a specified day, month, and year
	public MyDate(int dayEntered, int monthEntered, int yearEntered) {
		day = dayEntered;
		month = monthEntered - 1;
		year = yearEntered;
		calendar = new GregorianCalendar(year, month, day);
		GregorianCalendar calendar2 = new GregorianCalendar();
		calendar.setTimeZone(zone);
		dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
		hour = calendar2.get(calendar2.HOUR_OF_DAY);
		minute = calendar2.get(calendar2.MINUTE);
		printDate();
	}
	
	//Method to print the date and time
	public void printDate() {
		System.out.println("Date created successfully: " + getStrDay(dayOfWeek) + ", " + getStrMonth(month) + " " + day + ", " + year);
		System.out.println();
		System.out.print("Time on 24hr clock: " + hour +":");
		if (minute > 9) {
			System.out.println(minute);
		}
		else {
			System.out.println("0" + minute);
		}
		System.out.println();
	}
	
	//Method to change the time zone and redefine the date object
	public void changeTimeZone(TimeZone newZone) {
		zone = newZone;
		calendar.setTimeZone(zone);
		day = calendar.get(calendar.DAY_OF_MONTH);
		month = calendar.get(calendar.MONTH);
		year = calendar.get(calendar.YEAR);
		dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
		hour = calendar.get(calendar.HOUR_OF_DAY);
		minute = calendar.get(calendar.MINUTE);
	}
	
	//Getter methods for day, month, and year
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	
	//Method to set the date using a calendar and milliseconds since epoch
	public GregorianCalendar setDate(long elapsedTime) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTimeInMillis(elapsedTime);
		return calendar;
	}
	
	//Methods to get string equivalents of the month and day numbers
	public String getStrMonth(int month) {
		switch (month) {
		case 0: return "January"; 
		case 1: return "February";
		case 2: return "March";
		case 3: return "April";
		case 4: return "May";
		case 5: return "June";
		case 6: return "July";
		case 7: return "August";
		case 8: return "September";
		case 9: return "October";
		case 10: return "November";
		case 11: return "December";
		}
		return "";
	}
	public String getStrDay(int day) {
		switch (day) {
		case 1: return "Sunday";
		case 2: return "Monday"; 
		case 3: return "Tuesday";
		case 4: return "Wednesday";
		case 5: return "Thursday";
		case 6: return "Friday";
		case 7: return "Saturday";
		}
		return "";
	}
}