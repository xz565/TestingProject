package lcoj.array.sum;

import java.util.ArrayList;
import java.util.Arrays;

// Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
// Find all unique quadruplets in the array which gives the sum of target.
//
// Note:
// Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
// The solution set must not contain duplicate quadruplets.
// For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
//
// A solution set is:
// (-1, 0, 0, 1)
// (-2, -1, 1, 2)
// (-2, 0, 0, 2)
public class FourSum {

  // there is a O(N^2) solution, so fucking smart!
  public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

    Arrays.sort(num);
    ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();


    return results;
  }


  public static void main(String[] args) {

  }
}