package com.fuqi.year2023.month08;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/22 22:39
 * @description
 */
public class Solution00849 {
    /**
     * 最大的最近距离就是以下两种情况中取最大的：
     * 两边都有人的连续0的最长距离的一半：奇数的话一半之后要再+1
     * 数组两段的连续0的最大长度
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        if (n == 2) return 1;
        int left = 0;
        // 先找两端连续0的最大距离
        while (left < n) {
            if (seats[left] == 1) break;
            left++;
        }
        int right = n - 1;
        while (right >= 0) {
            if (seats[right] == 1) break;
            right--;
        }
        int zeroEdgeLen = Math.max(left, n - right - 1);
        // 再找中间连续0的最长距离
        int zeroMidLen = 0;
        while (left < right) {
            while (left < right && seats[left] == 1) left++;
            int curLen = 0;
            while (left < right && seats[left] == 0) {
                curLen++;
                left++;
            }
            zeroMidLen = Math.max(zeroMidLen, curLen);
        }
        // 比较两种的最大值即可
        if ((zeroMidLen & 1) == 0) return Math.max(zeroMidLen / 2, zeroEdgeLen);

        return Math.max(zeroMidLen / 2 + 1, zeroEdgeLen);
    }

    public static void main(String[] args) {
        Solution00849 solution00849 = new Solution00849();
//        int[] seats = {1, 0, 0, 0, 1, 0, 1};
        int[] seats = {1, 0, 0, 0};
        System.out.println(solution00849.maxDistToClosest(seats));
    }
}
