package lcoj.recursive;

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


  public static void main(String[] args) {

    Permutations p = new Permutations();
    int[] num = { 1, 2, 3, 4 };
    System.out.println(p.permute(num).size());
  }
}
