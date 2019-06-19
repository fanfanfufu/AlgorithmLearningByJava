package com.fuqi.month06.day0619;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 给定一个三角形，从上到下求最小路径和。每一步都可以移动到下面一行的相邻数字。
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 *
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * 这里对相邻的理解：若在当前行索引为0，则上一行只有0为其相邻的
 *                 若在当前行索引为len-1，则上一行只有最后一个与其相邻
 *                 其他情况下，上一行与其相邻的元素只有索引相等与索引-1的元素算使与其相邻
 *
 * @Author 傅琦
 * @Date 2019/6/19 9:00
 * @Version V1.0
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] f = new int[2][n];
        int old;
        int now = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            old = now;
            now = 1 - old;
            for (int j = 0; j <= i; j++) {
                int num = triangle.get(i).get(j);
                if (i == 0 && j == 0) {
                    f[now][j] = num;
                } else if (j == i) {
                    f[now][j] = f[old][j - 1] + num;
                } else if (j == 0) {
                    f[now][j] = f[old][0] + num;
                } else {
                    f[now][j] = Math.min(f[old][j], f[old][j - 1]) + num;
                }
                if (i == m - 1) {
                    min = Math.min(f[now][j], min);
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        boolean[] dp = new boolean[5];
        for (boolean each: dp) {
            System.out.print(each + " ");
        }
    }
}
