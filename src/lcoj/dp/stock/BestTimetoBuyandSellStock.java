package lcoj.dp.stock;

// Say you have an array for which the ith element is the price of a given stock on day i.
//
// If you were only permitted to complete at most one transaction
// (ie, buy one and sell one share of the stock),
// design an algorithm to find the maximum profit.
public class BestTimetoBuyandSellStock {

  // O(N^2) TLE
  public int maxProfitBad(int[] prices) {

    int max = 0;
    for (int i = 0 ; i < prices.length ; i++) {
      for (int j = i + 1 ; j < prices.length ; j++) {
        int diff = prices[j] - prices[i];
        if (diff > max) {
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

    for (int i = 1 ; i < prices.length ; i++) {
      int diff = prices[i] - prices[i - 1];
      if ((diff + currtMax) < 0) {
        currtMax = 0;
      } else {
        currtMax += diff;
      }

      if (currtMax > max) {
        max = currtMax;
      }
    }

    return max;
  }


  // dp[i] is the max profit between [0,i]
  // max profit at a point i is prices[i] - minPrice
  // so the recursion is: dp[i+1] = max(dp[i], prices[i+1] - minPrice)
  // where minPrice is the min price between [0,i]
  //
  // This one is easier to understand than the previous one, which is too tricky
  public int maxProfit_DP(int[] prices) {

    if (prices.length == 0) {
      return 0;
    }

    int[] dp = new int[prices.length];

    int max = 0;
    int minPrice = prices[0];
    for (int i = 1 ; i < prices.length ; i++) {
      dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
      minPrice = Math.min(minPrice, prices[i]);

      if (dp[i] > max) {
        max = dp[i];
      }
    }

    return max;
  }


  public static void main(String[] args) {

    int[] prices = { 1, 4, 2 };

    BestTimetoBuyandSellStock bt = new BestTimetoBuyandSellStock();
    System.out.println(bt.maxProfit(prices));
  }
}
