package com.fuqi.year2024.month02;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/2/28 21:22
 * @description
 */
public class Solution02673 {
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        if (n == 1) return ans;
        int i = n - 1;
        while (i > 1) {
            ans += Math.abs(cost[i] - cost[i - 1]);
            cost[i / 2 - 1] += Math.max(cost[i], cost[i - 1]);
            i -= 2;
        }

        return ans;
    }
}
