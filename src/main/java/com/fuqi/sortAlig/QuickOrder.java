package com.fuqi.sortAlig;

/**
 * @Description: 快速排序
 * @Author 傅琦
 * @Date 2019/6/5 22:27
 * @Version V1.0
 */
public class QuickOrder {
    private static void order(int[] data, int left, int right){
        if (data == null || left < 0 || right > data.length-1){
            throw new IllegalArgumentException("Invalid Parameters");
        }
        if (left >= right){return ;}
        int m = left;
        int n = right;
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
        order(data, left, m-1);
        // 递归右边
        order(data, m+1, right);
    }

    public static void main(String[] args){
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        order(arr, 0, arr.length-1);
        for (int num: arr) {
            System.out.print(num + " ");
        }
    }
}
