package com.fuqi.year2023.month03;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/3/12 18:58
 * @description
 */
public class Solution06317 {
    public long beautifulSubarrays(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i)
            s[i + 1] = s[i] ^ nums[i];
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : s) {
            // 先计入答案再统计个数，如果反过来的话，就相当于把空子数组也计入答案了
            ans += cnt.getOrDefault(x, 0);
            cnt.merge(x, 1, Integer::sum);
        }
        return ans;
    }
}
