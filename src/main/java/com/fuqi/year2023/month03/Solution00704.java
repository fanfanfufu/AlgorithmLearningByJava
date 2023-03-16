package com.fuqi.year2023.month03;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/3/16 22:33
 * @description
 */
public class Solution00704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
