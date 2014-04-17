package lcoj.recursive.permutations;

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
    System.out.println(p.permuteUnique(num));
  }
}
