package com.fuqi.year2023.month07;

import java.util.*;

/**
 * 报文过滤
 */
public class Honor071302 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str == null || str.trim().length() == 0) {
            System.out.println("");
            in.close();
            return;
        }
        List<String> ans = checkMessage(str.split(" "));
        if (ans.isEmpty()) {
            System.out.println();
        } else {
            System.out.println(String.join(" ", ans));
        }
    }

    private static String edge = "5a";
    private static String trans = "5b";

    private static List<String> checkMessage(String[] messages) {
        List<String> ans = new ArrayList<>();
        Deque<String> window = new ArrayDeque<>();
        int n = messages.length;
        int lengthChange = 0;
        for (int i = 0; i < n; i++) {
            if (window.isEmpty()) {
                if (edge.equals(messages[i])) {
                    window.offerLast(messages[i]);
                }
                continue;
            }
            // 如果已经有了5a，再出现一个5a的时
            if (edge.equals(messages[i])) {
                // 1. 首先校验是否是一个完整的报文
                int singleMessageLength = Integer.parseInt(window.peekLast(), 16);
                if (window.size() - 2 + lengthChange == singleMessageLength) {
                    // 如果此时窗口里的报文长度与长度域一致，则说明此时是一个合法的报文，需要输出到结果集中
                    while (!window.isEmpty()) {
                        ans.add(window.pollFirst());
                    }
                    lengthChange = 0;
                    window.offerLast(edge);
                    continue;
                }
                // 不符合一个完整报文的要求，则清除前面窗口中的内容
                window.clear();
                window.offerLast(edge);
                lengthChange = 0;
                continue;
            }
            // 如果已经有了5a，再遇到了5b
            if ("5b".equals(messages[i])) {
                if (i == n-1) {
                    window.clear();
                    if (!ans.isEmpty()) {
                        ans.add(edge);
                    }
                    break;
                }
                if ("ba".equals(messages[i + 1]) || "bb".equals(messages[i + 1])) {
                    window.offerLast(messages[i]);
                    lengthChange -= 1;
                    continue;
                }
                // 后一个不是转义的字符串，则是不符合要求的报文
                window.clear();
                lengthChange = 0;
                continue;
            }
            // 普通字符串内容
            window.offerLast(messages[i]);
        }
        if (!ans.isEmpty()) {
            ans.add(edge);
        }

        return ans;
    }
}
