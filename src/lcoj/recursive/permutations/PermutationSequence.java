package lcoj.recursive.permutations;

import java.util.ArrayList;
import java.util.List;

// The set [1,2,3,…,n] contains a total of n! unique permutations.
//
// By listing and labeling all of the permutations in order,
// We get the following sequence (ie, for n = 3):
//
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.
//
// Note: Given n will be between 1 and 9 inclusive.
public class PermutationSequence {

  // For example, n = 4 and k = 17
  // (n-1)! = 3! = 6
  // 17/6 = 2
  // so first number is 3
  // then n = [1,2,4] and k = 17 - 6*2 = 5 recursive

  // n=3 (3-1)! = 2
  // 5 / 2 = 2
  // so second number is 4

  // This is more like a math problem rather than a coding question
  public String getPermutation(int n, int k) {

    List<Integer> list = new ArrayList<Integer>();
    for (int i = 1 ; i <= n ; i++) {
      list.add(i);
    }

    return helper(n, k, list);

  }


  private String helper(int n, int k, List<Integer> list) {


    if (n == 1) {
      return String.valueOf(list.get(0));
    }

    int fac = factory(n - 1);
    int numIdx = k / fac;
    if (k % fac == 0) {
      numIdx--;
    }

    int num = list.get(numIdx);
    list.remove(new Integer(num));

    return String.valueOf(num) + helper(n - 1, k - fac * numIdx, list);
  }


  private int factory(int n) {

    int rst = 1;

    for (int i = 1 ; i <= n ; i++) {
      rst *= i;
    }
    return rst;
  }


  public static void main(String[] args) {

    //
    // List<Integer> list = new ArrayList<Integer>();
    // list.add(1);
    // list.add(2);
    // list.add(3);
    // System.out.println(list.get(0));

    PermutationSequence permutationSequence = new PermutationSequence();
    System.out.println(permutationSequence.getPermutation(3, 1));
    System.out.println(permutationSequence.getPermutation(3, 2));
    System.out.println(permutationSequence.getPermutation(3, 3));
    System.out.println(permutationSequence.getPermutation(3, 4));
    System.out.println(permutationSequence.getPermutation(3, 5));
    System.out.println(permutationSequence.getPermutation(3, 6));
    System.out.println(permutationSequence.getPermutation(4, 17));
  }
}
