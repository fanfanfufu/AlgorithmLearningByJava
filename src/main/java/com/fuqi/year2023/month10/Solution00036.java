package com.fuqi.year2023.month10;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/10/10 22:12
 * @description
 */
public class Solution00036 {
    /**
     * 使用哈希表记录每一行、每一列和每一个小九宫格中，每个数字出现的次数。
     * 只需要遍历数独一次，在遍历的过程中更新哈希表中的计数，并判断是否满足有效的数独的条件即可。
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] subBoxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int numIndex = c -'0'-1;
                    rows[i][numIndex]++;
                    cols[j][numIndex]++;
                    subBoxes[i/3][j/3][numIndex]++;
                    if (rows[i][numIndex] > 1 || cols[j][numIndex] > 1 || subBoxes[i/3][j/3][numIndex] > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
