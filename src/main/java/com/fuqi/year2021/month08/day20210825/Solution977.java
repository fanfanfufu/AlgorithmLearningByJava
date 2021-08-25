package com.fuqi.year2021.month08.day20210825;

import java.util.Arrays;

/**
 * @author FuQi
 */
public class Solution977 {
    /**
     * 方法一：直接排序，时间复杂度 O(nlogn)
     * @param nums
     * @return
     */
    public int[] sortedSquares1(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);

        return ans;
    }

    /**
     * 解法二：双指针法
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares2(int[] nums) {
        // 1. 找到第一个非负数的下标
        int len = nums.length;;
        int zeroIndex = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                zeroIndex = i;
            } else {
                break;
            }
        }
        // 2. 双指针往数组两边遍历
        int left = zeroIndex;
        int right = zeroIndex + 1;
        int[] ans = new int[len];
        int i = 0;
        while (left >= 0 || right < len) {
            if (left < 0) {
                ans[i] = nums[right] * nums[right];
                right++;
            } else if (right == left) {
                ans[i] = nums[left] * nums[left];
                left--;
            } else if (nums[left] * nums[left] > nums[right] * nums[right]) {
                ans[i] = nums[right] * nums[right];
                right++;
            } else {
                ans[i] = nums[left] * nums[left];
                left--;
            }
            i++;
        }

        return ans;
    }

    /**
     * 从两个边界开始遍历，将结果从新数组倒着顺序写入
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares3(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0, right = nums.length-1, i = right;
        while (left <= right) {
            int leftPow = nums[left] * nums[left];
            int rightPow = nums[right] * nums[right];
            if (leftPow > rightPow) {
                ans[i] = leftPow;
                left++;
            } else {
                ans[i] = rightPow;
                right--;
            }
            i--;
        }

        return ans;
    }
}
