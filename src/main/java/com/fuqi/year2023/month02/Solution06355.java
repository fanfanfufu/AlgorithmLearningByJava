package com.fuqi.year2023.month02;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2023/2/12 15:13
 * @description 统计公平数对的数目
 */
public class Solution06355 {
    /**
     * 容易超时的思路
     * 时间复杂度为O(n^2)
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public long countFairPairs0(int[] nums, int lower, int upper) {
        int len = nums.length;
        // 用于记录每位数字满足条件的另一半的范围
        int[][] partnerRange = new int[len][2];
        long ans = 0L;
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            // 将当前数字另一半的上下界放入数组中
            partnerRange[i][0] = lower - cur;
            partnerRange[i][1] = upper - cur;
            for (int j = 0; j < i; j++) {
                if (partnerRange[j][0] <= cur && cur <= partnerRange[j][1]) {
                    ans++;
                }
            }
        }

        return ans;
    }

    /**
     * 优化：
     * 1. 因为结果与i,j的原始坐标无关，因此可以考虑通过对原始数组排序后，成为有序数组，可以通过二分查找降低时间复杂度
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public long countFairPairs1(int[] nums, int lower, int upper) {
        int len = nums.length;
        long ans = 0L;
        // 1. 对数组进行排序
        Arrays.sort(nums);
        // 2. 遍历数组
        for (int i = 0; i < len - 1; i++) {
            int lowerIndex = searchLowerIndex(nums, lower - nums[i], i + 1, len - 1);
            if (lowerIndex == -1) continue;
            int upperIndex = searchUpperIndex(nums, upper - nums[i], i + 1, len - 1);
            if (upperIndex == -1) continue;

            ans += (upperIndex - lowerIndex + 1);
        }

        return ans;
    }

    private int searchLowerIndex(int[] nums, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[right] >= target ? right : -1;
    }

    private int searchUpperIndex(int[] nums, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return nums[right] <= target ? right : -1;
    }
}
