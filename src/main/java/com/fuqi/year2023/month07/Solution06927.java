package com.fuqi.year2023.month07;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/16 11:53
 * @description
 */
public class Solution06927 {
    public int minimumIndex(List<Integer> nums) {
        if (nums.size() == 1) return -1;
        // 1 遍历找到频率最高的数以及对应的频次
        int x = nums.get(0);
        int freq = 1;
        Map<Integer, Integer> numCount = new HashMap<>();
        for (Integer num : nums) {
            int count = numCount.getOrDefault(num, 0) + 1;
            numCount.put(num, count);
            if (count > freq) {
                x = num;
                freq = count;
            }
        }
        // 2 从左往右遍历截止到i处，左右两边的众数是否与整个数组的众数一致
        int n = nums.size();
        int curFreq = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) != x) continue;
            curFreq += 1;
            if (curFreq * 2 > (i+1) && (freq - curFreq) * 2 > (n-i-1)) return i;
        }

        return -1;
    }
}
