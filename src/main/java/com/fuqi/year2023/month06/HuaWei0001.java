package com.fuqi.year2023.month06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/4 21:16
 * @description 宜居星球改造计划
 */
public class HuaWei0001 {
    private static int[] dx = new int[]{1,0,-1,0};
    private static int[] dy = new int[]{0,1,0,-1};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String[]> matrix = new ArrayList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if ("".equals(line)) break;
            else matrix.add(line.split(" "));
        }

        int n = matrix.size();
        int m = matrix.get(0).length;
        List<int[]> yes_area = new ArrayList<>();
        int no_count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i)[j].equals("YES")) yes_area.add(new int[]{i, j});
                else no_count++;
            }
        }

        if (yes_area.size() == 0) {
            System.out.println(-1);
            return;
        }
        if (yes_area.size() == n * m) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs(matrix, n, m, yes_area, no_count));
    }

    private static int bfs(List<String[]> matrix, int n, int m, List<int[]> yesArea, int noCount) {
        int ans = 0;
        while (yesArea.size() >0 && noCount > 0) {
            List<int[]> newYesArea = new ArrayList<>();
            for (int[] pos : yesArea) {
                for (int i = 0; i < 4; i++) {
                    int nx = pos[0] + dx[i], ny = pos[1] + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && matrix.get(nx)[ny].equals("NO")) {
                        matrix.get(nx)[ny] = "YES";
                        newYesArea.add(new int[]{nx, ny});
                        noCount--;
                    }
                }
            }

            ans++;
            yesArea = newYesArea;
        }

        return noCount == 0 ? ans : -1;
    }
}
