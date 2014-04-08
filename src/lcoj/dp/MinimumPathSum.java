package lcoj.dp;

/*
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes 
 * the sum of all numbers along its path.
 */
public class MinimumPathSum {

	
	public static int minPathSum(int[][] grid) {
		
		int[][] cache = new int[grid.length][grid[0].length];
		cache[0][0] = grid[0][0];
		
		for(int i = 1; i < grid.length; i++) {
			cache[i][0] = cache[i-1][0] + grid[i][0];
		}
		for(int i = 1; i < grid[0].length; i++ ) {
			cache[0][i] = cache[0][i-1] + grid[0][i];
		}
		for(int i = 1; i < grid.length; i++) {
			for(int j = 1; j < grid[0].length; j++) {
				cache[i][j] = Math.min(cache[i-1][j], cache[i][j-1]) + grid[i][j];
			}
		}
		print(cache);
		return cache[cache.length - 1][cache[0].length - 1];
	}

	private static void print(int[][] cache) {
		for(int i = 0 ; i < cache.length; i++) {
			for(int j = 0; j < cache[0].length; j ++) {
				System.out.print(cache[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// this is a DP problem
	public static int minPathSumBad(int[][] grid) {

				
		int[] min = { Integer.MAX_VALUE };
		helper(grid, 0, 0, 0, min);
		return min[0];
	}

	public static void helper(int[][] grid, int row, int col, int currtVal,
			int[] min) {

		int newCurrt = grid[row][col] + currtVal;

//		if ( newCurrt >= min[0]) {
//			return;
//		}	
		
		if (row == grid.length - 1 && col == grid[0].length - 1) {
		    if(newCurrt < min[0]) {
		    	min[0] = newCurrt;
		    }
			return;
		}

		// go down
		if (row < grid.length - 1) {
			helper(grid, row + 1, col, newCurrt, min);
		}

		// go right
		if (col < grid[0].length - 1) {
			helper(grid, row, col + 1, newCurrt, min);
		}
	}

	public static void main(String[] args) {

		int[][] grid = { { 7,1,3,5,8,9,9,2,1,9,0,8,3,1,6,6,9,5 }, 
				         { 9,5,9,4,0,4,8,8,9,5,7,3,6,6,6,9,1,6 },
				         { 8,2,9,1,3,1,9,7,2,5,3,1,2,4,8,2,8,8 },
				         { 6,7,9,8,4,8,3,0,4,0,9,6,6,0,0,5,1,4 },
				         { 7,1,3,1,8,8,3,1,2,1,5,0,2,1,9,1,1,4 },
				         { 9,5,4,3,5,6,1,3,6,4,9,7,0,8,0,3,9,9 },
				         { 1,4,2,5,8,7,7,0,0,7,1,2,1,2,7,7,7,4 },
				         { 3,9,7,9,5,8,9,5,6,9,8,8,0,1,4,2,8,2 },
				         { 1,5,2,2,2,5,6,3,9,3,1,7,9,6,8,6,8,3 },
				         { 5,7,8,3,8,8,3,9,9,8,1,9,2,5,4,7,7,7 },
				         { 2,3,2,4,8,5,1,7,2,9,5,2,4,2,9,2,8,7 },
				         { 0,1,6,1,1,0,0,6,5,4,3,4,3,7,9,6,1,9 }};

		System.out.println(minPathSumBad(grid));
	}
}
