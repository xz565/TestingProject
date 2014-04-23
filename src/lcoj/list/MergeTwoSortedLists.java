package lcoj.list;

import lcoj.common.ListNode;

public class MergeTwoSortedLists {

	// idea is simple
	// hard part is pointer manipulation
	
	// usually, the use of a dummy head/tail is helpful in list (or maybe array) manipulations
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    	if(l1 == null) {
    		return l2;
    	} else if(l2 == null) {
    		return l1;
    	}
    	
    	ListNode head = new ListNode(0);
    	ListNode tail = head;
    	
    	if(l1.val < l2.val) {
    		head.next = tail.next = l1;
    	} else {
    		head.next = tail.next = l2;
    	}
    	    	
    	while(l1 != null && l2 != null) {
    	
    		if(l1.val < l2.val) {
    			tail.next = l1;
    			tail = l1;
    			l1 = l1.next;
    		} else {
    			tail.next = l2;
    			tail = l2;
    			l2 = l2.next;
    		}
    	}
    	
    	if(l1 == null) {
    		tail.next = l2;
    	} else if(l2 == null) {
    		tail.next = l1;
    	}
    	
    	return head.next;
    }
}
