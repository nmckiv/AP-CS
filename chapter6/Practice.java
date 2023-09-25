/**
 * 
 */
package chapter6;

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
		int[] myList = makeList();
		myList = sortList(myList);
		for (int i: myList) {
			System.out.println(myList[i]);
		}

	}
	public static int[] makeList() {
		int[] myList = new int[10];
		for (int i = 0; i < myList.length; i++) {
			myList[i] = ((int) (Math.random() * 5)) + 1;
		}
		return myList;
	}
	public static int[] sortList(int[] myList) {
		for (int i = 0; i < myList.length - 1; i++) {
			int min = myList[i];
			int minIndex = i;
			for (int x = i + 1; x < myList.length; x++) {
				if (min > myList[x]) {
					min = myList[x];
					minIndex = x;
				}
				
			}
			if (minIndex != i) {
				myList[minIndex] = myList[i];
				myList[i] = min;
			}
		}
		return myList;
	}
	
	public static double findMean(int[] myList) {
		int sum = 0;
		for (int i = 0; i < myList.length; i++) {
			sum += myList[i];		
		}
		double mean = ((double) sum) / ((double) myList.length);
		return mean;
	}
	
	public static int findMinimum(int[] myList) {
		return myList[0];
	}
	
	public static int findMaximum(int[] myList) {
		return myList[myList.length - 1];
	}
	
	public static double findMedian(int[] myList) {
		int x = myList[4999] + myList[5000];
		double median = ((double) x) / 2.0;
		return median;
	}
	
	public static int findMode(int[] myList) {
		int count = 0;
		int mode = 0;
		for (int i = 0; i < myList.length; i++) {
			count = 0;
		}
		return mode;
	}

}