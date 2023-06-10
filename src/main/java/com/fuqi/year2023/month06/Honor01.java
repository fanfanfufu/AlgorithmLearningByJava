package com.fuqi.year2023.month06;

import java.util.Scanner;

public class Honor01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = Integer.parseInt(in.nextLine());
        int n = Integer.parseInt(in.nextLine());
        int[][] matrix = generateMatrix(m, n);
        int[] colSum = calculateHeadTailColSum(matrix);
        for (int sum : colSum) {
            System.out.println(sum);
        }
    }

    public static int[][] generateMatrix(int m, int n) {
        int[][] matrix = new int[m][n];
        int value = 1;
        int valueCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (valueCount < 2) {
                    matrix[j][i] = value;
                    valueCount += 1;
                }
                if (valueCount == 2) {
                    value += 1;
                    valueCount = 0;
                }
            }
        }

        return matrix;
    }

    public static int[] calculateHeadTailColSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = matrix[i][0] + matrix[i][n - 1];
        }

        return ans;
    }
}
