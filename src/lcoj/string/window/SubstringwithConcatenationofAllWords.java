package lcoj.string.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// You are given a string, S, and a list of words, L, that are all of the same length.
// Find all starting indices of substring(s) in S that is a concatenation of each word
// in L exactly once and without any intervening characters.
//
// For example, given:
// S: "barfoothefoobarman"
// L: ["foo", "bar"]
//
// You should return the indices: [0,9].
// (order does not matter).
public class SubstringwithConcatenationofAllWords {

  // similar to min window substring
  // we maintain a sliding window to reduce the time complexity to linear

  // This is actually O(N^2) solution
  public static List<Integer> findSubstring_BAD(String S, String[] L) {

    List<Integer> rst = new ArrayList<Integer>();
    if (S == null || L == null || L.length == 0) {
      return rst;
    }
    final int LEN = L[0].length();

    Map<String, Integer> LMap = new HashMap<String, Integer>();
    for (String str : L) {
      if (!LMap.containsKey(str)) {
        LMap.put(str, 0);
      }
      LMap.put(str, LMap.get(str) + 1);
    }


    int head = 0;
    while (S.length() - head >= LEN * L.length) {

      String headTemp = S.substring(head, head + LEN);

      System.out.println(LMap);
      System.out.println(headTemp);

      if (LMap.containsKey(headTemp)) {
        Map<String, Integer> tempMap = new HashMap<String, Integer>(LMap);

        int tail = head;
        while (tail < S.length()) {

          // System.out.println(tempMap);

          String temp = S.substring(tail, tail + LEN);

          if (tempMap.containsKey(temp) && tempMap.get(temp) == 1) {
            tempMap.remove(temp);
          } else if (!tempMap.containsKey(temp)) {
            break;
          } else {
            tempMap.put(temp, tempMap.get(temp) - 1);
          }

          if (tempMap.isEmpty()) {
            rst.add(head);
            break;
          }

          tail += LEN;
        }
      }

      head++;
    }

    return rst;
  }


  // looks like the slidig window solution is complex
  public static List<Integer> findSubstring(String S, String[] L) {

    return null;
  }


  public static void main(String[] args) {

    String S = "barfoothefoobarman";
    String[] L = { "foo", "bar" };
    System.out.println(findSubstring(S, L));

    S = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
    String[] L1 = { "fooo", "barr", "wing", "ding", "wing" };
    System.out.println(findSubstring(S, L1));
  }
}
