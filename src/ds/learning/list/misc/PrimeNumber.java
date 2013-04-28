package ds.learning.list.misc;

public class PrimeNumber {

	public static void main(String args[]) {
	findPrime(20);
	}
	
	private static void findPrime(int n) {
		int count = 0;
		for (int i=1; i<n; i++) {
			
			for (int j =1; j <= i/2; j++) {
				if ( i % j == 0) {
					count++;
				}
			}
			
			if (count <= 1) {
				System.out.println(i+" is a prime number");
			} 
			
			count = 0;
			
		 }
	}
}
