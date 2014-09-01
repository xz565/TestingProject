package lcoj.recursive.dfs.permutation;

import java.util.ArrayList;
import java.util.List;


// Given a collection of numbers, return all possible permutations.
//
// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

public class Permutations {

  public ArrayList<ArrayList<Integer>> permute(int[] num) {

    List<Integer> numList = new ArrayList<Integer>();
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
    }

    return results;
  }


  // Still not standard DFS
  public List<List<Integer>> permute2(int[] num) {

    return helper2(num, 0);
  }


  private List<List<Integer>> helper2(int[] num, int pos) {

    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    if (num == null || num.length == 0) {
      return rst;
    } else if (pos == num.length - 1) {
      List<Integer> list = new ArrayList<Integer>();
      list.add(num[pos]);
      rst.add(list);
      return rst;
    }

    List<List<Integer>> lastRst = helper2(num, pos + 1);

    for (List<Integer> lastRstList : lastRst) {
      for (int i = 0 ; i <= lastRstList.size() ; i++) {
        List<Integer> curtList = new ArrayList<Integer>(lastRstList);
        curtList.add(i, num[pos]);
        rst.add(curtList);
      }
    }
    return rst;
  }


  // This looks like a standard DFS
  public List<List<Integer>> permuteDFS(int[] num) {

    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<Integer>();
    boolean[] visited = new boolean[num.length];

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
      }
    }
  }


  public static void main(String[] args) {

    Permutations p = new Permutations();
    int[] num = { 1, 2, 3, 4 };
    System.out.println(p.permuteDFS(num));
  }
}
