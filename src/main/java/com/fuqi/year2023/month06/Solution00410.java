package com.fuqi.year2023.month06;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/11 13:54
 * @description 分割数组的最大值
 */
public class Solution00410 {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        // 先求前缀和
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        // 使用dp数组
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int maxSplit = Math.min(i, k);
            for (int j = 1; j <= maxSplit; j++) {
                for (int p = 0; p < i; p++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[p][j-1], sum[i]-sum[p]));
                }
            }
        }

        return dp[n][k];
    }

    public int splitArray2(int[] nums, int k) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = (left + right) / 2;
            if (check(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean check(int[] nums, int x, int k) {
        int sum = 0, cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }

        return cnt <= k;
    }
}
