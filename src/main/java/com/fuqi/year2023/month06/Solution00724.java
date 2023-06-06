package com.fuqi.year2023.month06;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/5 22:23
 * @description 寻找数组的中心下标
 */
public class Solution00724 {
    public int pivotIndex(int[] nums) {
        int[] suffixSum = new int[nums.length];
        suffixSum[nums.length-1] = 0;
        for (int i = nums.length-2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i+1] + nums[i+1];
        }

        int ans = -1, preSum = 0;
        if (suffixSum[0] == preSum) return 0;
        for (int i = 1; i < nums.length; i++) {
            preSum += nums[i-1];
            if (preSum == suffixSum[i]) return i;
        }

        return ans;
    }
}
