package lcoj.recursive.dfs.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given a set of candidate numbers (C) and a target number (T),
// find all unique combinations in C where the candidate numbers sums to T.
//
// The same repeated number may be chosen from C
// UNLIMITED number of times.
//
// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 2,3,6,7 and target 7,
//
// A solution set is:
// [7]
// [2, 2, 3]
public class CombinationSum {

  // Hehe, so easily ACed
  public List<List<Integer>> combinationSum(int[] candidates, int target) {

    // prepare
    Arrays.sort(candidates);

    List<Integer> tempList = new ArrayList<Integer>();
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    helper(candidates, candidates.length - 1, target, tempList, result);

    return result;
  }


  private void helper(int[] candidates, int idx, int target, List<Integer> tempList, List<List<Integer>> result) {

    System.out.println(tempList);

    if (target < 0 || idx < 0) {
      return;
    }

    if (target == 0) {
      result.add(new ArrayList<Integer>(tempList));
    }

    for (int i = idx ; i >= 0 ; i--) {
      tempList.add(candidates[i]);
      helper(candidates, i, target - candidates[i], tempList, result);
      tempList.remove(tempList.size() - 1);
    }
  }


  public static void main(String[] args) {

    int[] arr = { 1, 2 };
    CombinationSum com = new CombinationSum();
    System.out.println(com.combinationSum(arr, 3));
  }
}
