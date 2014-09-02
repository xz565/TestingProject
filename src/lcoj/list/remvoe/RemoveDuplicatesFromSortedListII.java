package lcoj.list.remvoe;

import lcoj.common.ListNode;

// Given a sorted linked list, delete all nodes that have duplicate numbers,
// leaving only distinct numbers from the original list.
//
// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.
public class RemoveDuplicatesFromSortedListII {

  // it's already sorted, this makes the question much easier
  // ugly ugly code
  // how can I write a so ugly, buggy code !!!!!!!!
  public ListNode deleteDuplicates_UGLY(ListNode head) {

    if (head == null) {
      return null;
    }

    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;

    ListNode prev = dummyHead;
    ListNode curt = head;
    ListNode next = head.next;

    boolean flag = false;
    while (curt != null) {

      // every time use next, need to add a null pointer checker
      // bad bad bad
      if (next != null && curt.val == next.val) {
        prev.next = curt.next;
        curt = next;
        next = next.next;

        flag = true;
      } else {
        if (flag) {
          prev.next = curt.next;
          curt = next;
          if (next != null) {
            next = next.next;
          }
        } else {
          prev = prev.next;
          curt = curt.next;
          if (next != null) {
            next = next.next;
          }
        }
        flag = false;
      }


    }
    return dummyHead.next;
  }


  // A more beautiful one
  public ListNode deleteDuplicates(ListNode head) {

    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;

    ListNode prev = dummyHead;
    ListNode curt = head;

    while (curt != null) {

      ListNode next = curt.next;
      while (next != null && curt.val == next.val) {
        next = next.next;
      }

      if (next == curt.next) {
        prev = curt;
        curt = next;
      } else {
        prev.next = next;
        curt = next;
      }

    }

    return dummyHead.next;
  }


  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next.next = new ListNode(5);

    ListNode.printListNode(head);

    RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedListII();
    ListNode.printListNode(removeDuplicatesFromSortedList.deleteDuplicates(head));


    head = new ListNode(1);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(2);
    // head.next.next.next.next = new ListNode(4);

    ListNode.printListNode(head);
    ListNode.printListNode(removeDuplicatesFromSortedList.deleteDuplicates(head));

  }
}
