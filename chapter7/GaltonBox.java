/**
 * 
 */
package chapter7;

/**
 * @author mckivergannp22
 *
 */
import java.util.Scanner;
public class GaltonBox {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		//Initialize variables
		int balls = 0;
		int slots = 0;
		
		//Obtain user input to define the number of balls and slots, prevents invalid integers from being entered
		for (int a = 1; a > 0;) {
			System.out.print("How many balls: ");
			balls = input.nextInt();
			if (balls < 1) {
				System.out.println("invalid input, please enter a positve number of at least one");
			}
			else {
				break;
			}
		}

		for (int b = 1; b > 0;) {
			System.out.print("How many slots (at least two): ");
			slots = input.nextInt();
			if (slots < 2) {
				System.out.println("invalid input, please enter a positve number of at least two");
			}
			else {
				break;
			}
		}
		System.out.println("Results: ");//header
		System.out.println();
		
		
		boolean[] direction = new boolean[slots - 1];//Array representing the direction a ball bounces off each peg
		int[] result = new int[balls];//Array to contain the slot number each ball ends up on
		int lowSlot = 1;//Default value representing the leftmost slot, to be incremented each time the ball bounces to the right
		
		for (int d = 0; d < balls; d++) {
			System.out.print((d + 1) + ".\t ");
			lowSlot = 1;//resets the default slot value for each ball
			
			//Fills the direction array with random boolean values and prints output showing the path of the ball
			for (int c = 0; c < direction.length; c++) {
				if (((int) (Math.random() * 20)) + 1 > 10) {
					direction[c] = true;
					lowSlot++;
				}
				if (direction[c] == true) {
					System.out.print("R");
				}
				else if (direction[c] == false) {
					System.out.print("L");
				}
			}
			result[d] = lowSlot;//fills the result array with the slot number the ball finished in
			
			//Loop to reset every value of direction for a new trial with a new ball
			for (int e = 0; e < direction.length; e++) {
				direction[e] = false;
			}
			System.out.println();
		}
		for (int g = 0; g < result.length; g++) {
		}
		System.out.println();
		int[] numInSlot = new int[slots];//New array to contain the number of balls that finished in each slot
		
		//Defines numInSLot array using result array
		for (int h = 0; h < numInSlot.length; h++) {
			for (int i = 0; i < result.length; i++) {
				if (result[i] == (h + 1)) {
					numInSlot[h]++;
				}
			}
		}
		printBalls(numInSlot);//Invokes method to print out the distribution of the balls
}
	//Array to find and return the maximum value in an array
	public static int findMax(int numInSlot[]) {
		int max = 0;
		for (int j = 0; j < numInSlot.length; j++) {
			if (numInSlot[j] > max) {
				max = numInSlot[j];
			}
		}
		return max;
	}
	
	//Method to print distribution of the balls
	public static void printBalls(int numInSlot[]) {
		System.out.println("Final Ball Distribution");//header
		System.out.println();
		int max = findMax(numInSlot);//Finds the maximum number of balls in any one slot
		int m = max;//Holds the value of max
		
		//Prints the distribution in layers from the top down
		for (int p = 0; p < m; p++) {
			System.out.print("|");
			
			//Prints an O if a ball is in the slot for a particular layer, and a space if there is no ball
			for (int q = 0; q < numInSlot.length; q++) {
				if (numInSlot[q] == max) {
					System.out.print("O|");
					numInSlot[q]--;//Decrements the value in the array so "the ball below" will be printed in the next level
				}
				else {
					System.out.print(" |");
				}
			}
			System.out.println();
			max--;//Decrement max to move down to the next level
		}
	}
}
