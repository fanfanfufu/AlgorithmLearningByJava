package com.fuqi.year2023.month01;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2023/1/11 21:58
 * @description
 */
public class Solution00678 {
    /**
     * 方法一：借助栈
     *
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) return false;
        if (s.length() == 1 && s.charAt(0) != '*') return false;
        // 用两个栈分别存储左括号和*的index值
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack1.offerFirst(i);
                continue;
            }
            if (s.charAt(i) == '*') {
                stack2.offerFirst(i);
                continue;
            }
            // 排除前面两种情况，就只剩当前字符是右括号的情况
            // 3.1 如果两个栈都为空，则直接返回false
            if (stack1.isEmpty() && stack2.isEmpty()) return false;
            if (stack1.isEmpty()) {
                // 如果没有左括号，但是还有*，则存储*号的栈可以弹出栈顶元素
                stack2.pollFirst();
                continue;
            }
            // 否则，优先弹出左括号的元素
            stack1.pollFirst();
        }
        // 第一次遍历完之后，可能左括号和*还不为空
        // 必须要保证左括号能够和出现在其之后的*匹配
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int index1 = stack1.pollFirst();
            int index2 = stack2.pollFirst();
            // 如果左括号栈顶元素对应的左括号出现在*之后，则直接返回false
            if (index1 > index2) return false;
        }

        return stack1.isEmpty();
    }
}
