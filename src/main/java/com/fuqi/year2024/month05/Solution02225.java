package com.fuqi.year2024.month05;

import java.util.*;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/5/22 20:49
 * @description
 */
public class Solution02225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int[] match : matches) {
            int winner = match[0], loser = match[1];
            freq.putIfAbsent(winner, 0);
            freq.put(loser, freq.getOrDefault(loser, 0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < 2; ++i) {
            ans.add(new ArrayList<Integer>());
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (value < 2) {
                ans.get(value).add(key);
            }
        }

        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}
