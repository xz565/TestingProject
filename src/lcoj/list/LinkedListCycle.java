package lcoj.list;

import java.util.HashSet;
import java.util.Set;

import lcoj.common.ListNode;

public class LinkedListCycle {
	
	// O(N) space, but still accepted
    public boolean hasCycleBad(ListNode head) {
    	
    	Set<ListNode> set = new HashSet<ListNode>();
    	
    	while(head != null) {
    		if(set.contains(head)) {
    			return true;
    		} else {
    			set.add(head);
    			head = head.next;
    		}
    	}
        
    	return false;
    }
    
    // O(1) space solution
    public class Solution {
    	
        public boolean hasCycle(ListNode head) {

        	ListNode fast = head;
        	ListNode slow = head;
        	
        	while(fast != null && fast.next != null) {
        		fast = fast.next.next;
        		slow = slow.next;
        		if(fast == slow) {
        			return true;
        		}
        	}
        	
        	return false;
        }
        
    }

}
