/**
 * 
 */
package chapter9;

/**
 * @author sisne
 *
 */
public class TestStopwatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stopwatch stopwatch = new Stopwatch();//Create stopwatch object
		
		//Create and fill three arrays of random numbers
		int[] arr1 = new int[100000];
		int[] arr2= new int[100000];
		int[] arr3 = new int[100000];
		fillArr(arr1);
		fillArr(arr2);
		fillArr(arr3);
		
		//Go through sorting procedure and record the times of each sorting method
		System.out.println("Array 1: ");
		stopwatch.delay(1);
		printArr(arr1);
		stopwatch.delay(1);
		System.out.println("Select sorting...");
		stopwatch.start();
		selectSort(arr1);
		stopwatch.stop();
		stopwatch.getElapsedTime();
		stopwatch.storeTime();
		System.out.println("Select sorting complete");
		stopwatch.delay(1);
		System.out.println("Sorted array: ");
		stopwatch.delay(1);
		printArr(arr1);
		stopwatch.delay(1);
		System.out.println("Time taken to sort: " + ((double) stopwatch.getElapsedTime()) / 1000.0 + " seconds");
		stopwatch.delay(1);
		stopwatch.clearScreen();
		
		
		stopwatch.delay(1);
		System.out.println("Array 2: ");
		stopwatch.delay(1);
		printArr(arr2);
		stopwatch.delay(1);
		System.out.println("Insertion sorting...");
		stopwatch.start();
		insertionSort(arr2);
		stopwatch.stop();
		stopwatch.getElapsedTime();
		stopwatch.storeTime();
		System.out.println("Insertion sorting complete");
		stopwatch.delay(1);
		System.out.println("Sorted array: ");
		stopwatch.delay(1);
		printArr(arr2);
		stopwatch.delay(1);
		System.out.println("Time taken to sort: " + ((double) stopwatch.getElapsedTime()) / 1000.0 + " seconds");
		stopwatch.delay(1);
		stopwatch.clearScreen();
		
		
		stopwatch.delay(1);
		System.out.println("Array 3: ");
		stopwatch.delay(1);
		printArr(arr3);
		stopwatch.delay(1);
		System.out.println("Quick sorting...");
		stopwatch.start();
		QuickSort(arr3, 0, arr3.length - 1);
		stopwatch.stop();
		stopwatch.getElapsedTime();
		stopwatch.storeTime();
		System.out.println("Quick sorting complete");
		stopwatch.delay(1);
		System.out.println("Sorted array: ");
		stopwatch.delay(1);
		printArr(arr3);
		stopwatch.delay(1);
		System.out.println("Time taken to sort: " + ((double) stopwatch.getElapsedTime()) / 1000.0 + " seconds");
		stopwatch.delay(1);
		stopwatch.clearScreen();
		stopwatch.displayTimes("Select Sort", "Insertion Sort", "Quick Sort", "", "");
		}
	
	//Method to fill arrays with random integers
	public static void fillArr(int[] arr) {
		for (int x = 0; x < arr.length; x++) {
			arr[x] = (int) (Math.random() * 100) + 1;
		}
	}
	
	//Method to print the first and last ten elements of each array
	public static void printArr(int[] arr) {
		for (int x = 0; x < 10; x++) {
			System.out.println(x + 1 + ".\t" + arr[x]);
		}
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		System.out.println(".");
		for (int x = arr.length - 11; x < arr.length; x++) {
			System.out.println(x + 1 + ".\t" + arr[x]);
		}
	}
	
	//Method for select sorting, copied from google classroom
	public static void selectSort(int arr[])
	{
	int n = arr.length;
	// starting point of unsorted subarray is increased as
	// smallest element is placed in order.
	for (int i = 0; i < n-1; i++)
	{
	// Find the minimum element in unsorted array
	int min_idx = i;
	for (int j = i+1; j < n; j++)
	if (arr[j] < arr[min_idx])
	min_idx = j;

	// Swap the found minimum element with the first
	// element
	int temp = arr[min_idx];
	arr[min_idx] = arr[i];
	arr[i] = temp;
	}
	}
	
	//Method for quick sorting, copied from google classroom
	public static void QuickSort(int[] arr, int left, int right)
	{
	if (right - left <= 0)
	return;
	else
	{
	int pivot = arr[right];
	int partition = partitionIt(arr, left, right, pivot);
	QuickSort(arr, left, partition - 1);
	QuickSort(arr, partition + 1, right);
	}
	}
	public static int partitionIt(int[] arr, int left, int right, long pivot)
	{
	int leftPtr = left - 1;
	int rightPtr = right;
	while (true)
	{
	// finds left partition point
	while (arr[++leftPtr] < pivot);
	// finds right partition point
	while (rightPtr > 0 && arr[--rightPtr] > pivot);
	// if the left partition point is past the right then list is sorted
	if (leftPtr >= rightPtr)
	break;
	else
	// otherwise swap values
	swap(arr, leftPtr, rightPtr);
	}
	swap(arr, leftPtr, right);
	return leftPtr;
	}
	public static void swap(int[] arr, int dex1, int dex2)
	{
	int temp = arr[dex1];
	arr[dex1] = arr[dex2];
	arr[dex2] = temp;
	}
	
	//Method for insertion sorting, copied from google classroom
	public static void insertionSort(int[] nums) {
		int length = nums.length;
		for (int x = 0; x < length; x++) {
			int key = nums[x];
			int y = x - 1;
			while (y >= 0 && nums[y] > key) {
				nums[y + 1] = nums[y];
				y--;
			}
			nums[y + 1] = key;
		}
	}

}
