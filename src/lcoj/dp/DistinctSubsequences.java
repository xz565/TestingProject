package lcoj.dp;

// Given a string S and a string T, count the number of distinct subsequences of T in S.
//
// A subsequence of a string is a new string which is formed from the original string
// by deleting some (can be none) of the characters without disturbing the relative positions of
// the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//
// Here is an example:
// S = "rabbbit", T = "rabbit"
//
// Return 3.

// Sometimes, it takes some effort to understand the question
// In this case, simply solution is find all subsequence of S,
// and see how many of them equals to T
//
// An experience is sometimes the example given by the question is tricky and misleading
// In this cases, In S, only remove one single bit, then can form T
// but we also need to consider cases when multiple bits need to be removed
public class DistinctSubsequences {

  // simple solution is to find all subsequence and count the match
  public int numDistinct_TLE(String S, String T) {

    // ask what to return when S == T
    if (S.equals(T)) {
      return 1;
    }

    int count = 0;
    // this method, the two for loop are M*N time complexity
    // but the equals function inside the loop need another M time
    // so it's O(M^3) time complexity
    for (int i = 0 ; i < S.length() ; i++) {
      for (int j = i ; j < S.length() ; j++) {
        StringBuffer sb = new StringBuffer(S);
        sb.deleteCharAt(i);
        if (i != j) {
          sb.deleteCharAt(j - 1);
        }
        if (T.equals(sb.toString())) {
          count++;
        }
      }
    }

    return count;
  }


  // When you see string problem that is about subsequence or matching,
  // dynamic programming method should come to your mind naturally.
  // The key is to find the changing condition.

  // DP solution, still cannot come up with this kind of solution
  // understand and remember it
  // Let W(i, j) stand for the number of subsequences of S(0, i) in T(0, j).
  // If S.charAt(i) == T.charAt(j), W(i, j) = W(i-1, j-1) + W(i-1,j);
  // Otherwise, W(i, j) = W(i-1,j).
  public int numDistinct(String S, String T) {

    // each string starts at position 1 and ends at length
    int[][] dpTable = new int[S.length() + 1][T.length() + 1];

    for (int i = 0 ; i <= S.length() ; i++) {
      // at position 0 of S, all equals to 0, default value
      // at position 0 of T, all equals to 1, override position 0,0
      dpTable[i][0] = 1;
    }

    // this is a O(M*N) solution with M*N space
    // cab by future optimized to N space
    for (int i = 1 ; i <= S.length() ; i++) {
      for (int j = 1 ; j <= T.length() ; j++) {
        if (S.charAt(i - 1) == T.charAt(j - 1)) {
          dpTable[i][j] = dpTable[i - 1][j - 1] + dpTable[i - 1][j];
        } else {
          dpTable[i][j] = dpTable[i - 1][j];
        }
      }
    }

    return dpTable[S.length()][T.length()];
  }


  public static void main(String[] args) {

    String S = "rabbbiit";
    String T = "rabbit";


    DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
    System.out.println(distinctSubsequences.numDistinct(S, T));
  }
}
