package com.fuqi.year2022.month10;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author FuQi
 * @date 2022/10/8 20:49
 * @description
 */
public class Solution00227 {
    public static int calculate(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        char[] arr = s.toCharArray();
        char preSign = '+';
        int num = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerLast(0);
        for (int i = 0; i < n; i++) {
            int curNum = arr[i] - '0';
            if (curNum >= 0 && curNum <= 9) {
                num = num * 10 + curNum;
            }
            if ((curNum < 0 || curNum > 9) && arr[i] != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        deque.offerLast(num);
                        break;
                    case '-':
                        deque.offerLast(-num);
                        break;
                    case '*':
                        int multiRes = deque.pollLast() * num;
                        deque.offerLast(multiRes);
                        break;
                    default:
                        int divRes = deque.pollLast() / num;
                        deque.offerLast(divRes);
                }
                preSign = arr[i];
                num = 0;
            }
        }

        int ans = 0;
        while (!deque.isEmpty()) {
            ans += deque.poll();
        }

        return ans;
    }

    public static void main(String[] args) {
//        Assertions.assertEquals(0, Solution00227.calculate(null));
//        Assertions.assertEquals(0, Solution00227.calculate(""));
//        Assertions.assertEquals(0, Solution00227.calculate(" "));
        Assertions.assertEquals(1, Solution00227.calculate(" 1 "));
        Assertions.assertEquals(42, Solution00227.calculate(" 42 "));
        Assertions.assertEquals(6, Solution00227.calculate(" 42 / 7 "));
        Assertions.assertEquals(3, Solution00227.calculate(" 42 / 14 "));
        Assertions.assertEquals(3, Solution00227.calculate(" 1+2 "));
        Assertions.assertEquals(-1, Solution00227.calculate(" 1-2 "));
        Assertions.assertEquals(4, Solution00227.calculate(" 2*2 "));
        Assertions.assertEquals(1, Solution00227.calculate(" 2/2 "));
        Assertions.assertEquals(15, Solution00227.calculate("3+5*2+6/3-7+9-1-3-6+8"));
    }
}
