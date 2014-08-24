package lcoj.string;


// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",
//
// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.
public class InterleavingString {


  public static boolean isInterleave_TLE(String s1, String s2, String s3) {

    System.out.println(s1 + " " + s2 + " " + s3);

    int idx1 = 0;
    int idx2 = 0;
    int idx3 = 0;

    while (idx3 < s3.length()) {

      char ch1 = idx1 < s1.length() ? s1.charAt(idx1) : ' ';
      char ch2 = idx2 < s2.length() ? s2.charAt(idx2) : ' ';
      char ch3 = s3.charAt(idx3);

      if (ch1 == ch3 && ch2 != ch3) {
        idx1++;
      } else if (ch1 != ch3 && ch2 == ch3) {
        idx2++;
      } else if (ch1 == ch3 && ch2 == ch3) {
        // recursion
        return isInterleave(s1.substring(idx1 + 1), s2.substring(idx2), s3.substring(idx3 + 1)) || isInterleave(s1.substring(idx1), s2.substring(idx2 + 1), s3.substring(idx3 + 1));
      } else {
        return false;
      }

      idx3++;
    }

    if (idx1 == s1.length() && idx2 == s2.length() && idx3 == s3.length()) {
      return true;
    } else {
      return false;
    }

  }


  // DP
  // dp[i][j] = dp[i-1][j] || dp[i][j-1]
  // do this later

  // Almooooost solved it by myself, just a little detail!!!
  public static boolean isInterleave(String s1, String s2, String s3) {

    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }

    boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
    dp[0][0] = true;

    for (int i = 1 ; i <= s1.length() ; i++) {
      if (dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)) {
        dp[i][0] = true;
      }
    }

    for (int i = 1 ; i <= s2.length() ; i++) {
      if (dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1)) {
        dp[0][i] = true;
      }
    }

    for (int i = 1 ; i <= s1.length() ; i++) {
      for (int j = 1 ; j <= s2.length() ; j++) {

        if (s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]) {
          dp[i][j] = true;
        } else if (s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1]) {
          dp[i][j] = true;
        }
      }
    }

    // Util.printMatrix(dp);
    return dp[s1.length()][s2.length()];
  }


  public static void main(String[] args) {

    String s1 = "aa";
    String s2 = "a";
    String s3 = "aaba";
    // System.out.println(isInterleave(s1, s2, s3));
    //
    s1 = "aabcc";
    s2 = "dbbca";
    s3 = "aadbbcbcac";
    System.out.println(isInterleave(s1, s2, s3));

  }
}
