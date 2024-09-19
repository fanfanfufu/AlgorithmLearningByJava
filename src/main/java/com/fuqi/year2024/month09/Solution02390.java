package com.fuqi.year2024.month09;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/9/14 23:43
 * @description
 */
public class Solution02390 {
    public String removeStars(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (stringBuilder.length() == 0) continue;
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
                continue;
            }
            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }

    public String removeStars2(String s) {
        Deque<String> deque = new ArrayDeque<>();
        for (char cur : s.toCharArray()) {
            if (cur == '*') {
                deque.pollLast();
            } else {
                deque.offerLast(String.valueOf(cur));
            }
        }
        return String.join("", deque);
    }
}
