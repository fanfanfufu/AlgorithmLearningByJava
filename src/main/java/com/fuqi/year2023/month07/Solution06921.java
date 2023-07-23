package com.fuqi.year2023.month07;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/23 10:49
 * @description
 */
public class Solution06921 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (word.length() == 0) continue;
            int i = 0, j = i, n = word.length();
            while (j < n) {
                while (j < n && separator != word.charAt(i)) j++;
                if (i == j) {
                    i++;
                    j++;
                    continue;
                }
                ans.add(word.substring(i, j));
                if (j == n) continue;
                i = j + 1;
                j = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<String> words = Stream.of("|||").collect(Collectors.toList());
        Solution06921 solution06921 = new Solution06921();
        List<String> strings = solution06921.splitWordsBySeparator(words, '.');
        System.out.println();
    }
}
