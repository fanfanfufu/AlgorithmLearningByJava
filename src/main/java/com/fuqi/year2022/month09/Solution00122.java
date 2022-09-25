package com.fuqi.year2022.month09;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

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
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 如果当天买入股票，则当前的最大利润是前一天的最大利润与当天买入股票后的最大利润的最大值
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }

    /**
     * 时间复杂度，空间复杂度均为O(n)
     *
     * @param inputArray
     * @return
     */
    public int findMinPositiveNumber(int[] inputArray) {
        // 异常输入处理
        if (null == inputArray || inputArray.length == 0) {
            return 0;
        }
        int n = inputArray.length;
        // 特殊情况快速处理
        if (n == 1) {
            return inputArray[0] == 1 ? 2 : 1;
        }
        // 临时数组，若temp数组当前元素位1，则说明该索引在输入数组中出现过
        int[] temp = new int[n + 1];
        // 遍历输入数组
        for (int j : inputArray) {
            if (j < 1 || j > n) {
                continue;
            }
            temp[j] = 1;
        }
//        Arrays.stream(inputArray).filter(num -> num > 0 && num <= n).forEach(index -> temp[index] = 1);
        // 从1开始遍历临时数组，若是有某个元素为0，则说明其下标就是输入数组中未出现的最小整数
        for (int i = 1; i <= n; i++) {
            if (temp[i] == 0) {
                return i;
            }
        }

        return n + 1;
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param inputArray
     * @return
     */
    public int findMinPositiveNumber2(int[] inputArray) {
        // 异常输入处理
        if (null == inputArray || inputArray.length == 0) {
            return 0;
        }
        int n = inputArray.length;
        // 特殊情况快速处理
        if (n == 1) {
            return inputArray[0] == 1 ? 2 : 1;
        }
        for (int i = 0; i < n; i++) {
            while (inputArray[i] > 0 && inputArray[i] <= n && (i + 1 != inputArray[i])) {
                // 取出目标位的数据
                int targetIndex = inputArray[i] - 1;
                if (inputArray[targetIndex] == targetIndex) break;
                int temp = inputArray[targetIndex];
                inputArray[targetIndex] = inputArray[i];
                inputArray[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (inputArray[i] - 1 != i) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        Solution00122 solution = new Solution00122();
//        Assertions.assertEquals(0, solution.findMinPositiveNumber(null));
//        Assertions.assertEquals(0, solution.findMinPositiveNumber(new int[0]));
//        Assertions.assertEquals(2, solution.findMinPositiveNumber(new int[]{1}));
//        Assertions.assertEquals(1, solution.findMinPositiveNumber(new int[]{2}));
//        Assertions.assertEquals(3, solution.findMinPositiveNumber(new int[]{1, 2, 4}));
//        Assertions.assertEquals(4, solution.findMinPositiveNumber(new int[]{1, 2, 3}));
//        Assertions.assertEquals(1, solution.findMinPositiveNumber(new int[]{3, 2, 4}));
//        Assertions.assertEquals(1, solution.findMinPositiveNumber(new int[]{-2, -1}));

        Assertions.assertEquals(0, solution.findMinPositiveNumber2(null));
        Assertions.assertEquals(0, solution.findMinPositiveNumber2(new int[0]));
        Assertions.assertEquals(2, solution.findMinPositiveNumber2(new int[]{1}));
        Assertions.assertEquals(1, solution.findMinPositiveNumber2(new int[]{2}));
        Assertions.assertEquals(3, solution.findMinPositiveNumber2(new int[]{1, 2, 4}));
        Assertions.assertEquals(4, solution.findMinPositiveNumber2(new int[]{1, 2, 3}));
        Assertions.assertEquals(1, solution.findMinPositiveNumber2(new int[]{3, 2, 4}));
        Assertions.assertEquals(1, solution.findMinPositiveNumber2(new int[]{-2, -1}));
    }
}
