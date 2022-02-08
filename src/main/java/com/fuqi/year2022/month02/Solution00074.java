package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/8 21:42
 * @description
 */
public class Solution00074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int targetRow = searchFirstColumn(matrix, target);
        if (targetRow < 0) {
            return false;
        }

        return searchTargetRow(matrix[targetRow], target);
    }

    private int searchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length-1;
        while (low < high) {
            int mid = (low+high+1) / 2;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid-1;
            }
        }

        return low;
    }

    private boolean searchTargetRow(int[] row, int target) {
        int left = 0, right = row.length-1;
        while (left <= right) {
            int mid = (left+right) / 2;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                left = mid+1;
            } else {
                right = mid -1;
            }
        }

        return false;
    }
}
