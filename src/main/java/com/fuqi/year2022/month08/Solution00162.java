package com.fuqi.year2022.month08;

/**
 * @author FuQi
 * @date 2022/8/26 23:28
 * @description 寻找峰值元素
 */
public class Solution00162 {
    /**
     * 二分法的思路实现：
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {
                // 如果中间位置的数小于其右边的数，说明该位置处在上坡区
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
