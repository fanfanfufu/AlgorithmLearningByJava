package com.fuqi.year2023.month06;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/11 10:39
 * @description
 */
public class Solution06465 {
    private String[] table = {
            "a", "b", "c", "d", "e", "f", "g",
            "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z"
    };
    public String smallestString(String s) {
        if (s.equals("a")) return "z";
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int cntA = 0;
        int i = 0, n = s.length();
        while (i < n) {
            if (flag && s.charAt(i) == 'a') break;
            if (s.charAt(i) == 'a') {
                sb.append(s.charAt(i));
                i++;
                cntA++;
                continue;
            }
            flag = true;
            sb.append(table[s.charAt(i)-'a'-1]);
            i++;
        }
        if (i < n) {
            sb.append(s.substring(i));
        }
        if (cntA == n) {
            // 全是A的情况
            sb.replace(n-1, n, "z");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution06465 solution06465 = new Solution06465();
        String s = "aaa";
        System.out.println(solution06465.smallestString(s));
    }
}
