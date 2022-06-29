package com.fuqi.year2022.month02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/2/17 22:53
 * @description 括号生成
 */
public class Solution00022 {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);

        return ans;
    }

    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        // close < open，能保证左右括号数量相等，不会出现一些非法的组合
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
