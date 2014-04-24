package lcoj.array;

import java.util.Arrays;

/*
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatesfromSortedArray {

	// cheating one, but have fun
	public int removeDuplicates_cheats(int[] A) {

		if (A.length == 0)
			return 0;

		int[] array = new int[A.length];
		array[0] = A[0];

		int idx = 1;
		int last = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] == last) {
				continue;
			} else {
				last = A[i];
				array[idx] = A[i];
				idx++;
			}
		}

		for(int i = 0; i < A.length; i++) {
			A[i] = array[i];
		}
		return idx++;
	}
	
	// inplace one
    public int removeDuplicates(int[] A) {
    	
    	if(A.length == 0) return 0;
    	
    	int count = 1;
    	int prev = A[0];
    	for(int i = 1; i < A.length; i++) {
    		int curt = A[i];
    		if(curt == prev) {
    			continue;
    		} else {
    			A[count++] = curt;
    			prev = curt;
    		}
    	}
    	return count;
    }
	
	public static void main(String[] args) {
		
		int[] A = {1,1,2,3,3,3,4,4,5};
		
		RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
		System.out.println(r.removeDuplicates(A));
		System.out.println(Arrays.toString(A));

	}
}
