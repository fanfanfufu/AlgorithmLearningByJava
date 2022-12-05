package com.fuqi.year2022.month12;

/**
 * @author FuQi
 * @date 2022/12/5 21:15
 * @description 零钱兑换2
 */
public class Solution00518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }

        return dp[amount];
    }
}
