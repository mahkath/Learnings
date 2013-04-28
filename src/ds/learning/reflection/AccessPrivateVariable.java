package ds.learning.reflection;

import java.lang.reflect.Field;

// Ref: http://onjava.com/pub/a/onjava/2003/11/12/reflection.html
public class AccessPrivateVariable {
	public static void main(String args[]) throws Exception {
		
		final Field fields[] = FieldTest.class.getDeclaredFields();
		for (int i = 0; i < fields.length; ++i) {
			if ("privateString".equals(fields[i].getName())) {
				fields[i].setAccessible(true);
				System.out.println(fields[i].get(new FieldTest()));
				break;
			}
		}
		
	}
}
