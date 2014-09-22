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

  // simple though, at each position, check left and right until unmatched
  // and keep the longest
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


  // dp from left to right
  public String longestPalindrome_dp(String s) {

    int len = s.length();

    int startIdx = 0;
    int maxLen = 0;

    boolean[][] dp = new boolean[len][len];

    for (int i = 0 ; i < len ; i++) {
      dp[i][i] = true;

      startIdx = i;
      maxLen = 1;
    }

    for (int i = 0 ; i < len ; i++) {
      if (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
        dp[i][i + 1] = true;

        startIdx = i;
        maxLen = 2;
      }
    }


    for (int l = 3 ; l <= len ; l++) {
      for (int start = 0 ; start < len - l + 1 ; start++) {

        if (s.charAt(start) == s.charAt(start + l - 1) && dp[start + 1][start + l - 2]) {
          dp[start][start + l - 1] = true;

          startIdx = start;
          maxLen = l;
        }
      }
    }


    // System.out.println(startIdx + " " + maxLen);

    return s.substring(startIdx, startIdx + maxLen);
  }


  // æ ¹æ�® PalindromePartitioningII è¿™é�“é¢˜çš„æµ�å¼Šè§£æ³•ï¼Œç»™å‡ºä¸€æ›´ç®€æ´�çš„dp
  // dp from right to left, more neat and less error
  
  // dp[i][j] = s[i] == s[j] && (dp[i+1][j-1] || j-1 < 2)
  public String longestPalindrome_dp2(String s) {

    int len = s.length();

    boolean[][] dp = new boolean[len][len];

    int start = 0;
    int end = 0;
    int max = 0;

    for (int i = s.length() - 1 ; i >= 0 ; i--) {
      for (int j = i ; j < s.length() ; j++) {
        if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {

          dp[i][j] = true;

          if (j - i > max) {
            max = j - i;
            start = i;
            end = j;
          }
        }
      }
    }

    return s.substring(start, end + 1);
  }


  public static void main(String[] args) {

    LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
    String str = "abcdcbaa";
    System.out.println(longestPalindromicSubstring.longestPalindrome_dp2(str));

    str = "ccc";
    System.out.println(longestPalindromicSubstring.longestPalindrome_dp2(str));
  }
}
