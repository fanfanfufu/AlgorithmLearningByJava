package com.fuqi.year2024.month03;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/3/1 20:56
 * @description
 */
public class Solution02369 {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            if (i >= 2) dp[i] = dp[i-2] && validTwo(nums[i-2], nums[i-1]);
            if (i>=3) dp[i] = dp[i] || (dp[i-3] && validThree(nums[i-3], nums[i-2], nums[i-1]));
        }

        return dp[n];
    }

    public boolean validTwo(int num1, int num2) {
        return num1 == num2;
    }

    public boolean validThree(int a, int b, int c) {
        return (a == b && a == c) || (a + 1 == b && b + 1 == c);
    }
}
