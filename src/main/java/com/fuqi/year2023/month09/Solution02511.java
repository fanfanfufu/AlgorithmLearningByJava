package com.fuqi.year2023.month09;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/9/2 22:55
 * @description 最多可以摧毁的敌人城堡数目
 */
public class Solution02511 {
    public int captureForts(int[] forts) {
        int n = forts.length;
        int ans = 0, pre = -1;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1 || forts[i] == -1) {
                if (pre >= 0 && forts[i] != forts[pre]) {
                    ans = Math.max(ans, i - pre - 1);
                }
                pre = i;
            }
        }
        return ans;
    }
}
