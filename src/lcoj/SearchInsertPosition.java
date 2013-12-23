package lcoj;

public class SearchInsertPosition {

	// O(N)
    public int searchInsertBad(int[] A, int target) {
    	for(int i = 0; i < A.length; i++) {
    		if(target <= A[i]) {
    			return i;
    		}
    	}
    	return A.length;
    }
}
