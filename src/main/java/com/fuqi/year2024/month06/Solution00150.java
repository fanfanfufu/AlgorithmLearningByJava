package com.fuqi.year2024.month06;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/6/15 16:21
 * @description 逆波兰表达式
 */
public class Solution00150 {
    private Set<String> operatorSet = Stream.of("+", "-", "*", "/").collect(Collectors.toSet());

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (operatorSet.contains(token)) {
                int num2 = stack.pollFirst();
                int num1 = stack.pollFirst();
                int curRes = 0;
                switch (token) {
                    case "+":
                        curRes = num1 + num2;
                        break;
                    case "-":
                        curRes = num1 - num2;
                        break;
                    case "*":
                        curRes = num1 * num2;
                        break;
                    case "/":
                        curRes = num1 / num2;
                        break;
                    default:
                }
                stack.offerFirst(curRes);
            } else {
                stack.offerFirst(Integer.parseInt(token));
            }
        }

        return stack.pollFirst();
    }
}
