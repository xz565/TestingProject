package lcoj.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

  // O(N^2) solution
  // obvious this solution has lots of duplication may be cause TLE
  // may be DP can save some effort

  // similar to min window substring
  // we maintain a window to reduce the time complexity to linear
  public List<Integer> findSubstring(String S, String[] L) {

    List<Integer> rst = new ArrayList<Integer>();
    if (S == null || L == null || L.length == 0) {
      return rst;
    }
    final int LEN = L[0].length();
    Set<String> set = new HashSet<String>();
    set.addAll(Arrays.asList(L));
    int outerIdx = 0;
    while (outerIdx < S.length()) {
      String str = S.substring(outerIdx, outerIdx + LEN);
      if (set.contains(str)) {
        outerIdx += LEN;
        set.remove(str);
      } else {
        outerIdx++;
      }
    }

    return rst;
  }


  public static void main(String[] args) {

    String S = "barfoothefoobarman";
    String[] L = {};

    SubstringwithConcatenationofAllWords substringwithConcatenationofAllWords = new SubstringwithConcatenationofAllWords();
    System.out.println(substringwithConcatenationofAllWords.findSubstring(S, L));
  }
}
