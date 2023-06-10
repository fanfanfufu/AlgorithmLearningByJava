package com.fuqi.year2023.month06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Honor2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] input = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[][] position = calculatePosition(input[0], input[1], input[2], input[3]);
        List<String> cellList = calculateCell(position, input[0]);
        if (cellList.size() == 0) System.out.println(-1);
        else {
            System.out.println(String.join(" ", cellList));
        }
    }

    /**
     * 判断哪些坐标点在圆的范围内
     *
     * @param n
     * @param xc
     * @param yc
     * @param r
     * @return
     */
    public static boolean[][] calculatePosition(int n, int xc, int yc, int r) {
        boolean[][] matrix = new boolean[n+1][n+1];
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j <= n; j++) {
                int distX = Math.abs(j - xc);
                int distY = Math.abs(i - yc);
                if (distX * distX + distY * distY > r * r) continue;
                matrix[i][j] = true;
            }
        }

        return matrix;
    }

    public static List<String> calculateCell(boolean[][] matrix, int n) {
        List<String> ans = new ArrayList<>();
        int cellNum = 0;
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                boolean flag1 = matrix[i][j], flag2 = matrix[i][j+1], flag3 = matrix[i-1][j], flag4 = matrix[i-1][j+1];
                cellNum += 1;
                // 格子的四个角都是true
                if (flag1 && flag2 && flag3 && flag4) continue;
                // 格子的四个角都是false
                if (!flag1 && !flag2 && !flag3 && !flag4) continue;
                //
                // 一个点与圆相切的格子也不算
                // 格子的四个角不全一致，则说明被圆扫描到了，因此添加格子编号
                ans.add(String.valueOf(cellNum));
            }
        }

        return ans;
    }
}
