/**
 * 
 */
package chapter3;



/**
 * @author mckivergannp22
 *
 */
import java.util.Scanner;
public class Practice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Everything on the console will cleared");
		int number = input.nextInt();
		if (number == 5) {
        System.out.print("\033 [H \033 [2J");
        System.out.flush();
		}

	}

}
