package lcoj.list;

import lcoj.common.ListNode;

//Given a list, rotate the list to the right by k places, where k is non-negative.
//
//For example:
//Given 1->2->3->4->5->NULL and k = 2,
//return 4->5->1->2->3->NULL.
public class RotateList {

	// TODO
	// Need to see whether there is one pass solution
	
	// Is n always smaller than the length of the list??
    // Two pass solution
	public ListNode rotateRight(ListNode head, int n) {
 
    	if(head == null) return head;
    	
    	// get the len of the list;
    	int len = 1;
    	ListNode last = head;
    	while(last.next != null) {
    		len++;
    		last = last.next;
    	}
    	
    	n = n % len;
    	ListNode tail = head;
    	int count = len - n - 1;
    	while(count > 0) {
    		tail = tail.next;
    		count--;
    	}
    	
    	last.next = head;
    	head = tail.next;
    	tail.next = null;
    	
    	return head;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		System.out.println(head);
		RotateList rotateList = new RotateList();
		System.out.println(rotateList.rotateRight(head, 2));
		
	}
}
