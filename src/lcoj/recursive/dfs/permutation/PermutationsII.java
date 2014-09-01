package lcoj.recursive.dfs.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
// For example,
// [1,1,2] have the following unique permutations:
// [1,1,2], [1,2,1], and [2,1,1].

public class PermutationsII {

  public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {

    List<Integer> numList = new ArrayList<Integer>();
    Arrays.sort(num);
    for (int i : num) {
      numList.add(i);
    }

    return helper(numList);
  }


  private ArrayList<ArrayList<Integer>> helper(List<Integer> numList) {

    ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

    if (numList.isEmpty()) {
      return results;
    }

    if (numList.size() == 1) {
      ArrayList<Integer> al = new ArrayList<Integer>();
      al.add(numList.get(0));
      results.add(al);
      return results;
    }

    for (int i = 0 ; i < numList.size() ; i++) {

      int curt = numList.remove(i);
      ArrayList<ArrayList<Integer>> rst = helper(numList);
      for (ArrayList<Integer> al : rst) {
        al.add(0, curt);
        results.add(al);
      }
      numList.add(i, curt);

      while (i + 1 < numList.size() && numList.get(i) == numList.get(i + 1)) {
        i++;
      }
    }

    return results;
  }


  public static void main(String[] args) {

    PermutationsII p = new PermutationsII();
    int[] num = { 1, 2, 1 };
    System.out.println(p.permuteUniqueDFS(num));
  }


  public List<List<Integer>> permuteUniqueDFS(int[] num) {

    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<Integer>();
    boolean[] visited = new boolean[num.length];
    Arrays.sort(num);

    helper(num, rst, tmp, visited);

    return rst;
  }


  private void helper(int[] num, List<List<Integer>> rst, List<Integer> tmp, boolean[] visited) {

    if (tmp.size() == num.length) {
      rst.add(new ArrayList<Integer>(tmp));
      return;
    }

    for (int i = 0 ; i < num.length ; i++) {
      if (!visited[i]) {
        tmp.add(num[i]);
        visited[i] = true;
        helper(num, rst, tmp, visited);
        tmp.remove(tmp.size() - 1);
        visited[i] = false;

        while (i + 1 < num.length && num[i] == num[i + 1]) {
          i++;
        }
      }
    }
  }
}
