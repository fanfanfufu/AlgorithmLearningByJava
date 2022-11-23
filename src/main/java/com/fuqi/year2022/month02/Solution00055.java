package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/19 20:58
 * @description 跳跃游戏
 */
public class Solution00055 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int rightMost = 0;
        for (int i = 0; i < len; i++) {
            if (i > rightMost) {
                return false;
            }
            rightMost = Math.max(nums[i]+i, rightMost);
            if (rightMost >= len-1) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump2(int[] nums) {
        int len = nums.length;
        int cover = 0;
        for(int i = 0; i <= cover; i++) {
            cover = Math.max(cover, nums[i] + i);
            if (cover >= len - 1) {
                return true;
            }
        }

        return false;
    }
}
