package com.fuqi.year2022.month06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/6/6 23:00
 * @description 螺旋矩阵
 */
public class Solution00054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        int n = matrix.length, m = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        for(int i = 0, j = 0, d = 0, k = 0; k < n * m; k++){
            res.add(matrix[i][j]);
            matrix[i][j] = 101;
            int a = i + dx[d], b = j + dy[d];
            if(a < 0 || a >= n || b < 0 || b >= m || matrix[a][b] == 101){
                d = (d + 1) % 4;
                a = i + dx[d]; b = j + dy[d];
            }
            i = a; j = b;
        }
        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int count = 0, row = matrix.length, column = matrix[0].length;
        int total = row * column;
        int up = 0, down = row - 1, left = 0, right = column - 1;
        while(count < total) {
            for(int i = left; i <= right && count < total; i++){
                res.add(matrix[up][i]);
                count++;
            }
            up++;
            for(int i = up; i <= down && count < total; i++){
                res.add(matrix[i][right]);
                count++;
            }
            right--;
            for(int i = right; i >= left && count < total; i--){
                res.add(matrix[down][i]);
                count++;
            }
            down--;
            for(int i = down; i >= up && count < total; i--){
                res.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return res;
    }
}
