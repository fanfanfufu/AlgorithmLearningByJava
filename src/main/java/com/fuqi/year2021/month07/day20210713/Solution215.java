package com.fuqi.year2021.month07.day20210713;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author FuQi
 * @desc 数组中的第K个最大元素
 * @Solution:
 *    本质在于考察排序算法
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
//         int[] nums_order = order(nums);
//         int[] nums_order = order1(nums, 0, nums.length-1);
//         int[] nums_order = order2(nums, 0, nums.length-1);
//         return nums_order[nums.length - k];
        // 使用顶堆
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if(pq.size() < k){
                pq.add(num);
            }
            else if(pq.peek() < num){
                pq.remove();
                pq.add(num);
            }
        }
        return pq.peek();
    }

    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    private int[] order(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * 方式一：快排-递归实现
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
     * 方式二：快排-非递归实现
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
}
