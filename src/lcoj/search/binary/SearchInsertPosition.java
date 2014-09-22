package lcoj.search.binary;

//Given a sorted array and a target value, return the index if the target is found. 
//If not, return the index where it would be if it were inserted in order.
//
//You may assume no duplicates in the array.
//
//Here are few examples.
//[1,3,5,6], 5 → 2
//[1,3,5,6], 2 → 1
//[1,3,5,6], 7 → 4
//[1,3,5,6], 0 → 0
public class SearchInsertPosition {

	// O(N) linear solution
	// better to find a logN solution
	// Got AC by OJ...
    public int searchInsertBad(int[] A, int target) {
    	for(int i = 0; i < A.length; i++) {
    		if(target <= A[i]) {
    			return i;
    		}
    	}
    	return A.length;
    }
    
    
    // a binary search solution
    // A variation of regular binary search
    public int searchInsert(int[] A, int target) {
        
    	int head = 0;
    	int tail = A.length - 1;
    	int mid = 0;
    	
    	while(head <= tail) {
    		mid = head + (tail - head) / 2;
    		if(target > A[mid]) {
    			head = mid + 1;
    		} else if (target < A[mid]) {
    			tail = mid - 1;
    		} else {
    			return mid;
    		}
    	}
    	
    	if(target > A[mid]) {
    		return mid + 1;
    	} else {
    		return mid;
    	}
    }
    
    public static void main(String[] args) {
		
    	int[] A = {1,3,5,6};
    	SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
    	System.out.println(searchInsertPosition.searchInsert(A, 0));
	}
}
