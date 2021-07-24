package com.fuqi.year2021.month07.day20210724;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FuQi
 */
public class Solution1 {
    public static void main(String[] args) {

    }

    public boolean areOccurrencesEqual(String s) {
        if (s.length() == 1) {
            return true;
        }
        Map<Character, Integer> charCount = new HashMap<>(16);

        for (char ch : s.toCharArray()) {
            if (charCount.containsKey(ch)) {
                int count = charCount.get(ch) + 1;
                charCount.put(ch, count);
                continue;
            }
            charCount.put(ch, 1);
        }

        int count1 = charCount.get(s.charAt(0));
        for (int count2 : charCount.values()) {
            if (count1 != count2) {
                return false;
            }
        }

        return true;
    }
}
