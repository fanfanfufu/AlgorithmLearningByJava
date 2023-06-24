package com.fuqi.year2023.month04;

import java.util.Arrays;

public class Solution06359 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = -1, right = nums[n-1] - nums[0];
        while (left + 1 < right) {
            int mid = (left + right) >>> 1, cnt = 0;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i+1] - nums[i] <= mid) {
                    cnt++;
                    i++;
                }
            }
            if (cnt >= p) right = mid;
            else left = mid;
        }

        return right;
    }
}
