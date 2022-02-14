package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/14 22:24
 * @description
 */
public class Solution00130 {
    private int[] dx = new int[]{1,0,-1,0};
    private int[] dy = new int[]{0,-1,0,1};

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isEdge = i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                    continue;
                }
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i == board.length || j < 0 || j == board[0].length
                || board[i][j] == 'X' || board[i][j] == 'Y') {
            return;
        }
        board[i][j] = 'Y';
        for (int k = 0; k < 4; k++) {
            dfs(board, i+dx[k], j+dy[k]);
        }
    }
}
