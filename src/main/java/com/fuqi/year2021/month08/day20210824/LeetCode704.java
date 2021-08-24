package com.fuqi.year2021.month08.day20210824;

/**
 * @author FuQi
 */
public class LeetCode704 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid;
                continue;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        int target = 7;
        int res = search(nums, target);
        System.out.println("res = " + res);
    }
}
