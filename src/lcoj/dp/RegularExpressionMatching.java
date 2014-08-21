package lcoj.dp;

import lcoj.common.Util;


// Implement regular expression matching with support for '.' and '*'.
//
// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.
//
// The matching should cover the entire input string (not partial).
//
// The function prototype should be:
// bool isMatch(const char *s, const char *p)
//
// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "a*") → true
// isMatch("aa", ".*") → true
// isMatch("ab", ".*") → true
// isMatch("aab", "c*a*b") → true
public class RegularExpressionMatching {

  // a DP problem, similar to Wild Card Matching
  // Need to solve by yourself, no refere to answers

  // DP solution is complex
  public static boolean isMatch_DP(String s, String p) {

    boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

    // if s == 0, set dp to true
    for (int i = 0 ; i <= p.length() ; i++) {
      // dp[i][0] = true;
    }
    dp[0][0] = true;

    // recursion is


    for (int i = 1 ; i <= p.length() ; i++) {
      for (int j = 1 ; j <= s.length() ; j++) {

      }
    }

    Util.printMatrix(dp);
    return dp[p.length()][s.length()];
  }


  // recursive one
  // aa .*
  public static boolean isMatch_TLE(String s, String p) {

    // System.out.println("s: " + s + " p: " + p);

    if (s.isEmpty() && p.isEmpty()) {
      return true;
    }

    // pruning, deal with case:
    // s = "aaaaaaaaaaaaab";
    // p = "a*a*a*a*a*a*a*a*a*a*c";
    // "acaabbaccbbacaabbbb", "a*.*b*.*a*aa*a*"

    // still cannot pass OJ
    while (p.length() >= 4 && p.charAt(1) == '*' && p.charAt(3) == '*') {
      if (p.charAt(0) == p.charAt(2)) {
        p = p.substring(2);
      } else if (p.charAt(0) == '.' || p.charAt(2) == '.') {
        p = ".*" + p.substring(4);
      } else {
        break;
      }
    }


    if (p.length() > 1 && p.charAt(1) == '*') {

      // zero time
      if (isMatch_TLE(s, p.substring(2))) {
        return true;
      }

      if (p.charAt(0) == '.') {
        // one or more times
        for (int j = 0 ; j < s.length() ; j++) {
          if (isMatch_TLE(s.substring(j + 1), p)) {
            return true;
          }
        }

      } else {
        // one or more times
        for (int j = 0 ; j < s.length() ; j++) {
          if (s.charAt(j) == p.charAt(0) && isMatch_TLE(s.substring(j + 1), p)) {
            return true;
          }
        }
      }

    } else {
      if ((!p.isEmpty() && !s.isEmpty()) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
        return isMatch_TLE(s.substring(1), p.substring(1));
      } else {
        return false;
      }
    }

    return false;
  }


  // still need DP
  // recursive cannot pass DP
  public static boolean isMatch(String s, String p) {

    boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
    dp[0][0] = true;

    // aa a* WHY
    for (int i = 1 ; i < p.length() + 1 ; i++) {
      dp[i][0] = p.charAt(i - 1) == '*' ? dp[i - 2][0] : false;
    }

    for (int i = 1 ; i < p.length() + 1 ; i++) {
      for (int j = 1 ; j < s.length() + 1 ; j++) {
        if (p.charAt(i - 1) == '*') {
          dp[i][j] = match(s.charAt(j - 1), p.charAt(i - 2)) ? (dp[i][j - 1] || dp[i - 2][j]) : dp[i - 2][j];
        } else {
          dp[i][j] = match(s.charAt(j - 1), p.charAt(i - 1)) ? dp[i - 1][j - 1] : false;
        }
      }
    }

    return dp[p.length()][s.length()];
  }


  static boolean match(char a, char b) {

    if (a == '.' || b == '.') {
      return true;
    } else {
      return a == b;
    }
  }


  public static void main(String[] args) {

    String s, p;

    s = "aa";
    p = "a";
    System.out.println(s + " " + p + " " + isMatch(s, p));

    s = "aa";
    p = "aa";
    System.out.println(s + " " + p + " " + isMatch(s, p));

    s = "aaa";
    p = "aa";
    System.out.println(s + " " + p + " " + isMatch(s, p));

    s = "aa";
    p = "a*";
    System.out.println(s + " " + p + " " + isMatch(s, p));


    s = "aa";
    p = ".*";
    System.out.println(s + " " + p + " " + isMatch(s, p));

    s = "aab";
    p = "c*a*b";
    System.out.println(s + " " + p + " " + isMatch(s, p));


    s = "aaa";
    p = "aaaa";
    System.out.println(s + " " + p + " " + isMatch(s, p));

    s = "aaaaaaaaaaaaab";
    p = "a*a*a*a*a*a*a*a*a*a*c";
    System.out.println(s + " " + p + " " + isMatch(s, p));

    s = "acaabbaccbbacaabbbb";
    p = "a*.*b*.*a*aa*a*";
    System.out.println(s + " " + p + " " + isMatch(s, p));

    s = "caaabbacbabccabaacb";
    p = "a*b*.*c*c*.*b*abbc";
    System.out.println(s + " " + p + " " + isMatch(s, p));
  }
}
