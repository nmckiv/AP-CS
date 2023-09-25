package chapter1;
//Nolan McKivergan
//InputOutputSample
//==========================================

//Line imports the library needed to create a dialogue box
import javax.swing.JOptionPane;
//Line to get input library
import java.util.Scanner;
//Line to import decimal formatting library
import java.text.DecimalFormat;

public class ImputOutputSample
{
		
	public static void main(String[] args)
	{
		// declare two variables
		// A string for words and a double for real numbers
		String name;
		double number;
		
		// declares an object of the Scanner class for input
		Scanner scanobject = new Scanner(System.in);
		// declares an DecomalFormat Object to format numbers
		DecimalFormat df = new DecimalFormat("####.00");
		
		// Input requires one line for the prompt and another to get the input
		// Console input for a single word
		System.out.print("Enter your name:");
		name = scanobject.next();
		
		// Console input for a number
		System.out.print("Enter a number with a decimal:");
		number = scanobject.nextDouble();
		
		
		// Console output
		System.out.println("My name is "+ name +" and a number is "+number);
		System.out.println("Here is that number formatted: "+df.format(number));
		
			// Graphical window input
			name = JOptionPane.showInputDialog(null,"Enter your name here: ",
					"Input Dialogue", JOptionPane.QUESTION_MESSAGE);
			
			// Graphical window output
			JOptionPane.showMessageDialog(null, "Here you are in a dialog box"+name, "Window Title", JOptionPane.INFORMATION_MESSAGE);
	
		/* Multiline comments can be done using the /* and * /
			In any program, read the directions carefully as to whether console or dialog use is requires.  
			NEVER mix console and dialogs.  Use one or the other, never both in the same program!!
		 		
		 */
			
	}
	// end brace for class
}