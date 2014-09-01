package lcoj.recursive.dfs.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given a collection of integers that might contain duplicates, S, return all possible subsets.
//
// Note:
// Elements in a subset must be in non-descending order.
// The solution set must not contain duplicate subsets.
// For example,
// If S = [1,2,2], a solution is:
//
// [
// []
// [2],
// [1],
// [1,2,2],
// [2,2],
// [1,2],
// ]
public class SubsetsII {

  public List<List<Integer>> subsetsWithDup(int[] num) {

    Arrays.sort(num);
    return helper(num, num.length - 1);
  }


  private List<List<Integer>> helper(int[] num, int idx) {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    if (idx < 0) {
      List<Integer> empty = new ArrayList<Integer>();
      result.add(empty);
      return result;
    }

    List<List<Integer>> prev = helper(num, idx - 1);
    List<List<Integer>> curt = new ArrayList<List<Integer>>();

    for (List<Integer> prevList : prev) {

      @SuppressWarnings("unchecked")
      ArrayList<Integer> al = (ArrayList<Integer>) ((ArrayList<Integer>) prevList).clone();
      al.add(num[idx]);
      if (!prev.contains(al)) {
        curt.add(al);
      }
    }

    result.addAll(prev);
    result.addAll(curt);
    return result;
  }


  public static void main(String[] args) {

    SubsetsII subsetsII = new SubsetsII();
    System.out.println(subsetsII.subsetsWithDup(new int[] { 1, 2, 2 }));
  }
}
