package com.fuqi.year2023.month05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/17 22:37
 * @description
 */
public class Solution00051 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        // queens数组用于记录记录i行的皇后所在的列的下标（j）
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        // columns用于记录每一列是否已经有皇后了
        HashSet<Integer> columns = new HashSet<>();
        // diagonals1 方向一的斜线为从左上到右下方向，同一条斜线上的每个位置满足行下标与列下标之差相等
        HashSet<Integer> diagonals1 = new HashSet<>();
        // diagonals2 方向二的斜线为从右上到左下方向，同一条斜线上的每个位置满足行下标与列下标之和相等
        HashSet<Integer> diagonals2 = new HashSet<>();

        // 优化：使用数组代替set
        boolean[] columnUsed = new boolean[n];
        boolean[] diagonals1Used = new boolean[2 * n - 1];
        boolean[] diagonals2Used = new boolean[2 * n - 1];

        dfs(ans, queens, n, 0, columns, diagonals1, diagonals2);

        return ans;
    }

    private void dfs(List<List<String>> ans, int[] queens, int n, int row, HashSet<Integer> columns, HashSet<Integer> diagonals1, HashSet<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            ans.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) continue;
            int diagonal1 = row - i;
            if (diagonals1.contains(diagonal1)) continue;
            int diagonal2 = row + i;
            if (diagonals2.contains(diagonal2)) continue;

            queens[row] = i;
            columns.add(i);
            diagonals1.add(diagonal1);
            diagonals2.add(diagonal2);
            dfs(ans, queens, n, row + 1, columns, diagonals1, diagonals2);
            diagonals2.remove(diagonal2);
            diagonals1.remove(diagonal1);
            columns.remove(i);
            queens[row] = -1;
        }
    }

    private void dfs(List<List<String>> ans, int[] queens, int n, int row, boolean[] columnUsed, boolean[] diagonals1Used, boolean[] diagonals2Used) {
        if (row == n) {
            ans.add(generateBoard(queens, n));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (columnUsed[i]) continue;
            int diagonal1 = row - i + n - 1;
            if (diagonals1Used[diagonal1]) continue;
            int diagonal2 = row + i;
            if (diagonals2Used[diagonal2]) continue;

            queens[row] = i;
            columnUsed[i] = true;
            diagonals1Used[diagonal1] = true;
            diagonals2Used[diagonal2] = true;
            dfs(ans, queens, n, row+1, columnUsed, diagonals1Used, diagonals2Used);
            diagonals2Used[diagonal2] = false;
            diagonals1Used[diagonal1] = false;
            columnUsed[i] = false;
            queens[row] = -1;
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }

        return board;
    }
}
