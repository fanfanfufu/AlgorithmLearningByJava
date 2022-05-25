package com.fuqi.year2022.month05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2022/5/25 22:44
 * @description 迷宫中离入口最近的出口距离，BFS解法
 */
public class Solution01926 {
    private int[] dx = new int[]{1,0,-1,0};
    private int[] dy = new int[]{0,-1,0,1};

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int ans = 0;
        Deque<int[]> deque = new LinkedList<>();
        deque.offerLast(entrance);
        while (!deque.isEmpty()) {
            int len = deque.size();
            while (len > 0) {
                int[] temp = deque.pollFirst();
                int x = temp[0], y = temp[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx < 0 || nx == m || ny < 0 || ny == n) {
                        if (x != entrance[0] || y != entrance[1]) {
                            // 因为时广度优先遍历，所以距离最短的最先返回，不用比较距离的大小
                            return ans;
                        }
                    } else if (maze[nx][ny] == '.') {
                        maze[nx][ny] = '+';
                        deque.offerLast(new int[]{nx, ny});
                    }
                }
                len--;
            }
            ans++;
        }

        return -1;
    }
}
