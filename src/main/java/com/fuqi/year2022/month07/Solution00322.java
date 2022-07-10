package com.fuqi.year2022.month07;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2022/7/10 23:20
 * @description
 */
public class Solution00322 {
    /**
     * 暴力递归，会超时
     *
     * @param coins
     * @param amount
     * @return
     */
    private int ans1 = Integer.MAX_VALUE;

    public int coinChange1(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        dfs1(coins, amount, 0);

        if (ans1 == Integer.MAX_VALUE) {
            return -1;
        }

        return ans;
    }

    private void dfs1(int[] coins, int amount, int count) {
        if (amount < 0) {
            return;
        }
        if (amount == 0) {
            ans1 = Math.min(ans1, count);
        }

        for (int i = 0; i < coins.length; i++) {
            dfs1(coins, amount - coins[i], count + 1);
        }
    }

    /**
     * 记忆化搜索的递归
     *
     * @param coins
     * @param amount
     * @return
     */
    int[] mem;

    public int coinChange2(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        mem = new int[amount];

        return dfs2(coins, amount);
    }

    private int dfs2(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 利用已经处理过的节点来剪枝
        if (mem[amount - 1] != 0) {
            return mem[amount - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int ans = dfs2(coins, amount - coins[i]);
            if (ans >= 0 && ans < min) {
                min = ans + 1;
            }
        }
        mem[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;

        return mem[amount - 1];
    }

    /**
     * 上面的记忆化搜索是先从 memo[amonut-1]memo[amonut−1] 开始，从上到下
     * 动态规划从 memo[0]memo[0] 开始，从下到上
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        // dp[i]表示凑成总金额为i所需要的最少的硬币数
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] < min) {
                    // 如果当前数减去当前位置的硬币额度剩余的额度大于等于0，并且对应剩余额度计算得到的最少硬币数小于min
                    min = dp[i - coins[j]] + 1;
                }
            }
            dp[i] = min;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int coinChange4(int[] coins, int amount) {
        int max = amount+1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i < max; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
