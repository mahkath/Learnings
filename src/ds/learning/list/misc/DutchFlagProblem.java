package ds.learning.list.misc;

public class DutchFlagProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int arr[] = {5,2,9,3,-2,15,7,4,6};
		DutchFlagProblem prob = new DutchFlagProblem();
		prob.sortDutchFlag(arr,4,6);
		
		for(int i: arr) {
			System.out.print(i+",");
		}
	}

	
	public void sortDutchFlag(int arr[], int p, int k) {
		int i=0;
		int pIndex=0, kIndex=arr.length-1;
		
		while(i<=kIndex) {
			if(arr[i] < p) {
				swap(arr,i,pIndex);
				pIndex++;
				i++;
			} else if(arr[i] > k) {
				swap(arr,i,kIndex);
				kIndex--;
			} else {
				i++;
			}
		}
		if(arr[pIndex] > arr[kIndex])
			swap(arr,pIndex, kIndex);
	}
	
	private void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a]= arr[b];
		arr[b] = temp;
	}
}
