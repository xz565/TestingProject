package lcoj;

import java.util.Deque;
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
	Map<Integer, Integer> map;
	LinkedList<Integer> usageQueue;

	public LRUCache(int capacity) {

		this.maxCapacity = capacity;
		map = new HashMap<Integer, Integer>();
		usageQueue = new LinkedList<Integer>();
	}

	public int get(int key) {

		if (map.keySet().contains(key)) {

			// this step takes O(N) time, causes TLE
			usageQueue.remove(key);
			usageQueue.addFirst(key);

			return map.get(key);
		}

		return -1;
	}

	public void set(int key, int value) {

		if (map.size() >= maxCapacity) {

			int lastKey = usageQueue.getLast();
			map.remove(lastKey);
			usageQueue.removeLast();
		}

		map.put(key, value);
		usageQueue.addFirst(key);
	}

	private class CacheNode {

		int key;
		int value;

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
