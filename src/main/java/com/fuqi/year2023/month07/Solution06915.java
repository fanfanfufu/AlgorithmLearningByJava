package com.fuqi.year2023.month07;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/23 15:59
 * @description
 */
public class Solution06915 {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long ans = nums[n-1];
        long cur = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            if (cur >= nums[i]) cur += nums[i];
            else cur = nums[i];
            ans = Math.max(ans, cur);
        }

        return ans;
    }
}
