package com.fuqi.year2022.month01;

/**
 * @author FuQi
 * @date 2022/1/25 21:43
 * @description
 */
public class Solution00053 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        if (nums == null || nums.length == 0) {
            return sum;
        }
        if (nums.length == 1) {
            return nums[0];
        }int ans = nums[0];
        for (int num : nums) {
            sum = Math.max(sum+num, num);
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
