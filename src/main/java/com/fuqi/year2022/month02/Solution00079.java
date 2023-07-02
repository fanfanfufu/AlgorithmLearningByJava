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
                        // 回溯
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
                // 回溯
                used[newX][newY] = false;
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < this.row && y >= 0 && y < this.col;
    }

    private int[] dx = new int[]{1,0,-1,0};
    private int[] dy = new int[]{0,-1,0,1};

    public boolean exist2(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != word.charAt(0)) continue;
                used[i][j] = true;
                if (backtrack(board, i, j, word, used, 1)) return true;
                used[i][j] = false;
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, int x, int y, String word, boolean[][] used, int depth) {
        if (depth == word.length()) return true;
        for (int i = 0; i < 4; i++) {
            // 计算下一个位置的坐标
            int nx = x+dx[i], ny = y+dy[i];
            // 如果新位置不在合法的区域内，则直接跳过
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) continue;
            // 如果新位置是已经访问过的，页直接跳过
            if (used[nx][ny]) continue;
            // 如果新位置与word的下一个字符不等，也直接跳过
            if (board[nx][ny] != word.charAt(depth)) continue;
            // 经过前面几个的判断，到这里就说明新位置的字符与word下一个字符相等
            // 因此先标记新位置已经被访问过了
            used[nx][ny] = true;
            // 如果新位置与word的下一个字符相等，则继续递归判断，如果最终返回true，那么当前这一层也为true
            if (backtrack(board, nx, ny, word, used, depth+1)) return true;
            // 如果递归某处中断了，则将新位置标记为false
            used[nx][ny] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution00079 solution00079 = new Solution00079();
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "AAB";
        System.out.println(solution00079.exist2(board, word));
    }
}
