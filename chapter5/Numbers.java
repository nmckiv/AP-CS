/**
 * 
 */
package chapter5;

/**
 * @author mckivergannp22
 *
 */
//Import scanner
import java.util.Scanner;
public class Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Prepare scanner
		Scanner input = new Scanner(System.in);
		
		//Define variables
		int positive, negative, sum, posSum, negSum, count, number;
		positive = negative = sum = count = posSum = negSum = 0;
		
		//Promt the user to enter a number
		System.out.print("Enter a number: ");
		number = input.nextInt();
		
		//Define 0 as sentinel value
		while (number != 0) {
		//Process input as it comes in
			count += 1;
			sum += number;
			
			//Test for positivity
			if (number > 0) {
				positive += 1;
				posSum += number;
			}
			//Test for negativity 
			if (number < 0) {
				negative += 1;
				negSum += number;
			}
			
			//Promt the user to enter another number, or end the program
			System.out.print("Enter another number, or press 0 to end: ");
		number = input.nextInt();
			
			
		}
		//Calculate averages
		double mean, posMean, negMean;
		mean = ((double) sum) / ((double) count);
		posMean = ((double) posSum) / ((double) positive);
		negMean = ((double) negSum) / ((double) negative);
		//Print the results
		
		System.out.println();
		System.out.println("There are " + count + " numbers");
		System.out.println("All the numbers add up to " + sum);
		System.out.println("There are " + positive + " positive numbers");
		System.out.println("All the positive numbers add up to " + posSum);
		System.out.println("There are " + negative + " negative numbers");
		System.out.println("All the negative numbers add up to " + negSum);
		System.out.println("The average of all the numbers is " + ((double)((int)(mean * 100)) / 100));
		System.out.println("The average of all the positive numbers is " + ((double)((int)(posMean * 100)) / 100));
		System.out.println("The average of all the negative numbers is " + ((double)((int)(negMean * 100)) / 100));
		
		

	}

}
