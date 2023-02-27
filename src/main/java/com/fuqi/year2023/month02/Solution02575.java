package com.fuqi.year2023.month02;

/**
 * @author FuQi
 * @date 2023/2/27 22:08
 * @description
 */
public class Solution02575 {
    /**
     * 判断一个属能否被另一个数整除：模运算
     * 模运算前置知识：
     * 假设 a = k1*m + r1，b = k2*m + r2
     * 那么：
     * (a+b) mod m = (k1*m+r1+k2*m+r2) mod m = ((k1+k2)*m + (r1+r2)) mod m
     * 那么最终结果主要就是看 两个余数之和(r1+r2)能否被mod整除，即 (r1+r2) mod m ? 0
     *
     * @param word
     * @param m
     * @return
     */
    public int[] divisibilityArray(String word, int m) {
        // 对word为空、包含非数字的输入情况暂不考虑
        if (word.length() == 1) {
            // 如果word只有以为，则直接判断能否被
            return Integer.parseInt(word) % m == 0 ? new int[]{1} : new int[]{0};
        }
        int[] ans = new int[word.length()];
        long x = 0L;
        for (int i = 0; i < ans.length; i++) {
            x = (x*10 + (word.charAt(i)-'0')) % m;
            ans[i] = x == 0 ? 1 : 0;
        }

        return ans;
    }
}
