package com.fuqi.year2023.month03;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/3/12 11:09
 * @description
 */
public class Solution06315 {
    private static Set<Character> target = Stream.of('a', 'e', 'i', 'o', 'u').collect(Collectors.toSet());
    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;

        for (int i = left; i <= right; i++) if (target.contains(words[i].charAt(0)) && target.contains(words[i].charAt(words[i].length()-1))) ans++;

        return ans;
    }
}
