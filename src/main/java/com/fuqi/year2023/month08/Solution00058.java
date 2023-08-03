package com.fuqi.year2023.month08;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/1 23:12
 * @description
 */
public class Solution00058 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) return 0;
        int n = s.length();
        int right = n-1;
        while (right >= 0 && s.charAt(right) == ' ') right--;
        if (right < 0) return 0;
        int left = right;
        while (left >= 0 && s.charAt(left) != ' ') left--;

        return right - left;
    }

    public static void main(String[] args) {
        Solution00058 solution00058 = new Solution00058();
//        String s = "   fly me   to   the moon  ";
        String s = "luffy is still joyboy";
        int lengthOfLastWord = solution00058.lengthOfLastWord(s);
        System.out.println(lengthOfLastWord);
    }
}
