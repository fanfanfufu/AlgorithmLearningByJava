package com.fuqi.year2021.month08.day20210824;

/**
 * @author FuQi
 */
public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }

        return left;
    }
}
