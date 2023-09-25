/**
 * 
 */
package chapter5;

import java.text.DecimalFormat;

/**
 * @author mckivergannp22
 *
 */
public class OilLeaked {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Define decimal format
		DecimalFormat df = new DecimalFormat("###.00");
		
		//Initialize numerical variables representing speed, distance, oil leaked, oil remaining, and day number
		int miles;
		int speed;
		double oil = 20000;
		double leaked;
		int day = 1;
		
		//Initialize and define a boolean variable representing whether or not a low oil warning has been issued
		boolean warning = false;
		
		//Print header
		System.out.println("Day\tMiles Driven\tSpeed\tOil Remaining");
		
		while (oil > 0) {
			
			//Randomly generate speed and distance
			miles = (int) (Math.random() * 246) + 5;
			speed = (int) (Math.random() * 71) + 10;
			
			//If miles is greater than 240, but speed is only 10, all day will be spent driving.  If this is the case, leaked will equal 1344
			if (miles > 240 && speed == 10) {
				leaked = 1344.0;
			}
			
			//Otherwise, leaked will be calculated using time spent driving and time spent not driving
			else {
				leaked = ((((double) miles) / ((double) speed)) * 56.0) + ((24.0 - (((double) miles) / ((double) speed))) * 32.0);
			}
			
			//subtract leaked oil
			oil -= leaked;
			
			//Issue a warning if oil is less than 1000
			if (oil < 1000.0 && warning == false) {
				System.out.println("WARNING: LOW OIL!!!");
				warning = true;
			}
			
			//Terminate the loop if oil drops below 1000
			if (oil < 0) {
				System.out.println(day + "\t" + miles + " \t\t" + speed + "\t0");
				System.out.println();
				System.out.println("The oil ran out on day " + day);
				break;
			}
			
			//Print the day, distance, speed, and remaining oil
			else {
			System.out.println(day + "\t" + miles + " \t\t" + speed + "\t" + df.format(oil));
			}
			
			//Increment day and repeat the loop
			day += 1;
			
			
		}

	}

}
