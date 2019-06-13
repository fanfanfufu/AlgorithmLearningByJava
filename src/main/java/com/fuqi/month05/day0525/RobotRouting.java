package com.fuqi.month05.day0525;

/**
 * @Description:
 * @Author 傅琦
 * @Date 2019/5/25 16:40
 * @Version V1.0
 */
public class RobotRouting {
    /**
     * 思路：dfs,搜索四个方向，vis记录该方格是否被搜索过，预判方格是否合法，合法就从该方格接着搜索
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols)
    {
        int flag[][] = new int[rows][cols];
        return helper(0, 0, rows, cols, flag, threshold);
    }

    private int helper(int i, int j, int rows, int cols, int[][] flag, int threshold){
        if (i < 0 || i >= rows || j < 0 || j >= cols || numSum(i) + numSum(j) > threshold || flag[i][j] == 1){return 0;}

        flag[i][j] = 1;

        return helper(i-1, j, rows, cols, flag, threshold)
                + helper(i+1, j, rows, cols, flag, threshold)
                + helper(i, j-1, rows, cols, flag, threshold)
                + helper(i, j+1, rows, cols, flag, threshold)
                + 1;
    }

    private int numSum(int i){
        int sum = 0;
        while (i != 0){
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }
}
