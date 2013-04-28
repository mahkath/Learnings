package ds.learning.list.misc;


public class DistinctElementsInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int arraya[] = {1, 2, 3, 4, 4, 1, 1, 2, 5};
		
		int[] array = sort(arraya);
		
		int tmp = -1;
		for (int i= 0; i< array.length -1; i++) {
			if (tmp != array[i]) {
				System.out.println(array[i]);	
			}
			tmp = array[i];			
		}
	}
	
	static int[] sort(int[] array) {
		
		for (int pass=0; pass < array.length - 2; pass++) {
			for(int i=0; i < array.length - pass -2; i++) {
				if(array[i] > array[i+1]) {
					int tmp = array[i+1];
					array[i+1] = array[i];
					array[i] = tmp;
				}
			}
		}
		return array;
	}

}
