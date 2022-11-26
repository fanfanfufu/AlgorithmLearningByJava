package com.fuqi.year2022.month11;

/**
 * @author FuQi
 * @date 2022/11/26 23:34
 * @description
 */
public class Solution06250 {
    public int bestClosingTime(String customers) {
        int len = customers.length();
        // fn表示第一个到第i个累计有多少个N
        int[] fn = new int[len + 2];
        // gn表示第i个到最后累计有多少个Y
        int[] gn = new int[len + 2];
        for (int i = 1; i <= len; i++) {
            if (customers.charAt(i - 1) == 'Y') {
                fn[i] = fn[i-1];
                continue;
            }
            fn[i] = fn[i - 1] + 1;
        }
        gn[len + 1] = 0;
        for (int i = len; i > 0; i--) {
            if (customers.charAt(i - 1) == 'N') {
                gn[i] = gn[i+1];
                continue;
            }
            gn[i] = gn[i + 1] + 1;
        }

        int ans = 0, cost = Integer.MAX_VALUE;
        for (int i = 1; i <= len + 1; i++) {
            int temp = fn[i - 1] + gn[i];
            if (temp < cost) {
                ans = i;
                cost = temp;
            }
        }

        return ans - 1;
    }
}
