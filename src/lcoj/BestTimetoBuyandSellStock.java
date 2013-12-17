package lcoj;

public class BestTimetoBuyandSellStock {

	// O(N^2) TLE
    public int maxProfitBad(int[] prices) {
     
    	int max = 0;
    	for(int i = 0; i < prices.length; i++) {
    		for( int j = i + 1; j < prices.length; j++) {
    			int diff = prices[j] - prices[i];
    			if(diff > max) {
    				max = diff;
    			}
    		}
    	}
    	return max;
    }
    
    // O(N) time
    public int maxProfit(int[] prices) {
        
    	int max = 0;
    	int currtMax = 0;
    	
    	for(int i = 1; i < prices.length; i++) {
    		int diff = prices[i] - prices[i-1];
    		if((diff + currtMax) < 0) {
    			currtMax = 0;
    		} else {
    			currtMax += diff;
    		}
    		
    		if(currtMax > max) {
    			max = currtMax;
    		}
    	}
    	
    	return max;
    }
    
    public static void main(String[] args) {
		int[] prices = {1,4,2};
		
		BestTimetoBuyandSellStock bt = new BestTimetoBuyandSellStock();
		System.out.println(bt.maxProfit(prices));
	}
}
