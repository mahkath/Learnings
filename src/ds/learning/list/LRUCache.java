package ds.learning.list;

import java.util.LinkedHashMap;
import java.util.Map;

//http://codereview.stackexchange.com/questions/3138/linkedhashmap-usage
//http://www.source-code.biz/snippets/java/6.htm
public class LRUCache<K, V> {

	private static final float hashTableLoadFactor = 0.75f;
	private LinkedHashMap<K, V> map;
	private int cacheSize;

	/**
	 * Creates a new LRU cache.
	 * 
	 * @param cacheSize
	 *            the maximum number of entries that will be kept in this cache.
	 */
	public LRUCache(int cacheSize) {
		
		this.cacheSize = cacheSize;
		
		int hashTableCapacity = (int) Math.ceil(cacheSize / hashTableLoadFactor) + 1;
		
		//access order instead of insertion order
		map = new LinkedHashMap<K, V>(hashTableCapacity, hashTableLoadFactor, true) {
			// (an anonymous inner class)
			private static final long serialVersionUID = 1;

			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
				return size() > LRUCache.this.cacheSize;
			}
		};
	}

	/**
	 * Retrieves an entry from the cache.<br>
	 * The retrieved entry becomes the MRU (most recently used) entry.
	 * 
	 * @param key
	 *            the key whose associated value is to be returned.
	 * @return the value associated to this key, or null if no value with this
	 *         key exists in the cache.
	 */
	public synchronized V get(K key) {
		return map.get(key);
	}

	/**
	 * Adds an entry to this cache. The new entry becomes the MRU (most recently
	 * used) entry. If an entry with the specified key already exists in the
	 * cache, it is replaced by the new entry. If the cache is full, the LRU
	 * (least recently used) entry is removed from the cache.
	 * 
	 * @param key
	 *            the key with which the specified value is to be associated.
	 * @param value
	 *            a value to be associated with the specified key.
	 */
	public synchronized void put(K key, V value) {
		map.put(key, value);
	}

	/**
	 * Clears the cache.
	 */
	public synchronized void clear() {
		map.clear();
	}

	/**
	 * Returns the number of used entries in the cache.
	 * 
	 * @return the number of entries currently in the cache.
	 */
	public synchronized int usedEntries() {
		return map.size();
	}

} // end class LRUCache

