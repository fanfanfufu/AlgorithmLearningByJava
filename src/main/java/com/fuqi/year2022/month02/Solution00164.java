package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/8 22:20
 * @description
 */
public class Solution00164 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left+right)/2;
            if (nums[mid] < nums[mid+1]) {
                // 如果mid小于右边的数，说明峰值还在mid的右边
                left = mid + 1;
            } else {
                // 因为题目限制了每个数都不相等
                // 如果mid大于右边的数时，说明峰值在mid的左边
                right = mid;
            }
        }
        return left;
    }
}
