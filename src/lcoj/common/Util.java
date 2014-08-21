package lcoj.common;

import java.util.Arrays;

public class Util {

  public static void printMatrix(int[][] matrix) {

    for (int[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
    System.out.println();
  }


  public static void printMatrix(char[][] matrix) {

    for (char[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
    System.out.println();
  }


  public static void printMatrix(boolean[][] matrix) {

    for (boolean[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
    System.out.println();
  }
}
