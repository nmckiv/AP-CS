package chapter7;

public class Lockers {
	public static void main(String[] args) {
	
		//create an array with true corresponding to open and false corresponding to closed
		boolean[] lockers = new boolean[100];
		
		//Use nested loops to simulate the closing and opening action
		for (int s = 1; s <= lockers.length; s++) {//Goes through every number 1-100
			for (int l = 1; l <= lockers.length; l++) {//For each number 1-100, if the first number is evenly divisible by the second i.e. the 
													   //person opens that locker, switch the boolean type.
				if (l % s == 0) {
					if (lockers[l - 1] == true) {
						lockers[l - 1] = false;
					}
					else {
						lockers[l - 1] = true;
					}
				}
			}
		}
		
		//Print out the final results
		for (int i = 0; i < lockers.length; i++) {
			if (lockers[i] == true) {
				System.out.print("Open\t\t");
			}
			else {
				System.out.print("Closed\t\t");
			}
			if ((i + 1) % 10 == 0) {//Moves to a new line every 10th locker
				System.out.println();
			}
		}

	}
}
