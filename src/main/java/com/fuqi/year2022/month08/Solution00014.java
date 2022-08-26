package com.fuqi.year2022.month08;

/**
 * @author FuQi
 * @date 2022/8/26 23:32
 * @description
 */
public class Solution00014 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            ans = ans.substring(0, j);
            if ("".equals(ans)) {
                return ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"dog","racecar","car"};
        String res = longestCommonPrefix(strs);
        System.out.println(res);
    }
}
