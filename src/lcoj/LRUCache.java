package lcoj;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */

public class LRUCache {

	int maxCapacity;
	Map<Integer, CacheNode> map;
	CacheNode head;
	CacheNode tail;
	
	public LRUCache(int capacity) {

		this.maxCapacity = capacity;
		map = new HashMap<Integer, CacheNode>();
	}

	public int get(int key) {

		if (map.keySet().contains(key)) {

			CacheNode node = map.get(key);
			node.moveToHead();
			return node.value;
		}

		return -1;
	}

	public void set(int key, int value) {

		if(map.keySet().contains(key)) {
			
			CacheNode node = map.get(key);
			node.value = value;
			node.moveToHead();
			
		} else {
			
			if(map.keySet().size() >= maxCapacity) {
				tail.remove();
			}
			
			CacheNode node = new CacheNode(key, value);
			node.moveToHead();
		}
	}

	private class CacheNode {

		int key;
		int value;
		
		CacheNode prev;
		CacheNode next;
		
		public CacheNode(int key2, int value2) {
			key = key2;
			value = value2;
		}

		public void moveToHead() {
			
		}

		public void remove() {
			
		}

	}

	public static void main(String[] args) {

		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(2, 2);
		System.out.println(cache.get(2));
		cache.set(1, 1);
		cache.set(4, 1);
		System.out.println(cache.get(2));
	}
}