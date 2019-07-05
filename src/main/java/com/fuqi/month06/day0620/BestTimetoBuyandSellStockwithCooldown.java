package com.fuqi.month06.day0620;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/7/5 17:27
 * @Version V1.0
 */
public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 0){ return 0; }

        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);

        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][0]);
        }

        return dp[n-1][0];
    }
}
