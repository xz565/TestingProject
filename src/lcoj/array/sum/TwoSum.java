package lcoj.array.sum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class TwoSum {


  // O(N^2) time; accepted.... what an OJ
  public int[] twoSum2(int[] numbers, int target) {

    for (int i = 0 ; i < numbers.length ; i++) {
      for (int j = i + 1 ; j < numbers.length ; j++) {
        if (numbers[i] + numbers[j] == target) {
          return new int[] { i + 1, j + 1 };
        }
      }
    }

    return null;
  }


  // O(N) time; O(N) space
  public int[] twoSum_Bad(int[] numbers, int target) {

    Map<Integer, Integer> diffMap = new HashMap<Integer, Integer>();
    for (int i = 0 ; i < numbers.length ; i++) {
      diffMap.put(i, target - numbers[i]);
    }

    Set<Integer> diffSet = new HashSet<Integer>(diffMap.values());

    for (int i = 0 ; i < numbers.length ; i++) {
      // collection.contains() is O(N)
      if (diffSet.contains(numbers[i])) {
        for (Entry<Integer, Integer> entry : diffMap.entrySet()) {
          int key = entry.getKey();
          if (key != i && entry.getValue() == numbers[i]) {
            if (i < key) {
              return new int[] { i + 1, key + 1 };
            } else {
              return new int[] { key + 1, i + 1 };
            }
          }
        }
      }
    }

    return null;
  }


  // most optimized
  public int[] twoSum(int[] numbers, int target) {

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int[] rst = new int[2];

    for (int i = 0 ; i < numbers.length ; i++) {
      if (map.containsKey(numbers[i])) {
        rst[0] = map.get(numbers[i]) + 1;
        rst[1] = i + 1;
      } else {
        map.put(target - numbers[i], i);
      }
    }

    return rst;
  }


  // Anther solution is to sort the array first, then a head pointer and a tail pointer, move to middle
  // If we need to return the actually values, this solution is good since time is O(NlgN)
  // But here, we need to return the index. So we need another O(N) space to keep the index info
  //
  // Any way, we used N space, then why not use hash map which is O(N) time

  public static void main(String[] args) {

    int[] numbers = { -3, 4, 3, 90 };
    int target = 0;
    TwoSum twoSum = new TwoSum();
    int[] result = twoSum.twoSum(numbers, target);
    System.out.println(result[0] + " " + result[1]);
  }
}
