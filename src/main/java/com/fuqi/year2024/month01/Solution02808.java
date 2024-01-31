package com.fuqi.year2024.month01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/1/30 21:51
 * @description
 */
public class Solution02808 {
    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.size(), ans = n;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> positions : map.values()) {
            int mx = positions.get(0) + n - positions.get(positions.size() - 1);
            for (int i = 1; i < positions.size(); i++) {
                mx = Math.max(mx, positions.get(i) - positions.get(i - 1));
            }
            ans = Math.min(ans, mx / 2);
        }

        return ans;
    }
}
