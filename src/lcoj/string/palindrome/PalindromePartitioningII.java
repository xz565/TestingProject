package lcoj.string.palindrome;

// Given a string s, partition s such that every substring of the partition is a palindrome.
//
// Return the minimum cuts needed for a palindrome partitioning of s.
//
// For example, given s = "aab",
// Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
public class PalindromePartitioningII {

  // fabccbad

  // can get all the palindrome like previous question,
  // and then get the smallest list
  // but obviously, there are better solution

  // at first glance, there is only one string, so looks like a one dimension DP question
  // However, need to judge substring between i and j, so two dimension are required
  //
  // Actually, the judgment of this problem only require one dimension
  // but need a two dimension map for help


  // 真是要给大神跪了，这么高端的解法。。

  // This helper dp can also be applied to the first solution
  // after build the helper array, we need to apply DSF to find all the possible cuts
  public int minCut(String s) {

    if (s == null || s.isEmpty() || s.length() == 1) {
      return 0;
    }

    // helper[i][j] means substring between i and j is palindrome
    // recursion function is helper[i][j] = (helper[i+1][j-1] && s[i] == s[j]) || (j-i<2) &&s[i] == s[j])
    //
    // dp[i] means min cut between i and end of string
    // recursion function is dp[i] = min(dp[i], dp[j+1]+1) if helper[i][j] is true
    boolean[][] helper = new boolean[s.length()][s.length()];
    int[] dp = new int[s.length() + 1];

    for (int i = s.length() - 1 ; i >= 0 ; i--) {
      dp[i] = s.length() - i;
      for (int j = i ; j < s.length() ; j++) {
        if (s.charAt(i) == s.charAt(j)) {
          if (j - i < 2 || helper[i + 1][j - 1]) {
            helper[i][j] = true;
            dp[i] = Math.min(dp[i], dp[j + 1] + 1);
          }
        }
      }
    }

    return dp[0] - 1;
  }
}
