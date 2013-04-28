
public class PrimeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printPrime(20);
	}
	
	static void printPrime(int n) {
		int count = 0;
		for(int i=1; i<=n; i++) {
			for(int j=2; j<i; j++) {
				if(i%j == 0)
					count ++;
			}
			
			if(count == 0) {
				System.out.println( i + "is prime");
			}
			count = 0;
		}
	}

}
