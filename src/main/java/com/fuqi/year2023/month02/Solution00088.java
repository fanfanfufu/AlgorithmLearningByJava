package com.fuqi.year2023.month02;

/**
 * @author FuQi
 * @date 2023/2/9 22:04
 * @description
 */
public class Solution00088 {
    /**
     * 时间复杂度为O(n+m)的思路：
     * 倒着从大到小的往前将数字填入nums1数组中
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 题目输入的特殊情况的处理
        if (n == 0) return;
        if (m == 0) System.arraycopy(nums2, 0, nums1, 0, nums2.length);
        // 常规逻辑
        int i = m-1, j = n-1, k = (n+m)-1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                swap(nums1, i, k);
                i--;
                k--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        if (j >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, j+1);
        }
    }

    private void swap(int[] nums, int i, int k) {
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }

    /**
     * 代码优化，思路是一样的，倒着从nums1开始放
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1, tail = m+n-1;
        int curValue;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                curValue = nums2[j];
                j--;
            } else if (j < 0) {
                curValue = nums1[i];
                i--;
            } else if (nums1[i] > nums2[j]) {
                curValue = nums1[i];
                i--;
            } else {
                curValue = nums2[j];
                j--;
            }
            nums1[tail] = curValue;
            tail--;
        }
    }
}
