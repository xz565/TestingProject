package lcoj.dp;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 * 
 * @author amixyz0
 */
public class MaximumSubarray {

	// O(N)
	public int maxSubArray(int[] A) {

		int max = A[0];
		int runningSum = 0;

		for (int currt : A) {
			runningSum += currt;

			if (runningSum > max) {
				max = runningSum;
			}
			if (runningSum < 0) {
				runningSum = 0;
			}
		}

		return max;
	}
	
	// more clear DP solution
    public int maxSubArray2(int[] A) {
        
        int[] cache = new int[A.length + 1];
        // max[i] = max(0, max[i-1] + A[i])
        int max = A[0];
        for(int i = 1; i <= A.length; i++) {
            cache[i] = Math.max(A[i-1], cache[i-1] + A[i-1]);
            max = Math.max(cache[i], max);
        }
        
        return max;
    }

	// O(N^2)
	public int maxSubArrayBad(int[] A) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < A.length; i++) {
			int maxSoFar = 0;
			for (int j = i; j < A.length; j++) {
				maxSoFar += A[j];
				if (maxSoFar > max) {
					max = maxSoFar;
				}
			}
		}

		return max;
	}

	// O(N^3)
	public int maxSubArrayBadBad(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				int sum = sum(A, i, j);
				if (sum > max) {
					max = sum;
				}
			}
		}

		return max;
	}

	private int sum(int[] A, int i, int j) {

		int sum = 0;
		for (int k = i; k <= j; k++) {
			sum += A[k];
		}
		return sum;
	}

	public static void main(String[] args) {

		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		MaximumSubarray maximumSubarray = new MaximumSubarray();
		System.out.println(maximumSubarray.maxSubArray(A));
	}
}
