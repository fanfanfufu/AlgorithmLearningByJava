package com.fuqi.year2023.month06;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/4 10:56
 * @description
 */
public class Solution06424 {
    public int semiOrderedPermutation(int[] nums) {
        int left = 0, right = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) left = i;
            if (nums[i] == n) right = i;
        }

        int ans = left + n - 1 - right;
        if (left > right) ans -= 1;

        return ans;
    }
}
