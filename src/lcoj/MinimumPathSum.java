package lcoj;

/*
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right which minimizes 
 * the sum of all numbers along its path.
 */
public class MinimumPathSum {

	public static int minPathSum(int[][] grid) {

		int[] min = { Integer.MAX_VALUE };
		helper(grid, 0, 0, 0, min);
		return min[0];
	}

	public static void helper(int[][] grid, int row, int col, int currtVal,
			int[] min) {

		if (row == grid.length - 1 && col == grid[0].length - 1
				&& currtVal < min[0]) {
			min[0] = currtVal;
		}

		int newCurrt = grid[row][col] + currtVal;
		if ( >= min[0]) {
			return;
		}

		if (row < grid.length - 1) {
			helper(grid, row + 1, col, currtVal + grid[row][col], min);
		}

		if (col < grid[0].length - 1) {
			helper(grid, row, col + 1, currtVal + grid[row][col], min);
		}
	}

	public static void main(String[] args) {

		int[][] grid = { { 0, 1 } };
		System.out.println(minPathSum(grid));
	}
}
