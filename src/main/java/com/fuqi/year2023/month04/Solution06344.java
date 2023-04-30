package com.fuqi.year2023.month04;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/4/30 16:52
 * @description
 */
public class Solution06344 {
    public String smallestBeautifulString(String s, int k) {
        int len = s.length() - 1;
        for (int i = len; i >= 0; i--) {
            int cur = s.charAt(i) - 'a';
            if (cur == k - 1) continue;
            int[] t = before(s, i);
            int isValid = -1;
            for (int j = cur + 1; j < k; ++j) {
                if (j != t[0] && j != t[1]) {
                    isValid = j;
                    break;
                }
            }
            if (isValid != -1) {
                StringBuilder res = new StringBuilder(s.substring(0, i));
                res.append((char)(isValid + 'a'));
                for (int j = i + 1; j <= len; ++j) {
                    int b1 = res.charAt(res.length() - 1) - 'a';
                    int b2 = res.length() - 2 >= 0 ? (res.charAt(res.length() - 2) - 'a') : -1;
                    res.append(findBest(k, b1, b2));
                }
                return res.toString();
            }
        }

        return "";
    }

    private int[] before(String s, int p) {
        int l1 = p - 1 >= 0 ? (s.charAt(p-1) - 'a') : -1;
        int l2 = p - 2 >= 0 ? (s.charAt(p-2) - 'a') : -1;

        return new int[]{l1, l2};
    }

    private char findBest(int k, int a, int b) {
        for (int i = 0; i < k; i++) {
            if (i != a && i != b) {
                return (char) (i+'a');
            }
        }

        return 0;
    }
}
