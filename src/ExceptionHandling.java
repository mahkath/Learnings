
public class ExceptionHandling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ExceptionHandling e = new ExceptionHandling();
		System.out.println(e.testException());
		
		try {
			testError();
		} catch(Exception ee) {
			System.out.println(" " + ee.getClass().getName());
		}
		
		try {
			testError();
		} finally {
			System.out.println("Finallyy");
		}
	}
	
	public int testException() {
		int i=1;
		try {
			return i;
		} catch (Exception e) {
			return 2;
		} finally {
			i = 2;
			return 4;
		}
	}
	
	public static void testError()  {
		throw new RuntimeException();
	}

}
