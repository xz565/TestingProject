package lcoj.dp;

//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//
//For example:
//A = [2,3,1,1,4], return true.
//
//A = [3,2,1,0,4], return false.
public class JumpGame {

    public boolean canJumpTLE(int[] A) {
        boolean[] dp = new boolean[A.length];
        dp[dp.length-1] = true;
        
        for(int i = dp.length - 2; i >= 0; i--) {
        	for(int j = 1; j <= A[i]; j++) {
        		if(i+j < A.length && dp[i+j]) {
        			dp[i] = true;
        			break;
        		}
        	}
        }
        return dp[0];
    }
    
    public boolean canJump(int[] A) {
    
    	outer:
    	for(int i = 0; i < A.length - 1; i++) {
    		if(A[i] == 0) {
    			int j = 1;
    			while(i-j >= 0) {
    				if(A[i-j] > j) {
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
    
    public static void main(String[] args) {
		int[] A = {3,2,1,0,4};
		JumpGame jumpGame = new JumpGame();
		System.out.println(jumpGame.canJump(A));
	}
}
