/**
 * 
 */
package chapter4;

/**
 * @author mckivergannp22
 *
 */
public class WordGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Define variables corresponding to each letter
		int l1;
		int l2;
		int l3;
		int l4;
		int l5;
		
		//Generate random integers between 65 and 90
		l1 = 65 + (int)(Math.random() * 25);
		l2 = 65 + (int)(Math.random() * 25);
		l3 = 65 + (int)(Math.random() * 25);
		l4 = 65 + (int)(Math.random() * 25);
		l5 = 65 + (int)(Math.random() * 25);
		
		//Cast integers into ASCII characters
		char L1 = (char)l1;
		char L2 = (char)l2;
		char L3 = (char)l3;
		char L4 = (char)l4;
		char L5 = (char)l5;
		
		//Print word
		System.out.println(L1 + "" + L2 + "" + L3 + "" + L4 + "" + L5);
		
		

	}

}
