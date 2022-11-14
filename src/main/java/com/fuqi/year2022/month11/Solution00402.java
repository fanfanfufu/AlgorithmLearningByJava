package com.fuqi.year2022.month11;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2022/11/14 22:01
 * @description
 */
public class Solution00402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                // 当deque不为空并且k>0以及栈顶元素大于当前元素时，就需要弹出栈顶元素
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        // 针对还能继续弹出元素的情况
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        // 拼接结果
        StringBuilder ans = new StringBuilder();
        while (!deque.isEmpty()) {
            Character digit = deque.pollFirst();
            if (ans.length() == 0 && digit == '0') {
                // 前导0需要跳过
                continue;
            }
            ans.append(digit);
        }

        return ans.length() == 0 ? "0" : ans.toString();
    }
}
