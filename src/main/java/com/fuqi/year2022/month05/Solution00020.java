package com.fuqi.year2022.month05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2022/5/26 22:57
 * @description
 */
public class Solution00020 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                if (ch == ')' || ch == ']' || ch == '}') {
                    return false;
                }
                stack.offerFirst(ch);
                continue;
            }
            if (ch == ')' && stack.peek() == '(') {
                stack.pollFirst();
                continue;
            }
            if (ch == ']' && stack.peek() == '['){
                stack.pollFirst();
                continue;
            }
            if (ch == '}' && stack.peek() == '{') {
                stack.pollFirst();
                continue;
            }
            stack.offerFirst(ch);
        }

        return stack.isEmpty();
    }
}
