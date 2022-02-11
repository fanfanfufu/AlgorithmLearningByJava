package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/11 23:28
 * @description
 */
public class Solution00713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left++];
            }
            // 当left指针移动到满足left与right之间的连续子数组的乘积小于k时
            // 这段连续子数组内满足条件的子数组的个数为(right - left + 1)
            ans += right - left + 1;
        }
        return ans;
    }
}
