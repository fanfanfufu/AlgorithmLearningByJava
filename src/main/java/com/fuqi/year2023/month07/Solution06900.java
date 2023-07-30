package com.fuqi.year2023.month07;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/30 10:35
 * @description
 */
public class Solution06900 {
    public int countCompleteSubarrays(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            int count = numCount.getOrDefault(num, 0) + 1;
            numCount.put(num, count);
        }
        int n = nums.length;
        int size = numCount.size();
        if (size == 1) {
            return (n*(n+1)) / 2;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> subArrayNumCount = new HashMap<>();
            for (int j = i; j < n; j++) {
                int count = subArrayNumCount.getOrDefault(nums[j], 0) + 1;
                subArrayNumCount.put(nums[j], count);
                if (subArrayNumCount.size() == size) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
