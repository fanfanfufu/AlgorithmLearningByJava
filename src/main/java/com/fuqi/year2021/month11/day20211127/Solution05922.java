package com.fuqi.year2021.month11.day20211127;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author FuQi
 * @date 2021/11/27 23:01
 * @description 统计出现过一次的公共字符串
 */
public class Solution05922 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Long> map1 = Arrays.stream(words1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> map2 = Arrays.stream(words2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int ans = 0;
        for (String word : map1.keySet()) {
            if (map1.get(word) > 1) {
                continue;
            }
            // 只出现一次
            if (map2.getOrDefault(word, 0L) == 1) {
                ans++;
            }
        }

        return ans;
    }
}
