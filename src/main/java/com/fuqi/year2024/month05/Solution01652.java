package com.fuqi.year2024.month05;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/5/5 09:13
 * @description
 */
public class Solution01652 {
    /**
     * 暴力法直接模拟
     *
     * @param code 输入
     * @param k k个
     * @return
     */
    public int[] decrypt1(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }
        int[] ans = new int[n];
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= k; j++) {
                    int index = (i+j) % n;
                    sum += code[index];
                }
                ans[i] = sum;
            }
        } else {
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 1; j <= Math.abs(k); j++) {
                    int index = (i-j+n) % n;
                    sum += code[index];
                }
                ans[i] = sum;
            }
        }

        return ans;
    }

    /**
     * 前缀和
     * @param code
     * @param k
     * @return
     */
    public int[] decrypt2(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            Arrays.fill(code, 0);
            return code;
        }
        int[] preSum = new int[n*2];
        for (int i = 1; i <= n * 2; i++) preSum[i] = preSum[i-1] + code[(i-1)%n];

        int[] ans = new int[n];
        if (k > 0) {
            for (int i = 0; i < n; i++) ans[i] = preSum[i+k+1]-preSum[i+1];
        } else {
            for (int i = 0; i < n; i++) ans[i] = preSum[i+n] - preSum[i+k+n];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] code = new int[]{5,7,1,4};
    }
}
