package com.fuqi;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/9/9 23:09
 * @Version V1.0
 */
public class Main2 {
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                mi = next[mi];
            }
        }
        return mi == ms.length ? si - mi : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[ms.length];
        next[0] = -1;//规定0位置为-1
        next[1] = 0;//规定1位置为0
        int pos = 2;//标记从2开始的位置
        int cn = 0;//cn为跳的位置与(i+1)比较
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];//cn往前跳，继续找自己前面的前半段
            } else {
                next[pos++] = 0;//不存在前缀与后缀相等
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabaabaabcacb";
        String match = "abaabcac";
        System.out.println(getIndexOf(str, match));

    }
}
