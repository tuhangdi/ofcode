package leetcode.Array;

/**
 * Created by thd on 2017/8/21
 *
 Say you have an array for which the ith element is the price of a given stock on day i.
 说你有一个数组，第i个元素是第i天给定股票的价格。
 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 如果只允许最多完成一个交易（即购买一个交易并且卖出一个股票），则设计一个算法来找到最大利润。
 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 Example 2:
 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.


 为什么maxCur = Math.max（0，maxCur + = price [i] - price [i-1]）; ？

 那么，我们可以假设opt（i）是您在第i天出售股票时将获得的最大利润;

 我们现在面临两种情况：

 1.我们在第i天持有股票，这意味着opt（i）= opt（i - 1） - price[i - 1] +price[i]
    在第（i-1）天卖出股票可获得的最大利润 - 第（i-1）天购买股票将失去的金钱 + 在第i天出售股票所获得的金额。

 2.我们在第i天不持有股票，这意味着我们不能在第i天出售任何股票。在这种情况下，我们在第i天可以得到的钱是0;

 opt（i）是1和2的最佳情况。

 所以，opt（i）= Max {opt（i - 1） - price[i - 1] + price[i]，0}

 */


public class n121BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {// 类似于求最大子数组时用到的Kadane's Algorithm，优化后的dp
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
