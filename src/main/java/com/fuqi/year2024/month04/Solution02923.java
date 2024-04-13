package com.fuqi.year2024.month04;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/4/12 22:00
 * @description
 */
public class Solution02923 {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < n) {
                // 如果遇到为0的表示此时i队比j队弱，则i队不满足条件，
                // 因此第i行不用再遍历了
                if (i != j && grid[i][j] == 0) break;
                j++;
            }
            // 这一行遍历完的话，说明i队没有遇到比它强的队伍，则i队就是冠军队伍
            if (j == n) return i;
        }

        return n;
    }
}
