/**
 * 
 */
package chapter2;

/**
 * @author mckivergannp22
 *
 */
import java.util.Scanner;
public class Wind {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ask for temperature and windchill
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the 'feels like' temperature in fahrenheit");
		Double windChillIndex = input.nextDouble();
		System.out.print("Enter the Fahrenheit temperature");
		Double fahrenheitTemp = input.nextDouble();
		//Define windspeed in terms of given values
		Double windSpeed = Math.pow((windChillIndex - 35.74 - 0.6215 * fahrenheitTemp) / (0.4275 * fahrenheitTemp - 35.75), (1/0.16));
		//Calculate and print wind speed to two decimal places
		System.out.println("The wind speed is " + (double)((int)(windSpeed * 100)) / 100 + " MPH");

	}

}
