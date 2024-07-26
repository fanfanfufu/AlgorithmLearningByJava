package com.fuqi.year2024.month07;

import java.util.*;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/7/26 21:37
 * @description
 */
public class Solution02766 {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) map.put(num, true);

        for (int i = 0; i < moveFrom.length; i++) {
            map.remove(moveFrom[i]);
            map.put(moveTo[i], true);
        }

        List<Integer> ans = new ArrayList<>(map.keySet());

        Collections.sort(ans);

        return ans;
    }
}
