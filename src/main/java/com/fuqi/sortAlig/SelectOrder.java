package com.fuqi.sortAlig;

/**
 * @Description: 简单选择排序
 * @Author 傅琦
 * @Date 2019/6/4 9:45
 * @Version V1.0
 */
public class SelectOrder {
    public static void main(String[] args){
        int[] arr = {5, 2, 8, 3, 45, 33, 1, 12, 7};
        System.out.println("交换前：");
        for (int num: arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] res = order(arr);
        System.out.println("交换后：");
        for (int num: res) {
            System.out.print(num + " ");
        }
    }

    private static int[] order(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i;
            for (int j = k + 1; j < arr.length; j++) {
                if (arr[j] < arr[k]){
                    k = j;
                }
            }

            // 一个内层循环结束后，找到本轮最小的数以后，根据位置进行交换
            if (i != k){
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        return arr;
    }
}
