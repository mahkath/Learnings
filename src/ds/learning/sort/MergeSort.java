package ds.learning.sort;

public class MergeSort {
	
	private static int[] numbers;

	private static int number;

	public static void sort(int[] values) {
		numbers = values;
		number = values.length;
		mergesort(0, number - 1);
	}

	private static void mergesort(int low, int high) {
		// Check if low is smaller then high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = (low + high) / 2;
			// Sort the left side of the array
			mergesort(low, middle);
			// Sort the right side of the array
			mergesort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}

	private static void merge(int low, int middle, int high) {
		
		// Helperarray
		int[] helper = new int[number];
		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}
		helper = null;

	}
	
	public static void main(String args[]) {
		int array[] = {12,9,4,99,120,1,3,10};
		for( int i = 0; i <array.length; i++) {
			 System.out.print(array[i]+"  ");
		 }
		System.out.println();
		sort(array);
		 for( int i = 0; i <array.length; i++) {
			 System.out.print(array[i]+"  ");
		 }
			 
	}
	
}

			