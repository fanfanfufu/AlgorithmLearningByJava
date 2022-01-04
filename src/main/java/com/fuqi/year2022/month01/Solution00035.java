package com.fuqi.year2022.month01;

/**
 * @author FuQi
 * @date 2022/1/4 21:53
 * @description
 * 找出target在nums中的下标，若没有找到，则返回需要target插入的下标
 */
public class Solution00035 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,8};
        int target = 7;
        System.out.println("res = " + searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (nums[0] > target) {
            return 0;
        }
        if (nums[n-1] < target) {
            return n;
        }
        int left = 0, right = n-1;
        int ans = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
                ans = left;
            } else if (nums[mid] > target) {
                right = mid;
                ans = right;
            } else {
                return mid;
            }
        }

        return ans;
    }
}
