/**
 * 
 */
package chapter8;

/**
 * @author mckivergannp22
 *
 */
import java.util.Scanner;
public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[25][25];
		//Fill the entire board with dashes initially
		for (int x = 0; x < 25; x++) {
			for (int y = 0; y < 25; y++) {
				board[x][y] = '-';
			}
		}
		int direction;//Number representing the direction a word will travel
		//Print header
		System.out.println("Let's play a word search!  Enter 10 words below to place on the grid");
		System.out.println();
		System.out.print("Enter words: ");
		//have the user enter a list of words
		String[] words = getWords();
		//Individually place every word on the board
		for (int x = 0; x < words.length; x++) {
			//Randomly establish direction here
			direction = (int) (Math.random() * 6 + 1);
			//Place the word using the fillBoard method
			fillBoard(board, words[x], direction);
		}
		//Uncomment line 40 to print out the key
//		printBoard(board);
		board = fillBoardWithRandomLetters(board);//Fills empty spaces with random letters
		System.out.println("                Your Word Search");
		printBoard(board);//Prints board
		printWords(words);//Prints list of words
	}
	//Method to replace empty spaces with random letters
	public static char[][] fillBoardWithRandomLetters(char[][] board) {
		//Loops go through every space
		for (int x = 0; x < 25; x++) {
			for (int y = 0; y < 25; y++) {
				//If there is no letter already in the space, place a random letter there
				if (board[x][y] == '-') {
					int letter = (int) (Math.random() * 26 + 1);
					switch (letter) {
					case 1:
						board[x][y] = 'A'; break;
					case 2:
						board[x][y] = 'B'; break;
					case 3:
						board[x][y] = 'C'; break;
					case 4:
						board[x][y] = 'D'; break;
					case 5:
						board[x][y] = 'E'; break;
					case 6:
						board[x][y] = 'F'; break;
					case 7:
						board[x][y] = 'G'; break;
					case 8:
						board[x][y] = 'H'; break;
					case 9:
						board[x][y] = 'I'; break;
					case 10:
						board[x][y] = 'J'; break;
					case 11:
						board[x][y] = 'K'; break;
					case 12:
						board[x][y] = 'L'; break;
					case 13:
						board[x][y] = 'M'; break;
					case 14:
						board[x][y] = 'N'; break;
					case 15:
						board[x][y] = 'O'; break;
					case 16:
						board[x][y] = 'P'; break;
					case 17:
						board[x][y] = 'Q'; break;
					case 18:
						board[x][y] = 'R'; break;
					case 19:
						board[x][y] = 'S'; break;
					case 20:
						board[x][y] = 'T'; break;
					case 21:
						board[x][y] = 'U'; break;
					case 22:
						board[x][y] = 'V'; break;
					case 23:
						board[x][y] = 'W'; break;
					case 24:
						board[x][y] = 'X'; break;
					case 25:
						board[x][y] = 'Y'; break;
					case 26:
						board[x][y] = 'Z'; break;
					}
				}
			}
		}
		return board;
	}
	//Method to get a list of words from the user and store it in an array
	public static String[] getWords() {
		String words[] = new String[15];
		Scanner input = new Scanner(System.in);
		for (int a = 0; a < words.length; a++) {
			if (a == 0) {
				System.out.print((a + 1) + ". ");

			}
			else {
				System.out.print("             " + (a + 1) + ". ");

			}
			words[a] = input.next();
			words[a] = words[a].toUpperCase();//Ensures all words are uppercase
		}
		System.out.println();
		return words;
	}
	//Method to print out the list of words
	public static void printWords(String[] words) {
		System.out.println();
		System.out.println("Words to find: ");
		System.out.println();
		for (int x = 0; x < words.length; x++) {
			System.out.println((x + 1) + ". " + words[x]);
		}
	}
	//Method to place a letter on the board
	public static char[][] fillBoard(char board[][], String word, int direction) {
		int[] start = new int[2];//Represents the starting point of the word
		//For int direction:
		//1 = forward
		//2 = backward
		//3 = up
		//4 = down
		//5 = ascending diagonal
		//6 = descending diagonal
		start = getStart(direction, word, board);//Finds a starting point where the word will fit based on its length, direction, and other words on the board

		//The following places the word on the board
		if (direction == 1) {
			for (int x = 0; x < word.length(); x++) {
				board[start[0]][start[1] + x] = word.charAt(x);
			}
		}
		else if (direction == 2) {
			for (int x = 0; x < word.length(); x++) {
				board[start[0]][start[1] - x] = word.charAt(x);
			}
		}
		else if (direction == 3) {
			for (int x = 0; x < word.length(); x++) {
				board[start[0] - x][start[1]] = word.charAt(x);
			}
		}
		else if (direction == 4) {
			for (int x = 0; x < word.length(); x++) {
				board[start[0] + x][start[1]] = word.charAt(x);
			}
		}
		else if (direction == 5) {
			for (int x = 0; x < word.length(); x++) {
				board[start[0] - x][start[1] + x] = word.charAt(x);
			}
		}
		else if (direction == 6) {
			for (int x = 0; x < word.length(); x++) {
				board[start[0] + x][start[1] + x] = word.charAt(x);
			}
		}
		return board;
	}
	
	//Method to find a starting point where the word will fit
	public static int[] getStart(int direction, String word, char[][] board) {
		int row = 0;//Starting row
		int column = 0;//Starting column
		int[] point = new int[2];//Starting point
		
		//The following finds an appropriate starting point depending on direction
		if (direction == 1) {
			
			//Use an infinite loop to continue generating points and checking them until one fits
			for (int x = 1; x > 0;) {
				row = (int) (Math.random() * 25);//Generates a random starting row
				column = (int) (Math.random() * 25);//Generates a random starting column
				
				//Determine whether the word will fit in the board with this point
				if (column + word.length() < 26) {
					point[0] = row;
					point[1] = column;
					
					//Use checkAvailability method to check if the word will hit another word
					if (checkAvailability(board, 1, word, row, column)) {
						return point;//Returns point and breaks the loop only if both above conditions are satisfied
					}
				}
			}
		}
		
		//Use the same process for the other five directions
		else if (direction == 2) {
			for (int x = 1; x > 0;) {
				row = (int) (Math.random() * 25);
				column = (int) (Math.random() * 25);
				if (column - word.length() > -2) {
					point[0] = row;
					point[1] = column;
					if (checkAvailability(board, 2, word, row, column)) {
						return point;
					}
				}
			}
		}
		else if (direction == 3) {
			for (int x = 1; x > 0;) {
				row = (int) (Math.random() * 25);
				column = (int) (Math.random() * 25);
				if (row - word.length() > -2) {
					point[0] = row;
					point[1] = column;
					if (checkAvailability(board, 3, word, row, column)) {
						return point;
					}
				}
			}
		}
		else if (direction == 4) {
			for (int x = 1; x > 0;) {
				row = (int) (Math.random() * 25);
				column = (int) (Math.random() * 25);
				if (row + word.length() < 26) {
					point[0] = row;
					point[1] = column;
					if (checkAvailability(board, 4, word, row, column)) {
						return point;
					}
				}
			}
		}
		else if (direction == 5) {
			for (int x = 1; x > 0;) {
				row = (int) (Math.random() * 25);
				column = (int) (Math.random() * 25);
				if (row - word.length() > -2 && column + word.length() < 26) {
					point[0] = row;
					point[1] = column;
					if (checkAvailability(board, 5, word, row, column)) {
						return point;
					}
				}
			}
		}
		else if (direction == 6) {
			for (int x = 1; x > 0;) {
				row = (int) (Math.random() * 25);
				column = (int) (Math.random() * 25);
				if (row + word.length() < 26 && column + word.length() < 26) {
					point[0] = row;
					point[1] = column;
					if (checkAvailability(board, 6, word, row, column)) {
						return point;

					}
				}
			}
		}
		return point;
	}
	//Method to determine if the word placement will hit another word
	public static boolean checkAvailability(char[][] board, int direction, String word, int startRow, int startColumn) {
		//Checks each direction
		if (direction == 1) {
			//Loop to go through every spot the word will take up
			for (int x = startColumn; x < startColumn + word.length(); x++) {
				//To be enacted if the space is not a dash
				if (board[startRow][x] != '-') {
					return false;
				}
			}
			//If every space is available, return true
			return true;
		}
		//Similar processes are used for each direction
		else if (direction == 2) {
			for (int x = startColumn - word.length() + 1; x < startColumn + 1; x++) {
				if (board[startRow][x] != '-') {
					return false;
				}
			}
			return true;
		}
		else if (direction == 3) {
			for (int x = startRow - word.length() + 1; x < startRow + 1; x++) {
				if (board[x][startColumn] != '-') {
					return false;
				}
			}
			return true;
		}
		else if (direction == 4) {
			for (int x = startRow; x < startRow + word.length() - 1; x++) {
				if (board[x][startColumn] != '-') {
					return false;
				}
			}
			return true;
		}
		else if (direction == 5) {
			for (int x = 0; x < word.length(); x++) {
				if (board[startRow - x][startColumn + x] != '-') {
					return false;
				}
			}
			return true;
		}
		else if (direction == 6) {
			for (int x = 0; x < word.length(); x++) {
				if (board[startRow + x][startColumn + x] != '-') {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	//Method to print the entire board
	public static void printBoard(char board[][]) {
		for (int a = 0; a < 25; a++) {
			for (int b = 0; b < 25; b++) {
				System.out.print(board[a][b] + " ");
			}
			System.out.println();
		}
	}

}
