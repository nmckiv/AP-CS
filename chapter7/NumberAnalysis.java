/**
 * 
 */
package chapter7;

import java.text.DecimalFormat;
/**
 * @author mckivergannp22
 *
 */
import java.util.Scanner;
public class NumberAnalysis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		//Create the list
		int[] myList = makeList();//Generates a random list
		myList = sortList(myList);//Sorts the list
		
		DecimalFormat df = new DecimalFormat("###.00");
		
		//Use an infinite loop to repeat the program until the user elects to exit
		for (int i = 1; i > 0;) {
		
		//Print a menu
		System.out.println("Choose an action to perform on the list:");
		System.out.println("1. Find the mean");
		System.out.println("2. Find the maximum and minimum");
		System.out.println("3. Find the median");
		System.out.println("4. Find the mode");
		System.out.println("5. Find the index of a specific number");
		System.out.println("6. Print a section of the list");
		System.out.println("7. Exit");
		
		//Ask the user what they want to do
		System.out.print("What would you like to to with the list?  Enter the number of your choice (1-7): ");
		int operation = input.nextInt();
		System.out.println();
		//Use the users response to call the appropriate methods
		switch (operation) {
		case 1: System.out.println("The mean of the list is " + df.format(findMean(myList))); break;
		case 2: System.out.println("The maximum of the list is " + findMaximum(myList) + " and the minimum is " + findMinimum(myList)); break;
		case 3: System.out.println("The median of the list is " + findMedian(myList)); break;
		case 4: findMode(myList); break;
		case 5: findNumber(myList); break;
		case 6: printList(myList); break;
		case 7: i = 0; break;//Terminates the loop to exit the program
		}
		System.out.println();
	}

	}
	
	//Method to generate a random list
	public static int[] makeList() {
		int[] myList = new int[10000];
		for (int i = 0; i < myList.length; i++) {
			myList[i] = ((int) (Math.random() * 5000)) + 1;
		}
		return myList;
	}
	
	//Method to sort the generated list in ascending order
	public static int[] sortList(int[] myList) {
		for (int i = 0; i < myList.length - 1; i++) {
			int min = myList[i];
			int minIndex = i;
			for (int x = i + 1; x < myList.length; x++) {
				if (min > myList[x]) {
					min = myList[x];
					minIndex = x;
				}
				
			}
			if (minIndex != i) {
				myList[minIndex] = myList[i];
				myList[i] = min;
			}
		}
		return myList;
	}
	
	//Method to find and return the mean of the list
	public static double findMean(int[] myList) {
		int sum = 0;
		for (int i = 0; i < myList.length; i++) {
			sum += myList[i];		
		}
		double mean = ((double) sum) / ((double) myList.length);
		return mean;
	}
	
	//Method to find and return the minimum of the list (the first number), provided that the list is already sorted
	public static int findMinimum(int[] myList) {
		return myList[0];
	}
	
	//Method to find and return the maximum of the list (the last number), provided that the list is already sorted
	public static int findMaximum(int[] myList) {
		return myList[myList.length - 1];
	}
	
	//Method to find and return the median of the list (the average of the 4999th and 5000th number), provided that the list is already sorted
	public static double findMedian(int[] myList) {
		int x = myList[4999] + myList[5000];
		double median = ((double) x) / 2.0;
		return median;
	}
	
	//Method to find and return the mode of the list
	public static void findMode(int[] myList) {
		int modeCount = 0;//How many times the mode exists in the list
		int currentCount = 0;//How many times the number being tested exists in the list
		int mode = 0;//To be changed as the mode is updated
		
		for (int i = 0; i <= findMaximum(myList); i++) {//Goes through every possible value in the list
			for (int x = 0; x < myList.length; x++) {//For every possible value, count up how many of that number exist in the list
				if (myList[x] == i) {
					currentCount++;
				}
			}
			
			//Update the mode if necessary
			if (currentCount > modeCount) {
				modeCount = currentCount;
				mode = i;
			}
			currentCount = 0;//Reset number counter for each new number tested
			}
		System.out.println("The mode is " + mode);
		System.out.println(mode + " appears " + modeCount + " times in the list");
		System.out.println();
	}
	
	//Method to print a specified section of the list
	public static void printList(int[] myList) {
		Scanner input = new Scanner(System.in);
		
		//Obtain user input to determine what section to print
		System.out.println("Enter the index (1-10000) of the first and last element you wish to print:");
		System.out.print("Beginning Index: ");
		int start = input.nextInt() - 1;//Define the starting point as a variable
		System.out.print("End Index: ");
		int finish = input.nextInt() - 1;//Define the ending point as a variable
		
		//Print the section
		int z = 0;//represents the number of terms printed on a line
		for (int i = start; i <= finish; i++) {
				System.out.print(myList[i] + "\t");
				z++;//increments per term printed
				if ((z) % 10 == 0) {//moves to a new line every 10th number
					System.out.println();
				}
		}
	}
	
	//Method to find where in the list a certain number exists
	public static void findNumber(int[] myList) {
		Scanner input = new Scanner(System.in);
		boolean exists = false;//Represents whether the given number exists in the list
		
		//Obtain user input to specify the number to search for
		System.out.print("Enter a number between 1 and 5000 to find where it exists in the list: ");
		int num = input.nextInt();
		System.out.println();
		
		//Determines whether the given number exists in the list
		for (int x = 0; x < myList.length; x++) {
			if (myList[x] == num) {
				exists = true;//Changes this variable accordingly
			}
		}
		
		//To be enacted if it is confirmed that the number exists in the list
		if (exists == true) {
		
		System.out.println("The number " + num + " exists in the following spots in the list:");//Prints header
		int count = 0;//variable representing the number of times the number appears in the list
		
		//Loop that goes through the entire list and prints the index if the number exists there (for practical purposes, 
		//the printed index is 1 greater than the actual index so it makes sense to the user)
		for (int i = 0; i < myList.length; i++) {
			if (myList[i] == num) {
				System.out.println(i + 1);
				count++;
			}
		}
		}
		
		//To be enacted if it has been confirmed that the number does not exist in the list
		else {
			System.out.println("The number " + num + " does not exist in the list");
		}
	}

}