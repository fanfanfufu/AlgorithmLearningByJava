package com.fuqi.year2023.month07;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/22 22:52
 * @description
 */
public class Solution06930 {
    public boolean isGood(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n-1] != nums[n-2]) return false;
        int maxNum = nums[n-1];
        if (maxNum != n-1) return false;
        for (int i = 1; i < n; i++) {
            if (nums[i-1] != i) return false;
        }

        return true;
    }
}
