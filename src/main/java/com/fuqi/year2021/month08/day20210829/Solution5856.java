package com.fuqi.year2021.month08.day20210829;

import java.util.Arrays;

/**
 * TODO：设计较多位运算相关操作，后续再重做
 * @author FuQi
 */
public class Solution5856 {
    public static int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length, m = 1 << n;
        final int INF = 20;
        int[] dp = new int[m];
        Arrays.fill(dp, INF);

        // 预处理每个状态，合法状态预设为 1
        for (int i = 1; i < m; i++) {
            int state = i, idx = 0;
            int spend = 0;
            while (state > 0) {
                int bit = state & 1;
                if (bit == 1) {
                    spend += tasks[idx];
                }
                state >>= 1;
                idx++;
            }
            if (spend <= sessionTime) {
                dp[i] = 1;
            }
        }

        // 对每个状态枚举子集，跳过已经有最优解的状态
        for (int i = 1; i < m; i++) {
            if (dp[i] == 1) {
                continue;
            }
            for (int j = i; j > 0; j = (j - 1) & i) {
                // i 状态的最优解可能由当前子集 j 与子集 j 的补集得来
                dp[i] = Math.min(dp[i], dp[j] + dp[i ^ j]);
            }
        }

        return dp[m - 1];
    }

    public static void main(String[] args) {
        int[] tasks = new int[]{3,2,3,6,7};
        int sessionTime = 8;
        System.out.println(minSessions(tasks, sessionTime));
    }
}
