package lcoj.list.reverse;

import lcoj.common.ListNode;

// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
//
// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
//
// You may not alter the values in the nodes, only nodes itself may be changed.
//
// Only constant memory is allowed.
//
// For example,
// Given this linked list: 1->2->3->4->5
//
// For k = 2, you should return: 2->1->4->3->5
//
// For k = 3, you should return: 3->2->1->4->5

// 通过这道题，我们学会了：
//
// 有效的算法是简洁的！简洁的！！简洁的！！！
public class ReverseNodesInKGroup {


  public static ListNode reverseKGroup(ListNode head, int k) {

    if (head == null || k == 1) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy;
    int i = 0;
    while (head != null) {
      i++;
      if (i % k == 0) {
        prev = reverse(prev, head.next);
        head = prev.next;
      } else {
        head = head.next;
      }
    }

    return dummy.next;
  }


  // Reverse a link list between pre and next exclusively
  private static ListNode reverse(ListNode prev, ListNode next) {

    ListNode last = prev.next;
    ListNode curt = last.next;

    while (curt != next) {
      last.next = curt.next;
      curt.next = prev.next;
      prev.next = curt;
      curt = last.next;
    }

    return last;
  }


  /*
   * This is the most elegant way of reverse a linked list I'd ever seen
   */
  // a simple program to reverse a linked list
  // 第一个肯定是last one。然后我们每遍历到一个node，就把它放到最链表的首位，最后一个么，最后就成为第一个了
  public static ListNode reverse(ListNode head) {

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode curt = head.next;
    ListNode last = head;

    while (curt != null) {
      // logically beautiful
      last.next = curt.next;
      curt.next = dummy.next;
      dummy.next = curt;
      curt = last.next;
    }

    return dummy.next;
  }


  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    ListNode.printListNode(head);

    head = reverseKGroup(head, 2);

    ListNode.printListNode(head);
  }
}
