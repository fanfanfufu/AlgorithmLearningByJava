package com.fuqi.year2022.month02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<>();
        if (n < 1) return ans;
        dfs(ans, "", n, n);
        return ans;
    }

    /**
     * 生成括号对的方法
     *
     * @param ans 返回结果
     * @param path 中间过程中存储括号对的
     * @param left 左括号剩余可用数量
     * @param right 右括号剩余可用数量
     */
    private void dfs(List<String> ans, String path, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(String.join("", path));
            return;
        }
        if (left > right) {
            // 如果左括号剩余可用数量严格大于右括号剩余可用数量，则说明后续一定无法生成合法的括号对了，直接中止递归（剪枝）
            return;
        }
        if (left > 0) {
            // 如果还有左括号可以用，则添加左括号
            dfs(ans, path + "(", left-1, right);
        }
        if (right > 0) {
            // 如果右括号还有，则添加右括号
            dfs(ans, path + ")", left, right-1);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }
}
