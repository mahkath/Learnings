package ds.learning.list.misc;

import java.util.ArrayList;
import java.util.List;

public class DeleteElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer arr[] = {10,5,2,9,20,1,6,3,-5};
		Integer indexes[] = {1,3,5};
		List<Integer> array = new ArrayList<Integer>();
		List<Integer> indexList = new ArrayList<Integer>();
		
		for(int i : arr) {
			array.add(i);
		}
		
		for(int i : indexes) {
			indexList.add(i);
		}
		
		DeleteElements de = new DeleteElements();
		
		System.out.println("********Before***********");
		for(int a : array) {
			System.out.print(a + ",");
		}
		
		de.removeElements_OtherApproach(array, indexList);
		
		System.out.println("********After***********");
		for(int a : array) {
			System.out.print(a+ ",");
		}
	}
	
	public void removeElements(List<Integer> arr, List<Integer> toRemoveIndexes) {
		int count=0;
		
		for(int i=0; i<arr.size(); i++) {
			if((toRemoveIndexes.contains(i+count))) {
				arr.remove(i);
				count++;
			}
		}
		
		System.out.println(" ###" + count);
	}
	
	
	public void removeElements_OtherApproach(List<Integer> arr, List<Integer> toRemoveIndexes) {
		
		for(int i= arr.size()-1; i >=0; i--) {
			if((toRemoveIndexes.contains(i))) {
				arr.remove(i);
			}
		}
		
	}

}
