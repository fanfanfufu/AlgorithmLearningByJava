package com.fuqi.month06.day0620;

/**
 * @Description: 买卖股票问题加上手续费
 * @Author: 傅琦
 * @DateTime: 2019/7/5 23:49
 * @Version: V1.0
 */
public class BestTimetoBuyandSellStockwithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n < 2){ return 0; }

        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return dp[n-1][0];
    }
}
