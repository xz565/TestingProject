package lcoj.list.reverse;

import lcoj.common.ListNode;

// not official in OJ, but there is ReverseLinkedListII, so added this I as warm up
// also, reverse linked list is important
public class ReverseLinkedList {

  // easy one
  public ListNode reverse(ListNode head) {

    if (head == null) {
      return head;
    }

    ListNode prev = null;
    ListNode curt = head;
    ListNode next = head.next;

    while (next != null) {
      curt.next = prev;
      prev = curt;
      curt = next;
      next = next.next;
    }
    curt.next = prev;

    return curt;
  }


  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    ListNode.printListNode(head);

    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    head = reverseLinkedList.reverse(head);

    ListNode.printListNode(head);
  }
}
