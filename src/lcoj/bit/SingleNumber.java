package lcoj.bit;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of integers, every element appears twice except for one. 
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */

public class SingleNumber {

    public static int singleNumberWithExtraMemory(int[] A) {

    	Set<Integer> set = new HashSet<Integer>();
    	
    	for (int i = 0; i < A.length; i++) {
    		
			if(!set.contains(A[i])) {
				set.add(A[i]);
			} else {
				set.remove(A[i]);
			}
		}
    	
    	int result = 0;
    	
    	if(set.size() == 1) {
	    	for (Integer integer : set) {
				result = integer;
			}
    	} else {
    		System.out.println("error");
    	}
    	return result;
    }
    
    public static int singleNumber(int[] A) {
        
    	int result = A[0];
    	
    	for(int i = 1; i < A.length; i++) {
    		result = result^A[i];
    	}
    	
    	return result;
    }
    
    public static void main(String[] args) {
		int[] A = {1,2,1};
		System.out.println(singleNumber(A));
	}
}
