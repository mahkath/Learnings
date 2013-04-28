package ds.learning.list.misc;

import java.util.*;

//http://www.brilliantsheep.com/finding-the-intersection-of-two-unsorted-arrays/

//Very good link
//http://alg-code.blogspot.com/2011/02/intersection-of-two-unsorted-arrays.html

public class UnSortedArrayUnionIntersection {
 
    public static Integer[ ] getIntersection( Integer[ ] arrayOne, Integer[ ] arrayTwo ) {
 
    	// Determine which is the smaller array, so we end up less time in
    	// initializing and populating the lookup hash set data structure.
    	//
    	Integer[ ] arrayToHash;
    	Integer[ ] arrayToSearch;
 
    	if( arrayOne.length < arrayTwo.length ) {
    		arrayToHash = arrayOne;
    		arrayToSearch = arrayTwo;
    	} else {
    		arrayToHash = arrayTwo;
    		arrayToSearch = arrayOne;
    	}
 
        // Use a hash set for results.
        //
        HashSet<Integer> intersection = new HashSet<Integer>( );
 
        // Initialize the hash set only for the values of the smaller array.
        // Do note that add( E e ) and contains( Object o ) methods run in 
        // constant time, i.e. O(1).
        //
        HashSet<Integer> hashedArray = new HashSet<Integer>( );
        for( Integer entry : arrayToHash ) {
            hashedArray.add( entry );
        }
 
        // Iterate through the array determined to be searched and add any 
        // entries that intersect to the intersection hash set data structure.
        //
        for( Integer entry : arrayToSearch ) {
            if( hashedArray.contains( entry ) ) {
                intersection.add( entry );
            }
        }
 
        // Do note that the toArray( T[ ] ) call will take linear time O(n),
        // as it fully traverses the linked list. 
        //
        return intersection.toArray( new Integer[ 0 ] );
    }
    /**
     * Test Method
     */
    public static void main( String[ ] args ) {
 
        Integer[ ] a = { 4, 5, 2, 1, 3, 9 };
        Integer[ ] b = { 6, 8, 4, 7, 5 };
 
        Integer[ ] intersection = getIntersection( a, b );
 
        for( Integer entry : intersection ) {
            System.out.print( entry + " " );
        }
    }
}