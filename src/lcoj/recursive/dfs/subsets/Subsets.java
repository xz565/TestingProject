package lcoj.recursive.dfs.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * 
 * Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets.
 * 
 * @author amixyz0
 * 
 *         For example, If S = [1,2,3], a solution is:
 * 
 *         [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 */
public class Subsets {

  public ArrayList<ArrayList<Integer>> subsets(int[] S) {

    Arrays.sort(S);
    return helper(S, S.length - 1);
  }


  // This uses relation between Sn and Sn-1
  // Is this DFS ?
  private ArrayList<ArrayList<Integer>> helper(int[] s, int idx) {

    ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

    if (idx < 0) {
      ArrayList<Integer> empt = new ArrayList<Integer>();
      results.add(empt);
      return results;
    }

    ArrayList<ArrayList<Integer>> prev = helper(s, idx - 1);
    ArrayList<ArrayList<Integer>> curt = new ArrayList<ArrayList<Integer>>();
    for (ArrayList<Integer> a : prev) {
      ArrayList<Integer> b = new ArrayList<Integer>(a);
      b.add(s[idx]);
      curt.add(b);
    }
    results.addAll(prev);
    results.addAll(curt);

    return results;
  }


  public List<List<Integer>> subsetsDFS(int[] S) {

    Arrays.sort(S);
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    List<Integer> tmp = new ArrayList<Integer>();
    rst.add(new ArrayList<Integer>(tmp));

    dfsHelper(S, rst, tmp, 0);

    return rst;
  }


  private void dfsHelper(int[] S, List<List<Integer>> rst, List<Integer> tmp, int pos) {

    for (int i = pos ; i < S.length ; i++) {
      tmp.add(S[i]);
      rst.add(new ArrayList<Integer>(tmp));
      dfsHelper(S, rst, tmp, i + 1);
      tmp.remove(tmp.size() - 1);
    }

  }


  public static void main(String[] args) {

    Subsets s = new Subsets();
    System.out.println(s.subsetsDFS(new int[] {}));
    System.out.println(s.subsetsDFS(new int[] { 1 }));
    System.out.println(s.subsetsDFS(new int[] { 1, 2 }));
    System.out.println(s.subsetsDFS(new int[] { 1, 3, 2 }));
  }
}
