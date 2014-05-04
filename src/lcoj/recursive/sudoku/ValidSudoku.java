package lcoj.recursive.sudoku;

import java.util.HashSet;


public class ValidSudoku {

  public boolean isValidSudoku(char[][] board) {

    final int LEN = board.length;

    for (int i = 0 ; i < LEN ; i++) {
      // row
      if (!isValid(board[i])) {
        return false;
      }

      // col
      char[] col = new char[LEN];
      for (int j = 0 ; i < LEN ; j++) {
        col[j] = board[i][j];
      }
      if (!isValid(col)) {
        return false;
      }
    }

    for (int i = 0 ; i < LEN / 3 ; i++) {
      for (int j = 0 ; i < LEN / 3 ; j++) {
        char[] grid = new char[LEN];
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
}
