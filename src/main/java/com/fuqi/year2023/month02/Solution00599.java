package com.fuqi.year2023.month02;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author FuQi
 * @date 2023/2/15 21:34
 * @description
 */
public class Solution00599 {
    /**
     * 哈希表法
     *
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant0(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        int minIndexSum = Integer.MAX_VALUE;
        List<String> ansRes = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            // 如果map2中不包含当前key，则遍历下一个
            if (!map2.containsKey(key)) continue;
            int curIndexSum = entry.getValue() + map2.get(key);
            if (curIndexSum < minIndexSum) {
                minIndexSum = curIndexSum;
                ansRes = Stream.of(key).collect(Collectors.toList());
            } else if (curIndexSum == minIndexSum) {
                ansRes.add(key);
            }
        }

        String[] ans = new String[ansRes.size()];
        for (int i = 0; i < ansRes.size(); i++) {
            ans[i] = ansRes.get(i);
        }

        return ans;
    }

    /**
     * 哈希表法优化
     *
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant1(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        int minIndexSum = Integer.MAX_VALUE;
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (i > minIndexSum) continue;
            String curS = list2[i];
            if (!map1.containsKey(curS)) continue;
            int curIndexSum = i + map1.get(curS);
            if (curIndexSum > minIndexSum) continue;
            if (curIndexSum < minIndexSum) {
                // 如果索引和更小，则更新索引和，并且清空ret
                minIndexSum = curIndexSum;
                ret.clear();
            }
            // 添加当前餐厅名到ret中
            ret.add(curS);
        }

        return ret.toArray(new String[0]);
    }
}
