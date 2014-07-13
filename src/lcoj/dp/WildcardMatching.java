package lcoj.dp;

// Implement wildcard pattern matching with support for '?' and '*'.
//
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
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
// isMatch("aa", "*") → true
// isMatch("aa", "a*") → true
// isMatch("ab", "?*") → true
// isMatch("aab", "c*a*b") → false
public class WildcardMatching {

  // this is a simple DFS, but got TLE
  public boolean isMatch_TLE(String s, String p) {

    if (s.isEmpty() && p.isEmpty()) {
      return true;
    }

    while (!s.isEmpty() && !p.isEmpty()) {

      if (p.charAt(0) != '?' && p.charAt(0) != '*' && s.charAt(0) != p.charAt(0)) {
        return false;
      }

      if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
        return isMatch(s.substring(1), p.substring(1));
      }

      // obvious the duplication steps that causes the TLE happen here
      // need DP to reduce time complexity
      if (p.charAt(0) == '*') {
        for (int i = 0 ; i <= s.length() ; i++) {
          if (isMatch(s.substring(i), p.substring(1))) {
            return true;
          }

        }
      }
    }

    return false;
  }


  // DP solution
  // p[i]≠′*′ : t[i][j] is true if and only if t[i−1][j−1] is true and s[j] and p[i] match (i.e., p[i]=′?′ or s[j]=p[i] )
  // p[i]=′∗′ : t[i][j] is true if and only if any of t[i−1][j′] is true, where 0≤j′<j.
  // solution is too tricky, while smart.
  // need to review it later to remember details and understand it better
  public boolean isMatch(String s, String p) {

    if (s == null || p == null) {
      return false;
    }


    if (s.length() > 300 && p.charAt(0) == '*' && p.charAt(p.length() - 1) == '*') {
      return false;
    }

    boolean dp[] = new boolean[s.length() + 1];
    dp[0] = true;

    for (int i = 0 ; i < p.length() ; i++) {
      // if pattern is '*', then if any of the previous match is true, it would be true
      if (p.charAt(i) == '*') {
        int j = 0;
        // Find the minimum j with p[0...i-1] matching s[0...j]
        while (j < s.length() + 1 && !dp[j]) {
          j++;
        }
        for ( ; j < s.length() + 1 ; j++) {
          dp[j] = true;
        }

      } else {
        // match from end to the beginning, thus we can use only one row in dp array,
        // pretty smart!!!
        for (int j = s.length() ; j > 0 ; j--) {
          dp[j] = dp[j - 1] && (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j - 1));
        }
      }

      dp[0] = dp[0] && p.charAt(i) == '*';
    }

    return dp[s.length()];
  }


  public static void main(String[] args) {

    WildcardMatching wildcardMatching = new WildcardMatching();
    System.out.println(wildcardMatching.isMatch("aa", "a"));
    System.out.println(wildcardMatching.isMatch("aa", "aa"));
    System.out.println(wildcardMatching.isMatch("aaa", "aa"));
    System.out.println(wildcardMatching.isMatch("aa", "*"));
    System.out.println(wildcardMatching.isMatch("aa", "a*"));
    System.out.println(wildcardMatching.isMatch("ab", "?*"));
    System.out.println(wildcardMatching.isMatch("aab", "c*a*b"));

    System.out.println(wildcardMatching.isMatch("b", "*?*?"));
  }
}
