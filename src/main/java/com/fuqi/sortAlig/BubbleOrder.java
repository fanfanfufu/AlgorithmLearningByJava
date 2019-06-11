package com.fuqi.sortAlig;

/**
 * @Description: 冒泡排序
 * @Author 傅琦
 * @Date 2019/6/4 10:54
 * @Version V1.0
 */
public class BubbleOrder {
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
}
