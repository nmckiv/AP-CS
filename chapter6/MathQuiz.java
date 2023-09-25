/**
 * 
 */
package chapter6;

/**
 * @author McKiverganNP22
 *
 */
import java.util.Scanner;//Import scanner
public class MathQuiz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Print a header
		System.out.println("MATH QUIZ!");
	
		int operation = chooseOperations();//Invoke the chooseOperation method
		
		//Define variables
		int tries;
		int results = 0;
		int firstTryCorrect = 0;
		int secondTryCorrect = 0;
		int thirdTryCorrect = 0;
		int wrong = 0;
		
		//Ask the user for the number of questions, repeat the loop the same number of times
		for (int questions = numberOfQuestions(); questions > 0; questions--) {
			

			tries = askQuestion(operation);//Invoke the askQuestion method to ask a question
			
			//Keep track of how many times the user got the answer in one try, two tries, three tries, or got it wrong
			if (tries == 1) {
				firstTryCorrect += 1;
			}
			else if (tries == 2) {
				secondTryCorrect += 1;
			}
			else if (tries == 3) {
				thirdTryCorrect += 1;
			}
			else if (tries == 4) {
				wrong += 1;
			}
			
		}
		
		//Display the final results as a percentage of the number of questions asked
		System.out.println("You got " + (int)((((double)(firstTryCorrect)) / (double)(firstTryCorrect + secondTryCorrect + thirdTryCorrect + wrong)) * 100.0) + "% of the questions correct on the first attempt");
		System.out.println("You got " + (int)((((double)(secondTryCorrect)) / (double)(firstTryCorrect + secondTryCorrect + thirdTryCorrect + wrong)) * 100.0) + "% of the questions correct on the second attempt");
		System.out.println("You got " + (int)((((double)(thirdTryCorrect)) / (double)(firstTryCorrect + secondTryCorrect + thirdTryCorrect + wrong)) * 100.0) + "% of the questions correct on the third attempt");
		System.out.println("You got " + (int)((((double)(wrong)) / (double)(firstTryCorrect + secondTryCorrect + thirdTryCorrect + wrong)) * 100.0) + "% of the questions wrong");

	}
	
	//Have the user choose an operation
	//Return the number of tries it took to get a correct answer
	public static int chooseOperations() {
		System.out.println("Choose which operations to do");
		System.out.println("Addition:       Enter 1");
		System.out.println("Subtraction:    Enter 2");
		System.out.println("Multiplication: Enter 3");
		System.out.println("Division:       Enter 4");
		System.out.println("Mix:            Enter 5");
		System.out.println();
		System.out.print("Choose an operation: ");
		Scanner input = new Scanner(System.in);
		int operation = input.nextInt();
		return operation;
	}
	
	//Have the user choose the number of questions
	public static int numberOfQuestions() {
		System.out.println();
		System.out.print("How many questions? ");
		Scanner input = new Scanner(System.in);
		int numOfQuestions = input.nextInt();
		return numOfQuestions;
	}
	
	//Ask the questions based on the users choices
	public static int askQuestion(int operation) {
		
		
		if (operation == 5) {//If there is a mix of questions, randomize the variable "operation" every time a new question is asked
			operation = 1 + (int) (Math.random() * 4);
		}
		Scanner input = new Scanner(System.in);
		
		//Choose random numbers for each question
		int num1 = 1 + (int) (Math.random() * 20);
		int num2 = 1 + (int) (Math.random() * 20);
		
		//Define variables for the users input, the correct answer, and remaining tries
		int answer;
		int useranswer;
		int triesremaining = 3;
		
		//If addition was selected, run this segment
		if (operation == 1) {
			answer = num1 + num2;//Define answer
			System.out.print(num1 +" + " + num2 + " = ");
			for (;triesremaining > 0; triesremaining--) {//Allow the user to enter another answer only when tries are remaining
				useranswer = input.nextInt();
				if (useranswer == answer) {
					System.out.println("Correct! Good Job!");
					return (4 - triesremaining);
			}
				else {//if an incorrect answer is given, remove one try and prompt the user to try again
					System.out.println(useranswer + " is not the correct answer.  You have " + (triesremaining - 1) + " attempts remaining");
					if (triesremaining > 1) {
						System.out.print(num1 +" + " + num2 + " = ");
					}
					else {//If the user runs out of tries, tell them the correct answer
						System.out.println("The correct answer is " + answer);
					}
				}
			}
		}
		//This else if statement is the same as above, but for subtraction
		else if (operation == 2) {
			answer = num1 - num2;
			System.out.print(num1 + " - " + num2 + " = ");
			for (;triesremaining > 0; triesremaining--) {
				useranswer = input.nextInt();
				if (useranswer == answer) {
					System.out.println("Correct! Good Job!");
					return (4 - triesremaining);
			}
				else {
					System.out.println(useranswer + " is not the correct answer.  You have " + (triesremaining - 1) + " attempts remaining");
					if (triesremaining > 1) {
						System.out.print(num1 +" - " + num2 + " = ");
					}
					else {
						System.out.println("The correct answer is " + answer);
					}
				}
			}
		}
		//This else if statement is the same as above, but for multiplication
		else if (operation == 3) {
			answer = num1 * num2;
			System.out.print(num1 + " X " + num2 + " = ");
			for (;triesremaining > 0; triesremaining--) {
				useranswer = input.nextInt();
				if (useranswer == answer) {
					System.out.println("Correct! Good Job!");
					return (4 - triesremaining);
			}
				else {
					System.out.println(useranswer + " is not the correct answer.  You have " + (triesremaining - 1) + " attempts remaining");
					if (triesremaining > 1) {
						System.out.print(num1 +" X " + num2 + " = ");
					}
					else {
						System.out.println("The correct answer is " + answer);
					}
				}
			}
		}
		//This else if statement is the same as above, but for division
		//Additional manipulation is required to allow the user to enter a decimal number as an answer, hence the casting between double and integer data types
		else if (operation == 4) {
			answer = (int) (((double) num1) / ((double) num2) * 10);
			System.out.print(num1 + " / " + num2 + " = ");
			for (;triesremaining > 0; triesremaining--) {
				useranswer = (int) (10.0 * input.nextDouble());
				if (useranswer == answer) {
					System.out.println("Correct! Good Job!");
					return (4 - triesremaining);
			}
				else {
					System.out.println((((double) useranswer) / 10.0) + " is not the correct answer.  You have " + (triesremaining - 1) + " attempts remaining");
					if (triesremaining > 1) {
						System.out.print(num1 +" / " + num2 + " = ");
					}
					else {
						System.out.println("The correct answer is " + (((double) answer) / 10.0));
					}
				}
			}
		}
		return 4;//If none of the above if-else statements return a value, the user got the problem wrong.  4 should be returned
	}

}
