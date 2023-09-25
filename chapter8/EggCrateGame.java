/**
 * 
 */
package chapter8;

/**
 * @author mckivergannp22
 *
 */
import java.util.Scanner;//Import scanner
public class EggCrateGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] eggs = new boolean[6][6];//Boolean matrix to represent 6x6 grid of eggs
		//Place initial eggs on board
		eggs[0][0] = true;
		eggs[5][5] = true;
		//Prints instructions
		System.out.println("Lets play a game!");
		System.out.println("Choose a slot to place an egg, or enter 0 to remove an egg");
		System.out.println("No more than two eggs can exist in any row, column, or diagonal");
		System.out.println("Place a dozen eggs to win!");
		System.out.println();
		//Infinite loop to play the game until the board contains 12 eggs
		for (int c = 1; c > 0;) {
			printEggs(eggs);//Prints the board
			eggs = takeTurn(eggs);//Has the user take a turn and alter the board
			//If eggs on board exceeds 11, end the game
			if (countEggs(eggs) > 11) {
				printEggs(eggs);
				System.out.println("Congratulations, you won!");
				break;
			}
		}
		
	}
	//Method to print board
	public static void printEggs(boolean[][] eggs) {
		System.out.println("  1 2 3 4 5 6");//Top row header
		for (int a = 0; a < eggs.length; a++) {
			System.out.print(a + 1 + " ");
			for (int b = 0; b < eggs.length; b++) {
				if (eggs[a][b] == false) {
					System.out.print("- ");
				}
				else {
					System.out.print("O ");
				}
			}
			System.out.println();
		}
	}
	//Method to take a turn
	public static boolean[][] takeTurn(boolean[][] eggs) {
		Scanner input = new Scanner(System.in);//Scanner for getting input
		//Infinite loop to keep going until a valid input is given
		for (int e = 1; e > 0;) {
			System.out.print("Enter a row: ");
			int row = input.nextInt() - 1;
			//If the user enters 0, they want to remove an egg, so enact that method
			if (row == -1) {
				eggs = removeEggs(eggs);
				return eggs;
			}
			System.out.print("Enter a column: ");
			int column = input.nextInt() - 1;
			//If the user enters 0, they want to remove an egg, so enact that method
			if (column == -1) {
				eggs = removeEggs(eggs);
				return eggs;
			}
			System.out.println();
			//To be enacted if the user enters a slot not already occupied by an egg
			if (eggs[row][column] == false) {
				eggs[row][column] = true;
				//Enacts the method to check the validity of the board after the last egg was placed
				if (checkEggs(eggs) == true) {
					return eggs;//Returns the new value of eggs as long as the last move was valid
				}
				else {//To be enacted only if the last move was not valid
					eggs[row][column] = false;//Resets last move
					printEggs(eggs);
				}
			}
			//Prevents user from placing an egg in an occupied slot
			else if (eggs[row][column]) {
				System.out.println("Error: an egg already exists at row " + (row + 1) + " and column " + (column + 1));
				System.out.println();
				printEggs(eggs);
			}
		}
		return eggs;
				
	}
	//Method to remove an egg if the user chooses to do so
	public static boolean[][] removeEggs(boolean[][] eggs) {
		Scanner input = new Scanner(System.in);
		
		//Infinite loop to keep going until the user enters a valid egg to remove
		for (int j = 1; j > 0;) {
			System.out.println();
		System.out.println("Removing egg");
		System.out.print("Enter a row: ");
		int row = input.nextInt() - 1;
		System.out.print("Enter a column: ");
		int column = input.nextInt() - 1;
		//Prevents the user from removing the initial two eggs, loop repeats
		if ((row == 0 && column == 0) || (row == 5 && column == 5)) {
			System.out.println();
			System.out.println("Error: These eggs cannot be removed");
			System.out.println();
			printEggs(eggs);
		}
		//Removes the selected egg if there is an egg to remove, returns eggs
		else if (eggs[row][column] == true) {
			eggs[row][column] = false;
			System.out.println();
			System.out.println("Egg removed successfully!");
			System.out.println();
			return eggs;
		}
		//If the selected slot doesn't contain an egg, display an error message and repeat the loop
		else if (eggs[row][column] == false){
			System.out.println();
			System.out.println("Error: No egg exists at row " + (row + 1) + " and column " + (column + 1));
			System.out.println();
			printEggs(eggs);
		}
		}
		return eggs;
	}
	//Method to check board layout and determine availability, returns true if valid and false if not
	public static boolean checkEggs(boolean[][] eggs) {
		int rowCount = 0;//Total number in each row
		int columnCount = 0;//Total number in each column
		int count = 0;//Total number in a diagonal direction
		//If the board fails any condition false will immediately be returned
		//Checks each row
		for (int d = 0; d < 6; d++) {
			for (int e = 0; e < 6; e++) {
				if (eggs[d][e] == true) {
					rowCount++;
				}
				if (rowCount > 2) {
					System.out.println("Error: more than two eggs cannot exist in row " + (d + 1));
					System.out.println();
					return false;
				}
			}
			rowCount = 0;
		}
		
		//Checks each column
		for (int f = 0; f < 6; f++) {
			for (int g = 0; g < 6; g++) {
				if (eggs[g][f] == true) {
					columnCount++;
				}
				if (columnCount > 2) {
					System.out.println("Error: more than two eggs cannot exist in column " + (f + 1));
					System.out.println();
					return false;
				}
			}
			columnCount = 0;
		}
		
		//Checks diagonals in every direction
		//Checks first-half ascending diagonals
		for (int x = 1; x < 6; x++) {
			int row = x;
			int column = 0;
			for (int y = 0; y < x + 1; y++) {
				if (eggs[row][column] == true) {
					count++;
				}
				if (count > 2) {
					System.out.println("Error: more than two eggs cannot exist in a diagonal");
					System.out.println();
					return false;
				}
				row--;
				column++;
			}
			count = 0;
		}
		count = 0;
		//Checks second-half ascending diagonals
		for (int x = 1; x < 5; x++) {
			int row = 5;
			int column = x;
			for (int y = 0; y < 6 - x; y++) {
				if (eggs[row][column] == true) {
					count++;
				}
				if (count > 2) {
					System.out.println("Error: more than two eggs cannot exist in a diagonal");
					System.out.println();
					return false;
				}
				row--;
				column++;
			}
			count = 0;
		}
		count = 0;
		//Checks first-half descending diagonals
		for (int x = 1; x < 6; x++) {
			int row = 5 - x;
			int column = 0;
			for (int y = 0; y < x + 1; y++) {
				if (eggs[row][column] == true) {
					count++;
				}
				if (count > 2) {
					System.out.println("Error: more than two eggs cannot exist in a diagonal");
					System.out.println();
					return false;
				}
				row++;
				column++;
			}
			count = 0;
		}
		count = 0;
		//Checks second-half descending diagonals
		for (int x = 1; x < 6; x++) {
			int row = 0;
			int column = x;
			for (int y = 0; y < 6 - x; y++) {
				if (eggs[row][column] == true) {
					count++;
				}
				if (count > 2) {
					System.out.println("Error: more than two eggs cannot exist in a diagonal");
					System.out.println();
					return false;
				}
				row++;
				column++;
			}
			count = 0;
		}
		
		//Enacts only if all the above conditions have been passed
		System.out.print("Egg placed successfully!");
		System.out.println();
		System.out.println();
		return true;
	}
	//Method to count total eggs on board
	public static int countEggs(boolean[][] eggs) {
		int count = 0;
		for (int k = 0; k < 6; k++) {
			for (int l = 0; l < 6; l++) {
				if (eggs[k][l] == true) {
					count++;
				}
			}
		}
		return count;
	}

}
