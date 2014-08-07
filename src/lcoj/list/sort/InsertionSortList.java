package lcoj.list.sort;

import lcoj.common.ListNode;

// Sort a linked list using insertion sort.
public class InsertionSortList {

  // Well, this is more like bubble sort
  // And swap the value, not manipulate pointers
  // tooo bad
  public ListNode insertionSortList_(ListNode head) {

    if (head == null) {
      return head;
    }

    ListNode outer = head.next;

    while (outer != null) {

      ListNode inner = head;

      while (inner != outer) {

        if (inner.val > outer.val) {
          // exchange values
          int temp = inner.val;
          inner.val = outer.val;
          outer.val = temp;
        }

        inner = inner.next;
      }

      outer = outer.next;
    }
    return head;
  }


  // This is much better solution
  public ListNode insertionSortList(ListNode head) {

    ListNode helper = new ListNode(0);
    ListNode curt = head;

    while (curt != null) {

      ListNode pre = helper;
      ListNode next = curt.next;

      while (pre.next != null && pre.next.val < curt.val) {
        pre = pre.next;
      }

      // swap
      curt.next = pre.next;
      pre.next = curt;
      curt = next;
    }

    return helper.next;
  }


  public static void main(String[] args) {

    ListNode head = new ListNode(3);
    head.next = new ListNode(5);
    head.next.next = new ListNode(1);

    InsertionSortList insertionSortList = new InsertionSortList();
    head = insertionSortList.insertionSortList(head);
    ListNode.printListNode(head);
  }
}
