package lcoj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {

  Set<String> cache = new HashSet<String>();


  public boolean wordBreak(String s, Set<String> dict) {

    if (s.length() == 0) {
      return true;
    }

    for (int i = 1 ; i <= s.length() ; i++) {
      String subStr = s.substring(0, i);
      if (dict.contains(subStr)) {

        String subStr2 = s.substring(i);
        if (cache.contains(subStr2)) {
          return false;
        } else {
          if (wordBreak(subStr2, dict)) {
            return true;
          } else {
            cache.add(subStr2);
            return false;
          }
        }

      }
    }
    return false;
  }


  public static void main(String[] args) {

    Set<String> dict = new HashSet<String>();
    String[] strings = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa" };
    dict.addAll(Arrays.asList(strings));

    WordBreak wb = new WordBreak();
    String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    System.out.println(wb.wordBreak(s, dict));
  }
}
