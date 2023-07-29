package com.fuqi.year2023.month07;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/29 16:30
 * @description
 */
public class Solution00238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++) ans[i] = ans[i-1] * nums[i-1];
        int suffix = 1;
        for (int i = n-2; i >= 0; i--) {
            suffix = nums[i+1] * suffix;
            ans[i] = ans[i] * suffix;
        }

        return ans;
    }
}
