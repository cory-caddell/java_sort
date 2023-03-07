// CoryCaddellAssignment2B.java

import java.util.Scanner;

public class CoryCaddellAssignment2B {
	
	/** Program demonstrates various sorting algorithms. */
	public static void main(String[] args) {
		
		// get array
		int[] CoryCaddellArray = CoryCaddellGetArray();
		
		// display "INSERTION POINT" to console
		System.out.println("INSERTION SORT");
		
		// copy array and display to console
		int[] CoryCaddellArrayI = CoryCaddellCopyArray(CoryCaddellArray);
		CoryCaddellPrintArray(CoryCaddellArrayI);
		
		// sort array using insertion algorithm and display to console
		CoryCaddellInsertionSort(CoryCaddellArrayI);
		System.out.println();
		CoryCaddellPrintArray(CoryCaddellArrayI);
		
		// display "BUBBLE SORT" to console
		System.out.println("\nBUBBLE SORT");
		
		// copy array and display to console
		int[] CoryCaddellArrayB = CoryCaddellCopyArray(CoryCaddellArray);
		CoryCaddellPrintArray(CoryCaddellArrayB);
		
		// sort array using bubble sort algorithm and display to console
		CoryCaddellBubbleSort(CoryCaddellArrayB);
		System.out.println();
		CoryCaddellPrintArray(CoryCaddellArrayB);
		
		//display "MERGE SORT" to console
		System.out.println("\nMERGE SORT");
		
		// copy array and display to console
		int[] CoryCaddellArrayM = CoryCaddellCopyArray(CoryCaddellArray);
		CoryCaddellPrintArray(CoryCaddellArrayM);
		
		// sort array using merge sort algorithm and display to console
		CoryCaddellMergeSort(CoryCaddellArrayM);
		System.out.println();
		CoryCaddellPrintArray(CoryCaddellArrayM);
		
		// display "QUICK SORT" to console
		System.out.println("\nMERGE SORT");
		
		// copy and array and display to console
		int[] CoryCaddellArrayQ = CoryCaddellCopyArray(CoryCaddellArray);
		CoryCaddellPrintArray(CoryCaddellArrayQ);
		
		// sort array using quick sort algorithm and display to console
		CoryCaddellQuickSort(CoryCaddellArrayQ);
		System.out.println();
		CoryCaddellPrintArray(CoryCaddellArrayQ);
	}
	
	/** Method to get 10 integral numbers from user. */
	public static int[] CoryCaddellGetArray() {
		
		int SIZE = 10;
		int[] arrayA = new int[SIZE];
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter " + SIZE +  " integral numbers: ");
		for (int i = 0; i < SIZE; i++) {
			arrayA[i] = keyboard.nextInt();
		}
		keyboard.close();
		
		return arrayA;
	}
	
	/** Method to make a copy of an integer array. */
	public static int[] CoryCaddellCopyArray(int[] arrayA) {
		
		int[] arrayB = new int[arrayA.length];
		
		for (int i = 0; i < arrayA.length; i++) {
			arrayB[i] = arrayA[i];
		}
		
		return arrayB;
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
		
		boolean nextPass = true;  		// control variable - only need to cycle through array multiple times if not sorted
		
		// control loop - reduce amount of comparisons after each iteration, since largest element in array is moved to end of array
		for (int k = 1; k < array.length && nextPass; k++) {
			
			nextPass = false;
			
			// cycle through array comparing adjacent elements
			for (int i = 0; i < array.length - k; i++) {
								
				// if current element is greater than next element
				if (array[i] > array[i + 1]) {
					
					// swap the element values
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					
					nextPass = true;
				}
			}
		}
	}

	/** Method to sort array via merge sort algorithm. */
	public static void CoryCaddellMergeSort(int[] array) {
				
		if(array.length > 1) {
			
			int[] firstHalf = new int[array.length / 2];
			System.arraycopy(array, 0, firstHalf, 0, array.length / 2);
			CoryCaddellMergeSort(firstHalf);
			
			int[] secondHalf = new int[array.length - firstHalf.length];
			System.arraycopy(array, firstHalf.length, secondHalf, 0, secondHalf.length);
			CoryCaddellMergeSort(secondHalf);
			
			// Merge the two sorted lists
			int firstHalfIndex = 0;		// current index of first half array
			int secondHalfIndex = 0;	// current index of second half array
			int originalArrayIndex = 0;	// current index of original array
			
			while(firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length) {
				
				if (firstHalf[firstHalfIndex] < secondHalf[secondHalfIndex]) {
					array[originalArrayIndex++] = firstHalf[firstHalfIndex++];
				}
				else {
					array[originalArrayIndex++] = secondHalf[secondHalfIndex++];
				}
			}
			
			while (firstHalfIndex < firstHalf.length) {
				array[originalArrayIndex++] = firstHalf[firstHalfIndex++];					
			}
			
			while (secondHalfIndex < secondHalf.length) {
				array[originalArrayIndex++] = secondHalf[secondHalfIndex++];					
			}
		}
	}
	
	/** Method to sort array via quick sort algorithm. */
	public static void CoryCaddellQuickSort(int[] array) {
		
		// call helper method with additional parameters
		CoryCaddellQuickSort(array, 0, array.length - 1);
	}
	
	/** Helper method for quick sort algorithm. */
	public static void CoryCaddellQuickSort(int[] array, int first, int last) {
		
		if (last > first) {
			int pivotIndex = partition(array, first, last);
			CoryCaddellQuickSort(array, first, pivotIndex - 1);
			CoryCaddellQuickSort(array, pivotIndex + 1, last);
		}
	}
	
	/** Method to partition array for quick sort algorithm. */
	public static int partition(int[] array, int first, int last) {
		
		int pivot = array[first];  	// pivot element - ideally this splits the array up evenly
		int low = first + 1;		// beg index for forward search		
		int high = last;			// beg index for backward search
		
		while (high > low) {
			
			// forward search - find index of element that is greater than or equal to pivot element
			while (low <= high && array[low] <= pivot) {
				low++;
			}
			
			// backward search - find index of element that is less than pivot element
			while (low <= high && array[high] > pivot) {
				high--;
			}
			
			// swap low and high elements
			if (high > low) {
				int temp = array[high];
				array[high] = array[low];
				array[low] = temp;
			}
		}
		
		// backward search - find next element that is less than pivot
		while (high > first  && array[high] >= pivot) {
			high--;
		}
				
		// swap pivot with above element
		if (pivot > array[high]) {
			array[first] = array[high];
			array[high] = pivot;
			return high;				// next pivot index - splits array in two
		}
		else {
			return first;				// array is sorted
		}
	}
}
