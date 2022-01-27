package com.fuqi.year2022.month01;

/**
 * @author FuQi
 * @date 2022/1/27 21:55
 * @description 买卖股票的最佳时机
 */
public class Solution00121 {
    /**
     * 暴力解法
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int ans = 0;
        if (prices == null || prices.length == 0) {
            return ans;
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                ans = Math.max(ans, prices[j] - prices[i]);
            }
        }

        return ans;
    }

    /**
     * 动态规划的思路
     * 用dp数组记录从0到i的最低价格，
     * 再与当前价格最差，用一个ans维护最大的价格差即可
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int ans = 0;
        if (prices == null || prices.length == 0) {
            return ans;
        }
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i-1], prices[i]);
            ans = Math.max(prices[i] - dp[i], ans);
        }

        return ans;
    }

    /**
     * 基于动态规划进行空间复杂度优化
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int ans = 0;
        if (prices == null || prices.length == 0) {
            return ans;
        }
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            ans = Math.max(ans, prices[i] - minPrice);
        }

        return ans;
    }
}
