/**
 * 
 */
package chapter6;

/**
 * @author mckivergannp22
 *
 */
import java.util.Scanner;
public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Prepare scanner
		Scanner input = new Scanner(System.in);
		//Obtain an integer
		System.out.print("Enter an integer: ");
		long number = input.nextLong();
		//Invoke the reverse method and print the result
		long newnumber = reverse(number);
		System.out.println(number + " reversed is " + newnumber);

	}
	public static long reverse(long number) {
		//Obtain length of number
		long length = 0;
		long x = number;
		while (x > 0) {
			x = x / 10;
			length += 1;
		}

		//Reverse the number
		for (long y = 1; y <length + 1; y++) {//Repeat 'length' number of times
			long digit = (long) (((int)((number / Math.pow(10, length - y)) % 10)) * Math.pow(10, y - 1));//Separate the number defined by each digit, and transform it into the number for the reversed integer
			x += digit;//Add up all the transformed digits
		}
		//Return the new number
		return x;
		
	}

}
