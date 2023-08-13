package com.fuqi.year2023.month08;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/13 10:31
 * @description
 */
public class Solution06939 {
    public int maxSum(int[] nums) {
        int n = nums.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int left = nums[i];
            int leftM = findMaxBit(left);
            for (int j = i + 1; j < n; j++) {
                int right = nums[j];
                int rightM = findMaxBit(right);
                if (leftM == rightM) {
                    ans = Math.max(ans, left + right);
                }
            }
        }

        return ans;
    }

    private int findMaxBit(int num) {
        if (num < 10) return num;
        int ans = 1;
        while (num > 0) {
            int mod = num % 10;
            ans = Math.max(ans, mod);
            num /= 10;
        }

        return ans;
    }
}
