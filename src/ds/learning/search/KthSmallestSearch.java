package ds.learning.search;

public class KthSmallestSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {9,1,5,2,8,6,10,3,7};
		//1,2,3,5,6,7,8,9,10
		KthSmallestSearch search = new KthSmallestSearch();
		int kthLargest = 5;
		int number = search.findKthSmallest(arr, 0, arr.length-1, kthLargest-1);
		System.out.println(kthLargest +"th LargestNumber is : " + number);
	}
	
	public int findKthSmallest(int arr[], int left, int right, int k) {
		
		int pivot = partition(arr, left, right);
		if(pivot == k) {
			for(int i=0; i<=k; i++) {
				System.out.println(arr[i]);
			}
			return arr[k];
		} else if(pivot < k && pivot <= right) {
			return findKthSmallest(arr, pivot+1, right, k);
		} else if(pivot > k && pivot >= left) {
			return findKthSmallest(arr, left, pivot-1, k);
		} else {
			return 0;
		}
	}
	
	private int partition(int arr[], int left, int right) {
		int i=left, j=right;
		int mid = (left+right)/2;
		while(i<j) {
			while(arr[i]<arr[mid]) 
				i++;
			
			while(arr[j]>arr[mid]) 
				j--;
			
			if(i<=j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
				
		}
		
		return i;
	}

}
