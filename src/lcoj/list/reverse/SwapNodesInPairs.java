package lcoj.list.reverse;

import lcoj.common.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * 
 * @author Xiaodong Zhang
 * 
 */
public class SwapNodesInPairs {

  public static ListNode swapPairs(ListNode head) {

    if (head == null) {
      return null;
    }

    ListNode result = head;
    if (head.next != null) {
      result = head.next;
    }

    while (head != null && head.next != null) {
      ListNode third = head.next.next;
      ListNode forth = null;
      if (third != null) {
        forth = third.next;
      }
      head.next.next = head;
      if (forth != null) {
        head.next = forth;
      } else {
        head.next = third;
      }
      head = third;
    }

    return result;
  }


  public static ListNode swapPairs2(ListNode head) {

    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;

    ListNode prev = dummyHead;
    ListNode curt = head;

    while (curt != null && curt.next != null) {
      ListNode next = curt.next;

      prev.next = next;
      curt.next = next.next;
      next.next = curt;

      prev = curt;
      curt = curt.next;
    }

    return dummyHead.next;
  }


  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

    System.out.println(head);

    System.out.println(swapPairs2(head));
  }
}
