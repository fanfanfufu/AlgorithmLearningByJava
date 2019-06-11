package com.fuqi.sortAlig;

/**
 * @Description: 简单插入排序
 * @Author 傅琦
 * @Date 2019/6/4 15:25
 * @Version V1.0
 */
public class InsertOrder {
    private static int[] order(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args){
        // {2,3,5,1,23,6,78,34}
        // {5, 2, 8, 3, 45, 33, 1, 12, 7}
        int[] arr = {2,3,5,1,23,6,78,34};
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
}
