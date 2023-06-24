package com.fuqi.year2023.month04;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/4/2 10:33
 * @description
 */
public class Solution06362 {
    public int findTheLongestBalancedSubstring(String s) {
        if (s.length() == 1) return 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 1; i < len; i++) {
            if (chars[i] == '1' && chars[i-1] == '0') {
                int temp = expandFind(chars, i);
                ans = Math.max(temp, ans);
            }
        }

        return ans;
    }

    private int expandFind(char[] chars, int i) {
        if (i == chars.length-1) return 2;
        if (i == 1) return 2;
        int left = i-1, right = i, ans = 0;
        while (left >= 0 && right < chars.length) {
            if (chars[left] != '0' || chars[right] != '1') break;
            ans = Math.max(right-left+1, ans);
            left--;
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution06362 solution06362 = new Solution06362();
        String s = "01000111";
        int max = solution06362.findTheLongestBalancedSubstring(s);
        System.out.println(max);
    }
}
