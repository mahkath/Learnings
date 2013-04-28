package ds.learning.list.misc;

public class EquilibriumIndex {

	/**
	 * @param args
	 *http://www.geeksforgeeks.org/equilibrium-index-of-an-array
	 */
	public static void main(String[] args) {
		int arr[] = {-7, 1, 5, 2, -4, 3, 0};
		
		System.out.println("Equilibrium Index=" + equilibrium(arr, arr.length));
	}
	
	public static int equilibrium(int arr[], int n)	{
	   int sum = 0;      // initialize sum of whole array
	   int leftsum = 0; // initialize leftsum
	   int i;
	 
	   /* Find sum of the whole array */
	   for (i = 0; i < n; ++i)
	        sum += arr[i];
	 
	   for( i = 0; i < n; ++i) {
	      sum -= arr[i]; // sum is now right sum for index i
	 
	      if(leftsum == sum)
	        return i;
	 
	      leftsum += arr[i];
	   }
	 
	    /* If no equilibrium index found, then return 0 */
	    return -1;
	}
	 
	

}
