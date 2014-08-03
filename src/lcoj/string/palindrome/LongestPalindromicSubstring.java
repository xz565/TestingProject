package lcoj.string.palindrome;

// Given a string S, find the longest palindromic substring in S.
// You may assume that the maximum length of S is 1000,
// and there exists one unique longest palindromic substring.
public class LongestPalindromicSubstring {

  // s = "abcdcba";

  // a few ways solving this problem
  // brute force O(N^3)
  // DP O(N^2) space O(N^2)
  //
  // with some observation, can reduce to O(N^2) and constant space
  //
  // there is a linear solution called Manacher's algorithm

  // Here we implememnt the O(N^2) solution with constant space

  // next round, try to understand and implement Manacher's algorithm
  public String longestPalindrome(String s) {

    if (s == null || s.length() == 0) {
      return s;
    }

    String longest = s.substring(0, 1);

    for (int i = 0 ; i < s.length() ; i++) {
      String p1 = helper(s, i, i);
      if (p1.length() > longest.length()) {
        longest = p1;
      }

      String p2 = helper(s, i, i + 1);
      if (p2.length() > longest.length()) {
        longest = p2;
      }
    }

    return longest;
  }


  private String helper(String s, int left, int right) {

    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return s.substring(left + 1, right);
  }


  public static void main(String[] args) {

    LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
    String str = "abcdcbaa";
    System.out.println(longestPalindromicSubstring.longestPalindrome(str));
  }
}
