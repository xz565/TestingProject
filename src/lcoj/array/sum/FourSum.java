package lcoj.array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
// Find all unique quadruplets in the array which gives the sum of target.
//
// Note:
// Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
// The solution set must not contain duplicate quadruplets.
// For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
//
// A solution set is:
// (-1, 0, 0, 1)
// (-2, -1, 1, 2)
// (-2, 0, 0, 2)
public class FourSum {

  // there is a O(N^2) solution, so smart!
  // Get N^2 pairs, then take two pairs whose sum == target
  // will do it later


  // This is O(N^3) solution
  public List<List<Integer>> fourSum(int[] num, int target) {

    Arrays.sort(num);
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    Set<List<Integer>> set = new HashSet<List<Integer>>();

    for (int i = 0 ; i < num.length ; i++) {
      for (int j = i + 1 ; j < num.length ; j++) {

        int head = j + 1;
        int tail = num.length - 1;
        while (head < tail) {
          int sum = num[i] + num[j] + num[head] + num[tail];
          if (sum > target) {
            tail--;
          } else if (sum < target) {
            head++;
          } else { // sum == target
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(num[i]);
            temp.add(num[j]);
            temp.add(num[head]);
            temp.add(num[tail]);

            if (!set.contains(temp)) {
              set.add(temp);
              results.add(temp);
            }
          }

          head++;
          tail--;
        }
      }
    }

    return results;
  }


  public static void main(String[] args) {

  }
}
