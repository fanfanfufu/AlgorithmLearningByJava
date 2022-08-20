package com.fuqi.year2022.month08;

/**
 * @author FuQi
 * @date 2022/8/20 0:04
 * @description
 */
public class Solution00718 {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    public int findLength2(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n-i);
            int maxLen = maxLength(nums1, nums2, i, 0, len);
            ans = Math.max(ans, maxLen);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m-i);
            int maxLen = maxLength(nums1, nums2, 0, i, len);
            ans = Math.max(ans, maxLen);
        }

        return ans;
    }

    /**
     * 计算每个窗口内的最大公共子数组长度
     *
     * @param nums1
     * @param nums2
     * @param index1
     * @param index2
     * @param len
     * @return
     */
    public int maxLength(int[] nums1, int[] nums2, int index1, int index2, int len) {
        int ans = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[index1+i] == nums2[index2+i]) {
                k++;
            } else {
                k = 0;
            }
            ans = Math.max(ans, k);
        }

        return ans;
    }
}
