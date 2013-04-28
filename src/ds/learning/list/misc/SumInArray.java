package ds.learning.list.misc;

import java.util.HashMap;
import java.util.Map;


/*
 Probably the best way to do this is to go through the array and hash them 
based on the value. Then you can go through the array again, take the value 
in the n-th position and the desired sum to find the other number that would 
meet the criteria and look for that number in the hash table. If the number 
is found, you have the answer. If not, continue iterating through the array. 
Requires two passes through the array, thus O(n).
*/
public class SumInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
	    int sumvalue = 10;
	    Map map = new HashMap<Integer, Integer>();
	    for (int i=0; i < array.length; i++) {
	    	int key = array[i];
	    	int diff =  sumvalue - array[i];
	    	map.put(key, diff);
	    	if (map.containsKey(diff)) {
	    		System.out.println("Found the pair:"+key +":"+diff);
	    	}
	    }
	}

}
