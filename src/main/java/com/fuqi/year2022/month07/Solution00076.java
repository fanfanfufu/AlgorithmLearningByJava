package com.fuqi.year2022.month07;

/**
 * @author FuQi
 * @date 2022/7/10 23:03
 * @description
 */
public class Solution00076 {
    /**
     * 滑动窗口, 维护合法区间, 判断区间长度是否更小, 记录区间头与区间长度
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int[] cnts = new int[100];
        for (char ch : t.toCharArray()) {
            cnts[ch - 'A']++;
        }
        char[] cs = s.toCharArray();
        int num = t.length(), pre = 0, ans = cs.length+1, pos = 0, len = cs.length;
        for (int i = 0; i < len; i++) {
            if (--cnts[cs[i]-'A'] >= 0) {
                num--;
            }
            while (pre < len && cnts[cs[pre]-'A'] < 0) {
                cnts[cs[pre++]-'A']++;
            }
            if (num == 0 && i-pre+1 < ans) {
                ans = i-pre+1;
                pos = pre;
            }
        }

        return ans == cs.length+1 ? "" : s.substring(pos, pos+ans);
    }
}
