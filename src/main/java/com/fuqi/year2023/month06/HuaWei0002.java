package com.fuqi.year2023.month06;

import java.util.Deque;
import java.util.Scanner;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/4 21:44
 * @description 需要打开多少监视器
 */
public class HuaWei0002 {

    private static int[] dx = new int[]{1,0,-1,0};
    private static int[] dy = new int[]{0,1,0,-1};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        System.out.println(bfs(matrix, m, n));
    }

    private static int bfs(int[][] matrix, int m, int n) {
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    ans++;
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k], ny = j + dy[k];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] == 1) {
                        ans++;
                        break;
                    }
                }
            }
        }

        return ans;
    }
}
