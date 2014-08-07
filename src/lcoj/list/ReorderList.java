package lcoj.list;

import lcoj.common.ListNode;

// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//
// You must do this in-place without altering the nodes' values.
//
// For example,
// Given {1,2,3,4}, reorder it to {1,4,2,3}.
public class ReorderList {

  // split the list into two
  // reverse the second hald
  // merge


  public void reorderList(ListNode head) {

    ListNode mid = getMid(head);

    mid = reverse(mid);
    // ListNode.printListNode(head);
    // ListNode.printListNode(mid);


    head = merge(head, mid);
  }


  private ListNode merge(ListNode l1, ListNode l2) {

    ListNode head = new ListNode(0);
    ListNode rst = head;

    boolean flag = true;
    while (l1 != null && l2 != null) {
      if (flag) {
        head.next = l1;
        l1 = l1.next;
      } else {
        head.next = l2;
        l2 = l2.next;
      }

      flag = !flag;
      head = head.next;
    }

    if (l1 == null) {
      head.next = l2;
    } else {
      head.next = l1;
    }

    return rst.next;
  }


  // this function is populate in list manipulation
  private ListNode getMid(ListNode head) {

    if (head == null || head.next == null) {
      return null;
    }

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


  private ListNode reverse(ListNode head) {

    if (head == null) {
      return null;
    }

    ListNode prev = null;
    ListNode curt = head;
    ListNode next = curt.next;

    while (curt != null && next != null) {
      curt.next = prev;
      prev = curt;
      curt = next;
      next = curt.next;
    }
    curt.next = prev;
    return curt;
  }


  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    ReorderList reorderList = new ReorderList();
    reorderList.reorderList(head);
    ListNode.printListNode(head);
  }
}
