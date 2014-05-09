package lcoj.recursive.sudoku;

import java.util.HashSet;
import java.util.Set;

import lcoj.common.Util;

public class SudokuSolver {

	private static final int LEN = 9;

	// simple back tracing approach
	// too much duplication, need optimization
	// use of isValidSudoku() is time consuming
	public void solveSudoku(char[][] board) {
		helper(board, 0, 0);
	}

	private boolean helper(char[][] board, int row, int col) {

		if (row >= 9) {
			return true;
		} else if (col >= 9) {
			return helper(board, row + 1, 0);
		} else if (board[row][col] != '.') {
			return helper(board, row, col + 1);
		} else {
			Set<Character> set = new HashSet<Character>();
			for (int i = 0; i < LEN; i++) {
				set.add(board[row][i]);
				set.add(board[i][col]);
			}
			for (char i = '1'; i <= '9'; i++) {
				if (!set.contains(i)) {
					board[row][col] = i;
					if (isValidSudoku(board)) {
						if (helper(board, row, col + 1)) {
							return true;
						}
					}
				}
			}
			board[row][col] = '.';
			return false;
		}
	}

	public boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < LEN; i++) {
			// row
			if (!isValid(board[i])) {
				return false;
			}

			char[] col = new char[LEN];
			for (int j = 0; j < LEN; j++) {
				// col
				col[j] = board[j][i];
			}
			if (!isValid(col)) {
				return false;
			}
		}

		// 3 * 3 grid
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				char[] grid = new char[LEN];
				for (int m = 0; m < 3; m++) {
					for (int n = 0; n < 3; n++) {
						grid[m * 3 + n] = board[i * 3 + m][j * 3 + n];
					}
				}

				if (!isValid(grid)) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean isValid(char[] cs) {

		HashSet<Character> set = new HashSet<Character>();
		for (char ch : cs) {
			if (!set.contains(ch)) {
				set.add(ch);
			} else {
				if (ch != '.') {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		char[][] board = { { '.', '8', '7', '6', '5', '4', '3', '2', '1' },
				{ '2', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '3', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '4', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '5', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '6', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '7', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '8', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '1', '.', '.', '.', '.', '.', '.', '.', '.' } };
		char[][] board2 = { { '.', '.', '.', '.', '.', '7', '.', '.', '9' },
				{ '.', '4', '.', '.', '8', '1', '2', '.', '.' },
				{ '.', '.', '.', '9', '.', '.', '.', '1', '.' },
				{ '.', '.', '5', '3', '.', '.', '.', '7', '2' },
				{ '2', '9', '3', '.', '.', '.', '.', '5', '.' },
				{ '.', '.', '.', '.', '.', '5', '3', '.', '.' },
				{ '8', '.', '.', '.', '2', '3', '.', '.', '.' },
				{ '7', '.', '.', '.', '5', '.', '.', '4', '.' },
				{ '5', '3', '1', '.', '7', '.', '.', '.', '.' } };

		Util.printMatrix(board);
		Util.printMatrix(board2);
		SudokuSolver solver = new SudokuSolver();
		long startTime = System.currentTimeMillis();
		solver.solveSudoku(board2);
		System.out.println("Time: " + (System.currentTimeMillis() - startTime));
		Util.printMatrix(board2);
	}
}
