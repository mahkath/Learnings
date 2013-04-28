package ds.learning.list.misc;

import java.util.HashMap;
import java.util.Map;

public class MapMemoryLeak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MapMemoryLeak m = new MapMemoryLeak();
		m.generateMemmoryError();
		
		
	}

	public void generateMemmoryError() {
		Map<Key, String> map = new HashMap<Key, String>();
		
		Key k1 = new Key("mahesh");
		Key k2 = new Key("rajesh");
		Key k3 = new Key("mahesh");
		
		map.put(k1, k1.getName());
		map.put(k2, k2.getName());
		
		//System.out.println(k1.equals(k3));
		
		System.out.println("**********Before***************");
		for(Key key : map.keySet()) {
			System.out.println("Key=" + key.getName() +" value=" + map.get(key));
		}
		
		k1.setName("dathrika");
		
		System.out.println("**********After**Keys*************");
		for(Key key : map.keySet()) {
			System.out.println("Key=" + key.getName() +" value=" + map.get(key));
		}
		
		System.out.println("**********After**Values*************");
		for(String str : map.values()) {
			System.out.println(str);
		}
		
		k3 = new Key("dathrika");
		System.out.println("\nKey=" + k3.getName() + " Value=" + map.get(k3));
	}
	
	private class Key {
		private String name;

		public Key(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public boolean equals(Object obj) {
			Key k = (Key) obj;
			return k.getName().equals(this.getName());
		}
		
		@Override
		public int hashCode() {
			return this.getName().hashCode();
		}
	}
}
