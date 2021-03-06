package lcoj.dp;

//Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//
//You have the following 3 operations permitted on a word:
//
//a) Insert a character
//b) Delete a character
//c) Replace a character
public class EditDistance {

	// class dp problem
    public int minDistance(String word1, String word2) {
        
    	int len1 = word1.length();
    	int len2 = word2.length();
    	
    	int[][] dp = new int[len1+1][len2+1];
    	
    	for(int i = 0; i < len1 + 1; i++) {
    		for(int j = 0; j < len2 + 1; j++) {
    			if(i == 0) {
    				dp[0][j] = j;
    			} else if(j == 0) {
    				dp[i][0] = i;
    			} else {
    				if(word1.charAt(i-1) == word2.charAt(j-1)) {
    					dp[i][j] = dp[i-1][j-1];
    				} else {
    					int min = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
    					dp[i][j] = min + 1;
    				}
    			}
    		}
    	}
    	
    	return dp[len1][len2];
    }

}
