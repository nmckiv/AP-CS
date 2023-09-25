/**
 * 
 */
package chapter5;

/**
 * @author mckivergannp22
 *
 */
public class BigPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//The first for loop defines the number of lines printed
		for (int i = 1; i < 9; i++) {
			
			//r will define the highest value on each line, which is a power of two
			int r = (int) Math.pow(2.0, (double)i);
			
			//Prints the tabs before the numbers
			for (int t = i; t < 8; t++) {
				System.out.print("\t");
			}
			
			//Prints the numbers leading up to r with tabs in between
			for (int j = 1; j < (r);) {
				System.out.print(j + "\t");
				j = j * 2;
			}
			
			//defines the numbers descending from r
			for (int k = (r / 2); k > 0;) {
				k = (k / 2);
				
				//Sometimes k rounds to 0.  Use an if statement to prevent the 0's from printing
				if (k != 0)
				//prints the numbers coming down from 0 with tabs in between
				System.out.print(k + "\t");
				
			}
			//Puts each sequence on a new line
			System.out.println();
		}
	}
}