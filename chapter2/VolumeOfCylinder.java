/**
 * 
 */
package chapter2;

/**
 * @author mckivergannp22
 *
 */
//Import the scanner
import java.util.Scanner;

public class VolumeOfCylinder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Prepare the scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the radius of the cylinder: ");
		//Define input as the radius
		double radius = input.nextDouble();
		System.out.print("Enter the length of the cylinder: ");
		//Define input as the length
		double length = input.nextDouble();
		
		//Define Pi
		final double PI = 3.14159;
		
		//Calculate area
		double area = radius * radius * PI;
		
		//Calculate volume
		double volume = area * length;
		//Print volume with two decimal places
		System.out.println("The volume of the cylinder is " + (double)((int)(volume * 100)) / 100);
		
	}

}
