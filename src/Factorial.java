
public class Factorial {

	public final int i=0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factorial f = new Factorial();
		System.out.println(f.fac(5));
		
		System.out.println(f.loopFac(5));
	}
	
	public int fac(int n) {
		
		if(n == 1)
			return 1;
		
		 return n * fac(n-1);
	}
	
	public int loopFac(int n) {
		int fac = 1;
		for(int i=1; i<=n; i++) {
			fac = fac * i;
		}
		
		return fac;
	}

}


