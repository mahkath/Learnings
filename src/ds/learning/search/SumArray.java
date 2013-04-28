package ds.learning.search;

import java.util.HashMap;

public class SumArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer arr[] = {1,10,5,9,6};
		getArraySumPairs(arr,15);
	}
	
	public static void getArraySumPairs(Integer arr[], int sum) {
		HashMap sums = new HashMap();
		int diff = 0;
		for(int i=0; i<arr.length-1;i++) {
			diff = sum - arr[i];
			if(sums.get( diff) != null) {
				System.out.println("Pairs are : " + arr[i] + " " +sums.get(diff));
			} else {
				sums.put(diff,arr[i]);
			}
		}
	}

}
