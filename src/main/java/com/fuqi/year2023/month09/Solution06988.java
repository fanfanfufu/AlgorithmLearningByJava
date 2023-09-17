package com.fuqi.year2023.month09;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/9/16 23:00
 * @description
 */
public class Solution06988 {
    /**
     * 暴力解法
     *
     * @param coordinates
     * @param k
     * @return
     */
    public int countPairs(List<List<Integer>> coordinates, int k) {
        int ans = 0;
        int n = coordinates.size();
        for (int i = 0; i < n; i++) {
            List<Integer> cur = coordinates.get(i);
            for (int j = i + 1; j < n; j++) {
                List<Integer> next = coordinates.get(j);
                if ((cur.get(0) ^ next.get(0)) + (cur.get(1) ^ next.get(1)) == k) ans++;
            }
        }

        return ans;
    }

    /**
     * 类似两数之和
     *
     * @param coordinates
     * @param k
     * @return
     */
    public int countPairs2(List<List<Integer>> coordinates, int k) {
        int cnt = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (List<Integer> coordinate : coordinates) {
            int x = coordinate.get(0);
            int y = coordinate.get(1);
            for (int i = 0; i <= k; i++) {
                Map<Integer, Integer> map1 = map.get(x ^ i);
                if (map1 == null) {
                    continue;
                }
                cnt += map1.getOrDefault(y ^ (k - i), 0);
            }
            Map<Integer, Integer> map1 = map.computeIfAbsent(x, key -> new HashMap<>());
            map1.put(y, map1.getOrDefault(y, 0) + 1);
        }
        return cnt;
    }

}
