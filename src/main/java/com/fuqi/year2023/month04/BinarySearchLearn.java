package com.fuqi.year2023.month04;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/4/22 17:10
 * @description 二分查找练习：找出第一大于等于target的元素的下标，没有则返回数组长度
 */
public class BinarySearchLearn {
    /**
     * 在[left, right]的闭区间上查找
     *
     * @param nums 已经升序排列好的数组
     * @param target 目标元素
     * @return int
     */
    public int lowerBound1(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            // 常规的left+right的一般会有整数溢出的风险，因此使用这种方式
            int mid = left + (right-left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    /**
     * 在[left, right)的闭区间上查找
     *
     * @param nums 已经升序排列好的数组
     * @param target 目标元素
     * @return int
     */
    public int lowerBound2(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n;
        while (left < right) {
            // 常规的left+right的一般会有整数溢出的风险，因此使用这种方式
            int mid = left + (right-left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    /**
     * 在(left, right)的闭区间上查找
     *
     * @param nums 已经升序排列好的数组
     * @param target 目标元素
     * @return int
     */
    public int lowerBound3(int[] nums, int target) {
        int n = nums.length;
        int left = -1, right = n;
        while (left+1 < right) {
            // 常规的left+right的一般会有整数溢出的风险，因此使用这种方式
            int mid = left + (right-left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
