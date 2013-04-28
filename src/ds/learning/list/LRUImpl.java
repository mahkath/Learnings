package ds.learning.list;

import java.util.HashMap;

public class LRUImpl {

	private HashMap<String, String> cache = new HashMap<String, String>();
	private java.util.LinkedList<String> LRUOrder = new java.util.LinkedList<String>();
	private int size = 10;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LRUImpl lru = new LRUImpl();
		lru.put("1", "A");
		lru.put("2", "B");
		lru.put("3", "C");
		lru.put("4", "D");
		lru.put("5", "E");
		lru.put("6", "F");
		lru.put("7", "G");
		
		lru.get("1");
		 
		lru.put("8", "H");
		lru.put("9", "I");
		lru.put("10", "J");
		lru.put("11", "K");
		
		//System.out.println("get() " + lru.get("1"));
		
		lru.printValues();
		
	}
	
	LRUImpl() {
	}
	
	LRUImpl(int size) {
		this.size = size;
	}

	public void put(String key, String value) {
		if(!cache.containsKey(key)) {
			
			if(LRUOrder.size() == size) {
				LRUOrder.removeLast();
			}
			cache.put(key, value);
			LRUOrder.addFirst(key);
		}
	}
	
	public String get(String key) {
		if(cache.containsKey(key)) {
			LRUOrder.remove(key);
			LRUOrder.addFirst(key);
			return cache.get(key);
		} else {
			return null;
		}
	}
	
	public void printValues() {
		for(String key : LRUOrder) {
			System.out.println(key + " : " + cache.get(key));
		}
	}

}
