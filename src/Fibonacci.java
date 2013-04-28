import java.util.Collections;


public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		f.getFib(10);
		System.out.println("");
		System.out.println(f.fib(10));
		
		Collections.sort(null);
	}
	
	public void getFib(int n) {
		int fib1=0, fib2=1, fib3=0;
		System.out.print(fib1 +" " + fib2 + " ");
		for(int i=1; i<=n;i++) {
			fib3 = fib1 + fib2;
			System.out.print(fib3 + " ");
			fib1=fib2;
			fib2=fib3;
		}
	}
	
	public int fib(int n) {
		if( n < 2) {
			//System.out.print(n + " ");
			return n;
		}
		
		int fibN = fib(n-1) + fib(n-2);
		//System.out.print(fibN + " ");
		return fibN;
	}

}
