package com.fuqi.month06.day0620;

/**
 * @Description:
 * @Author 傅琦
 * @Date 2019/6/20 8:56
 * @Version V1.0
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }

        int maxProfit = 0;
        /**
         * 暴力解法：
         * 时间复杂度为O(n^2)
         * 空间复杂度为O(1)
         */
//        for (int i = 0; i < prices.length-1; i++) {
//            for (int j = i+1; j < prices.length; j++) {
//                if (prices[i] < prices[j]){
//                    maxProfit = maxProfit > (prices[j] - prices[i]) ? maxProfit : (prices[j] - prices[i]);
//                }
//            }
//        }

        /**
         * 用DP来做
         * dp[i][0]代表第i天不持有股票
         * dp[i][1]代表第i天持有股票
         */
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 今天没有股票，要么和昨天保持一样没有持有，要么就是昨天持有，今天卖掉。二者取最大的
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // 今天持有股票：要么昨天持有，要么昨天没有持有，今天才买入。
            // 这里做了一个简单的优化，因为只能由一次操作，
            // 所以就可以将今天当成是第一次操作，这里将 dp[i-1][0] - prices[i] 简化为了 -prices[9]
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }

//        return dp[prices.length-1][0];

        /**
         * 再优化，在DP的基础上优化
         * 时间复杂度为O(n)
         * 空间复杂度O(1)
         */
        int minPrice = Integer.MAX_VALUE;
        for (int price: prices) {
            if (price < minPrice){
                minPrice = price;
            }else {
                maxProfit = maxProfit > (price - minPrice) ? maxProfit : (price - minPrice);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock sellStock = new BestTimeToBuyAndSellStock();
        int[] input1 = {7,2,1,5,3,6,4,8};
        int[] input2 = {7,6,4,3,1};
        int res = sellStock.maxProfit(input1);
        System.out.println("res = " + res);
    }
}
