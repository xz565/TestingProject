package lcoj;

import lcoj.common.ListNode;

/*
 * Given a linked list, remove the nth node
 *  from the end of list and return its head. 
 *  
 *  Note:
 *  Given n will always be valid.
 *  Try to do this in one pass.
 */

public class RemoveNthNodeFromEndOfList {

  public ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode root = new ListNode(0);
    root.next = head;
    ListNode faster = root;
    
    // move faster pointer n nodes ahead
    for (int i = 0 ; i < n; i++) {
      faster = faster.next;
    }
    
    // if n equals the length of the list
    if(faster.next == null) {
      return head.next;
    }
    
    ListNode slower = root;
    // if n is greater than the length of the list
    // move both pointer until faster reaches the end
    while(faster.next != null) {
      faster = faster.next;
      slower = slower.next;
    }
    
    // delete Nth node
    slower.next = slower.next.next;
    
    return head;
  }
}
