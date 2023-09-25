/**
 * 
 */
package chapter5;

/**
 * @author mckivergannp22
 *
 */
import java.util.Scanner;
public class Patterns {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		//Use a sum to determine which pattern to display.  The user will enter 1 to move on to the next pattern
		System.out.print("Press 1 and then enter to display the first pattern: ");
		
		int pattern = 0;
		
		pattern = input.nextInt();
		System.out.println();
		
		if (pattern == 1) {
			for (int i = 1; i < 7; i++) {
				
				for (int j = 1; j < (i + 1); j++) {
					System.out.print(j + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.print("Enter 1 to move on to the next pattern: ");
			pattern += (input.nextInt()) * 10;
			System.out.println();
		}
		if (pattern == 11) {
			for (int i = 1; i < 7; i++) {
				
				for (int j = 1; j < (8 - i); j++) {
					System.out.print(j + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.print("Enter 1 to move on to the next pattern: ");
			pattern = (pattern * 10) + input.nextInt();
			System.out.println();

			
		}
		if (pattern == 111) {
			for (int i = 1; i < 7; i++) {
				for (int k = 1; k < (7 - i); k++) {
					System.out.print("  ");
				
				}
				for (int j = 1; j < (i + 1); j++) {
					
					System.out.print(((i - j) + 1) + " ");
				}
				System.out.println();
			}
			System.out.println();
			System.out.print("Enter 1 to move on to the next pattern");
			pattern = (pattern * 10) + input.nextInt();
			System.out.println();
			}
		if (pattern == 1111) {
			for (int i = 1; i < 7; i++) {
				for (int k = 1; k < (i); k++) {
					System.out.print("  ");
				
				}
				for (int j = 1; j < (8 - i); j++) {
					System.out.print(j + " ");
				}
				System.out.println();
			}
			}
		
		else 
			System.out.print("Invalid input: please enter 1 to move on to the next pattern");
		

	}

}
