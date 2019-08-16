package com.fuqi.sortAlig;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 快速排序
 * @Author 傅琦
 * @Date 2019/6/5 22:27
 * @Version V1.0
 */
public class QuickOrder {
    /**
     * 方式一：递归实现
     * @param data
     * @param left
     * @param right
     */
    private static void order1(int[] data, int left, int right){
        if (data == null || left < 0 || right > data.length-1){
            throw new IllegalArgumentException("Invalid Parameters");
        }
        if (left >= right){return ;}
        int m = left;
        int n = right;
        // temp是基准值
        int temp = data[left];

        while (m < n){
            while (temp <= data[n] && m < n){
                n--;
            }

            while (temp >= data[m] && m < n){
                m++;
            }

            if (m < n){
                int x = data[m];
                data[m] = data[n];
                data[n] = x;
            }
        }

        // 将基准数与m,n相等位置的数交换
        data[left] = data[m];
        data[m] = temp;

        // 递归左边
        order1(data, left, m-1);
        // 递归右边
        order1(data, m+1, right);
    }

    /**
     * 方式二：非递归实现
     * @param data
     * @param left
     * @param right
     */
    public static void order2(int[] data, int left, int right){
        Deque<Integer> stack = new LinkedList<>();
        stack.push(left);
        stack.push(right);
        int i, j;
        while (!stack.isEmpty()){
            // 出栈时遵循先进后出的原则
            right = stack.pop();
            left = stack.pop();
            i = left;
            j = right;
            // 第一次就选第一个元素作为基准值
            int keyValue = data[left];

            while (i < j){
                while (i < j && data[j] >= keyValue) { j--; }
                while (i < j && data[i] <= keyValue) { i++; }

                // 交换操作
                if (i < j) {
                    data[i] = data[i] + data[j];
                    data[j] = data[i] - data[j];
                    data[i] = data[i] - data[j];
                }
            }

            data[left] = data[i];
            data[i] = keyValue;

            if (i-1 > left) {
                stack.push(left);
                stack.push(i-1);
            }

            if (i+1 < right){
                stack.push(i+1);
                stack.push(right);
            }
        }

    }

    public static void main(String[] args){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        order1(arr, 0, arr.length-1);
        for (int num: arr) {
            System.out.print(num + " ");
        }
    }
}
