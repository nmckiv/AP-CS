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
public class DistanceBetweenCities {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Define variables
		String city1;
		String city2;
		double latitude1;
		double longitude1;
		double latitude2;
		double longitude2;
		double distance;
		
		//Prepare scanner
		Scanner input = new Scanner(System.in);
		
		//Ask user for the first city
		System.out.print("Enter a city: ");
		city1 = input.nextLine();
		System.out.print("Enter the latitude: ");
		latitude1 = input.nextDouble();
		System.out.print("Enter the longitude: ");
		longitude1 = input.nextDouble();
		
		//Ask the user for the second city
		System.out.print("Enter another city: ");
		city2 = input.nextLine();
		input.nextLine();
		System.out.print("Enter the latitude: ");
		latitude2 = input.nextDouble();
		System.out.print("Enter the longitude: ");
		longitude2 = input.nextDouble();
		
		//Calculate the distance between the cities in kilometers
		distance = 6371 * Math.acos(Math.sin(Math.toRadians(latitude1)) * Math.sin(Math.toRadians(latitude2)) + 
				Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2)) * Math.cos(Math.toRadians(longitude1 - longitude2)));
		System.out.print("The distance between these cities in kilometers is " + ((double)((int)(distance * 100)) / 100) + ", and the distance in miles is " + (double)((int)((distance * 0.621371 * 100) / 100)));
		
		
		
		
		

	}

}
