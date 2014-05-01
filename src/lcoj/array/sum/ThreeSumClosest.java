package lcoj.array.sum;

import java.util.Arrays;

// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
// Return the sum of the three integers.
// You may assume that each input would have exactly one solution.
//
// For example, given array S = {-1 2 1 -4}, and target = 1.
//
// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
public class ThreeSumClosest {

  public int threeSumClosest(int[] num, int target) {

    Arrays.sort(num);
    int closest = Integer.MAX_VALUE;
    int result = 0;

    for (int i = 0 ; i < num.length ; i++) {
      int head = i + 1;
      int tail = num.length - 1;

      while (head < tail) {
        int sum = num[i] + num[head] + num[tail];
        int diff = target - sum;

        if (diff == 0) {
          return sum;
        } else {
          if (Math.abs(diff) < closest) {
            closest = Math.abs(diff);
            result = sum;
          }
        }

        if (diff < 0) {
          tail--;
        } else {
          head++;
        }
      }
    }
    return result;
  }


  public static void main(String[] args) {

    int[] s = { 1, 1, 1, 0 };
    ThreeSumClosest threeSumClosest = new ThreeSumClosest();
    System.out.println(threeSumClosest.threeSumClosest(s, 100));
  }
}
