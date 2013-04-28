package ds.learning.list.misc;

public class SortedArrayUnionAndIntersection {

	/**
	 * Link
	 * http://www.geeksforgeeks.org/archives/6873
	 * 
	 * Time Complexity: O(m+n)
	 */
	public static void main(String[] args) {
		int arr1[] = { 1, 3, 4, 5, 7 };
		int arr2[] = { 2, 3, 5, 6 };
		
		System.out.println("Union");
		printUnion(arr1, arr2, arr1.length, arr2.length);
		
		System.out.println("Intersection");
		printIntersection(arr1, arr2, arr1.length, arr2.length);
		
	}

	/*
	 * Function prints union of arr1[] and arr2[] m is the number of elements in
	 * arr1[] n is the number of elements in arr2[]
	 */
	static void printUnion(int arr1[], int arr2[], int m, int n) {
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (arr1[i] < arr2[j])
				System.out.print(arr1[i++]);
			else if (arr2[j] < arr1[i])
				System.out.print(arr2[j++]);
			else {
				System.out.print(arr2[j++]);
				i++;
			}
		}

		/* Print remaining elements of the larger array */
		while (i < m)
			System.out.print(arr1[i++]);
		while (j < n)
			System.out.print(arr2[j++]);
		
		System.out.println();
	}

	/*
	 * Function prints Intersection of arr1[] and arr2[] m is the number of
	 * elements in arr1[] n is the number of elements in arr2[]
	 */
	static void printIntersection(int arr1[], int arr2[], int m, int n) {
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (arr1[i] < arr2[j])
				i++;
			else if (arr2[j] < arr1[i])
				j++;
			else /* if arr1[i] == arr2[j] */
			{
				System.out.print(arr2[j++]);
				i++;
			}
		}
		System.out.println();
	}

}
