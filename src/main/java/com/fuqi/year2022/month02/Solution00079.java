package com.fuqi.year2022.month02;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2022/2/17 23:04
 * @description
 */
public class Solution00079 {
    private boolean[][] used;
    private int row, col;
    private char[][] board;
    private char[] ws;
    private int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        this.row = board.length;
        this.col = board[0].length;
        this.used = new boolean[row][col];
        for (boolean[] u : used) {
            Arrays.fill(u, false);
        }

        this.board = board;
        this.ws = word.toCharArray();

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (board[i][j] == ws[0]) {
                    used[i][j] = true;
                    if (dfs(i, j, 1)) {
                        return true;
                    } else {
                        used[i][j] = false;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int depth) {
        if (depth == ws.length) {
            return true;
        }

        for (int[] d : direction) {
            int newX = i + d[0];
            int newY = j + d[1];
            // 剪枝
            if (! inArea(newX, newY)) {
                continue;
            }
            // 剪枝
            if (used[newX][newY]) {
                continue;
            }
            // 剪枝
            if (board[newX][newY] != ws[depth]) {
                continue;
            }

            used[newX][newY] = true;
            if (dfs(newX, newY, depth + 1)) {
                return true;
            } else {
                used[newX][newY] = false;
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.row && y >= 0 && y < this.col;
    }
}