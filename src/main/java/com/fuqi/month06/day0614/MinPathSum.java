package com.fuqi.month06.day0614;

/**
 * @Description: 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *               说明：每次只能向下或者向右移动一步。
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * @Author 傅琦
 * @Date 2019/6/14 10:35
 * @Version V1.0
 */
public class MinPathSum {
    /**
     * 二维数组动态规划
     * @param grid
     * @return
     */
    private int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        // 遍历每行第一列，逐渐累加
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i-1][0];
        }

        // 遍历第一行每列，累加
        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] += grid[0][j-1];
        }

        // 遍历剩余的部分
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        return grid[grid.length-1][grid[0].length-1];
    }

    /**
     * 一维动态规划：自底向上
     * @param grid
     * @return
     */
    private int minPathSum2(int[][] grid){
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        System.out.println(grid[0].length);
        int[] record = new int[grid[0].length];
        for (int i = grid.length-1; i >= 0; i--) {
            for (int j = grid[0].length-1; j >= 0; j--) {
                if (i == grid.length-1 && j != grid[0].length-1){
                    record[j] = grid[i][j] + record[j+1];
                }else if (i != grid.length -1 && j == grid[0].length-1){
                    record[j] = grid[i][j] + record[j];
                }else if (i != grid.length -1 && j != grid[0].length-1){
                    record[j] = grid[i][j] + Math.min(record[j], record[j+1]);
                }else {
                    record[j] = grid[i][j];
                }
            }
        }
        return record[0];
    }

    /**
     * 一维动态规划：自顶向上
     * @param grid
     * @return
     */
    private int minPathSum3(int[][] grid){
        int[] record = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0){
                    record[j] = grid[i][j];
                }else if (i == 0 && j != 0){
                    record[j] = grid[i][j] + record[j-1];
                }else if (i != 0 && j == 0){
                    record[j] = grid[i][j] + record[j];
                }else {
                    record[j] = grid[i][j] + Math.min(record[j], record[j-1]);
                }
            }
        }
        return record[grid[0].length-1];
    }

    public static void main(String[] args){
        int[][] grid = new int[][]{{1,2},{5,6},{1,1}};
        MinPathSum pathSum = new MinPathSum();
        int res = pathSum.minPathSum3(grid);
        System.out.println(res);
    }
}
