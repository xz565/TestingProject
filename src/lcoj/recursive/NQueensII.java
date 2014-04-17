package lcoj.recursive;

public class NQueensII {

	public int totalNQueens(int n) {
		
		if(n==0) return 0;

		int[] board = new int[n];
		int[] count = new int[1];

		helper(0, board, count);
		
		return count[0];
	}

	private void helper(int row, int[] board, int[] count) {

		if (row == board.length) {
			count[0] += 1;
			return;
		}

		for (int i = 0; i < board.length; i++) {

			board[row] = i;

			if (validate(row, board)) {
				helper(row + 1, board, count);
			}
		}
	}

	private boolean validate(int row, int[] board) {

		for (int i = 0; i <= row; i++) {
			for (int j = i + 1; j <= row; j++) {
				if (board[i] == board[j]) {
					return false;
				}
				if (Math.abs(board[i] - board[j]) == Math.abs(i - j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {

		NQueensII queens = new NQueensII();
		System.out.println(queens.totalNQueens(0));
		System.out.println(queens.totalNQueens(1));
		System.out.println(queens.totalNQueens(2));
		System.out.println(queens.totalNQueens(3));
		System.out.println(queens.totalNQueens(4));
		System.out.println(queens.totalNQueens(8));
	}
}
