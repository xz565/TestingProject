package lcoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*[
	 [".Q..",  // Solution 1
	  "...Q",
	  "Q...",
	  "..Q."],
	
	 ["..Q.",  // Solution 2
	  "Q...",
	  "...Q",
	  ".Q.."]
]*/


public class NQueens {

	static int totalNum = 0;
	
    public static ArrayList<String[]> solveNQueens(int n) {

    	ArrayList<String[]> solutions = new ArrayList<String[]>();
    	int[] board = new int[n];
    	
    	helper(0, board, solutions);
    	
    	return solutions;
    }
	
	private static void helper(int currentRow, int[] board, ArrayList<String[]> solutions) {

		if(currentRow == board.length) {
			buildSolution(board, solutions);
			return;
		}
		
		for (int i = 1; i <= board.length; i++) {
			board[currentRow] = i;
			
			if(valide(board, currentRow))
				helper(currentRow + 1, board, solutions);
		}
	}

	private static boolean valide(int[] board, int currentRow) {
		
		for(int i = 0; i <= currentRow - 1; i++) {
			for(int j = i + 1; j <= currentRow; j++) {
				if(board[i] == board[j] && board[i] != 0 && board[j] != 0)
					return false;
				
				if(Math.abs((board[i] - board[j])) == Math.abs((i - j)))
					return false;
			}
		}
		
		return true;
	}

	private static void buildSolution(int[] board, ArrayList<String[]> solutions) {
		
		String[] boardStr = new String[board.length];

		for (int i = 0; i < board.length; i++) {
			StringBuffer sb = new StringBuffer();
			for(int j = 1; j <= board.length; j++) {
				if(board[i] == j)
					sb.append("Q");
				else
					sb.append(".");
			}
			boardStr[i] = sb.toString();
		}
		
		solutions.add(boardStr);
	}
	
	public static void main(String[] args) {
		
		List<String[]> solution = NQueens.solveNQueens(4);
		for(String[] a : solution) {
			System.out.println(Arrays.toString(a));
		}
	}
}