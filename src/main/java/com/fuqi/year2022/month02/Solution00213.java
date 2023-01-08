package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/19 11:15
 * @description
 */
public class Solution00213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(dp(nums, 0, nums.length-1), dp(nums,1,nums.length));
    }

    private int dp(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start+1]);
        for (int i = start+2; i < end; i++) {
            int temp = second;
            second = Math.max(temp, nums[i]+first);
            first = temp;
        }

        return second;
    }

    /**
     * 打家劫舍优化空间复杂度的版本
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        int pre = 0, cur = 0;
        for (int num : nums) {
            int temp = Math.max(cur, pre + num);
            pre = cur;
            cur = temp;
        }

        return cur;
    }
}
