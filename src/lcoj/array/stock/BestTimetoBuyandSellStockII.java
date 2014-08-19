package lcoj.array.stock;

// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit.
// You may complete as many transactions as you like
// (ie, buy one and sell one share of the stock multiple times).
//
// However, you may not engage in multiple transactions at the same time
// (ie, you must sell the stock before you buy again).
public class BestTimetoBuyandSellStockII {

  public int maxProfit(int[] prices) {

    int sum = 0;
    int buyPrice = 0;
    boolean hold = false;

    for (int i = 1 ; i < prices.length ; i++) {
      int diff = prices[i] - prices[i - 1];

      if (hold && diff < 0) {
        hold = false;
        sum += prices[i - 1] - buyPrice;
      } else if (!hold && diff > 0) {
        hold = true;
        buyPrice = prices[i - 1];
      }
    }

    if (hold) {
      sum += prices[prices.length - 1] - buyPrice;
    }
    return sum;
  }


  public static void main(String[] args) {

    int[] prices = { 7, 1, 9, 8 };
    BestTimetoBuyandSellStockII bt = new BestTimetoBuyandSellStockII();
    System.out.println(bt.maxProfit(prices));
  }
}
