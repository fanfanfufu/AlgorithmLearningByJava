package com.fuqi.year2019.month11.day1113;

/**
 * @Description: LeetCode第289题
 * @Author 傅琦
 * @date 2019/11/13 10:12
 * @Version V1.0
 */
public class LeetCode289 {
    /**
     * 简单直白，完全按照题目解释做了两个循环。
     * 第一个循环用于标记，第二个循环用于赋值。
     * 1——保持1
     * -1——1转0
     * 0——保持0
     * -2——0转1
     * @param board
     */
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = checkLoc(board, i, j);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = board[i][j] == 1 || board[i][j] == -2 ? 1 : 0;
            }
        }
    }

    private int checkLoc(int[][] board, int i, int j) {
        int count = 0;
        int left = Math.max(j-1, 0);
        int right = Math.min(j+1, board[i].length-1);
        int top = Math.max(i-1, 0);
        int bottom = Math.min(i+1, board.length-1);

        for (int k = top; k <= bottom; k++) {
            for (int l = left; l <= right ; l++) {
                // 当前位置上的数字为1或者-1的，说明之前该位置上是1(即，是一个活细胞)
                count = board[k][l] == 1 || board[k][l] == -1 ? count+1 : count;
            }
        }

        return board[i][j] == 1 ? (count == 3 || count == 4 ? 1: -1) : (count == 3 ? -2 : 0);
    }
}
