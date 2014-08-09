package lcoj.list.remvoe;

import lcoj.common.ListNode;


/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDuplicatesFromSortedList {
	
    public ListNode deleteDuplicates(ListNode head) {
    	
    	if(head == null)
    		return head;
        
    	ListNode slow = head;
    	ListNode fast = head.next;
    	
    	while(fast != null) {
    		if(fast.val == slow.val) {
    			slow.next = fast.next;
    			fast = fast.next;
    		} else {
    			slow = slow.next;
    			fast = fast.next;
    		}
    	}
    	
    	return head;
    }
    
    public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(1);
		ListNode third = new ListNode(2);
		ListNode forth = new ListNode(3);
		ListNode fifth = new ListNode(3);
		first.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		
		RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
		r.print(first);
		r.deleteDuplicates(first);
		r.print(first);
	}
    
    private void print(ListNode head) {
    	while(head != null) {
    		System.out.print(head.val + "->");
    		head = head.next;
    	}
    	
    	System.out.print("NULL\n");
    }

}
