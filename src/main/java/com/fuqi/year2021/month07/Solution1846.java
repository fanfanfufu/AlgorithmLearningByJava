package com.fuqi.year2021.month07;

import java.util.Arrays;

/**
 * @author FuQi
 */
public class Solution1846 {
    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // 显然最大值不会超过数组长度, 更大的值必须舍弃
        int n = arr.length;
        int[] count = new int[n + 1];
        // 计数
        // 为什么长度是 n + 1 呢? 因为长度 n + 1 => 最大值为n, 再大照样会被缩小
        for (int i = 0; i < n; i++) {
            count[Math.min(arr[i], n)]++;
            // 使用min函数 => 避免数组溢出
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            // 根据键统计值
            res = Math.min(res + count[i], i);
            // 对于修改后的 arr, 其每个元素必须等于 min(前数 + 1, 后数), 以满足元素只能变小的限制
        }
        // 为什么是count[i], 因为将重复的元素i都合并处理了, 加了 count[i] 个 1
        return res;
    }

    public static int maximumElementAfterDecrementingAndRearranging2(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i-1] > 1) {
                arr[i] = arr[i-1] + 1;
            }
        }
        return arr[arr.length-1];
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,4,5};
//        int[] arr = new int[]{100,1,1000};
//        int[] arr = new int[]{1,1,2,2,2};
//        int[] arr = new int[]{2,4,5};
//        int[] arr = new int[]{2,4,5};
//        int[] arr = new int[]{1,1,1,1,1,1,1,210};
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = 209;
        }
        arr[32] = 10000;
        arr[3656] = 1;
        int res = maximumElementAfterDecrementingAndRearranging2(arr);
        System.out.println("res = " + res);
    }
}
