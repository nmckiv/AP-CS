//package chapter10;
//
//import java.text.DateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//
//public class MyDate {
//	public int day;
//	public int month;
//	public int year;
//	public int dayOfWeek;
//	public int hour;
//	public int minute;
//
//	
//	public MyDate() {
//		GregorianCalendar calendar = new GregorianCalendar();
//		day = calendar.get(calendar.DAY_OF_MONTH);
//		month = calendar.get(calendar.MONTH);
//		year = calendar.get(calendar.YEAR);
//		dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
//		hour = calendar.get(calendar.HOUR_OF_DAY);
//		minute = calendar.get(calendar.MINUTE);
//		System.out.println("Date created successfully: " + getStrDay(dayOfWeek) + ", " + getStrMonth(month) + " " + day + ", " + year);
//		System.out.print("Time: " + hour +":");
//		if (minute > 9) {
//			System.out.println(minute);
//		}
//		else {
//			System.out.println("0" + minute);
//		}
//	}
//	public MyDate(long timeElapsed) {
//		GregorianCalendar calendar = setDate(timeElapsed);
//		day = calendar.get(calendar.DAY_OF_MONTH);
//		month = calendar.get(calendar.MONTH);
//		year = calendar.get(calendar.YEAR);
//		dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
//		hour = calendar.get(calendar.HOUR_OF_DAY);
//		minute = calendar.get(calendar.MINUTE);
//		System.out.println("Date created successfully: " + getStrDay(dayOfWeek) + ", " + getStrMonth(month) + " " + day + ", " + year);
//		System.out.print("Time: " + hour +":");
//		if (minute > 9) {
//			System.out.println(minute);
//		}
//		else {
//			System.out.println("0" + minute);
//		}
//	}
//	public MyDate(int dayEntered, int monthEntered, int yearEntered) {
//		GregorianCalendar calendar = new GregorianCalendar(year, month, day);
//		GregorianCalendar calendar2 = new GregorianCalendar();
//		day = dayEntered;
//		month = monthEntered;
//		year = yearEntered;
//		dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
//		hour = calendar.get(calendar2.HOUR_OF_DAY);
//		minute = calendar.get(calendar2.MINUTE);
//		System.out.println("Date created successfully: " + getStrDay(dayOfWeek) + ", " + getStrMonth(month) + " " + day + ", " + year);
//		System.out.print("Time: " + hour +":");
//		if (minute > 9) {
//			System.out.println(minute);
//		}
//		else {
//			System.out.println("0" + minute);
//		}
//	}
//	
//	public int getDay() {
//		return day;
//	}
//	public int getMonth() {
//		return month;
//	}
//	public int getYear() {
//		return year;
//	}
//	
//	public GregorianCalendar setDate(long elapsedTime) {
//		GregorianCalendar calendar = new GregorianCalendar();
//		calendar.setTimeInMillis(elapsedTime);
//		return calendar;
//	}
//	
//	public String getStrMonth(int month) {
//		switch (month) {
//		case 0: return "January"; 
//		case 1: return "February";
//		case 2: return "March";
//		case 3: return "April";
//		case 4: return "May";
//		case 5: return "June";
//		case 6: return "July";
//		case 7: return "August";
//		case 8: return "September";
//		case 9: return "October";
//		case 10: return "November";
//		case 11: return "December";
//		}
//		return "";
//	}
//	public String getStrDay(int day) {
//		switch (day) {
//		case 1: return "Sunday";
//		case 2: return "Monday"; 
//		case 3: return "Tuesday";
//		case 4: return "Wednesday";
//		case 5: return "Thursday";
//		case 6: return "Friday";
//		case 7: return "Saturday";
//		}
//		return "";
//	}
//}