package lcoj.array;

import java.util.Arrays;

//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?
//
//For example,
//Given sorted array A = [1,1,1,2,2,3],
//
//Your function should return length = 5, and A is now [1,1,2,2,3].
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] A) {
        
    	if(A.length < 3) return A.length;
    	
    	int count = 1;
    	int prev = A[0];
    	boolean repeate = false;
    	
    	for(int i = 1; i < A.length; i++) {
    		int a = A[i];
    		if(a != prev) {
    			A[count++] = a;
    			repeate = false;
    			prev = a;
    		} else if(a == prev && !repeate) {
    			A[count++] = a;
    			repeate = true;
    		} else {
    			continue;
    		}
    	}
    	return count;
    }
    
    public static void main(String[] args) {
		
    	int[] A = {1,1,1,2,3,3,3,3,3,3,4,4,5};
    	RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();
    	System.out.println(removeDuplicatesFromSortedArrayII.removeDuplicates(A));
    	System.out.println(Arrays.toString(A));
	}
}
