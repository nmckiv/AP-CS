/**
 * 
 */
package chapter9;

import java.util.ArrayList;

/**
 * @author sisne
 *
 */
public class TestUtilityClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NMU util = new NMU();//Creates an NMU object called util
		ArrayList<String> list = new ArrayList<>();//List of all outputs
		
		//Demonstrates capabilities of util as instructed
		String name = util.getString("Enter your name: ");
		list.add(name);
		util.delay(1.5);
		int num = util.getInt("Enter a whole number: ");
		list.add(Integer.toString(num));
		util.delay(1.5);
		double decimalNum = util.getDouble("Enter a decimal number: ");
		list.add(Double.toString(util.formatNum(decimalNum, 2)));
		util.delay(1.5);
		util.clearScreen();
		util.delay(1.5);
		util.printNL(name + " typed in " + num + " and " + util.formatNum(decimalNum, 2));
		util.delay(1.5);
		util.printNL("The result is " + (num * util.formatNum(decimalNum, 2)));
		list.add(Double.toString((num * util.formatNum(decimalNum, 2))));
		util.delay(1.5);
		util.printNL("Here's all that information printed in a list");
		util.delay(1.5);
		util.printArrayList(list);
	}

}
