package com.fuqi.year2023.month09;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/9/13 23:19
 * @description
 */
public class Solution02596 {
    private final int[][] nextPos = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        boolean[][] isVisited = new boolean[n][n];

        Deque<int[]> nextVisit = new ArrayDeque<>();
        nextVisit.offerLast(new int[]{0, 0});
        isVisited[0][0] = true;
        int curNum = 0;

        while (!nextVisit.isEmpty()) {
            int[] curPos = nextVisit.pollFirst();
            for (int i = 0; i < 8; i++) {
                int x = curPos[0] + nextPos[i][0], y = curPos[1] + nextPos[i][1];
                if (x < 0 || x >= n || y < 0 || y >= n || isVisited[x][y]) continue;
                int nextNum = grid[x][y];
                if (nextNum == curNum + 1) {
                    nextVisit.offerLast(new int[]{x, y});
                    isVisited[x][y] = true;
                    curNum = nextNum;
                    break;
                }
            }
        }

        return curNum == n * n - 1;
    }
}
