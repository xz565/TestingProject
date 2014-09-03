package lcoj.list.reverse;

import lcoj.common.ListNode;

// not official in OJ, but there is ReverseLinkedListII, so added this I as warm up
// also, reverse linked list is important
public class ReverseLinkedList {

  // easy one
  // this method modify the next pointer of current node,
  // change the next pointer of current node to point to previous node
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


  // this method maintains a previous node and a last node, which don't change in each iteration
  // then insert each new node after prev node
  // is more logically beautiful
  public ListNode reverse2(ListNode head) {

    ListNode dummyNode = new ListNode(0);
    dummyNode.next = head;

    ListNode last = head;
    ListNode curt = head.next;
    while (curt != null) {
      last.next = curt.next;
      curt.next = dummyNode.next;
      dummyNode.next = curt;

      curt = last.next;
    }

    return dummyNode.next;
  }


  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    ListNode.printListNode(head);

    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    head = reverseLinkedList.reverse2(head);

    ListNode.printListNode(head);
  }
}
