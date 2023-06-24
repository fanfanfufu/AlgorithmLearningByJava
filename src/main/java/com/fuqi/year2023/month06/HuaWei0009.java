package com.fuqi.year2023.month06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/7 23:28
 * @description
 */
public class HuaWei0009 {
    public static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> graph = new ArrayList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.length() == 0) {
                break;
            }
            graph.add(line);
        }
        in.close();
        if (graph.size() == 0) {
            System.out.println(0);
            return;
        }
        int n = graph.size();
        int m = graph.get(0).length();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = graph.get(i);
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(maxValueOfGrid(grid));
    }

    private static int maxValueOfGrid(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) continue;
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }

        return ans;
    }

    private static int[] dx = new int[]{1,0,-1,0};
    private static int[] dy = new int[]{0,-1,0,1};

    private static int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) return 0;
        int ans = grid[x][y];
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            ans += dfs(grid, x+dx[i], y+dy[i]);
        }

        return ans;
    }
}
