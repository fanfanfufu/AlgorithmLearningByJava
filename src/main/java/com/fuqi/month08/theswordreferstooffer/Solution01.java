package com.fuqi.month08.theswordreferstooffer;

/**
 * @Description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Author 傅琦
 * @date 2019/8/6 9:47
 * @Version V1.0
 */
public class Solution01 {
    public boolean find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0){
            return false;
        }

        int[] firstCol = new int[array.length];

        // 取出第一列
        for (int i = 0; i < array.length; i++) {
            firstCol[i] = array[i][0];
        }

        int left = 0;
        int right = firstCol.length-1;
        int mid = 0;

        if (firstCol[left] > target){
            return false;
        }

        if (firstCol[right] < target){
            for (int i = array.length-1; i >= 0; i--) {
                for (int j = array[i].length-1; j >= 0; j--) {
                    if (array[i][j] == target){
                        return true;
                    }
                }
            }
            return false;
        }

        while (left <= right){
            mid = (left + right) / 2;
            if (firstCol[mid] > target){
                if (firstCol[mid-1] < target){
                    return (commonBinarySearch(array[mid-1], target) != -1);
                }
                right = mid - 1;
            }else if (firstCol[mid] < target){
                if (firstCol[mid+1] > target){
                    return (commonBinarySearch(array[mid+1], target) != -1);
                }
                left = mid + 1;
            }else {
                return true;
            }
        }

        return false;
    }

    public static int commonBinarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;

        if (arr[low] > target || target > arr[high]) {
            return -1;
        }

        while (low <= high){
            middle = (low + high) / 2;
            if (arr[middle] > target){
                high = middle - 1;
            }else if (arr[middle] < target){
                low = middle + 1;
            }else {
                return middle;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
        int target = 7;
        Solution01 solution01 = new Solution01();
        boolean res = solution01.find(target, array);
        System.out.println("res = " + res);
    }
}
