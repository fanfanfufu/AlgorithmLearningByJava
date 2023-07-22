package com.fuqi.year2023.month07;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/22 23:00
 * @description
 */
public class Solution06926 {
    private static Set<Character> vowels = Stream.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u').collect(Collectors.toSet());

    public String sortVowels(String s) {
        if (s == null || s.length() < 2) return s;
        char[] chars = s.toCharArray();
        int n = chars.length;
        Map<Character, Integer> vowelCount = new TreeMap<>();
        for (char ch : chars) {
            if (!vowels.contains(ch)) continue;
            Integer count = vowelCount.getOrDefault(ch, 0) + 1;
            vowelCount.put(ch, count);
        }
        for (int i = 0; i < n; i++) {
            if (!vowels.contains(chars[i])) continue;
            for (Map.Entry<Character, Integer> entry : vowelCount.entrySet()) {
                Integer count = entry.getValue();
                if (count < 1) continue;
                chars[i] = entry.getKey();
                entry.setValue(count-1);
                break;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println('A' > 'E');
        System.out.println('A' < 'E');
        System.out.println('A' > 'a');
    }
}
