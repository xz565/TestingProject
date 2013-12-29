package lcoj;

import lcoj.common.ListNode;

public class LinkedListCycleII {
	
    public ListNode detectCycle(ListNode head) {
    	
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	while(fast != null && fast.next != null) {
    		
    		fast = fast.next.next;
    		slow = slow.next;
    		
    		if(fast == slow) {
    			
    			fast = head;
    			
    			while(fast != slow) {
    				fast = fast.next;
    				slow = slow.next;
    			}

    			return fast;
    		}
    	}
    	return null;
    }

    public static void main(String[] args) {
		
    	ListNode node = new ListNode(1);
    	node.next = node;
    	
    	System.out.println(new LinkedListCycleII().detectCycle(node));
	}
}
