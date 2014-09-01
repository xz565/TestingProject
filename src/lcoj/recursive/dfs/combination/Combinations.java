package lcoj.recursive.dfs.combination;

import java.util.ArrayList;
import java.util.List;

// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
// For example,
// If n = 4 and k = 2, a solution is:
//
// [
// [2,4],
// [3,4],
// [2,3],
// [1,2],
// [1,3],
// [1,4],
// ]
public class Combinations {

  // similar to permutation
  public List<List<Integer>> combine(int n, int k) {

    // boolean[] visited = new boolean[n];
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<Integer>();

    /**
     * If count is there, then visited array is NOT necessary!!!
     */
    // visited array guarantees element already used will not be use again in the same tmp
    // count guarantees it's done in ascending order,
    // this naturally guarantees that smaller element will not be put in tmp more than one time

    int count = 0; // difference with permutation
    helper(rst, tmp, n, k, count);

    return rst;
  }


  // the count keep the number in ascending order, so [1,2,3] and [1,3,2] wouldn't come together
  // for permutation, each loop starts from 0, so [1,2,3] and [1,3,2] will both come
  private void helper(List<List<Integer>> rst, List<Integer> tmp, int n, int k, int count) {

    if (tmp.size() == k) {
      rst.add(new ArrayList<Integer>(tmp));
    }

    for (int i = count ; i < n ; i++) {
      // if (!visited[i]) {
      // visited[i] = true;
      tmp.add(i + 1);
      helper(rst, tmp, n, k, i + 1);
      // visited[i] = false;
      tmp.remove(tmp.size() - 1);
      // }
    }
  }


  public static void main(String[] args) {

    Combinations comb = new Combinations();
    System.out.println(comb.combine(4, 2));
  }
}
