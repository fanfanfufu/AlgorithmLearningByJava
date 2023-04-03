package com.fuqi.year2023.month04;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/4/3 23:10
 * @description
 */
public class Solution01053 {
    public int[] prevPermOpt1(int[] arr) {
        for (int i = arr.length-2; i >= 0; i--) {
            // 1. 先找到第一个逆序数对
            if (arr[i] > arr[i+1]) {
                for (int j = arr.length-1; j > i; j--) {
                    // 2. 再找到i之后的第一个小于i出元素并且不是重复元素的数
                    if (arr[j] < arr[i] && arr[j] != arr[j-1]) {
                        // 3. 交换i，j的值
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;

                        return arr;
                    }
                }
            }
        }

        return arr;
    }
}
