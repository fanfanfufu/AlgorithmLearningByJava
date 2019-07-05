package com.fuqi.month06.day0620;

/**
 * @Description: 买卖股票3——最多操作两次
 * @Author 傅琦
 * @date 2019/7/5 11:23
 * @Version V1.0
 */
public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII stockIII = new BestTimeToBuyAndSellStockIII();
        // 3,3,5,0,0,3,1,4
        // 1, 7, 2, 3, 6, 7, 6, 7
        int[] input = {3,3,5,0,0,3,1,4};
        int res = stockIII.maxProfit(input, 2);
        System.out.println("res = " + res);
    }

    public int maxProfit(int[] prices, int max_k) {
        int n = prices.length;
        // 当k大于等于数组长度的1/2时，退化为不限次数的买卖股票问题
        if (max_k > n/2){
            int ans = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1]){
                    ans += prices[i] - prices[i-1];
                }
            }
            return ans;
        }

        // 创建一个三维数组，每个元素的值代表当前状态下的最大利润，第一维代表天数，第二位代表完整的交易次数，第三维代表当前是否持有股票
        int[][][] dp = new int[n][max_k+1][2];

        // 对第一天的情况提前做一点处理
        for (int i = 0; i <= max_k; i++) {
            // 当前没有持有股票，无论有多少次交易，利润都为0
            dp[0][i][0] = 0;
            // 当前若持有股票，无论有多少次交易，利润都为-prices[0]
            // 为什么不设置成负无穷，因为交易数+1代表一次完整的买入和卖出操作，
            // 所以第一天无论交易次数是多少，都可以看作是只有1次买入操作
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = max_k; j > 0; j--) {
                // 若此时没有股票，利润的最大值要么与前一天相同，要么是加上将前一天持有的股票今天卖掉所得的利润
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                // 若此时持有有股票，利润的最大值要么与前一天相同，要么是前一天前一次操作没有持有股票时的利润减去今天的股票价格
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }

        return dp[prices.length-1][max_k][0];
    }
}
