/**
 * 
 */
package chapter4;

/**
 * @author mckivergannp22
 *
 */
//Import scanner
import java.util.Scanner;
public class Test2Program3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Prepare the scanner
		Scanner input = new Scanner(System.in);
		
		//Ask the user to decide what to convert
		System.out.println("Select the measurement you want to convert: Select 1 to convert units of length");
		System.out.println("                                            Select 2 to convert units of mass");
		System.out.println("                                            Select 3 to convert units of temperature");
		System.out.println("                                            Select 4 to convert units of volume");
		
		//Process the users choice with a number
		int type = input.nextInt();
		
		
		//Prompt the user to enter a number for their selected conversion, and show the converted values
		if (type == 1) {
			System.out.print("Enter a length to convert: ");
			double length = input.nextDouble();
			System.out.println(length + " meters is equal to " + ((double)((int)((length * 3.3) * 100)) / 100) + " feet");
			System.out.println(length + " feet is equal to " + ((double)((int)((length / 3.3) * 100)) / 100) + " meters");
		}
		else if (type == 2) {
			System.out.print("Enter a mass to convert: ");
			double mass = input.nextDouble();
			System.out.println(mass + " kilograms is equal to " + ((double)((int)((mass * 2.2) * 100)) / 100) + " pounds");
			System.out.println(mass + " pounds is equal to " + ((double)((int)((mass / 2.2) * 100)) / 100) + " kilograms");
		}
		else if (type == 3) {
			System.out.print("Enter a temperature to convert: ");
			double temp = input.nextDouble();
			System.out.println(temp + " degrees Fahrenheit is equal to " + ((double)((int)(((5.0 / 9.0) * (temp - 32.0)) * 100)) / 100) + " degrees Celsius");
			System.out.println(temp + " degrees Celsius is equal to " + ((double)((int)(((9.0 / 5.0) * temp + 32.0) * 100)) / 100) + " degrees Fahrenheit");
		}
		else if (type == 4) {
			System.out.print("Enter a volume to convert: ");
			double volume = input.nextDouble();
			System.out.println(volume + " gallons is equal to " + ((double)((int)((((volume * 16.0) * 237.0) / 1000.0) * 100)) / 100) + " liters");
			System.out.println(volume + " liters is equal to " + ((double)((int)((((volume * 1000.0) / 237.0) / 16.0) * 100)) / 100) + " gallons");
		}
		//Display an error message if an invalid selection is entered
		else
			System.out.print("Invalid input: Please enter a number between 1 and 4");

	}
	
}
