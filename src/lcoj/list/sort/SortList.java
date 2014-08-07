package lcoj.list.sort;

import lcoj.common.ListNode;

// Sort a linked list in O(n log n) time using constant space complexity.

public class SortList {

  // It's easy to think using merge sort
  // Not to hard one
  // be careful when implementing the two sub functions
  public ListNode sortList(ListNode head) {

    if (head == null || head.next == null) {
      return head;
    }

    ListNode mid = getMid(head);

    ListNode l1 = sortList(head);
    ListNode l2 = sortList(mid);
    head = merge(l1, l2);

    return head;
  }


  private ListNode merge(ListNode l1, ListNode l2) {

    ListNode head = new ListNode(0);
    ListNode rst = head;

    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        head.next = l1;
        l1 = l1.next;

      } else {
        head.next = l2;
        l2 = l2.next;
      }

      head = head.next;
    }

    if (l1 == null) {
      head.next = l2;
    } else {
      head.next = l1;
    }

    return rst.next;
  }


  private ListNode getMid(ListNode head) {

    ListNode faster = head;
    ListNode prev = head;

    while (head != null && faster != null && faster.next != null) {
      prev = head;
      head = head.next;
      faster = faster.next.next;
    }
    prev.next = null;

    return head;
  }


  public static void main(String[] args) {

    ListNode head = new ListNode(3);
    head.next = new ListNode(1);
    head.next.next = new ListNode(5);

    SortList sortList = new SortList();
    head = sortList.sortList(head);
    ListNode.printListNode(head);
  }
}
