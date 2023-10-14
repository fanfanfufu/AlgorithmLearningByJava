package com.fuqi.year2023.month10;

import java.util.*;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/10/13 22:43
 * @description
 */
public class Solution01488 {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                set.add(i);
                continue;
            }
            ans[i] = -1;
            if (map.containsKey(rains[i])) {
                Integer ceiling = set.ceiling(map.get(rains[i]));
                if (ceiling == null) return new int[0];
                ans[ceiling] = rains[i];
                set.remove(ceiling);
            }
            map.put(rains[i], i);
        }

        return ans;
    }
}
