package lcoj.array;

import java.util.ArrayList;

// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
//
// For example,
// Given the following matrix:
//
// [
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
// ]
// You should return [1,2,3,6,9,8,7,4,5].
public class SpiralMatrix {

  // usually, try one more example
  // 1 2 3 4 5
  // 5 6 7 8 6
  // 9 0 1 2 7
  private static final int RIGHT = 0;
  private static final int DOWN = 1;
  private static final int LEFT = 2;
  private static final int UP = 3;


  public ArrayList<Integer> spiralOrder(int[][] matrix) {

    ArrayList<Integer> result = new ArrayList<Integer>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return result;
    }

    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    helper(matrix, visited, result, 0, 0, RIGHT);

    return result;
  }


  private void helper(int[][] matrix, boolean[][] visited, ArrayList<Integer> result, int row, int col, int dir) {

    result.add(matrix[row][col]);
    visited[row][col] = true;

    switch (dir) {
      case RIGHT: {
        // try right
        if (col + 1 < matrix[0].length && !visited[row][col + 1]) {
          helper(matrix, visited, result, row, col + 1, RIGHT);
        } else {
          // try down
          if (row + 1 < matrix.length && !visited[row + 1][col]) {
            helper(matrix, visited, result, row + 1, col, DOWN);
          }
        }
        break;
      }
      case DOWN: {
        // try down
        if (row + 1 < matrix.length && !visited[row + 1][col]) {
          helper(matrix, visited, result, row + 1, col, DOWN);
        } else {
          // try left
          if (col - 1 >= 0 && !visited[row][col - 1]) {
            helper(matrix, visited, result, row, col - 1, LEFT);
          }
        }
        break;
      }
      case LEFT: {
        // try left
        if (col - 1 >= 0 && !visited[row][col - 1]) {
          helper(matrix, visited, result, row, col - 1, LEFT);
        } else {
          // try up
          if (row - 1 >= 0 && !visited[row - 1][col]) {
            helper(matrix, visited, result, row - 1, col, UP);
          }
        }
        break;
      }
      case UP: {
        // try up
        if (row - 1 >= 0 && !visited[row - 1][col]) {
          helper(matrix, visited, result, row - 1, col, UP);
        } else {
          // try right
          if (col + 1 < matrix[0].length && !visited[row][col + 1]) {
            helper(matrix, visited, result, row, col + 1, RIGHT);
          }
        }
      }
    }
  }


  public static void main(String[] args) {

    int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    SpiralMatrix spiralMatrix = new SpiralMatrix();
    ArrayList<Integer> result = spiralMatrix.spiralOrder(matrix);
    System.out.println(result);
  }
}
