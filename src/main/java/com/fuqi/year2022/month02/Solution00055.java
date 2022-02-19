package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/19 20:58
 * @description
 */
public class Solution00055 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int rightMost = 0;
        for (int i = 0; i < len; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(nums[i]+i, rightMost);
                if (rightMost >= len-1) {
                    return true;
                }
            }
        }

        return false;
    }
}
