package lcoj.string.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


// Given a string S and a string T, find the minimum window in S
// which will contain all the characters in T in complexity O(n).
// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".
//
// Note:
// If there is no such window in S that covers all characters in T, return the emtpy string "".
//
// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
public class MinimumWindowSubstring {

  // The algorithm is not hard to come up with
  // but takes some efforts to implement it.
  // wrong implementation
  public String minWindow_Bad(String S, String T) {

    String shorest = "";

    if (S == null || T == null || S.isEmpty() || T.isEmpty()) {
      return shorest;
    }

    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0 ; i < T.length() ; i++) {
      if (map.containsKey(T.charAt(i))) {
        map.put(T.charAt(i), map.get(T.charAt(i) + 1));
      } else {
        map.put(T.charAt(i), 1);
      }
    }

    Set<Character> charSet = new HashSet<Character>();
    charSet.addAll(map.keySet());

    int headIdx = -1;
    int tailIdx = -1;

    // first step, find a substring that contains all the characters in T
    for (int i = 0 ; i < S.length() ; i++) {
      char ch = S.charAt(i);
      if (map.keySet().contains(ch)) {

        if (headIdx == -1) {
          headIdx = i;
        }

        int count = map.get(ch);
        if (count == 1) {
          map.remove(ch);
        } else {
          map.put(ch, --count);
        }
      }

      if (map.isEmpty()) {
        tailIdx = i;
        shorest = S.substring(headIdx, tailIdx + 1);
        break;
      }
    }

    if (headIdx == -1 || !map.isEmpty()) {
      return shorest;
    }


    // second step, shorten the window
    for ( ; tailIdx < S.length() ; tailIdx++) {

      char tailCh = S.charAt(tailIdx);
      if (charSet.contains(tailCh)) {

        if (S.charAt(headIdx) == tailCh) {
          headIdx++;
          for ( ; headIdx < tailIdx ; headIdx++) {

            char headCh = S.charAt(headIdx);
            if (charSet.contains(headCh)) {

              if (map.keySet().contains(headCh)) {

                Integer count = map.get(headCh);
                if (count == 1) {
                  map.remove(headCh);
                } else {
                  map.put(headCh, --count);
                }

              } else {

                if (tailIdx - headIdx + 1 < shorest.length()) {
                  shorest = S.substring(headIdx, tailIdx + 1);
                }
                break;
              }
            }
          }

        } else {
          Integer count = map.get(tailCh);
          if (count == null) {
            map.put(tailCh, 1);
          } else {
            map.put(tailCh, count + 1);
          }
        }
      }
    }


    return shorest;
  }


  // This is one of the typical window problems
  // can be solved with a hash map and a pair of pointer
  // the positive, negative and zero value in the map have different meaning
  // and it's key to utilize these info properly.
  public String minWindow(String S, String T) {

    String shorest = "";
    if (S == null || T == null || S.isEmpty() || T.isEmpty()) {
      return shorest;
    }

    // Put chars in T and count in a map
    // This map is the key to solve this problem.
    // # in the map represent how many chars are still needed between head and tail.
    // If the number is smaller than zero, that means there are more chars than needed
    // and the head pointer can move forward
    Map<Character, Integer> map = new HashMap<Character, Integer>();
    for (int i = 0 ; i < T.length() ; i++) {
      char ch = T.charAt(i);
      if (map.containsKey(ch)) {
        map.put(ch, map.get(ch) + 1);
      } else {
        map.put(ch, 1);
      }
    }

    // System.out.println(map);

    int count = 0;
    int head = 0;
    int minLen = Integer.MAX_VALUE;
    // iterate through each char in S
    for (int tail = 0 ; tail < S.length() ; tail++) {

      if (map.containsKey(S.charAt(tail))) {
        char tailCh = S.charAt(tail);
        map.put(tailCh, map.get(tailCh) - 1);
        if (map.get(tailCh) >= 0) {
          count++;
        }

        while (count == T.length()) {

          if (map.containsKey(S.charAt(head))) {

            // the substring operation many consume too much time
            // After remove this operation, got ACed
            int tempLen = tail + 1 - head;
            if (tempLen < minLen) {
              // String temp = S.substring(head, tail + 1);
              shorest = S.substring(head, tail + 1);
              minLen = shorest.length();
            }


            char headCh = S.charAt(head);
            map.put(headCh, map.get(headCh) + 1);
            if (map.get(headCh) > 0) {
              count--;
            }
          }
          head++;
        }
      }
    }

    return shorest;
  }


  public static void main(String[] args) {

    MinimumWindowSubstring minSubWin = new MinimumWindowSubstring();
    String S = "";
    String T = "";

    S = "ADOBECODEBANC";
    T = "ABC";
    System.out.println("min:" + minSubWin.minWindow(S, T) + ":");

    S = "";
    T = "";
    System.out.println("min:" + minSubWin.minWindow(S, T) + ":");

    S = "A";
    T = "";
    System.out.println("min:" + minSubWin.minWindow(S, T) + ":");

    S = "";
    T = "A";
    System.out.println("min:" + minSubWin.minWindow(S, T) + ":");

    S = "ADOBECODEBANC";
    T = "AABC";
    System.out.println("min:" + minSubWin.minWindow(S, T) + ":");

    S = "ADOBECODEBANC";
    T = "ABCD";
    System.out.println("min:" + minSubWin.minWindow(S, T) + ":");

    S = "bba";
    T = "ab";
    System.out.println("min:" + minSubWin.minWindow(S, T) + ":");
  }
}
