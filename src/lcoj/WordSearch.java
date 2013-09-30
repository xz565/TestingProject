package lcoj;

/*
 * 	[
	  ["ABCE"],
	  ["SFCS"],
	  ["ADEE"]
	]
	
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
    	
    	if(word.isEmpty()) return true;
        
    	// default all false
    	boolean[][] boardStatus = new boolean[board.length][board[0].length];

    	// start with first char in the word
    	char first = word.charAt(0);
    	
    	for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(first == board[i][j]) {
					boardStatus[i][j] = true; // set status to true
					if(helper(board, word.substring(1), boardStatus, i, j)) 
						return true;
					boardStatus[i][j] = false;
				}
			}
		}
    	
    	return false;
    }
    
    public static boolean helper(char[][] board, String word, boolean[][] boardStatus, int i, int j) {
    	
    	if(word.isEmpty()) return true;
    	
    	//if(word.charAt(0) != board[i][j]) return false;
    	
    	// check the four directions of current position
    	// Up
    	if(i - 1 >= 0 && word.charAt(0) == board[i - 1][j] && !boardStatus[i - 1][j]) {
    		boardStatus[i - 1][j] = true;
    		if(helper(board, word.substring(1), boardStatus, i - 1, j))
    			return true;
    		boardStatus[i - 1][j] = false;
    	}
    	
    	// Down
    	if(i + 1 < board.length && word.charAt(0) == board[i + 1][j] && !boardStatus[i + 1][j]) {
    		boardStatus[i + 1][j] = true;
    		if(helper(board, word.substring(1), boardStatus, i + 1, j))
    			return true;
    		boardStatus[i + 1][j] = false;
    	}
    	
    	// Left
    	if(j - 1 >= 0 && word.charAt(0) == board[i][j - 1] && !boardStatus[i][j - 1]) {
    		boardStatus[i][j - 1] = true;
    		if(helper(board, word.substring(1), boardStatus, i, j - 1))
    			return true;
    		boardStatus[i][j - 1] = false;
    	}
    	
    	// Right
    	if(j + 1 < board[0].length && word.charAt(0) == board[i][j + 1] && !boardStatus[i][j + 1]) {
    		boardStatus[i][j + 1] = true;
    		if(helper(board, word.substring(1), boardStatus, i, j + 1))
    			return true;
    		boardStatus[i][j + 1] = false;
    	}
    	
    	return false;
    }
    
    public static void main(String[] args) {
		char[][] board = {{'A', 'B', 'C', 'E'}, 
						  {'S', 'F', 'C', 'S'}, 
						  {'A', 'D', 'E', 'E'}
						 };
		
		//System.out.println(exist(board, "ABCCED"));
		//System.out.println(exist(board, "SEE"));
	}
}
