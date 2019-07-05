package com.fuqi.month06.day0620;

/**
 * @Description: 买卖股票3——最多操作两次
 * @Author 傅琦
 * @date 2019/7/5 11:23
 * @Version V1.0
 */
public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){ return 0; }

        // 操作次数
        int opTimes = 2;

        int[][][] dp = new int[prices.length][opTimes+1][2];
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        return dp[prices.length-1][opTimes][0];
    }
}
