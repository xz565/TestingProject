package lcoj.array;

import java.util.ArrayList;
import java.util.List;

// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
// For example, given the following triangle
// [
// [2],
// [3,4],
// [6,5,7],
// [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
// Note:
// Bonus point if you are able to do this using only O(n) extra space
// where n is the total number of rows in the triangle.
public class Triangle {

  // Time is O(N)
  // This solution uses O(N) space
  // can be Aced easily, better to come with O(n) space solution
  // where n is the total number of rows in the triangle
  public int minimumTotalMoreSpace(List<List<Integer>> triangle) {

    ArrayList<Integer> al = new ArrayList<Integer>();
    al.add(triangle.get(0).get(0));
    List<List<Integer>> sum = new ArrayList<List<Integer>>();
    sum.add(al);
    helper(triangle, 1, sum);

    // System.out.println(sum);

    int min = Integer.MAX_VALUE;
    for (int s : sum.get(sum.size() - 1)) {
      if (s < min) {
        min = s;
      }
    }
    return min;
  }


  private void helper(List<List<Integer>> triangle, int rowIdx, List<List<Integer>> sum) {

    if (rowIdx < triangle.size()) {
      List<Integer> curtRow = triangle.get(rowIdx);
      List<Integer> curtSum = new ArrayList<Integer>();

      for (int i = 0 ; i < curtRow.size() ; i++) {
        if (i == 0) {
          curtSum.add(curtRow.get(i) + sum.get(rowIdx - 1).get(i));
        } else if (i == curtRow.size() - 1) {
          curtSum.add(curtRow.get(i) + sum.get(rowIdx - 1).get(i - 1));
        } else {
          curtSum.add(curtRow.get(i) + Math.min(sum.get(rowIdx - 1).get(i), sum.get(rowIdx - 1).get(i - 1)));
        }
      }

      sum.add(curtSum);
      helper(triangle, ++rowIdx, sum);
    }
  }


  // first idea is treat the triangle like a tree
  // start from root, got left, then right
  // if DFS, then space will be log(N), which is log(n)

  // if treated as binary tree and use pre-order, will cause TLE for too many duplicates
  // so need a bottom up solution for traverse
  public int minimumTotal(List<List<Integer>> triangle) {

    int[] min = new int[1];
    min[0] = Integer.MAX_VALUE;
    helper2(triangle, 0, 0, 0, min);
    return min[0];
  }


  private void helper2(List<List<Integer>> triangle, int row, int col, int curtSum, int[] min) {

    if (row == triangle.size()) {
      if (curtSum < min[0]) {
        min[0] = curtSum;
      }
    } else {
      int newSum = curtSum + triangle.get(row).get(col);
      helper2(triangle, row + 1, col, newSum, min);
      helper2(triangle, row + 1, col + 1, newSum, min);
    }

  }


  public static void main(String[] args) {

    List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    ArrayList<Integer> al = null;

    al = new ArrayList<Integer>();
    al.add(2);
    triangle.add(al);

    al = new ArrayList<Integer>();
    al.add(3);
    al.add(4);
    triangle.add(al);

    al = new ArrayList<Integer>();
    al.add(6);
    al.add(5);
    al.add(7);
    triangle.add(al);

    Triangle tria = new Triangle();
    System.out.println(tria.minimumTotal(triangle));
  }
}
