package com.fuqi.year2022.month08;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author FuQi
 * @date 2022/9/4 14:53
 * @description
 */
public class Solution00394 {
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch - '0' >= 0 && ch - '0' <= 9) {
                // 当前位是数字，则需要将其后面中括号中的内容迭代多次
                StringBuilder numStr = new StringBuilder();
                while (s.charAt(i) != '[') {
                    numStr.append(s.charAt(i));
                    i++;
                }
                int times = Integer.parseInt(numStr.toString());
                Deque<Character> stack = new ArrayDeque<>();
                int j = i;
                while (j < n) {
                    // 找到当前左括号对应的右括号
                    if (s.charAt(j) == '[') {
                        stack.offerFirst(s.charAt(j));
                        j++;
                       continue;
                    }
                    if (s.charAt(j) == ']') {
                        stack.pollFirst();
                        if (stack.isEmpty()) {
                            // 如果此时栈为空，则说明当前的右括号与第一个左括号是成对的
                            // 因此可以终止循环
                            break;
                        }
                    }
                    j++;
                }
                // 找到又括号下标后，则递归处理当前括号中的
                String after = decodeString(s.substring(i + 1, j));
                // 添加数字的次数进入sb
                for (int k = 0; k < times; k++) {
                    sb.append(after);
                }
                // 更新i的值，然后进入下一次循环
                i = j+1;
                continue;
            }
            // 如果当前位不是数字
            sb.append(ch);
            i++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("abc"));
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[cmd7[p]]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("abc3[cd]xyz"));
        System.out.println(decodeString("100[leetcode]"));
    }
}
