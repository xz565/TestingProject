package lcoj.dp.stock;

// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit.
// You may complete at most two transactions.
//
// Note:
// You may not engage in multiple transactions at the same time
// (ie, you must sell the stock before you buy again).
public class BestTimetoBuyandSellStockIII {

  // from head to tail
  // dp[i+1] = max(dp[i], prices[i+1] - minPrice)
  // from tail to head
  // dp[i-1] = max(dp[i], maxPrice - prices[i-1]);
  public int maxProfit(int[] prices) {

    if (prices.length <= 1) {
      return 0;
    }

    // left to right
    int[] maxFromHead = new int[prices.length];
    int minPrice = prices[0];
    for (int i = 1 ; i < prices.length ; i++) {
      maxFromHead[i] = Math.max(maxFromHead[i - 1], prices[i] - minPrice);
      minPrice = Math.min(minPrice, prices[i]);
    }

    // right to left
    int result = maxFromHead[prices.length - 1];
    int curtMax = 0;
    int maxPrice = prices[prices.length - 1];
    for (int i = prices.length - 2 ; i >= 0 ; i--) {
      maxPrice = Math.max(maxPrice, prices[i + 1]);
      curtMax = Math.max(curtMax, maxPrice - prices[i]);
      if (curtMax + maxFromHead[i] > result) {
        result = curtMax + maxFromHead[i];
      }

    }

    return result;
  }
}
