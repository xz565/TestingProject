package lcoj.array.matrix;

import lcoj.common.Util;

//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//
//For example,
//Given n = 3,
//
//You should return the following matrix:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
public class SpiralMatrixII {

	private static final int RIGHT = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int UP = 3;

	public int[][] generateMatrix(int n) {

		int[][] result = new int[n][n];
		if (n == 0) {
			return result;
		}
		helper(result, 0, 0, 0, RIGHT);

		return result;
	}

	private void helper(int[][] result, int row, int col, int prev, int dir) {

		result[row][col] = prev + 1;

		switch (dir) {
		case RIGHT:
			if (col + 1 < result.length && result[row][col + 1] == 0) {
				helper(result, row, col + 1, prev + 1, RIGHT);
			} else {
				if (row + 1 < result.length && result[row + 1][col] == 0) {
					helper(result, row + 1, col, prev + 1, DOWN);
				}
			}
			break;

		case DOWN:
			if (row + 1 < result.length && result[row + 1][col] == 0) {
				helper(result, row + 1, col, prev + 1, DOWN);
			} else {
				if (col - 1 >= 0 && result[row][col - 1] == 0) {
					helper(result, row, col - 1, prev + 1, LEFT);
				}
			}
			break;

		case LEFT:
			if (col - 1 >= 0 && result[row][col - 1] == 0) {
				helper(result, row, col - 1, prev + 1, LEFT);
			} else {
				if (row - 1 >= 0 && result[row - 1][col] == 0) {
					helper(result, row - 1, col, prev + 1, UP);
				}
			}
			break;

		case UP:
			if (row - 1 >= 0 && result[row - 1][col] == 0) {
				helper(result, row - 1, col, prev + 1, UP);
			} else {
				if (col + 1 < result.length && result[row][col + 1] == 0) {
					helper(result, row, col + 1, prev + 1, RIGHT);
				}
			}
			break;
		}

	}

	public static void main(String[] args) {
		SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
		Util.printMatrix(spiralMatrixII.generateMatrix(4));
	}
}
