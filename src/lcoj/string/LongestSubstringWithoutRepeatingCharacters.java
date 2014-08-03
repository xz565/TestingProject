package lcoj.string;

import java.util.HashSet;
import java.util.Set;

// Given a string, find the length of the longest substring without repeating characters.
// For example, the longest substring without repeating letters for "abcabcbb" is "abc",
// which the length is 3.
// For "bbbbb" the longest substring is "b", with the length of 1.
public class LongestSubstringWithoutRepeatingCharacters {

  // looks like another example of sliding window problem
  public int lengthOfLongestSubstring(String s) {

    if (s == null || s.length() == 0) {
      return 0;
    }

    Set<Character> set = new HashSet<Character>();
    int maxLen = 1;
    int head = 0;
    int tail = 0;
    set.add(s.charAt(0));

    String max = s.substring(0, 1);


    // this is also a popular for loop style
    // just like a while loop
    for (tail = 1 ; tail < s.length() ;) {

      char ch = s.charAt(tail);
      if (!set.contains(ch)) {
        set.add(ch);
        tail++;

        int temp = tail - head;
        if (temp > maxLen) {
          maxLen = temp;
          max = s.substring(head, tail);
        }

      } else {
        while (s.charAt(head) != ch) {
          set.remove(s.charAt(head));
          head++;
        }
        set.remove(s.charAt(head));
        head++;
      }
    }

    return maxLen;
  }


  public static void main(String[] args) {

    LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
    String str = "";
    // System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(str));
    //
    // str = "a";
    // System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(str));
    //
    // str = "aaa";
    // System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(str));

    str = "hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcac";
    System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(str));


  }
}
