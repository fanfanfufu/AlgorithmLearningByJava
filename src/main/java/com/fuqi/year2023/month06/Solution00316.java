package com.fuqi.year2023.month06;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/25 00:00
 * @description 去除重复字母
 */
public class Solution00316 {
    public String removeDuplicateLetters(String s) {
        char[] charArray = s.toCharArray();
        int[] cnt = new int[26];
        for (char ch : charArray) {
            cnt[ch - 'a']++;
        }
        // 记录字符是否被压入栈中
        boolean[] used = new boolean[26];

        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : charArray) {
            // 如果当前字符已经在栈中了，则直接跳过
            if (used[ch-'a']) {
                cnt[ch-'a']--;
                continue;
            }
            // 为什么要放在last，是为了后续根据stack构造输出字符串时，不需要再额外的翻转一次
            // 如果栈不为空并且栈顶元素字典序大于当前字符，并且栈顶元素的出现次数还大于0
            while (!stack.isEmpty() && stack.peekLast() > ch && cnt[stack.peekLast()-'a'] > 0) {
                // 取出栈顶元素
                Character last = stack.pollLast();
                // 将栈顶元素标记为未在栈中
                used[last-'a'] = false;
            }
            // 压入当前字符
            stack.offerLast(ch);
            // 标记为已入栈
            used[ch-'a'] =  true;
            // 减去当前字符的出现次数
            cnt[ch-'a']--;
        }

        StringBuilder ans = new StringBuilder();
        for (char ch : stack) {
            ans.append(ch);
        }

        return ans.toString();
    }
}
