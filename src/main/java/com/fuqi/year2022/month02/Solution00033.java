package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/7 23:32
 * @description 搜索旋转排序数据
 *
 * 本题考察的是二分法的应用
 */
public class Solution00033 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                // 如果start的值小于mid，说明左半边区间是递增的
                if (target >= nums[start] && target < nums[mid]) {
                    // 满足这两个判断条件的，说明target可能位于左半边递增的区间中
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // 否则是右半边区间是有序递增的
                if (target <= nums[end] && target > nums[mid]) {
                    // 因此判断target是否在右半边区间内
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }

    public static int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid-1;
                    continue;
                }
                left = mid+1;
                continue;
            }
            if (nums[mid] < target && nums[right] >= target) {
                left = mid+1;
                continue;
            }
            right = mid-1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,1,3};
        System.out.println(search2(nums, 3));
    }
}
