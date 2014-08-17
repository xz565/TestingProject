package lcoj.list.reverse;

import lcoj.common.ListNode;

// Reverse a linked list from position m to n. Do it in-place and in one-pass.
//
// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//
// return 1->4->3->2->5->NULL.
//
// Note:
// Given m, n satisfy the following condition:
// 1 ≤ m ≤ n ≤ length of list.
public class ReverseLinkedListII {

  public static ListNode reverseBetween(ListNode head, int m, int n) {

    if (head == null || n == 1) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode mNode = dummy; // m-1 th node
    ListNode nNode = dummy.next; // n + 1 th node

    int count = 0;
    while (mNode != null && nNode != null) {
      count++;
      if (count < m) {
        mNode = mNode.next;
        nNode = nNode.next;
      } else if (count >= m && count < n) {
        nNode = nNode.next;
      } else { // count >= n
        break;
      }
    }
    nNode = nNode.next;

    ListNode prev = mNode;
    ListNode last = prev.next;
    ListNode curt = last.next;

    while (curt != nNode) {
      last.next = curt.next;
      curt.next = prev.next;
      prev.next = curt;
      curt = last.next;
    }

    return dummy.next;
  }


  // not neat, need to find a neat solution
  // so ugly !!!!!!!!!!
  public static ListNode reverseBetween_Bad(ListNode head, int m, int n) {

    // first step is to find the m-th and n-th node
    ListNode mNode = null;
    ListNode mPrev = null;
    ListNode nNode = null;
    ListNode nNext = null;

    ListNode curt = head;
    ListNode prev = null;
    int count = 1;
    while (curt != null) {
      if (count == m) {
        mPrev = prev;
        mNode = curt;
      }
      if (count == n) {
        nNode = curt;
        nNext = curt.next;
        break;
      }
      prev = curt;
      curt = curt.next;
      count++;
    }

    // System.out.println(mNode + " " + nNode);

    // reverse between mNode and nNode
    curt = mNode;
    prev = nNext;
    ListNode next = curt.next;
    while (curt != nNode) {
      curt.next = prev;
      prev = curt;
      curt = next;
      next = next.next;
    }
    curt.next = prev;
    if (mPrev != null) { // bug, need null pointer checker
      mPrev.next = curt;
    }
    if (m == 1) {
      return nNode;
    } else {
      return head;
    }
  }


  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    // head.next.next.next = new ListNode(4);
    // head.next.next.next.next = new ListNode(5);

    ListNode rst = reverseBetween(head, 2, 3);
    ListNode.printListNode(rst);
  }
}
