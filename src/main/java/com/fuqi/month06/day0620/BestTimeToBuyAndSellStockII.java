package com.fuqi.month06.day0620;

/**
 * @Description:
 * 假设你有一个数组，其中第i个元素是第一天给定股票的价格。
 * 您可以完成任意数量的事务(即，买进一股，再卖出一股)。
 * 注:你不可同时进行多项交易(即，你必须先把股票卖了再买)。
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * @Author 傅琦
 * @Date 2019/6/20 9:37
 * @Version V1.0
 */
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII sellStockII = new BestTimeToBuyAndSellStockII();
        int[] input = {1, 7, 2, 3, 6, 7, 6, 7};
        int res = sellStockII.methodDP(input);
        System.out.println("res = " + res);
    }

    public int maxProfit(int[] prices) {
        return calculate(prices, 0);
//        return method1(prices);
    }

    /**
     * 暴力法: 很容易超时
     * O(n^n)
     * O(n)
     */
    public int calculate(int prices[], int s) {
        if (s >= prices.length) {
            return 0;
        }
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit) {
                        maxprofit = profit;
                    }
                }
            }
            if (maxprofit > max) {
                max = maxprofit;
            }
        }
        return max;
    }

    /**
     * DP
     */
    public int methodDP(int[] prices){
        if (prices == null || prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }

    /**
     * 峰谷法
     * @param prices
     * @return
     */
    public int method1(int[] prices){
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxprofit += (peak - valley);
        }
        return maxprofit;
    }

    /**
     * Simple One Pass
     *
     * Time complexity : O(n)
     * Space complexity: O(1)
     *
     * @param prices
     * @return
     */
    public int method2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }
}
