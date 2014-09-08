package lcoj.dp.jumpgame;


// Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Determine if you are able to reach the last index.
//
// For example:
// A = [2,3,1,1,4], return true.
//
// A = [3,2,1,0,4], return false.
public class JumpGame {

  public boolean canJumpTLE(int[] A) {

    boolean[] dp = new boolean[A.length];
    dp[dp.length - 1] = true;

    for (int i = dp.length - 2 ; i >= 0 ; i--) {
      for (int j = 1 ; j <= A[i] ; j++) {
        if (i + j < A.length && dp[i + j]) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[0];
  }


  // this is actually a pruning technique
  public boolean canJump(int[] A) {

    outer: for (int i = 0 ; i < A.length - 1 ; i++) {
      if (A[i] == 0) {
        int j = 1;
        while (i - j >= 0) {
          if (A[i - j] > j) {
            continue outer;
          } else {
            j++;
          }
        }
        return false;
      }
    }

    return true;
  }


  // one dimension DP
  // 一维DP，定义 jump[i]为从index 0 走到第i步时，剩余的最大步数。
  // jump[i] = max(jump[i-1], A[i-1]) -1, i!=0
  // = 0 , i==0
  public boolean canJump_DP(int[] A) {

    int[] jump = new int[A.length];
    for (int i = 1 ; i < A.length ; i++) {
      jump[i] = Math.max(jump[i - 1], A[i - 1]) - 1;
      if (jump[i] < 0) {
        return false;
      }
    }
    return jump[A.length - 1] >= 0;

  }


  public static void main(String[] args) {

    int[] A = { 3, 2, 1, 0, 4 };
    JumpGame jumpGame = new JumpGame();
    System.out.println(jumpGame.canJump(A));
  }
}
