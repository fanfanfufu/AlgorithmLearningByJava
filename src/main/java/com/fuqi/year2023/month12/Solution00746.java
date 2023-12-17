package com.fuqi.year2023.month12;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/12/17 14:03
 * @description
 */
public class Solution00746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 1) return cost[0];
        if (n == 2) return Math.min(cost[0], cost[1]);
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[n];

        // 优化空间复杂度
//        int preTwo = 0, preOne = 0;
//        int ans = 0;
//        for (int i = 2; i <= n; i++) {
//            ans = Math.min(preTwo + cost[i-2], preOne + cost[i-1]);
//            preTwo = preOne;
//            preOne = ans;
//        }
//
//        return ans;
    }

    public static void main(String[] args) {
        Solution00746 solution00746 = new Solution00746();
//        int[] cost = {10,15,20};
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(solution00746.minCostClimbingStairs(cost));
    }
}
