// CoryCaddellAssignment2B.java

import java.util.Scanner;

public class CoryCaddellAssignment2B {
	
	public static void main(String[] args) {
		
		// delete me!!!
		int[] array = {8, 3, 2, 6, 0, 7, 1, 5, 4, 9};
		
		// get array
		// copy array
		// display array to console
		// sort using insertion sort algorithm
//		CoryCaddellInsertionSort(array);
//		CoryCaddellPrintArray(array);
		// sort using bubble sort algorithm
		CoryCaddellBubbleSort(array);
		CoryCaddellPrintArray(array);
		// sort using merge sort algorithm
		// sort using quick sort algorithm
	}
	
	/** Method to print elements of array. */
	public static void CoryCaddellPrintArray(int[] array) {
		
		for (int element : array) {
			System.out.print(element + "\t");
		}
		
	}
	
	/** Method to sort array via insertion sort algorithm. */
	public static void CoryCaddellInsertionSort(int[] array) {
		
		// iterate through array beginning with second element
		for (int i = 1; i < array.length; i++) {
			
			int currentElement = array[i];	// temp variable to store current element, since it could be overwritten
			int k;
			
			// if previous element(s) are greater than current element
			for (k = i - 1; k >= 0 && array[k] > currentElement; k--) {
				
				array[k + 1] = array[k]; // move/copy larger element to index + 1 position in array, overriding the current value in that index
			}
			
			array[k + 1] = currentElement; // insert current/smaller element
		}
	}
	
	/** Method to sort array via bubble sort algorithm.  */
	public static void CoryCaddellBubbleSort(int[] array) {
		
		boolean nextPass = true;
		for (int k = 1; k < array.length && nextPass; k++) {
			
			nextPass = false;
			
			for (int i = 0; i < array.length - k; i++) {
								
				if (array[i] > array[i + 1]) {
					
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					
					nextPass = true;
				}
			}
		}
	}

}
