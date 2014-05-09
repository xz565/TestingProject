package lcoj.recursive.sudoku;

import java.util.HashSet;

public class ValidSudoku {

	private static final int LEN = 9;

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

		char[][] board = { 	{ '.', '8', '7', '6', '5', '4', '3', '2', '1' },
							{ '2', '.', '.', '.', '.', '.', '.', '.', '.' },
							{ '3', '.', '.', '.', '.', '.', '.', '.', '.' },
							{ '4', '.', '.', '.', '.', '.', '.', '.', '.' },
							{ '5', '.', '.', '.', '.', '.', '.', '.', '.' },
							{ '6', '.', '.', '.', '.', '.', '.', '.', '.' },
							{ '7', '.', '.', '.', '.', '.', '.', '.', '.' },
							{ '8', '.', '.', '.', '.', '.', '.', '.', '.' },
							{ '9', '.', '.', '.', '.', '.', '.', '.', '.' } };
		ValidSudoku validSudoku = new ValidSudoku();
		System.out.println(validSudoku.isValidSudoku(board));
	}
}
