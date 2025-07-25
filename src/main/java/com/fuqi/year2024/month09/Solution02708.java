package com.fuqi.year2024.month09;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/9/3 23:52
 * @description
 */
public class Solution02708 {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (nums[1] == 0 && nums[n - 1] == 0) {
            return 0;
        }
        long ans = 1;
        int i = 0;
        while (i < n) {
            if (nums[i] < 0 && i + 1 < n && nums[i + 1] < 0) {
                ans *= nums[i] * nums[i + 1];
                i += 2;
            } else if (nums[i] <= 0) {
                i += 1;
            } else {
                ans *= nums[i];
                i += 1;
            }
        }
        return ans;
    }
}
