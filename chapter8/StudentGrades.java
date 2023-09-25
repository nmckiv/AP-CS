/**
 * 
 */
package chapter8;

/**
 * @author mckivergannp22
 *
 */
import java.util.Scanner;
public class StudentGrades {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Create arrays for the names, grades, and averages
		String[] names;
		int[] gradeAverages;
		int[][] studentGrades;
		int[][] sortedStudentGrades;
		int[] sortedGradeAverages;
		names = getNames();//Get the list of names through user input
		//Create arryays to be filled with the sorted information
		String[] sortedNames = new String[names.length];
		int[] sortedIndexes = new int[names.length];
		gradeAverages = new int[names.length];
		sortedGradeAverages = new int[names.length];
		studentGrades = new int[names.length][15];
		sortedStudentGrades = new int[names.length][15];
		studentGrades = getGrades(studentGrades);//Randomly generates 15 grades for each student
		gradeAverages = getAverages(gradeAverages, studentGrades);//Calculates each student's average grade
		//Ask the user how they want to sort the lists
		System.out.print("Enter 1 to sort the students alphabetically, or two to sort by grade average: ");
		int choice = input.nextInt();
		//Uncomment line 38 to print the unsorted data to check against the sorted
//		printResults(names, gradeAverages, studentGrades);
		
		//To be enacted if the user elects to sort alphabetically
		if (choice == 1) {
			sortAlphabetically(names, sortedNames);//Sorts names
			sortedIndexes = getSortedIndexesAlphabetical(names, sortedNames);//Fills an array with the indexes of the unsorted names in the sorted array
			reArrangeGradeAverages(sortedGradeAverages, gradeAverages, sortedIndexes);//Rearranges the grade averages according to the sorted indexes
			reArrangeStudentGrades(sortedStudentGrades, studentGrades, sortedIndexes);//Rearranges the matrix of student grades according to the sorted indexes
			}
		
		//To be enacted if the user elects to sort numerically
		else if (choice == 2) {
			sortNumerically(gradeAverages, sortedGradeAverages);//Sorts averages
			sortedIndexes = getSortedIndexesNumerical(gradeAverages, sortedGradeAverages);//Fills an array with the indexes of the unsorted averages in the sorted array
			reArrangeNames(sortedNames, names, sortedIndexes);//Rearranges the grade averages according to the sorted indexes
			reArrangeStudentGrades(sortedStudentGrades, studentGrades, sortedIndexes);//Rearranges the matrix of student grades according to the sorted indexes
		}
		System.out.println();
		//Print final results
		printResults(sortedNames, sortedGradeAverages, sortedStudentGrades);
		}
	
	//Method to print results
	public static void printResults(String[] sortedNames, int[] sortedAverages, int[][] studentGrades ) {
		System.out.println();
		System.out.println("Name \t------------------------------------------------------Grades------------------------------------------------------   \tAverage");
		System.out.println();
		for (int x = 0; x < studentGrades.length; x++) {
			System.out.print(sortedNames[x] + ":\t");
			for (int y = 0; y < 15; y++) {
				System.out.print(studentGrades[x][y] + "\t");
			}
			System.out.print("  " + sortedAverages[x]);
			System.out.println();
		}
	}
	
	//Method to rearrange the matrix of student grades according to the list of sorted indexes
	public static void reArrangeStudentGrades(int[][] sortedStudentGrades, int[][] studentGrades, int[] sortedIndexes) {
		//Copies the unsorted matrix to the sorted matrix
		for (int a = 0; a < studentGrades.length; a++) {
			for (int b = 0; b < studentGrades[a].length; b++) {
				sortedStudentGrades[a][b] = studentGrades[a][b];
			}
		}
		//Rearranges the matrix
		for (int x = 0; x < studentGrades.length; x++) {
			for (int y = 0; y < studentGrades[x].length; y++) {
				sortedStudentGrades[x][y] = studentGrades[sortedIndexes[x]][y];
			}
		}
	}
	
	//Method to numerically sort the list of averages
	public static void sortNumerically(int[] unsortedGradeAverages, int[] sortedGradeAverages) {
		int num;//Temporary holds the max value
		int replaceIndex;//Index of the value being swapped
		
		//Copies unsorted to sorted
		for (int x = 0; x < unsortedGradeAverages.length; x++) 
			sortedGradeAverages[x] = unsortedGradeAverages[x];
		
		//sorts the list
		for (int x = 0; x < sortedGradeAverages.length; x++) {
			num = 0;
			replaceIndex = 0;
			for (int y = x; y < sortedGradeAverages.length; y++) {
				if (sortedGradeAverages[y] > num) {
					num = sortedGradeAverages[y];
					replaceIndex = y;
				}
			}
			//Moves the highest value found in that iteration of the loop
			sortedGradeAverages[replaceIndex] = sortedGradeAverages[x];
			sortedGradeAverages[x] = num;
		}
	}
	
	//Method to alphabetically sort the lists, works the same way as the numeric method
	public static void sortAlphabetically(String[] unsortedNames, String[] sortedNames) {
		String name;
		int replaceIndex;
		for (int x = 0; x < unsortedNames.length; x++) 
			sortedNames[x] = unsortedNames[x];
		
		for (int x = 0; x < sortedNames.length; x++) {
			name = "zzzzz";//A special value that will always yield the same result when compared to a name, similar to 0 for the numerical sort method
			replaceIndex = 0;
			for (int y = x; y < sortedNames.length; y++) {
				if (sortedNames[y].compareToIgnoreCase(name) < 0) {
					name = sortedNames[y];
					replaceIndex = y;
				}
			}
			sortedNames[replaceIndex] = sortedNames[x];
			sortedNames[x] = name;
		}
		
	}
	
	//This method compares the unsorted names to the sorted names and returns an array containing the locations of the unsorted array in the sorted
	public static int[] getSortedIndexesAlphabetical(String[] unSortedNames, String[] sortedNames) {
		int[] sortedIndexes = new int[sortedNames.length];
		//This method contains a special structure designed to handle multiple inputs of the same name. Once a match is found that value is effectively removed from the unsorted aray and the loop terminated
		
		
		//Goes through every value of sorted array and compares it with every value of unsorted
		for (int x = 0; x < sortedNames.length; x++) {
			for (int y = 0; y < sortedNames.length; y++) {
				if (sortedNames[x].equals(unSortedNames[y])) {
					unSortedNames[y] = "zzzzzzzzzzzzz";//Replaces a found name with a special value that would never be entered
					sortedIndexes[x]  = y;
					break;//Stops the loop when a match is found
				}
			}
		}
		return sortedIndexes;
	}
	
	//Functions similarly to method above, returns indexes of the numerically sorted averages
	public static int[] getSortedIndexesNumerical(int[] unsortedAverages, int[] sortedAverages) {
		int[] sortedIndexes = new int[sortedAverages.length];
		//This method contains a special structure designed to handle multiple inputs of the same number.  Once a match is found that value is effectively removed from the unsorted aray and the loop terminated
		
		//Goes through every value of sorted array and compares it with every value of unsorted
		for (int x = 0; x < sortedAverages.length; x++) {
			for (int y = 0; y < sortedAverages.length; y++) {
				if (sortedAverages[x] == unsortedAverages[y]) {
					unsortedAverages[y] = 0;//Replaces a found name with a special value that would never occur
					sortedIndexes[x] = y;
					break;//Stops the loop when a match is found
				}
			}
		}
		return sortedIndexes;
	}
	
	//This method rearranges the matrix of grades based on the sorted indexes
	public static void reArrangeGradeAverages(int[] sortedGradeAverages, int[] unsortedGradeAverages, int[] sortedIndexes) {
		for (int x = 0; x < unsortedGradeAverages.length; x++) {
			sortedGradeAverages[x] = unsortedGradeAverages[x];
		}
		for (int x = 0; x < sortedIndexes.length; x++) {
			sortedGradeAverages[x] = unsortedGradeAverages[sortedIndexes[x]];
		}
	}
	
	//This method rearranges the array of names based on the sorted indexes
	public static void reArrangeNames(String[] sortedNames, String[] names, int[] sortedIndexes) {
		for (int x = 0; x < names.length; x++) {
			sortedNames[x] = names[x];
		}
		for (int x = 0; x < sortedIndexes.length; x++) {
			sortedNames[x] = names[sortedIndexes[x]];
		}
	}
	
	//Prompts the user to enter a list of names
	public static String[] getNames() {
		Scanner input = new Scanner(System.in);
		System.out.print("How many students? ");
		int num = input.nextInt();
		String[] names = new String[num];
		System.out.print("Enter the names: ");
		for (int x = 0; x < num; x++) {
			if (x == 0) {
				System.out.print((x + 1) + ". ");
			}
			else {
				System.out.print("                 " + (x + 1) + ". ");
			}
			names[x] = input.next();
		}
		return names;
	}
	
	//Randomly generates 15 grades for each student between 50-100 
	public static int[][] getGrades(int[][] studentGrades) {
		for (int x = 0; x < studentGrades.length; x++) {
			for (int y = 0; y < studentGrades[0].length; y++) {
				studentGrades[x][y] = (int) (((Math.random() * 51) + 50));
			}
		}
		return studentGrades;
	}
	
	//Method to calculate each students average and fill an array
	public static int[] getAverages(int[] gradeAverages, int[][] studentGrades) {
		int accumulated;
		int average = 0;
		for (int x = 0; x < studentGrades.length; x++) {
			accumulated = 0;
			for (int y = 0; y < studentGrades[0].length; y++) {
				accumulated += studentGrades[x][y];
			}
			average = accumulated / studentGrades[0].length;
			gradeAverages[x] = average;
		}
		return gradeAverages;
	}
	

}
