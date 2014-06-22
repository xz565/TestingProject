package lcoj;

import java.util.Stack;

// Given n non-negative integers representing the histogram's bar height
// where the width of each bar is 1,
// find the area of largest rectangle in the histogram.
// For example,
// Given height = [2,1,5,6,2,3],
// return 10.
public class LargestRectangleinHistogram {

  // O(N^2) TLE
  // use pruning technique to optimize; passed OJ, but not good algorithm
  // And OJ got really good test cases
  public int largestRectangleArea_Prune(int[] height) {

    int max = 0;

    int lastHeight = Integer.MAX_VALUE;

    for (int i = 0 ; i < height.length ; i++) {

      if (i != 0 && height[i] == lastHeight) {
        continue;
      }
      lastHeight = height[i];

      int leftCount = i - 1;
      int rightCount = i + 1;

      int leftNum = 0;
      int rightNum = 0;

      while (leftCount >= 0) {
        if (height[leftCount] >= height[i]) {
          leftCount--;
          leftNum++;
        } else {
          break;
        }
      }

      while (rightCount < height.length) {
        if (height[rightCount] >= height[i]) {
          rightCount++;
          rightNum++;
        } else {
          break;
        }
      }

      int currtMax = (leftNum + rightNum + 1) * height[i];

      System.out.println(i + " " + currtMax);

      if (currtMax > max) {
        max = currtMax;
      }

    }

    return max;
  }


  // O(N^2) TLE
  public int largestRectangleArea_BF(int[] height) {

    int max = 0;
    for (int i = 0 ; i < height.length ; i++) {
      int curtHight = height[i];
      int width = 1;
      for (int j = i + 1 ; j < height.length ; j++) {
        if (height[j] >= curtHight) {
          width++;
        } else {
          break;
        }
      }
      int tempMax = curtHight * width;
      if (tempMax > max) {
        max = tempMax;
      }
    }
    return max;
  }


  public static void main(String[] args) {

    // int[] arr = { 2147483647 };
    int[] arr = { 2, 1, 5, 6, 2, 3 };
    LargestRectangleinHistogram largestRectangleinHistogram = new LargestRectangleinHistogram();
    System.out.println(largestRectangleinHistogram.largestRectangleArea(arr));
  }


  // most optimized solution
  public int largestRectangleArea(int[] arr) {

    Stack<Integer> stack = new Stack<Integer>();
    for (int element : arr) {

    }
    return 0;
  }
}
