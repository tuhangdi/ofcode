package leetcode.DP;

/**
 * Created by thd on 2017/9/4
 * Say you have an array for which the ith element is the price of a given stock on day i.
 说你有一个数组，第i个元素是第i天给定股票的价格。
 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

 设计一个算法来找到最大的利润。 您可以根据您的需要完成尽可能多的交易（即，多次购买一次并多次出售股票），但有以下限制：
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 您可能不会同时从事多个交易（即，您必须在再次购买之前出售股票）。
 卖出股票后，第二天就不能买股票。 （即冷却1天）

 Example:

 prices = [1, 2, 3, 0, 2]
 maxProfit = 3
 transactions = [buy, sell, cooldown, buy, sell]




 buy[i]  = max(rest[i-1]-price, buy[i-1])
 sell[i] = max(buy[i-1]+price, sell[i-1])
 rest[i] = max(sell[i-1], buy[i-1], rest[i-1])



 buy[i] = max(sell[i-2]-price, buy[i-1])
 sell[i] = max(buy[i-1]+price, sell[i-1])

 */
public class n309BestTime {
    public int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}
