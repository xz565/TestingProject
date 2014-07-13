package lcoj.array;

import java.util.HashSet;
import java.util.Set;

// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
// For example,
// Given [100, 3, 200, 1, 4, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
// Your algorithm should run in O(n) complexity
public class LongestConsecutiveSequence {

  // use HashTable, save time by using some extra space
  public int longestConsecutive(int[] num) {

    Set<Integer> set = new HashSet<Integer>();
    for (int i : num) {
      set.add(i);
    }

    int max = 0;
    for (int curt : num) {

      int left = curt - 1;
      int right = curt + 1;
      int count = 1;

      while (set.contains(left)) {
        set.remove(left); // save some time, will TLE if not remove this
        left--;
        count++;
      }

      while (set.contains(right)) {
        set.remove(right);
        right++;
        count++;
      }

      if (count > max) {
        max = count;
      }
    }

    return max;
  }


  public static void main(String[] args) {

    int[] num = { 100, 3, 200, 1, 4, 2 };
    LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
    System.out.println(longestConsecutiveSequence.longestConsecutive(num));
  }
}
