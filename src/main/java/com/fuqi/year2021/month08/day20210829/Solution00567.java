package com.fuqi.year2021.month08.day20210829;

import java.util.Arrays;

/**
 * 字符串的排列
 * @author FuQi
 */
public class Solution00567 {
    /**
     * 暴力解法
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion1(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);
        String s1N = new String(s1Array);

        if (s1.length() == s2.length()) {
            char[] s2Array = s2.toCharArray();
            Arrays.sort(s2Array);
            String s2N = new String(s2Array);

            return s1N.equals(s2N);
        }

        for (int i = 0; i < s2.length()-s1.length()+1; i++) {
            String ch = String.valueOf(s2.charAt(i));
            if (!s1.contains(ch)) {
                continue;
            }
            char[] subStrArray = s2.substring(i, i + s1.length()).toCharArray();
            Arrays.sort(subStrArray);
            String subStr = new String(subStrArray);
            if (subStr.equals(s1N)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 滑动窗口解法
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        // 先判断s1和s2长度相等的时候是否相等
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        // 从s2的第n位开始滑动窗口，
        // 对进入窗口的字母进行+1操作，对离开窗口的字母进行减1操作
        for (int i = n; i < m; ++i) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 滑动窗口的优化
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion3(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
            ++cnt[s2.charAt(i) - 'a'];
        }
        int diff = 0;
        for (int c : cnt) {
            if (c != 0) {
                ++diff;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < m; ++i) {
            int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
            if (x == y) {
                continue;
            }
            if (cnt[x] == 0) {
                ++diff;
            }
            ++cnt[x];
            if (cnt[x] == 0) {
                --diff;
            }
            if (cnt[y] == 0) {
                ++diff;
            }
            --cnt[y];
            if (cnt[y] == 0) {
                --diff;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 双指针法
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion4(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /*
        "ab", "eidbaooo"----true
        "ab", "eidaooo"--false
        "abc", "eidbacooo"--true
        "abc", "eidbcooo"--false
        "oo", "eidbcooo"--true
         */
        // true
        System.out.println(checkInclusion1("ab", "eidbaooo"));
        // false
        System.out.println(checkInclusion1("ab", "eidaooo"));
        // true
        System.out.println(checkInclusion1("abc", "eidbacooo"));
        // false
        System.out.println(checkInclusion1("abc", "eidbcooo"));
        // true
        System.out.println(checkInclusion1("oo", "eidbcooo"));
        // true
        System.out.println(checkInclusion4("adc", "dcda"));
        // false
        System.out.println(checkInclusion1("oo", "ob"));
        // true
        System.out.println(checkInclusion1("ab", "ba"));
        // false
        System.out.println(checkInclusion4("hello", "ooolleoooleh"));
    }
}
