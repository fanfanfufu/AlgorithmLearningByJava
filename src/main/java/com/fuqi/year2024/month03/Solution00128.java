package com.fuqi.year2024.month03;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/3/26 21:36
 * @description
 */
public class Solution00128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);
        int ans = 0;
        for (int num : nums) {
            if (!numSet.contains(num-1)) {
                int cur = num;
                int curLen = 1;
                while (numSet.contains(cur+1)) {
                    cur += 1;
                    curLen += 1;
                }

                ans = Math.max(ans, curLen);
            }
        }

        return ans;
    }
}
