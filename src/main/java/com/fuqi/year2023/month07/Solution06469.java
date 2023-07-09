package com.fuqi.year2023.month07;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/8 23:15
 * @description
 */
public class Solution06469 {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Map<Integer, Boolean> stoneCountMap = new TreeMap<>();
        for (int num : nums) {
            if (stoneCountMap.containsKey(num)) continue;
            stoneCountMap.put(num, true);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            Boolean hasStone = stoneCountMap.getOrDefault(moveFrom[i], false);
            if (!hasStone) continue;
            // 移除旧位置上的石头
            stoneCountMap.remove(moveFrom[i]);
            // 为新位置的石头设置值
            if (stoneCountMap.containsKey(moveTo[i])) continue;
            stoneCountMap.put(moveTo[i], true);
        }

        return new ArrayList<>(stoneCountMap.keySet());
    }
}
