package com.fuqi.year2023.month07;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/16 11:28
 * @description
 */
public class Solution06929 {
    public int maximumBeauty(int[] nums, int k) {
        if (nums.length == 1) return 1;
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            while (left < i && nums[i] - nums[left] > 2 * k) left++;
            ans = Math.max(ans, i - left + 1);
        }

        return ans;
    }
}
