package lcoj.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

  static Map<String, Integer> map = new HashMap<String, Integer>();


  // key points:
  // 1) the process of 0
  // 2) recursive with dp
  // 3) prcess of last two bits
  public static int numDecodings(String s) {

    if (map.containsKey(s)) {
      return map.get(s);
    }

    if (s.length() == 0 || s.charAt(0) == '0') {
      return 0;
    }

    if (s.length() == 1) {
      return 1;
    }

    int fix = (s.length() == 2 ? 1 : 0);

    int ways;

    if (s.charAt(0) == '1' || (s.charAt(0) == '2' && Integer.parseInt("" + s.charAt(1)) < 7)) {
      ways = numDecodings(s.substring(1)) + numDecodings(s.substring(2)) + fix;
      map.put(s, ways);
      return ways;
    }

    ways = numDecodings(s.substring(1));
    map.put(s, ways);
    return ways;
  }


  // right to left DP
  // dp[i] = 0 if s[i] is 0
  // dp[i] = dp[i+1] if s[i] != 0
  // dp[i] += dp[i+2] if s[i]s[i+1] < 27
  public static int numDecodings_dp(String s) {

    int[] dp = new int[s.length() + 1];
    dp[s.length()] = 1;

    for (int i = s.length() - 1 ; i >= 0 ; i--) {

      if (s.charAt(i) == '0') {
        dp[i] = 0;
      } else {
        dp[i] = dp[i + 1];

        if (i + 2 <= s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
          dp[i] += dp[i + 2];
        }
      }

    }

    System.out.println(Arrays.toString(dp));
    return dp[0];
  }


  public static void main(String[] args) {

    System.out.println(numDecodings_dp("110"));
  }
}
