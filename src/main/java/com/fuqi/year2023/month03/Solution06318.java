package com.fuqi.year2023.month03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/3/12 19:03
 * @description
 */
public class Solution06318 {
    public int findMinimumTime(int[][] tasks) {
        // 按照截止时间排序
        Arrays.sort(tasks, Comparator.comparingInt(o -> o[1]));
        int ans = 0;
        boolean[] run = new boolean[2001];
        for (int[] task : tasks) {
            int start = task[0], end = task[1], duration = task[2];
            for (int i = start; i <= end; i++) {
                if (run[i]) duration--;
            }
            for (int i = end; duration > 0; i--) {
                if (!run[i]) {
                    run[i] = true;
                    duration--;
                    ans++;
                }
            }
        }

        return ans;
    }
}
