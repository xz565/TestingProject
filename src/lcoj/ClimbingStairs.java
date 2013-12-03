package lcoj;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    /*
     * Time out
     */
    public int climbStairsTimeOut(int n) {
	if (n <= 0) {
	    return 0;
	}

	if (n == 1) {
	    return 1;
	}

	return climbStairsTimeOut(n - 1) + climbStairsTimeOut(n - 2);
    }

    /*
     * DP
     */
    int[] dp = new int[1000];

    public int climbStairs(int n) {

	if (n == 0) {
	    return 1;
	}

	if (n == 1) {
	    return 1;
	}

	if (dp[n] != 0) {
	    return dp[n];
	}

	int result = climbStairs(n - 1) + climbStairs(n - 2);
	dp[n] = result;
	return result;
    }

    public static void main(String[] args) {
	ClimbingStairs c = new ClimbingStairs();
	System.out.println(c.climbStairs(0)); // 1
	System.out.println(c.climbStairs(1)); // 1
	System.out.println(c.climbStairs(2)); // 2
	System.out.println(c.climbStairs(3)); // 3
    }
}
