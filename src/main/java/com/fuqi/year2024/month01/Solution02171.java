package com.fuqi.year2024.month01;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/1/18 22:18
 * @description
 */
public class Solution02171 {
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long total = 0;
        for (int i = 0; i < n; i++) {
            total += beans[i];
        }
        long ans = total;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, total - (long) beans[i] * (n - i));
        }

        return ans;
    }
}
