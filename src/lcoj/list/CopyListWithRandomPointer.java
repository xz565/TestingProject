package lcoj.list;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import lcoj.common.RandomListNode;

// A linked list is given such that each node contains
// an additional random pointer which could point to any node in the list or null.
//
// Return a deep copy of the list.
public class CopyListWithRandomPointer {

  // using a map is easy, but takes O(N) space
  // there is another solution without using extra memory
  // 1) Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List, create the copy of 2 and insert it between 2 & 3.. Continue in this fashion, add
  // the copy of N afte the Nth node
  // 2) Now copy the arbitrary link in this fashion
  //
  // original->next->arbitrary = original->arbitrary->next; /*TRAVERSE
  // TWO NODES*/
  // This works because original->next is nothing but copy of original and Original->arbitrary->next is nothing but copy of arbitrary.
  // 3) Now restore the original and copy linked lists in this fashion in a single loop.
  //
  // original->next = original->next->next;
  // copy->next = copy->next->next;
  // 4) Make sure that last element of original->next is NULL.
  //
  // Time Complexity: O(n)
  // Auxiliary Space: O(1)

  // will try this one next time

  // if list is like [1,2,3,4,4]
  // first 4's random points to next 4
  // second 4's random points to itself
  // how to handle this case?
  // oh, use a map <OldNode, NewNode>
  public RandomListNode copyRandomList(RandomListNode head) {

    if (head == null) {
      return null;
    }

    RandomListNode newHead = new RandomListNode(head.label);
    RandomListNode rst = newHead;

    Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    map.put(head, newHead);

    head = head.next;
    while (head != null) {
      RandomListNode newNode = new RandomListNode(head.label);
      newHead.next = newNode;
      newHead = newNode;

      map.put(head, newNode);

      head = head.next;
    }

    for (Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {

      RandomListNode oldNode = entry.getKey();
      RandomListNode newNode = entry.getValue();

      newNode.random = map.get(oldNode.random);
    }

    return rst;
  }
}
