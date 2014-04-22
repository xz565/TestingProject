package lcoj.array;

import lcoj.common.Util;


// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
//
// Follow up:
// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?
public class SetMatrixZeroes {

  // constant space
  // 常数空间的话，第一可以考虑是不是固定数量的几个变量能搞定；否则可以考虑是不是问题本身已经提供了足够的空间。
  public void setZeroes(int[][] matrix) {

    boolean firstRowZero = false;
    boolean firstColZero = false;

    for (int i = 0 ; i < matrix[0].length ; i++) {
      if (matrix[0][i] == 0) {
        firstRowZero = true;
        break;
      }
    }

    for (int[] element : matrix) {
      if (element[0] == 0) {
        firstColZero = true;
        break;
      }
    }

    for (int i = 1 ; i < matrix.length ; i++) {
      for (int j = 1 ; j < matrix[i].length ; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    for (int i = 1 ; i < matrix[0].length ; i++) {
      // set the whole column to zero
      if (matrix[0][i] == 0) {
        for (int j = 1 ; j < matrix.length ; j++) {
          matrix[j][i] = 0;
        }
      }
    }

    for (int i = 1 ; i < matrix.length ; i++) {
      // set the whoe row to zero
      if (matrix[i][0] == 0) {
        for (int j = 1 ; j < matrix[i].length ; j++) {
          matrix[i][j] = 0;
        }
      }
    }

    if (firstRowZero) {
      for (int i = 0 ; i < matrix[0].length ; i++) {
        matrix[0][i] = 0;
      }
    }

    if (firstColZero) {
      for (int i = 0 ; i < matrix.length ; i++) {
        matrix[i][0] = 0;
      }
    }
  }


  public static void main(String[] args) {

    int[][] matrix = { { 1, 2, 0, 5 }, { 4, 0, 2, 8 }, { 1, 1, 2, 2 }, { 3, 0, 5, 4 } };
    Util.printMatrix(matrix);
    SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
    setMatrixZeroes.setZeroes(matrix);
    Util.printMatrix(matrix);
  }
}
