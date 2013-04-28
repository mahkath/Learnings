package ds.learning.sort;

//http://www.algolist.net/Algorithms/Sorting/Quicksort
// BestCase: O(nlogn)
// WorstCase: O(n^2)
public class QuickSort {
	int partition(int arr[], int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}

	void quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1)
			quickSort(arr, left, index - 1);
		if (index < right)
			quickSort(arr, index, right);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {1, 12, 5, 26, 7, 14, 3, 8, 2};
		QuickSort sort = new QuickSort();
		sort.quickSort(a, 0, a.length -1);
		for( int i = 0; i <a.length; i++) {
			 System.out.print(a[i]+"  ");
		 }
	}

}
