/**
 * 
 */
package chapter8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author mckivergannp22
 *
 */
public class TestProgram2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		//Create matrices to fill with numbers 1-9 and corresponding prizes
		int[][] numBoard = new int[5][5];
		String[][] prizeBoard = new String[5][5];
		
		//Print welcome
		System.out.println("Welcome to the Penny Pitch Game!  Ten throws, if you get land in all three squares you win the prize!");
		System.out.print("Enter 's' to begin: ");
		String str = "";
		
		//Don't continue until the user enters the correct key to start
		while (!str.equalsIgnoreCase("s")) {
			str = input.next();
			if (!str.equalsIgnoreCase("s")) {
				System.out.print("Invalid input: Please enter 's' to begin: ");
			}
		}
		
		//Randomly fill the number board with numbers and use those numbers to fill the string board with prizes
		fillNumBoard(numBoard);
		fillPrizeBoard(numBoard, prizeBoard);
		
		System.out.println();
		
		//Show the initial prize board
		printPrizeBoard(prizeBoard);
		System.out.println("-------------------------------------------------");
		System.out.println();
		
		//Don't throw until the user enters the correct key to throw
		System.out.print("Enter 't' to throw your pennies: ");
		while (!str.equalsIgnoreCase("t")) {
			str = input.next();
			if (!str.equalsIgnoreCase("t")) {
				System.out.print("Invalid input: Please enter 't' to begin: ");
			}
		}
		
		//Throw the pennies
		throwPennies(numBoard, prizeBoard);
		
		//Use arrayLists to keep track of prizes won and prizes to be won with wild card
		ArrayList<String> prizesWon = new ArrayList<String>();
		getPrizesWon(numBoard, prizesWon);
		ArrayList<String> wildCardPrizes = new ArrayList<String>();
		getWildCardPrizes(numBoard, wildCardPrizes);
		System.out.println();
		
		//Conclude the game, tell the user what they won, have them choose a wild card prize if applicable
		finish(prizesWon, wildCardPrizes);
	}
	
	//To be run at the conclusion of the game
	public static void finish(ArrayList<String> prizesWon, ArrayList<String> wildCardPrizes) {
		Scanner input = new Scanner(System.in);
		
		//To be enacted if the user won any prizes
		if (prizesWon.size() > 0) {
			//List the prizes they won
			System.out.println("Congratulations, you won the: ");
			for (int x = 0; x < prizesWon.size(); x++) {
				System.out.println(prizesWon.get(x));
			}
			System.out.println();
		}
		
		//To be enacted if the user got the wild card and two of any prize
		if (wildCardPrizes.size() > 0) {
			//List the prizes they can choose
			System.out.println("You can use the WILD card to choose ONE of the following: ");
			for (int x = 0; x < wildCardPrizes.size(); x++) {
				System.out.println((x + 1) + ". " + wildCardPrizes.get(x));
			}
			System.out.println();
			
			//Have the user choose which prize they want
			System.out.print("Enter the number of your selection: ");
			int selection = input.nextInt();
			
			//Add it to prizesWon
			prizesWon.add(wildCardPrizes.get(selection - 1));
			System.out.println();
			
			//List their final prize winnings
			System.out.println("Congratulations, you won the: ");
			for (int x = 0; x < prizesWon.size(); x++) {
				System.out.println(prizesWon.get(x));
			}
			System.out.println();
		}
		
		//To be enacted only if the user won nothing (both lists are empty)
		if (prizesWon.size() == 0 && wildCardPrizes.size() == 0){
			System.out.println("You didn't win anything.  Sorry :(");
			System.out.println("Better luck next time!");
		}
	}
	
	//Checks which prizes the user got two out of three of and stores them in an arrayList
	public static void getWildCardPrizes(int[][] numBoard, ArrayList<String> prizes) {
		for (int x = 1; x < 9; x++) {
			if (checkWinWithWild(numBoard, x) && wild(numBoard)) {
				prizes.add(prizeNumToString(x));
			}
		}
	}
	
	//Checks if a prize only occurs once on the final board, meaning its other two squares have been hit
	public static boolean checkWinWithWild(int[][] numBoard, int num) {
		int count = 0;
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if (numBoard[x][y] == num) {
					count++;
				}
			}
		}
		if (count == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Checks the final board to see if the wild card has been hit
	public static boolean wild(int[][] numBoard) {
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if (numBoard[x][y] == 9) {
					return false;
				}
			}
		}
		return true;
	}
	
	//checks every prize to see if it has been won, and stores the won prizes in a list
	public static void getPrizesWon(int[][] numBoard, ArrayList<String> prizesWon) {
			for (int x = 1; x < 9; x++) {
				if (checkWin(numBoard, x)) {
					prizesWon.add(prizeNumToString(x));
				}
			}
		
	}
	
	//Checks if a given prize doesn't exist in the list (meaning it has been won)
	public static boolean checkWin(int[][] numBoard, int num) {
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if (numBoard[x][y] == num) {
					return false;//Returns false if the prize exists anywhere in the list
				}
			}
		}
		return true;//If the prize doesn't exist anywhere in the list, it must have been won
	}
	
	//Method to simulate throwing the pennies
	//NOTE!!!  Sometimes the time interval is slower from the user's perspective than it should be, probably because the computer is processing slow
	public static void throwPennies(int[][] numBoard, String[][] prizeBoard) {
		//Uses the start time as a reference for the throwing interval
		long startTime = System.currentTimeMillis();
		long interval = 1000;//Time in milliseconds between throws
		
		//Throws 10 pennies
		for (int x = 0; x < 10; x++) {
			//Infinite loop to be broken after interval milliseconds pass
			for (int y = 1; y > 0;) {
				if ((System.currentTimeMillis() - startTime) % interval == 0) {
					startTime--;//Must be decremented to prevent the loop from running twice in the same millisecond
					//Decrementing startTime is critical to proper performance, and the single-millisecond change in the time interval between throws is not noticeable to the user
					//Randomly throws a penny somwehere on the number board
					numBoard[(int) (Math.random() * 4 + 1)][(int) (Math.random() * 4 + 1)] = 10;//10 is used to indicate a penny
					fillPrizeBoard(numBoard, prizeBoard);//Fills the string board with an O in place of the prize
					System.out.println();
					System.out.print(x + 1 + ". ");//Numbers for each board iteration
					printPrizeBoard(prizeBoard);
					break;//Breaks the infinite loop each time a penny is thrown
				}
			}
		}
	}
	
	//Prints the prize board for the user to see
	public static void printPrizeBoard(String[][] prizeBoard) {
		System.out.println("-------------------------------------------------");
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				System.out.print(prizeBoard[x][y]);
			}
			System.out.println();
			System.out.println();
		}
	}
	
	//Fills the string matrix according to the numbered matrix
	public static void fillPrizeBoard(int[][] numBoard, String[][] prizeBoard) {
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				//Fills each element of prizeBoard with the appropriate string corresponding to prizeNum
				prizeBoard[x][y] = prizeNumToString(numBoard[x][y]);
			}
		}
	}
	
	//Method for using a prize number to return the prize name
	public static String prizeNumToString(int prizeNum) {
		switch(prizeNum) {
		case 1:
			return "Apple     ";
		case 2:
			return "iPhone    ";
		case 3:
			return "Lambo     ";
		case 4:
			return "TV        ";
		case 5:
			return "Candy     ";
		case 6:
			return "Dog       ";
		case 7:
			return "Computer  ";
		case 8:
			return "$$$       ";
		case 9:
			return "WILD      ";
		case 10:
			return "O         ";
		}
		return "";
	}
	
	//Fills the number board with three of each number 1-8 and one 9
	public static void fillNumBoard(int[][] numBoard) {
		numBoard[(int) (Math.random() * 4)][(int) (Math.random() * 4)] = 9;//Place the 9 before 1-8, indicates wild card
		int prizeNum;
		
		//Loops go through each element of numBoard
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				for (int z = 1; z > 0;) {
					//Don't fill if the wild card has been placed here
					if (numBoard[x][y] == 9) {
						break;
					}
					
					//Randomly generates a number, checks whether it fits appropriately, places it if it does and tries again if it doesn't
					prizeNum = (int) (Math.random() * 8 + 1);
					if (checkPrizeFit(numBoard, prizeNum)) {
						numBoard[x][y] = prizeNum;
						break;
					}
				}
			}
		}
	}
	
	//Counts how many of a certain number already exist in the numBoard, determines whether another can fit
	public static boolean checkPrizeFit(int[][] numBoard, int prizeNum) {
		int count = 0;
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 5; y++) {
				if (numBoard[x][y] == prizeNum) {
					count++;
				}
			}
		}
		if (count > 2) {
			//If more then two already exist, another cannot fit
			return false;
		}
		else {
			//If two or less already exist, another one can fit
			return true;
		}
	}
}
