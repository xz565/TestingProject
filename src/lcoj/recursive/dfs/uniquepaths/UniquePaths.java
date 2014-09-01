package lcoj.recursive.dfs.uniquepaths;

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//How many possible unique paths are there?

public class UniquePaths {

	// transfer it to a math problem: (m+n, n)
	// easily got over flowed...
    public int uniquePathsBad(int m, int n) {
        return (int) (factorial(m+n-2)/(factorial(n-1)*factorial(m-1)));
    }
     
    private long factorial(int i) {
		
    	long rst = 1;
    	
    	while(i > 0) {
    		rst *= i;
    		i--;
    	}
		return rst;
	}
    
    // traditional recursive solution
    // but easily got TLE because lots of duplicate calculation
    // can utilize DP to save time
    public int uniquePaths(int m, int n) {
        
    	int[][] cache = new int[m+1][n+1];
    	
    	return helper(m, n, cache);
    	
    }

	private int helper(int m, int n, int[][] cache) {
		
		// This condition is OR
		if(m <= 1 || n <= 1) {
			//cache[m][n] = 1;
    		return 1;
    	}

		if(cache[m][n] == 0) {
			int downCount = helper(m - 1, n, cache);
			int rightCount = helper(m, n - 1, cache);
			cache[m][n] = downCount + rightCount;
		}
		
    	return cache[m][n];
	}

	public static void main(String[] args) {
		UniquePaths uniquePaths = new UniquePaths();
		System.out.println(uniquePaths.uniquePaths(23, 12));
	}
}
