/**
 * 
 */
package chapter8;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author mckivergannp22
 *
 */
public class TestProgram1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub		System.out.println();

		Scanner input = new Scanner(System.in);
		//Three digit decimal format
		String pattern = "#.###";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		
		//Get an integer from the user
		System.out.print("Enter a positive integer: ");
		int num = input.nextInt();
		System.out.println();
		
		//Print out the digits
		printDigits(num);
		System.out.println();
		
		//Say how many digits the number contains
		System.out.println("This number has " + countDigits(num) + " digits");
		
		//Say how many are odd and how many are even
		System.out.println(countEven(num) + " are even and " + countOdd(num) + " are odd");
		
		//Get the average and print it out
		System.out.println("The average of these digits is " + decimalFormat.format(getMean(num)));
	}
	
	//Method for placing each digit of the number in an array
	public static int[] splitNum(int num) {
		num = Math.abs(num);//Takes the absolute value just in case the user entered a negative number
		int length = countDigits(num);//Need to know how many digits in order for this method to work properly
		int[] digits = new int[length];//Array to contain each digit in the correct order
		
		//Progressively divides by increasing powers of 10 and uses % to get the target digit
		for (int x = 0; x < length; x++) {
			digits[x] = ((int) (num / Math.pow(10, length - x - 1))) % 10;
		}
		return digits;
	}
	
	//Method for printing out each digit
	public static void printDigits(int num) {
		int[] digits = splitNum(num);
		System.out.print("You entered: ");
		for (int x = 0; x < digits.length; x++) {
			System.out.print(digits[x] + " ");
		}
	}
	
	//Counts and returns the number of digits in the number
	public static int countDigits(int num) {
		num = Math.abs(num);
		for (int x = 0; x > -1; x++) {
			if (Math.pow(10, x) > num) {
				return x;
			}
		}
		return 0;
	}
	
	//Counts and returns the number of even elements in the digits array
	public static int countEven(int num) {
		int[] digits = splitNum(num);
		int even = 0;
		for (int x = 0; x < digits.length; x++) {
			if (digits[x] % 2 == 0) {
				even++;
			}
		}
		return even;
	}
	
	//Counts and returns the number of odd elements in the digits array
	public static int countOdd(int num) {
		int[] digits = splitNum(num);
		int odd = 0;
		for (int x = 0; x < digits.length; x++) {
			if (digits[x] % 2 != 0) {
				odd++;
			}
		}
		return odd;
	}
	
	//Calculates and returns the mean average of all elements in the digits array
	public static double getMean(int num) {
		int[] digits = splitNum(num);
		double sum = 0;
		for (int x = 0; x < digits.length; x++) {
			sum += digits[x];
		}
		return sum / digits.length;
	}

}
