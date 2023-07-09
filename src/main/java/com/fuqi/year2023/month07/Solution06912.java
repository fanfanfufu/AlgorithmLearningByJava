package com.fuqi.year2023.month07;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/9 11:05
 * @description
 */
public class Solution06912 {
    /**
     * 需要使用同向双指针，借助滑动窗口的思想
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        if (n == 1) return 1;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            // 给定一个初值，可以理解为以i处元素结尾的连续子数组的长度为1
            // 这样可以保证在i处元素都小于nums1[i-1]和nums2[i-1]时有默认值
            dp[i][0] = dp[i][1] = 1;
            // 1 当nums1[i] >= nums1[i-1]时，此时以nums1[i]结尾的连续子数组的长度就是以nums1[i-1]结尾的连续子数组长度+1
            if (nums1[i] >= nums1[i-1]) dp[i][0] = Math.max(dp[i][0], dp[i-1][0]+1);
            // 2 当nums1[i] >= nums2[i-1]时，此时以nums1[i]结尾的连续子数组的长度就是以nums2[i-1]结尾的连续子数组长度+1
            if (nums1[i] >= nums2[i-1]) dp[i][0] = Math.max(dp[i][0], dp[i-1][1]+1);
            // 3 当nums2[i] >= nums1[i-1]时，此时以nums2[i]结尾的连续子数组的长度就是以nums1[i-1]结尾的连续子数组长度+1
            if (nums2[i] >= nums1[i-1]) dp[i][1] = Math.max(dp[i][1], dp[i-1][0]+1);
            // 4 当nums2[i] >= nums2[i-1]时，此时以nums2[i]结尾的连续子数组的长度就是以nums2[i-1]结尾的连续子数组长度+1
            if (nums2[i] >= nums2[i-1]) dp[i][1] = Math.max(dp[i][1], dp[i-1][1]+1);
            // 比较连续子数组的最大长度
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,2,1};
        int[] nums2 = {2,2,3,4};
        Solution06912 solution06912 = new Solution06912();
        System.out.println(solution06912.maxNonDecreasingLength(nums1, nums2));
    }
}
