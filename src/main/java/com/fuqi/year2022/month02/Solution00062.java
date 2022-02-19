package com.fuqi.year2022.month02;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2022/2/19 14:16
 * @description
 */
public class Solution00062 {
    /**
     * 动态规划
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 填充第一行
        Arrays.fill(dp[0], 1);
        // 填充第一列
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    /**
     * 公式
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
