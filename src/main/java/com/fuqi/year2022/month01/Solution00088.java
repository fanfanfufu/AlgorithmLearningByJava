package com.fuqi.year2022.month01;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2022/1/28 22:11
 * @description 合并两个有序数组
 */
public class Solution00088 {

    /**
     * 合并后排序
     * 时间复杂度：O((m+n)log(m+n))
     * 空间复杂度：O((m+n)log(m+n))
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 双指针法
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m+n)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            nums1[0] = nums2[0];
        }
        int[] ans = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                ans[k] = nums1[i];
                i++;
                k++;
                continue;
            }
            ans[k] = nums2[j];
            k++;
            j++;
        }

        // i<n说明nums2被遍历完了
        while (i < m) {
            ans[k] = nums1[i];
            k++;
            i++;
        }
        while (j < n) {
            ans[k] = nums2[j];
            j++;
            k++;
        }
        System.arraycopy(ans, 0, nums1, 0, ans.length);
    }

    /**
     * 倒排法，因为nums1的后面是0，因此可以到着遍历两个数组，较大的放到num1的尾部，从而实现堆nums1的原地操作
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}
