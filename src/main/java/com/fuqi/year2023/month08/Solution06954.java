package com.fuqi.year2023.month08;

import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/19 22:31
 * @description
 */
public class Solution06954 {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        if (n < 2) return 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target) ans++;
            }
        }

        return ans;
    }
}
