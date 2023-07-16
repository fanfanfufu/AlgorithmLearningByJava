package com.fuqi.year2023.month07;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/15 14:02
 * @description
 */
public class Solution01081 {
    public String smallestSubsequence(String s) {
        if (s == null || s.length() < 2) return s;
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) cnt[ch-'a']++;

        boolean[] used = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (used[ch-'a']) {
                cnt[ch-'a']--;
                continue;
            }
            while (cnt[ch-'a'] > 0 && !stack.isEmpty() && stack.peekLast() < ch) {
                Character last = stack.pollLast();
                used[last-'a'] = false;
            }
            stack.offerLast(ch);
            used[ch-'a'] = true;
            cnt[ch-'a']--;
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) ans.append(stack.pollFirst());

        return ans.toString();
    }
}
