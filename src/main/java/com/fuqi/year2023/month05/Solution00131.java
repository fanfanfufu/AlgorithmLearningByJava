package com.fuqi.year2023.month05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/12 22:28
 * @description 131 分割回文串
 */
public class Solution00131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        int start = 0, n = s.length();

        dfs(ans, path, s, start, n);

        return ans;
    }

    private void dfs(List<List<String>> ans, Deque<String> path, String s, int start, int n) {
        if (start == n) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < n; i++) {
            // 取出start-i的字串，如果字串是回文串，则递归处理后续的字串
            String curS = s.substring(start, i + 1);
            if (isPalindrome(curS)) {
                path.offerLast(curS);
                dfs(ans, path, s, i+1, n);
                path.pollLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(s.substring(1, 3));
    }
}
