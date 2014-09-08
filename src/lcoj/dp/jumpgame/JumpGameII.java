package lcoj.dp.jumpgame;


// Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Your goal is to reach the last index in the minimum number of jumps.
//
// For example:
// Given array A = [2,3,1,1,4]
//
// The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
public class JumpGameII {

  // simple DFS, TLE
  public int jumpTLE(int[] A) {

    return helper(A, 0, 0);
  }


  private int helper(int[] A, int idx, int count) {

    if (idx >= A.length - 1) {
      return count;
    }

    int min = Integer.MAX_VALUE;
    for (int i = A[idx] ; i >= 1 ; i--) {
      int temp = helper(A, idx + i, count + 1);
      if (temp < min) {
        min = temp;
      }
    }
    return min;
  }


  public int jump_TLE2(int[] A) {

    int[] dp = new int[A.length];
    helper(A, 0, 0, dp);
    // System.out.println(Arrays.toString(dp));
    return dp[A.length - 1];
  }


  private int helper(int[] A, int idx, int count, int[] dp) {

    if (idx >= A.length - 1) {
      if (dp[A.length - 1] == 0 || count < dp[A.length - 1]) {
        dp[A.length - 1] = count;
      }
      return dp[A.length - 1];
    }

    if (dp[idx] == 0 || count < dp[idx]) {
      int min = Integer.MAX_VALUE;
      for (int i = A[idx] ; i >= 1 ; i--) {
        int temp = helper(A, idx + i, count + 1, dp);
        if (temp < min) {
          min = temp;
        }
      }
      dp[idx] = min;
    }
    return dp[idx];
  }


  // A = [2,3,1,1,4]
  // This is greedy
  public int jump_greedy(int[] A) {

    int idx = 0;
    int jumpCount = 0;
    while (idx < A.length - 1) {
      int max = 0;
      int tempIdx = idx;
      for (int i = 0 ; i <= A[tempIdx] ; i++) {
        if (tempIdx + i < A.length) {
          if (i + A[tempIdx + i] > max && A[tempIdx + i] != 0) {
            max = i + A[tempIdx + i];
            idx = tempIdx + i;
          }
        } else {
          idx = A.length;
          break;
        }
      }
      // System.out.println(idx);
      jumpCount++;
    }

    return jumpCount;
  }


  public int jump(int[] A) {

    if (A == null) {
      return 0;
    }
    int len = A.length;
    if (len == 0 || len == 1) {
      return 0;
    }

    int cur = 0;
    int next = 0;
    int ret = 0;

    for (int i = 0 ; i < len ; i++) {
      if (i > cur) {
        cur = next;
        ret++;
      }
      next = Math.max(next, i + A[i]);
    }
    return ret;
  }


  public static void main(String[] args) {

    int[] A = { 5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5 };
    JumpGameII jumpGameII = new JumpGameII();
    System.out.println(jumpGameII.jump(A));

    // int[] B = new int[25000];
    // for (int i = 0 ; i < 25000 ; i++) {
    // B[i] = 25000 - i;
    // }
    int[] B = { 3, 4, 3, 1, 0, 7, 0, 3, 0, 2, 0, 3 };
    // long startTime = System.currentTimeMillis();
    System.out.println(jumpGameII.jump(B));
    // System.out.println(System.currentTimeMillis() - startTime);

    int[] C = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    System.out.println(jumpGameII.jump(C));
  }
}
