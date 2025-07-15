package com.fuqi.year2025.month07;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2025/7/15 23:14
 * @description
 */
public class Solution03136 {
    Set<Character> set = Stream.of('a', 'e', 'i', 'o', 'u').collect(Collectors.toSet());
    public boolean isValid(String word) {
        if (word == null || word.length() < 3) {
            return false;
        }
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                char ch = Character.toLowerCase(c);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return hasVowel && hasConsonant;
    }

    public static void main(String[] args) {
        String word = "234Adas";
        Solution03136 solution03136 = new Solution03136();
        boolean valid = solution03136.isValid(word);
        System.out.println("valid = " + valid);
    }
}
