package lcoj.recursive.dfs.uniquepaths;

//Follow up for "Unique Paths":
//
//Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//For example,
//There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//The total number of unique paths is 2.
//
//Note: m and n will be at most 100.

// This is a typical DFS + DP problem
// easy in algorithm, problem is how to write it neat and bug free
public class UniquePathsII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;
		int[][] cache = new int[row][col];

		helper(row - 1, col - 1, obstacleGrid, cache);

		if (cache[row - 1][col - 1] == -1) {
			return 0;
		} else {
			return cache[row - 1][col - 1];
		}
	}

	private int helper(int row, int col, int[][] obstacleGrid, int[][] cache) {

		if (obstacleGrid[row][col] == 1) {
			cache[row][col] = -1;
			return -1;

		} else {

			// this condition is AND!
			if (row <= 0 && col <= 0) {
				cache[row][col] = 1;
				return 1;
			}

			if (cache[row][col] == 0) {
				int down = 0;
				int right = 0;
				if (row - 1 >= 0) {
					down = helper(row - 1, col, obstacleGrid, cache);
				}
				if (col - 1 >= 0) {
					right = helper(row, col - 1, obstacleGrid, cache);
				}
				if (down > 0) {
					cache[row][col] += down;
				}
				if (right > 0) {
					cache[row][col] += right;
				}
				if (down < 0 && right < 0) {
					cache[row][col] = -1;
				}
			}

			return cache[row][col];
		}
	}

	
	// Interesting fact
	// First tried from [0,0] to lower right corner,
	// however, got TLE because of boundary check !!!
	//
	// then reversed from [obstacleGrid-1][obstacleGrid[0].length] to [0, 0], and got accepted !!!
	// looks like the .length operation is expensive in Java OR because the recursive step is too much
	int[][] cache;
	public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
		
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 0;
		}
		
		cache = new int[obstacleGrid.length][obstacleGrid[0].length];
		int rst = helper(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
	
		return rst;
	}
	
	
	private int helper(int[][] obstacleGrid, int row, int col) {

		if(row < 0 || col < 0) {
			return 0;
		}
		
		if(cache[row][col] == 0) {
			
			if(obstacleGrid[row][col] == 1) {
			    cache[row][col] = -1;
			} else {
			    if(row == 0 && col == 0) {
			        cache[row][col] = 1;
			    } else {
			        cache[row][col] = helper(obstacleGrid, row - 1, col) + helper(obstacleGrid, row, col - 1);
			    }
			}
		}
		
		return cache[row][col] == -1 ? 0 : cache[row][col];
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int[][] grid2 = { { 1, 0 } };
		UniquePathsII uniquePathsII = new UniquePathsII();
		System.out.println(uniquePathsII.uniquePathsWithObstacles2(grid));
		System.out.println(uniquePathsII.uniquePathsWithObstacles2(grid2));
	}
}
