package com.fuqi.year2023.month07;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/16 11:07
 * @description
 */
public class Solution06889 {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                ans += (nums[i-1] * nums[i-1]);
            }
        }

        return ans;
    }
}
