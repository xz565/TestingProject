package lcoj.dp;

public class MaximumProductSubarray {

    public static int maxProduct(int[] A) {
    	if(A == null || A.length ==0) {
    		return 0;
    	}
    	
    	int max = A[0];
    	int prevMax = A[0];
    	int prevMin = A[0];
    	
    	for(int i = 1; i < A.length; i++) {
    		int curtMax = Math.max(A[i], Math.max(prevMin * A[i], prevMax * A[i]));
    		prevMin = Math.min(A[i], Math.min(prevMax * A[i], prevMin * A[i]));

    		prevMax = curtMax;
    		max = Math.max(max, curtMax);
    	}
    	return max;
    }
    
    public static void main(String[] args) {
    	int[] A = new int[]{0,-1,1};
    	System.out.println(maxProduct(A));

    	int[] A2 = new int[]{0,-2,-3,-4};
    	System.out.println(maxProduct(A2));

    	int[] A3 = new int[]{0,2,3,4};
    	System.out.println(maxProduct(A3));

    	int[] A4 = new int[]{0,2,-3,4,0};
    	System.out.println(maxProduct(A4));
    	
    	
    	int[] A5 = new int[]{0,2,-3,4,10,0,3,-4,-5};
    	System.out.println(maxProduct(A5));
	}
}
