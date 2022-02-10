package com.fuqi.year2022.month02;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2022/2/10 21:03
 * @description
 */
public class Solution00884 {
    public static boolean backspaceCompare(String s, String t) {
        // 方法一：借助额外的栈
//        return processStr(s).equals(processStr(t));

        // 方法二：双指针法
        int i = s.length()-1, j = t.length()-1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            // 执行到此说明 s.charAt(i) == t.charAt(j)
            i--;
            j--;
        }

        return true;
    }

    private static String processStr(String string) {
        Deque<Character> stack = new LinkedList<>();
        for (char ch : string.toCharArray()) {
            if (ch != '#') {
                stack.offerLast(ch);
                continue;
            }
            if (stack.isEmpty()) {
                continue;
            }
            stack.removeLast();
        }

        StringBuilder ans = new StringBuilder();
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            ans.append(stack.pollFirst());
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "aaa###a";
        String t = "aaaa###a";
        System.out.println(backspaceCompare(s, t));
    }
}
