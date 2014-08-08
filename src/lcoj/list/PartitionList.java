package lcoj.list;

import lcoj.common.ListNode;


// Given a linked list and a value x, partition it such that
// all nodes less than x come before nodes greater than or equal to x.
//
// You should preserve the original relative order of the nodes in each of the two partitions.
//
// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.

// read the question carefully......
public class PartitionList {

  // from left, find the first node greater than OR EQUAL TO x
  // go right, put nodes smaller than x to the left of x
  //
  // another solution is put element small or equal to list 1
  // others to l2 and then merge two lists
  public ListNode partition(ListNode head, int x) {

    if (head == null) {
      return null;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode curt = head;
    ListNode nodePrev = dummy;
    while (curt != null && curt.val < x) {
      nodePrev = curt;
      curt = curt.next;
    }

    ListNode node = curt;
    ListNode curtPrev = curt;
    // curt = curt.next;

    while (curt != null) {
      if (curt.val < x) {
        curtPrev.next = curt.next;
        curt.next = node;
        nodePrev.next = curt;
        nodePrev = curt; // missing for the first time

        curt = curtPrev.next;
      } else {
        curtPrev = curt;
        curt = curt.next;
      }
    }

    return dummy.next;
  }


  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(4);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(2);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(2);
    ListNode.printListNode(head);

    PartitionList partitionList = new PartitionList();
    head = partitionList.partition(head, 3);
    ListNode.printListNode(head);
  }
}
