package com.fuqi.year2023.month10;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/10/5 11:39
 * @description 309. 买卖股票的最佳时机含冷冻期
 */
public class Solution00309 {
    /**
     * dp[i][0]表示截止到第i天没有持有股票的最大利润
     * dp[i][1]表示截止到第i天持有股票的最大利润
     *
     * @param prices 每天的股票价格
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;
        if (n == 2) return prices[1] > prices[0] ? prices[1] - prices[0] : 0;

        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);

        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[n-1][0];
    }
}
