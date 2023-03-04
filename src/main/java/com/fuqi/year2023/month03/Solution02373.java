package com.fuqi.year2023.month03;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2023/3/4 23:31
 * @description
 */
public class Solution02373 {
    /**
     * 方法一： 直接模拟
     *
     * @param grid
     * @return
     */
    public int[][] largestLocal1(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n-2][n-2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                ans[i][j] = localMax(grid, i, j);
            }
        }

        return ans;
    }

    private int localMax(int[][] grid, int left, int top) {
        int max = 0;
        for (int i = left; i < left+3; i++) {
            for (int j = top; j < top+3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }

        return max;
    }

    /**
     * 单调队列
     *
     * @param grid
     * @return
     */
    public int[][] largestLocal2(int[][] grid) {
        int n = grid.length;
        int[][] ans= new int[n-2][n-2];
        Deque<Integer> deque;
        int value;
        for (int i = 0; i < n; i++) {
            // 针对每一行再创建一个单调队列
            deque = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                while (!deque.isEmpty() && grid[i][j] > grid[i][deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(j);
                if (j >= 2) {
                    // 当已经遍历过前面三个元素之后，在队列队首的元素就是前三个元素中的最大值
                    value = grid[i][deque.peekFirst()];
                    for (int k = i-2; k <= i; k++) {
                        if (k >= 0 && k < n-2) {
                            ans[k][j-2] = Math.max(ans[k][j-2], value);
                        }
                    }
                    if (deque.peekFirst() <= j-2) {
                        deque.pollFirst();
                    }
                }
            }
        }

        return ans;
    }
}
