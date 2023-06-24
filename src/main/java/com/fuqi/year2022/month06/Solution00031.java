package com.fuqi.year2022.month06;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2022/6/27 23:12
 * @description
 */
public class Solution00031 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // 1. 从右往左找到第一个nums[i] < nums[i+1]的
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            reverse(nums, 0);
            return;
        }
        int j = nums.length - 1;
        // 2. 找到第一个大于第一个升序对中第一个元素的数
        while (j >= 0 && nums[i] >= nums[j]) {
            j--;
        }
        // 3. 交换i，j的元素
        swap(nums, i, j);
        // 4. 将i之后的数组调整成升序
        // 这里可以直接reverse的原因是，i之后的数的排序是降序的，因此可以直接反转
        reverse(nums, i+1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
