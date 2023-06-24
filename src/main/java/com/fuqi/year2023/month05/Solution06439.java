package com.fuqi.year2023.month05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/21 21:34
 * @description 6439. 删除子串后的字符串最小长度
 */
public class Solution06439 {
    /**
     * 参考括号匹配的题的解法，借助栈来解决
     *
     * @param s
     * @return
     */
    public int minLength(String s) {
        if (s.length() < 2) return s.length();
        Deque<String> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.offerFirst(String.valueOf(ch));
                continue;
            }
            if (ch == 'B' && stack.peekFirst().equals("A")) {
                stack.pollFirst();
                continue;
            }
            if (ch == 'D' && stack.peekFirst().equals("C")) {
                stack.pollFirst();
                continue;
            }
            stack.offerFirst(String.valueOf(ch));
        }

        return stack.size();
    }
}
