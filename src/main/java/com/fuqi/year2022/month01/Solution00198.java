package com.fuqi.year2022.month01;

/**
 * @author FuQi
 * @date 2022/1/16 18:13
 * @description
 */
public class Solution00198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[nums.length-1];
    }

    /**
     * 直接dp, 空间复杂度为O(n)
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }

        return dp[n];
    }

    /**
     * 优化dp的空间复杂度， 将为常数级
     *
     * @param nums
     * @return
     */
    public int rob3(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int cur = 1;
        for (int i = 2; i < n; i++) {
            cur = 1 - cur;
            dp[cur] = Math.max(nums[i] + dp[cur], dp[1-cur]);
        }

        return Math.max(dp[0], dp[1]);
    }
}
