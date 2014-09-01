package lcoj.recursive.dfs.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
// Each number in C may only be used once in the combination.
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

    if (target == 0) {
      List<Integer> list = new ArrayList<Integer>();
      for (int i = tempList.size() - 1 ; i >= 0 ; i--) {
        list.add(tempList.get(i));
      }
      if (!result.contains(list)) {
        result.add(list);
      }
    }

    if (target < 0 || idx < 0) {
      return;
    }

    for (int i = idx ; i >= 0 ; i--) {
      tempList.add(candidates[i]);
      helper(candidates, i - 1, target - candidates[i], tempList, result);
      tempList.remove(tempList.size() - 1);
    }
  }


  public static void main(String[] args) {

    int[] arr = { 1, 1, 2, 5, 6, 7, 10 };
    CombinationSumII com = new CombinationSumII();
    System.out.println(com.combinationSum2(arr, 8));
  }
}
