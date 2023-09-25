/**
 * 
 */
package chapter9;

/**
 * @author sisne
 *
 */
public class Stopwatch {
	//Class variables
	private long startTime;//Start time of stopwatch
	private long stopTime;//End time of stopwatch
	private long[] times = new long[5];//Array filled with recorded times
	
	//Constructor
	public Stopwatch() {
		startTime = System.currentTimeMillis();
	}
	
	//Method to clear the screen by pronting a bunch of spaces
	public static void clearScreen() {
		for (int x = 0; x < 100; x++) {
			System.out.println();
		}
	}
	
	//Method to delay the program for a specified amount of time
	public static void delay(double duration) {
		long startTime = System.currentTimeMillis();
		while (1 > 0) {
			if (System.currentTimeMillis() > startTime + duration * 1000) {
				break;
			}
		}
		
	}
	
	//Methods to start and stop the stopwatch
	public void start() {
		startTime = System.currentTimeMillis();
	}
	public void stop() {
		stopTime = System.currentTimeMillis();
	}
	
	//Method to subtract the start time from the stop time and get the elapsed time
	public long getElapsedTime() {
		return stopTime - startTime;
	}
	
	//Method to store the elapsed time in the times array
	public void storeTime() {
		for (int x = 0; x < 5; x++) {
			if (times[x] == 0) {
				times[x] = getElapsedTime();
				break;
			}
		}
	}
	
	//Method to print the recorded times, along with the sorting method they were recording
	public void displayTimes(String sortMethod1, String sortMethod2, String sortMethod3, String sortMethod4, String sortMethod5) {
		for (int x = 0; x < 5; x++) {
			//Only prints the time if it doesn't equal zero, so it will only print recorded times
			if (times[x] != 0) {
				if (x == 0) {
					System.out.println(sortMethod1 + " time: " + (((double) times[x]) / 1000));
				}
				else if (x == 1) {
					System.out.println(sortMethod2 + " time: " + (((double) times[x]) / 1000));
				}
				else if (x == 2) {
					System.out.println(sortMethod3 + " time: " + (((double) times[x]) / 1000));
				}
				else if (x == 3) {
					System.out.println(sortMethod4 + " time: " + (((double) times[x]) / 1000));
				}
				else if (x == 4) {
					System.out.println(sortMethod5 + " time: " + (((double) times[x]) / 1000));
				}
			}
		}
	}
}
