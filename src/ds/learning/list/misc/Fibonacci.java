package ds.learning.list.misc;


//Example - Fibonaci series
// 1 1 2 3 5 8 13 21 34 55
// Formula: n = (n-1) + (n-2)

public class Fibonacci {
	  public static void main(String[] args) {
		  fibMatrixWay(7);
	  }
	  
	  public static void fibIterative() {
		  int n0 = 1, n1 = 1, n2; // Initialize variables
		    System.out.print(n0 + " " + // Print first and second terms
		        n1 + " "); // of the series

		    for (int i = 0; i < 18; i++) { // Loop for the next 18 terms
		      n2 = n1 + n0; // Next term is sum of previous two
		      System.out.print(n2 + " "); // Print it out
		      n0 = n1; // First previous becomes 2nd previous
		      n1 = n2; // And current number becomes previous
		    }
		    System.out.println(); // Terminate the line
	  }
	  
	  public static int fibRecusrsive(int n) {
		    if (n < 2) {
		      return n;
		    } else {
		      return fibRecusrsive(n-1)+fibRecusrsive(n-2);
		    }
	  }
	  
	  public static void fibMatrixWay(int n) {
		  int a[][] = {{1,1},{1,0}};
		  int b[][] = {{1,1},{1,0}};
		  
		  for(int i=1; i<= n-1; i++) {
			  a = matrixMultiply(a,b);
		  }
		  
		  System.out.println(a[1][1]);
	  }
	  
	  public static int[][] matrixMultiply(int a[][], int b[][]) {
		  
		  int a00 = a[0][0]*b[0][0] + a[0][1]*b[1][0];
		  int a01 = a[0][0]*b[0][1] + a[0][1]*b[1][1];
		  int a10 = a[1][0]*b[0][0] + a[1][1]*b[1][0];
		  int a11 = a[1][0]*b[0][1] + a[1][1]*b[1][1];
		  
		  a[0][0] = a00;
		  a[0][1] = a01;
		  a[1][0] = a10;
		  a[1][1] = a11;
		  
		  return a;
				 
	  }
}
