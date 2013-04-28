package ds.learning.list.misc;

import java.math.BigDecimal;

public class Test {

	private enum Number {
		ONE, TWO
	};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		BigDecimal a = new BigDecimal(2.0);
		BigDecimal a =  BigDecimal.valueOf(2.0);
		BigDecimal b =  BigDecimal.valueOf(1.1);
		System.out.println(a.subtract(b));
		String s = null;
		
		System.out.println(get());
		Number n = Number.ONE;
		System.out.println(n);
		System.out.println(Number.TWO);
		
		Object t = new Test();
		System.out.println(t.getClass().getName());
		
		Test t1 = new Test();
		
		System.out.println(t.getClass() == t1.getClass());
		
		Super su = new Sub();
		su.getName();

	}
	
	public static Integer get() {
		Integer i= new Integer(200);
		
		Thread t = Thread.currentThread();
		for(StackTraceElement stack : t.getStackTrace()) {
			System.out.println(stack.getClassName() + " "+ stack.getMethodName());
		}
		
		try {
			System.out.println("Try");
			//s.charAt(1);
			i= new Integer(201);
			return i;
		}finally {
			System.out.println("finally");
			i= new Integer(202);
			//return i;
		}	
	}

}

class Super {
	public Super() {
		System.out.println("Super() Cons");
	}
	public static void getName() {System.out.println("Super");} 
}

class Sub extends Super {
	
	public Sub() {
		System.out.println("Sub() Cons");
	}
	public static void getName() {System.out.println("Sub");}
}
