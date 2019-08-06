package com.fuqi.searchalgorithm;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/6 10:03
 * @Version V1.0
 */
public class BinarySearch {
    /**
     * 递归实现的二分查找
     * @param arr 带查询的有序数组
     * @param target 待查找的目标数
     * @param low 地位置（初始为0）
     * @param high 高位置（初始数值为 数组长度-1）
     * @return 要查找的数的位置
     */
    public static int recursionBinarySearch(int[] arr, int target, int low, int high){
        if (target < arr[low] || target > arr[high] || low > high){
            return -1;
        }

        int middle = (low + high) / 2;
        if (arr[middle] > target){
            // 如果位于查询区间中间的数大于目标数，则说明目标数在左半区间
            return recursionBinarySearch(arr, target, low, middle-1);
        }else if (arr[middle] < target) {
            // 如果位于查询区间中间的数小于目标数，则说明目标数在右半区间
            return recursionBinarySearch(arr, target, low+1, high);
        }else {
            // 刚好中间的数等于目标的情况，直接输出下标即可
            return middle;
        }
    }

    /**
     *
     * @param arr
     * @param target
     * @return
     */
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

    }
}
