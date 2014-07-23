package lcoj.array.matrix;

import java.util.ArrayList;

import lcoj.common.Util;

// Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
// For example,
// X X X X
// X O O X
// X X O X
// X O X X
// After running your function, the board should be:
//
// X X X X
// X X X X
// X X X X
// X O X X

// from this question,
// understood difference between DFS and BFS better
public class SurroundedRegions {

  // proposal, for this problem
  // an aux board with states machine may be helpful
  // don't even need to bother with another board
  // can mark the state in the original board
  // O can be in state:
  // P - pending
  // F - not surrounded
  public void solve_bad(char[][] board) {

    // this solution got Stack Overflow Error
    // there could be some technique to optimize
    // when a position is set to false,
    // all the 'O' around it can also be set to false
    for (int i = 0 ; i < board.length ; i++) {
      for (int j = 0 ; j < board[0].length ; j++) {
        helper_BAD(board, i, j);
      }
    }
    // put back 'F' to 'O'
    for (int i = 0 ; i < board.length ; i++) {
      for (int j = 0 ; j < board[0].length ; j++) {
        if (board[i][j] == 'F') {
          board[i][j] = 'O';
        }
      }
    }
  }


  private boolean helper_BAD(char[][] board, int i, int j) {

    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'F') {
      return false;
    }

    if (board[i][j] == 'X' || board[i][j] == 'P') {
      return true;
    }

    if (board[i][j] == 'O') {
      board[i][j] = 'P'; // set it to Pending state
      // look around recursively
      // THIS RECURSIVE STEP IS TOO EXPENSIVE IN SPACE
      // This is actually DFS
      if (helper_BAD(board, i - 1, j) && helper_BAD(board, i, j - 1) && helper_BAD(board, i + 1, j) && helper_BAD(board, i, j + 1)) {
        board[i][j] = 'X';
        return true;
      } else {
        board[i][j] = 'F';
      }
    }
    return false;
  }


  class Pair {

    int i;
    int j;


    public Pair(int i, int j) {

      this.i = i;
      this.j = j;
    }
  }


  public void solve(char[][] board) {

    // mark all the 'O's that are reachable from boarder
    // change them to 'P', then change all other 'O's to X
    // change 'P' back to O. done
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }

    for (int i = 0 ; i < board.length ; i++) {
      helper(board, i, 0);
      helper(board, i, board[0].length - 1);
    }
    for (int j = 0 ; j < board[0].length ; j++) {
      helper(board, 0, j);
      helper(board, board.length - 1, j);
    }

    for (int i = 0 ; i < board.length ; i++) {
      for (int j = 0 ; j < board[0].length ; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        } else if (board[i][j] == 'P') {
          board[i][j] = 'O';
        }
      }
    }
  }


  private void helper(char[][] board, int i, int j) {

    if (board[i][j] == 'O') {
      ArrayList<Pair> queue = new ArrayList<Pair>();
      queue.add(new Pair(i, j));
      while (!queue.isEmpty()) {
        // System.out.println(queue);
        Pair curtPair = queue.remove(0);
        int curtI = curtPair.i;
        int curtJ = curtPair.j;
        // one thing to notice is the place we put the boarder checker
        // if we put this checker around each of the add method below
        // will cause TLE
        // also the code will look ugly
        // it's art!
        if (curtI < 0 || curtJ < 0 || curtI >= board.length || curtJ >= board[0].length || board[curtI][curtJ] != 'O') {
          continue;
        }
        board[curtI][curtJ] = 'P';
        queue.add(new Pair(curtI - 1, curtJ));
        queue.add(new Pair(curtI + 1, curtJ));
        queue.add(new Pair(curtI, curtJ - 1));
        queue.add(new Pair(curtI, curtJ + 1));
      }
    }
  }


  public static void main(String[] args) {

    char[][] board = { { 'X', 'O', 'X', 'X' }, { 'X', 'O', 'X', 'X' }, { 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };
    Util.printMatrix(board);
    SurroundedRegions surroundedRegions = new SurroundedRegions();
    surroundedRegions.solve(board);
    Util.printMatrix(board);
  }
}
