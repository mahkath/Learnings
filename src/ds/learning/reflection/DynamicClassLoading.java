package ds.learning.reflection;

import com.assignment.util.Node;

public class DynamicClassLoading {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class node = Class.forName("com.assignment.util.Node");
			Object obj = node.newInstance();
			
			if(obj instanceof Node) {
				((Node)obj).setKey("abc");
				System.out.println(((Node)obj).getKey());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
}
