/**
 * 
 */
package chapter9;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 */
public class NMU {
	
	//Constructor
	public NMU() {
		
	}
	
	//Method to print every element of a string arrayList in an organized manner
	public static void printArrayList(ArrayList<String> list) {
		for (int x = 0; x < list.size(); x++) {
			System.out.print(x + 1 + ". ");
			printNL(list.get(x));
		}
	}
	
	//Methods to print every element of arrays of primitive types in an organized manner
	public static void printList(char[] list) {
		for (int x = 0; x < list.length; x++) {
			System.out.print(x + 1 + ". ");
			printNL(list[x]);
		}
	}
	public static void printList(String[] list) {
		for (int x = 0; x < list.length; x++) {
			System.out.print(x + 1 + ". ");
			printNL(list[x]);
		}
	}
	public static void printList(double[] list) {
		for (int x = 0; x < list.length; x++) {
			System.out.print(x + 1 + ". ");
			printNL(list[x]);
		}
	}
	public static void printList(int[] list) {
		for (int x = 0; x < list.length; x++) {
			System.out.print(x + 1 + ". ");
			printNL(list[x]);
		}
	}
	
	//Methods overloaded to obtain input of primitive types from the user
	//A prompt must be passed in
	//When called, these methods print the prompt and return the users input
	public static String getString(String prompt) {
		Scanner input = new Scanner(System.in);
		System.out.print(prompt);
		return input.next();
	}
	public static double getDouble(String prompt) {
		Scanner input = new Scanner(System.in);
		System.out.print(prompt);
		return input.nextDouble();
	}
	public static int getInt(String prompt) {
		Scanner input = new Scanner(System.in);
		System.out.print(prompt);
		return input.nextInt();
	}
	public static char getChar(String prompt) {
		Scanner input = new Scanner(System.in);
		System.out.print(prompt);
		return input.next().charAt(0);
	}
	public static void clearScreen() {
		for (int x = 0; x < 100; x++) {
			System.out.println();
		}
	}
	
	//Overloaded methods to print primitive types and then move to the next line
	public static void printNL(String string) {
		System.out.println(string);
	}
	public static void printNL(char letter) {
		System.out.println(letter);
	}
	public static void printNL(int num) {
		System.out.println(num);
	}
	public static void printNL(double num) {
		System.out.println(num);
	}
	
	//Overloaded methods to print primitive types but stay on the same line
	public static void printSL(String string) {
		System.out.print(string);
	}
	public static void printSL(int num) {
		System.out.print(num);
	}
	public static void printSL(double num) {
		System.out.print(num);
	}
	
	//Method to truncate a decimal number
	public static int truncNum(double num) {
		return (int) num;
	}
	
	//Method to make the computer wait for a specified numbe rof seconds before continuing with the program
	public static void delay(double duration) {
		long startTime = System.currentTimeMillis();
		while (1 > 0) {
			if (System.currentTimeMillis() > startTime + duration * 1000) {
				break;
			}
		}
		
	}
	
	//Method to format a decimal number to a specified number of decimal places
	public static double formatNum(double num, int places) {
		num *= Math.pow(10, places);
		num = (double) (int) num;
		num /= Math.pow(10, places);
		return num;
	}
	
	//Random number generator
	//Generates a random integer between the specified min and max inclusive
	public static int randomInt(int min, int max) {
		int range = max - min;
		return min + (int) (Math.random() * range + 1);
	}
}
