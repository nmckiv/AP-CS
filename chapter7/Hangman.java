/**
 * 
 */
package chapter7;

/**
 * @author mckivergannp22
 *
 */
import java.util.Scanner;
public class Hangman {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = chooseWord(getWords());//Chooses a random word from the word bank
		boolean result = (playHangman(word));//Invokes the method to play hangman with the selected word
		System.out.println();
		
		//Prints a congratulatory or disparaging message depending on the outcome
		if (result == true) {
			System.out.println("Congratulations, you won!");
		}
		else if (result == false) {
			System.out.println();
			System.out.println("The word was: " + word);
			System.out.println("Sorry, you lost :(");
		}

	}
	
	//Method to define a word bank as an array
	public static String[] getWords() {
		String[] words = {"corgi", "awkward", "bagpipes", "espionage", "fluffiness", "knapsack", "larynx", "microwave", "numbskull", "peekaboo", "pneumonia", "quartz", "voyage", "transgress", "wristwatch", "xylophone", "zigzagging", "zombie", "zodiac"};
		return words;
	}
	
	//Method to randomly choose an element from the word bank array
	public static String chooseWord(String[] words) {
		int i = ((int) (Math.random() * words.length));
		return words[i];
	}
	
	//Method where hangman is played, returns true for a win and false for a loss
	public static boolean playHangman(String word) {
		Scanner input = new Scanner(System.in);
		String guess = "";//String to define which letters the user has accurately guessed and where they are int he word
		String letter = "";//To be replaced by the selected letter
		for (int i = 0; i < word.length(); i++) {
			guess += "-";//Turns the string guess into a series of dashes representing an unknown word
		}
		boolean result = false;//Default value is set to false
		
		//Define arrays for the available letters and used letters
		String[] availableLetters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		String[] usedLetters = {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", };
			
			System.out.println();
			
			//Use an infinite loop to repeat the game until the player wins or loses
			for (int f = 0; f > -1; f++) {
				
				//Print the header
				System.out.println("********************************************************************");
				System.out.println("                Hangman");
				System.out.println();
				System.out.println("Word to guess: " + guess);
				System.out.println();
				drawHangman(f);//Uses the draw hangman method to draw the hangman depending on the value of f
				
				//To be enacted if f == 6, indicating a loss
				if (f == 6) {
					return false;//method returns false, signaling a loss
				}
				//Prints out available and used letters
				System.out.print("available leters: ");
				for (int x = 0; x < 26; x++) {
					System.out.print(availableLetters[x] + " ");
				}
				System.out.println();
				System.out.print("used letters:     ");
				for (int y = 0; y < 26; y++) {
					System.out.print(usedLetters[y] + " ");
				}
				System.out.println();
				System.out.println("Or press 1 to give up");//Indicates escape value
				System.out.println();
			
				//Obtains user input for the guessed letter, uses an infinite loop to display an error message if anything other than an available letter is entered
				for (int a = 1; a > 0;) {
				System.out.print("Enter your guess: ");
				letter = input.nextLine();
				letter = letter.toLowerCase();//Ensures the value of letter is lowercase to avoid confusion
				
				//To be enacted if the letter is available, will then proceed with the rest of the program
				if (checkAvailability(availableLetters, letter) == true) {
					break;
				}
				
				//To be enacted if the user elects to quit, returns false as if it were a loss
				else if (letter.equals("1")) {
					return false;
				}
				
				//Prints an error message if a letter is already used, multiple characters are entered, or a non-letter is entered.
				//Does not exit the loop so user will have to enter guesses until a legal guess is entered
				else {
					System.out.println("invalid input, please enter one available letter");
				}
				}
			
				//To be enacted if the selected letter is in the word, uses the search word method to do so
				if (searchWord(word, letter) == true) {
				f--;//Keeps the value of f constant, preventing another part of the hangman being drawn
				
				//Goes through the word and replaces the dashes int eh guess with the chosen letter if the chosen letter is present in the word
				for (int g = 0; g < word.length(); g++) {
					if ((word.substring(g, g + 1)).equals(letter)) {
						guess = guess.substring(0, g) + letter + guess.substring(g + 1);
					}
				}
			}
			
			//Replaces the used letters with dashes in availableLetters and replaces the dashed with the used letters in usedLetters
			for (int c = 0; c < 26; c++) {
				if (availableLetters[c].equals(letter)) {
					availableLetters[c] = "-";
					usedLetters[c] = letter;
				}
			}
			//To be enacted if guess no longer contains any dashes, meaning the word has been correctly guessed and the user wins
			if (guess.contains("-") == false) {
				System.out.println("********************************************************************");
				System.out.println("                Hangman");
				System.out.println();
				System.out.println("Word to guess: " + guess);
				System.out.println();
				drawHangman(f + 1);//Brings f back to it's original value during the prior turn, ensuring the right stage of the hangman is drawn in the final screen
				System.out.print("available leters: ");
				for (int x = 0; x < 26; x++) {
					System.out.print(availableLetters[x] + " ");
				}
				System.out.println();
				System.out.print("used letters:     ");
				for (int y = 0; y < 26; y++) {
					System.out.print(usedLetters[y] + " ");
				}
				System.out.println();
				return true;//Returns true to the main method, indicating victory for the user
			}
			
			System.out.println();
			}
			
		return result;
	}
	
	//Method to search the selected word for the selected letter and return true if it is found
	public static boolean searchWord(String word, String letter) {
		
		if (word.contains(letter)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Method to search the available letters for the selected letter and return true if it is found
	public static boolean checkAvailability(String[] availableLetters, String letter) {
		for (int b = 0; b < 26; b++) {
			if (availableLetters[b].equals(letter)) {
				return true;
			}
		}
		return false;
	}
	
	//Method to draw the hangman depending on the value of f in the playHangman method
	public static void drawHangman(int guess) {
		
		if (guess == 0) {
			System.out.println("-------");
			System.out.println("|     |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|___________");
		}
		else if (guess == 1) {
			System.out.println("-------");
			System.out.println("|     |");
			System.out.println("|     O");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|___________");
		}
		else if (guess == 2) {
			System.out.println("-------");
			System.out.println("|     |");
			System.out.println("|     O");
			System.out.println("|     |");
			System.out.println("|     |");
			System.out.println("|");
			System.out.println("|___________");
		}
		else if (guess == 3) {
			System.out.println("-------");
			System.out.println("|     |");
			System.out.println("|     O");
			System.out.println("|    /|");
			System.out.println("|     |");
			System.out.println("|");
			System.out.println("|___________");
		}
		else if (guess == 4) {
			System.out.println("-------");
			System.out.println("|     |");
			System.out.println("|     O");
			System.out.println("|    /|\\");
			System.out.println("|     |");
			System.out.println("|");
			System.out.println("|___________");
		}
		else if (guess == 5) {
			System.out.println("-------");
			System.out.println("|     |");
			System.out.println("|     O");
			System.out.println("|    /|\\");
			System.out.println("|     |");
			System.out.println("|    /");
			System.out.println("|___________");
		}
		else if (guess == 6) {
			System.out.println("-------");
			System.out.println("|     |");
			System.out.println("|     O");
			System.out.println("|    /|\\");
			System.out.println("|     |");
			System.out.println("|    / \\");
			System.out.println("|___________");
		}
	}
	
	}

