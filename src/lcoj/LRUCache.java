package lcoj;

import java.util.HashMap;
import java.util.Map;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1. set(key, value) - Set or insert the value if the key is not
 * already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */

// pitfalls remove from map before delete node
public class LRUCache {

  int maxCapacity;
  Map<Integer, CacheNode> map;
  CacheNode dummyHead;
  CacheNode dummyTail;


  public LRUCache(int capacity) {

    this.maxCapacity = capacity;
    map = new HashMap<Integer, CacheNode>();

    dummyHead = new CacheNode();
    dummyTail = new CacheNode();

    dummyHead.next = dummyTail;
    dummyTail.prev = dummyHead;
  }


  public int get(int key) {

    if (map.keySet().contains(key)) {

      CacheNode node = map.get(key);
      node.moveToHead(dummyHead);

      // printList(dummyHead, dummyTail);
      return node.value;
    }

    // printList(dummyHead, dummyTail);
    return -1;
  }


  public void set(int key, int value) {

    if (map.keySet().contains(key)) {

      CacheNode node = map.get(key);
      node.value = value;
      node.moveToHead(dummyHead);

    } else {

      if (map.keySet().size() >= maxCapacity) {

        map.remove(dummyTail.prev.key);
        dummyTail.removePrev();
      }

      CacheNode node = new CacheNode(key, value);
      node.insertToHead(dummyHead);
      map.put(key, node);
    }

    // printList(dummyHead, dummyTail);
  }


  // private void printList(CacheNode dummyHead2, CacheNode dummyTail2) {
  //
  // while (dummyHead2 != null) {
  // System.out.print(dummyHead2.key + "->");
  // dummyHead2 = dummyHead2.next;
  // }
  // System.out.println();
  //
  // while (dummyTail2 != null) {
  // System.out.print(dummyTail2.key + "->");
  // dummyTail2 = dummyTail2.prev;
  // }
  // System.out.println();
  //
  // System.out.println(map);
  // }

  private class CacheNode {

    int key;
    int value;

    CacheNode prev = null;
    CacheNode next = null;


    public CacheNode() {

    }


    public CacheNode(int key2, int value2) {

      key = key2;
      value = value2;
    }


    // move an existing node to head
    public void moveToHead(CacheNode dummyHead) {

      this.prev.next = this.next;
      this.next.prev = this.prev;

      this.prev = dummyHead;
      this.next = dummyHead.next;

      dummyHead.next.prev = this;
      dummyHead.next = this;
    }


    // insert a new node to head
    public void insertToHead(CacheNode dummyHead) {

      this.prev = dummyHead;
      this.next = dummyHead.next;

      dummyHead.next.prev = this;
      dummyHead.next = this;
    }


    public void removePrev() {

      this.prev.prev.next = this;
      this.prev = this.prev.prev;
    }

  }


  public static void main(String[] args) {

    // testCase1();
    testCase2();
  }


  private static void testCase2() {

    LRUCache cache = new LRUCache(3);
    cache.set(1, 1);
    cache.set(2, 2);
    cache.set(3, 3);
    cache.set(4, 4);

    System.out.println(cache.get(4));
    System.out.println(cache.get(3));
    System.out.println(cache.get(2));
    System.out.println(cache.get(1));

    cache.set(5, 5);

    System.out.println(cache.get(1));
    System.out.println(cache.get(2));
    System.out.println(cache.get(3));
    System.out.println(cache.get(4));
    System.out.println(cache.get(5));
  }


  /**
   * @param cache
   */
  protected static void testCase1() {

    LRUCache cache = new LRUCache(2);
    cache.set(2, 1);
    cache.set(2, 2);
    System.out.println(cache.get(2));
    cache.set(1, 1);
    cache.set(4, 1);
    System.out.println(cache.get(2));
  }
}
