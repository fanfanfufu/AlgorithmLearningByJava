package com.fuqi.year2023.month07;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/30 11:17
 * @description
 */
public class Solution06918 {
    /**
     * 组合两个字符串，如果有首尾重合的部分，则进行合并
     *
     * @param a
     * @param b
     * @return
     */
    String concat(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            boolean legal = true;
            for (int j = 0; legal && j < b.length() && (i + j) < a.length(); j++) {
                if (a.charAt(i + j) != b.charAt(j)) {
                    legal = false;
                }
            }
            if (legal) {
                StringBuilder sb = new StringBuilder(a);
                for (int j = a.length() - i; j < b.length(); j++) {
                    sb.append(b.charAt(j));
                }
                return sb.toString();
            }
        }
        return a + b;
    }

    String getBetter(String a, String b) {
        if (a.length() < b.length()) {
            return a;
        }
        if (a.length() > b.length()) {
            return b;
        }
        return a.compareTo(b) < 0 ? a : b;
    }

    public String minimumString(String a, String b, String c) {
        String ret = concat(concat(a, b), c);
        ret = getBetter(ret, concat(concat(a, c), b));
        ret = getBetter(ret, concat(concat(b, a), c));
        ret = getBetter(ret, concat(concat(b, c), a));
        ret = getBetter(ret, concat(concat(c, a), b));
        ret = getBetter(ret, concat(concat(c, b), a));
        return ret;
    }

    public static void main(String[] args) {
        Solution06918 solution06918 = new Solution06918();
        String a = "abc";
        String b = "bca";
        solution06918.concat(a, b);
    }
}
