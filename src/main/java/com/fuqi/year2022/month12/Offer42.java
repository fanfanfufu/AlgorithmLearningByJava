package com.fuqi.year2022.month12;

/**
 * @author FuQi
 * @date 2022/12/8 22:36
 * @description 连续子数组的最大和
 */
public class Offer42 {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
