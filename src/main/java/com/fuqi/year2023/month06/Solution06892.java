package com.fuqi.year2023.month06;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/24 22:33
 * @description 最大字符串配对数目
 */
public class Solution06892 {
    /**
     * 参考两数之和的思路
     *
     * @param words
     * @return
     */
    public int maximumNumberOfStringPairs(String[] words) {
        Map<String, String> wordPairMap = new HashMap<>();
        int ans = 0;

        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            if (wordPairMap.containsKey(reverse)) {
                ans++;
            }
            wordPairMap.put(word, reverse);
        }

        return ans;
    }
}
