package com.fuqi.year2023.month08;

import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/13 10:55
 * @description
 */
public class Solution07022 {
    /**
     * 暴力写法
     *
     * @param nums
     * @param x
     * @return
     */
    public int minAbsoluteDifference0(List<Integer> nums, int x) {
        int n = nums.size();
        if (n == 1) return -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i+x; j < n; j++) {
                ans = Math.min(ans, Math.abs(nums.get(i) - nums.get(j)));
            }
        }

        return ans;
    }

    public int minAbsoluteDifference(List<Integer> nums, int x) {
        return 0;
    }
}
