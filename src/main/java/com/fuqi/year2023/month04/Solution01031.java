package com.fuqi.year2023.month04;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/4/26 22:07
 * @description
 */
public class Solution01031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++)
            // 计算 nums 的前缀和
            preSum[i + 1] = preSum[i] + nums[i];
        int ans = 0, maxSumA = 0, maxSumB = 0;
        for (int i = firstLen + secondLen; i <= n; ++i) {
            maxSumA = Math.max(maxSumA, preSum[i - secondLen] - preSum[i - secondLen - firstLen]);
            maxSumB = Math.max(maxSumB, preSum[i - firstLen] - preSum[i - firstLen - secondLen]);
            ans = Math.max(ans, Math.max(maxSumA + preSum[i] - preSum[i - secondLen],  // 左 a 右 b
                    maxSumB + preSum[i] - preSum[i - firstLen])); // 左 b 右 a
        }
        return ans;
    }
}
