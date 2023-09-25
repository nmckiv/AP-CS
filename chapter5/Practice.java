/**
 * 
 */
package chapter5;

/**
 * @author mckivergannp22
 *
 */
public class Practice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Loreal = 0;
		int Hbird1 = 0;
		int Hbird2 = 0;
		int drops = 4891;
		int hours = 0;
		int LorealStart = 0;
		int Hbird1Start = 0;
		int Hbird2Start = 0;
		System.out.println(18 % 7);
		for (int day = 1; drops > 0; day++) {
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
			
				
		drops -= (Loreal + Hbird1 + Hbird2);
		System.out.println(Loreal + "\t" + Hbird1 + "\t" + Hbird2 + "\t" + drops);
		Loreal = 0;
		Hbird1 = 0;
		Hbird2 = 0;
		LorealStart = 7 - ((17 - LorealStart) % 7);
		Hbird1Start = 4 - ((17 - Hbird1Start) % 4);
		Hbird2Start = 5 - ((17 - Hbird2Start) % 5);
		
		}
		}
}

