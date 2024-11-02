package com.fuqi.year2024.month11;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/11/1 22:14
 * @description
 */
public class Solution03259 {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] dp = new long[n + 1][2];
        dp[1][0] = dp[0][0] + energyDrinkA[0];
        dp[1][1] = dp[0][1] + energyDrinkB[0];

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i][0], dp[i - 2][1] + energyDrinkA[i - 1]);
            dp[i][1] = Math.max(dp[i][1], dp[i - 2][0] + energyDrinkB[i - 1]);
        }

        return Math.max(dp[n][0], dp[n][1]);
    }
}
