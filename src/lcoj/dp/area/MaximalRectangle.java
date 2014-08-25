package lcoj.dp.area;

import java.util.Arrays;
import java.util.Stack;

// Given a 2D binary matrix filled with 0's and 1's,
// find the largest rectangle containing all ones and return its area.
public class MaximalRectangle {

  // 0000111
  // 1110111
  // 1111111
  // 1100011
  // 1100011
  // leetcode的题目真是越来越经典了。比如这个题目，就是一道男默女泪的题

  // This is a O(N^2) solution based on the previous problem
  public static int maximalRectangle(char[][] matrix) {

    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int[] curtLine = new int[matrix[0].length];
    for (int i = 0 ; i < curtLine.length ; i++) {
      curtLine[i] = matrix[0][i] - '0';
    }

    int max = largestRectangleArea(curtLine);

    for (int i = 1 ; i < matrix.length ; i++) {
      for (int j = 0 ; j < curtLine.length ; j++) {
        curtLine[j] = matrix[i][j] == '0' ? 0 : curtLine[j] + matrix[i][j] - '0';
      }
      max = Math.max(max, largestRectangleArea(curtLine));
    }

    return max;
  }


  public static int largestRectangleArea(int[] arr) {

    System.out.println(Arrays.toString(arr));

    Stack<Integer> stack = new Stack<Integer>();
    int max = 0;

    for (int curt : arr) {

      if (stack.isEmpty() || stack.peek() <= curt) {
        stack.push(curt);

      } else {

        int count = 1;
        while (!stack.isEmpty() && curt < stack.peek()) {
          // stack.pop();
          max = Math.max(max, count * stack.pop());
          count++;

        }

        for (int i = 1 ; i <= count ; i++) {
          stack.push(curt);
        }

      }
    }

    int len = 1;
    while (!stack.isEmpty()) {
      max = Math.max(max, len * stack.pop());
      len++;
    }

    return max;
  }


  public static void main(String[] args) {

    char[][] matrix = { { '1', '1', '1', '1' }, { '1', '1', '1', '1' } };
    System.out.println(maximalRectangle(matrix));
  }
}
