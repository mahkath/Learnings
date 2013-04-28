import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Constructor implements Cloneable{

	public String str = "abc";
	
	public Constructor() {
		System.out.println("Constructor()" + this.toString());
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		int abc[][] = new int[3][3];
		
		String str = "DMK";
		String str2 = "DMK";
		
		if(str.equals(str2)) {
			System.out.println("equ Eq");
		}
		
		if(str == str2) {
			System.out.println("== Eq");
		}
		B b =new B(1);
		b.get();
		
		
		A a = (A) b;
		a.get();
		
		ArrayList<String> arr = new ArrayList<String>();
		
		Constructor cons = new Constructor();
		Constructor consClone = (Constructor)cons.clone();
		
		System.out.println(consClone.toString());
		cons.str="def";
		
		System.out.println(cons.str);
		System.out.println(consClone.str);
		
		Class cl = Constructor.class;
		System.out.println(cl.getName());
		
		List<String> s = new ArrayList<String>(1);
		s.add("");
		System.out.println(s.size());
		
		s.add("b");
		System.out.println(s.size());
	}

}

class A implements Cloneable{
	void A(){
		
	}
	public A() throws Exception {
		System.out.println("A()");
	}
	public A(int a) {
		System.out.println("A(int)");
	}
	
	public void get() {
		System.out.println("A -- get()");
	}
	
	public static void put() {
		System.out.println("A -- put()");
	}
	
}

class B extends A{
	
	public B(int a) throws Exception {
		System.out.println("B(int)");
	}
	
	public void get() {
		System.out.println("B -- get()");
	}
	
	public static void put() {
		System.out.println("B -- put()");
	}
}
