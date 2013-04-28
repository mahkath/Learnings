
public class OverridingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Object p1 = new Person("aaa");
		Object p2 = new Person("aaa");
		System.out.println(p1.equals(p2));
		
		StringBuilder buff = new StringBuilder();
		String str = new String("abc");
		buff.append("abc");
	
		System.out.println(str == str);
	}

}

class Person {
	public String name;
	
	Person(String n) {
		name = n;
	}
	
	@Override
	public boolean equals(Object other) {
		System.out.println("equals()");
		return true;
	}
}