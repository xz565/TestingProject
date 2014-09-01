package lcoj.recursive.dfs.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given a collection of candidate numbers (C) and a target number (T),
// find all unique combinations in C where the candidate numbers sums to T.
//
// Each number in C may only be used ONCE in the combination.
//
// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 10,1,2,7,6,1,5 and target 8,
// A solution set is:
// [1, 7]
// [1, 2, 5]
// [2, 6]
// [1, 1, 6]
public class CombinationSumII {

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {

    // prepare
    Arrays.sort(candidates);

    List<Integer> tempList = new ArrayList<Integer>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    helper(candidates, candidates.length - 1, target, tempList, result);

    return result;
  }


  private void helper(int[] candidates, int idx, int target, List<Integer> tempList, List<List<Integer>> result) {

    System.out.println(tempList);

    if (target == 0) {
      result.add(new ArrayList<Integer>(tempList));
    }

    if (target < 0 || idx < 0) {
      return;
    }

    for (int i = idx ; i >= 0 ; i--) {
      tempList.add(0, candidates[i]);
      helper(candidates, i - 1, target - candidates[i], tempList, result);
      tempList.remove(0);

      // all the cases for second 1 will be covered by first
      // think throughout and carefully
      while (i - 1 >= 0 && candidates[i] == candidates[i - 1]) {
        i--;
      }
    }
  }


  public static void main(String[] args) {

    int[] arr = { 1, 1, 2 };
    CombinationSumII com = new CombinationSumII();
    System.out.println(com.combinationSum2(arr, 5));
  }
}
