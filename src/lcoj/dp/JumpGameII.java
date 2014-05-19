package lcoj.dp;

import java.util.Arrays;


//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Your goal is to reach the last index in the minimum number of jumps.
//
//For example:
//Given array A = [2,3,1,1,4]
//
//The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
public class JumpGameII {

	public int jumpTLE(int[] A) {
		return helper(A, 0, 0);
	}

	private int helper(int[] A, int idx, int count) {

		if (idx >= A.length - 1) {
			return count;
		}

		int min = Integer.MAX_VALUE;
		for (int i = A[idx]; i >= 1; i--) {
			int temp = helper(A, idx + i, count + 1);
			if (temp < min) {
				min = temp;
			}
		}
		return min;
	}

	public int jump(int[] A) {

		int[] dp = new int[A.length];
		helper(A, 0, 0, dp);
		//System.out.println(Arrays.toString(dp));
		return dp[A.length-1];
	}

	private int helper(int[] A, int idx, int count, int[] dp) {

		if (idx >= A.length - 1) {
			if (dp[A.length - 1] == 0 || count < dp[A.length - 1]) {
				dp[A.length-1] = count;
			}
			return dp[A.length-1];
		}

		if (dp[idx] == 0 || count < dp[idx]) {
			int min = Integer.MAX_VALUE;
			for (int i = A[idx]; i >= 1; i--) {
				int temp = helper(A, idx + i, count + 1, dp);
				if (temp < min) {
					min = temp;
				}
			}
			dp[idx] = min;
		} 
		return dp[idx];
	}

	public static void main(String[] args) {
		int[] A = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
		JumpGameII jumpGameII = new JumpGameII();
		System.out.println(jumpGameII.jump(A));
		
		int[] B = new int[25000];
		for(int i = 0; i < 25000; i++) {
			B[i] = 25000 - i;
		}
		long startTime = System.currentTimeMillis();
		jumpGameII.jump(B);
		System.out.println(System.currentTimeMillis() - startTime);
		
	}
}
