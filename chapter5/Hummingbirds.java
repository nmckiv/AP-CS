/**
 * 
 */
package chapter5;

/**
 * @author mckivergannp22
 *
 */
public class Hummingbirds {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initialize the variable for how many drops each animal drinks in a day
		int Loreal = 0;
		int Hbird1 = 0;
		int Hbird2 = 0;
		
		//Define how many drops are in the feeder initially
		int drops = 4891;
		
		//Initialize variables for the calculations
		int hours = 0;
		int LorealStart = 0;
		int Hbird1Start = 0;
		int Hbird2Start = 0;
		
		//Print the header
		System.out.println("Day\tLoreal\tHbird1\tHbird2\tDrops Remaining");
		
		//Repeat calculation for each day, continue until remaining drops is less than 0
		for (int day = 1; drops > 0; day++) {
			
			//Calculate how many feeding cycles are completed on the given day, add the number of drops to each animals variables for each completed feeding cycle
			for (hours = 0; hours < 25; hours++) {
				if (((hours - LorealStart) % 7 == 0) && (hours < 18) && (hours != 0)) {
					Loreal += 25;
				}
				if (((hours - Hbird1Start) % 4 == 0) && (hours < 18) && (hours != 0)) {
					Hbird1 += 11;
				}
				if (((hours - Hbird2Start) % 5 == 0) && (hours < 18) && (hours != 0)) {
					Hbird2 += 17;
				}
			}
			
		//Calculate remaining drops		
		drops -= (Loreal + Hbird1 + Hbird2);
		
		//If drops is below 0, reset it to 0 for the output to make sense
		if (drops < 0) {
			drops = 0;
		}
		
		//Print the info for the day
		System.out.println(day + "\t" + Loreal + "\t" + Hbird1 + "\t" + Hbird2 + "\t" + drops);
		
		//If the drops run out that day, print a message reminding someone to refill the feeder
		if (drops == 0) {
			System.out.println();
			System.out.println("The feeder ran out of water on day " + day + ".  It must be refilled on day " + day + ".");
		}
		
		//Reset each animals drop counter at the end of the day
		Loreal = 0;
		Hbird1 = 0;
		Hbird2 = 0;
		
		//Calculate what hour their next feeding cycle will end on tomorrow
		LorealStart = 7 - ((17 - LorealStart) % 7);
		Hbird1Start = 4 - ((17 - Hbird1Start) % 4);
		Hbird2Start = 5 - ((17 - Hbird2Start) % 5);
		
		}

		}
}

