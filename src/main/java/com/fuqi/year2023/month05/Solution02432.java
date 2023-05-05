package com.fuqi.year2023.month05;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/5 21:40
 * @description 处理用时最长的那个任务的员工
 */
public class Solution02432 {
    public int hardestWorker(int n, int[][] logs) {
        int maxTime = logs[0][1];
        int ans = logs[0][0];
        for (int i = 1; i < logs.length; i++) {
            int curTime = logs[i][1] - logs[i - 1][1];
            if (curTime < maxTime) continue;
            if (curTime == maxTime) {
                ans = Math.min(ans, logs[i][0]);
                continue;
            }
            maxTime = curTime;
            ans = logs[i][0];
        }

        return ans;
    }
}
