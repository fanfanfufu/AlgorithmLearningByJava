package com.fuqi.year2022.month01;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author FuQi
 * @date 2022/1/6 23:45
 * @description
 */
public class Solution00071 {
    /**
     * 直接模拟
     * @param path
     * @return
     */
    public String simplifyPath1(String path) {
        Deque<String> tempNames = new LinkedList<>();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                continue;
            }
            int cur = i;
            while (i < path.length() && path.charAt(i) != '/') {
                i++;
            }
            String substring = path.substring(cur, i);
            if (!".".equals(substring) && !"..".equals(substring)) {
                tempNames.offer(substring);
            } else if ("..".equals(substring) && !tempNames.isEmpty()) {
                tempNames.removeLast();
            }
        }

        String ans = "/";
        if (tempNames.isEmpty()) {
            return ans;
        }

        return ans + String.join("/", tempNames);
    }

    /**
     * 借助栈
     * @param path
     * @return
     */
    public String simplifyPath2(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] names = path.split("/");
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offer(name);
            }
        }

        String ans = "/";
        if (stack.isEmpty()) {
            return ans;
        }

        return ans + String.join("/", stack);
    }
}
