package com.fuqi.month06.day0622;

/**
 * @Description: 销售问题3：最多售卖2次
 *
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * @Author 傅琦
 * @date 2019/6/22 14:22
 * @Version V1.0
 */
public class BestTimetoBuyandSellStockIII {
    public static int maxProfit1(int[] prices) {
        int oneBuy = Integer.MIN_VALUE;
        int twoBuy = Integer.MIN_VALUE;
        int oneSell = 0;
        int twoSell = 0;
        for(int price : prices){
            oneBuy = Math.max(oneBuy, -price);
            oneSell = Math.max(oneSell, price+oneBuy);
            twoBuy = Math.max(twoBuy, oneSell-price);
            twoSell = Math.max(twoSell, price+twoBuy);
        }
        return twoSell;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        return constantSpaceDP(prices);
        //return nSpaceDP(prices);
        //return mnSpaceDP(prices);
    }

    /**
    sell2[i]: max profit when have sold upon p[i], total transaction is 2
    buy2[i]: max profit when have bought upon p[i], total transaction is 2
    sell1[i]: max profit when have sold upon p[i], total transaction is 1
    buy1[i]: max profit when have bought upon p[i], total transaction is 1

    sell2[i] = max(sell2[i - 1], buy2[i - 1] + p[i])
    buy2[i] = max(buy2[i - 1], sell1[i - 1] - p[i])， buy2 depends on previous sell1

    sell1[i] = max(sell1[i - 1], buy1[i - 1] + p[i])
    buy1[i] = max(buy1[i - 1], -p[i])

    optimization: space O(4n) -> O(4)
    */

    private int constantSpaceDP(int[] p) {
        int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
        for (int tp : p) {
            sell2 = Math.max(sell2, buy2 + tp);
            buy2 = Math.max(buy2, sell1 - tp);
            sell1 = Math.max(sell1, buy1 + tp);
            buy1 = Math.max(buy1, -tp);
        }
        return Math.max(sell1, sell2);
    }

    /**
    M[i][j]: max profit of i-th transaction from day 0 to day j
    M[i][j] = max(M[i][j - 1], max(M[i - 1][k] + p[j] - p[k])), k from 0 to j - 1
            = max(M[i][j - 1], p[j] + max(M[i - 1][k] - p[k]))
            = max(M[i][j - 1], p[j] + tmp);
        tmp = Math.max(tmp, M[i - 1][j] - p[j]);
    optimization: space O(m*n) -> O(n)
    */

    private int nSpaceDP(int[] p) {
        int[] M = new int[p.length];
        for (int i = 1; i < 3; i++) {
            int tmp = M[0] - p[0], top;
            for (int j = 1; j < p.length; j++) {
                top = M[j];
                M[j] = Math.max(M[j - 1], tmp + p[j]);
                tmp = Math.max(tmp, top - p[j]);
            }
        }
        return M[p.length - 1];
    }

    private int mnSpaceDP(int[] p) {
        int[][] M = new int[3][p.length];
        for (int i = 1; i < 3; i++) {
            int tmp = M[i - 1][0] - p[0];
            for (int j = 1; j < p.length; j++) {
                M[i][j] = Math.max(M[i][j - 1], tmp + p[j]);
                tmp = Math.max(tmp, M[i - 1][j] - p[j]);
            }
        }
        return M[2][p.length - 1];
    }

    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[prices.length];
        int lowest = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = max;
            if (prices[i] - lowest >= max) {
                max = prices[i] - lowest;
                dp[i] = max;
            }
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
        }
        // if there are two transaction process
        int newMax = max;
        int secondMax = 0;
        int highest = prices[prices.length - 1];
        // cursor i is the starting point of the second transaction
        for (int i = prices.length - 2; i >= 2; i--) {
            if (highest - prices[i] > secondMax) {
                secondMax = highest - prices[i];
                if (secondMax + dp[i-1] > newMax) {
                    newMax = Math.max(newMax, secondMax + dp[i-1]);
                }
            }
            if (prices[i] > highest) {
                highest = prices[i];
            }
        }
        return newMax;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5};
        int res = maxProfit3(input);
        System.out.println("res = " + res);
    }
}
