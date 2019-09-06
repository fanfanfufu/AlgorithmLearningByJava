package com.fuqi.sortAlig;

import java.util.Arrays;

/**
 * @Description: 希尔排序
 * @Author 傅琦
 * @date 2019/9/6 20:42
 * @Version V1.0
 */
public class ShellSort {
    private static void sort(int[] arr) {
        for (int gap = arr.length/2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && temp < arr[j-gap]; j -= gap) {
                    arr[j] = arr[j-gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 3, 45, 33, 1, 12, 7};
        System.out.println("排序前：" + Arrays.toString(arr));
        sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
