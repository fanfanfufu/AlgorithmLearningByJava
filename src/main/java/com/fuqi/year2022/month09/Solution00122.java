package com.fuqi.year2022.month09;

/**
 * @author FuQi
 * @date 2022/9/13 22:28
 * @description 买卖股票的最佳时机||
 */
public class Solution00122 {
    /**
     * 因为不限制交易次数，因此只要当天的价格高于昨天的，即可卖出
     * 所以本题适用贪心算法
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }

        return ans;
    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        // 用一个二维的dp数组来存储
        // 第二位的0表示当天不买卖股票，1表示买卖股票
        int[][] dp = new int[prices.length][2];

        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 如果当天不持有股票，则当前的最大利润是前一天与在今天卖出股票所累积利润的最大值
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // 如果当天买入股票，则当前的最大利润是前一天的最大利润与当天买入股票后的最大利润的最大值
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
