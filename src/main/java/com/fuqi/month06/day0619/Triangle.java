package com.fuqi.month06.day0619;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
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
        List<Integer> raw1 = new ArrayList<>();
        raw1.add(2);
    }
}
