package com.fuqi.sortAlig;

/**
 * @Description: 计数排序，适合整型数组的排序
 * @Author 傅琦
 * @Date 2019/6/6 9:06
 * @Version V1.0
 */
public class CountOrder {
    public static void main(String[] args){
        int[] arr = {1,4,6,7,5,4,3,2,1,4,5,10,9,10,3};
        order(arr);
        for (int num: arr) {
            System.out.print(num + " ");
        }
    }

    private static void order(int[] data){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num: data) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        int[] temp = new int[max - min + 1];

        for (int i = 0; i < data.length; i++) {
            int index = data[i];
            temp[index-min] += 1;
        }

        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += temp[i];
            temp[i] = sum;
        }

        int k = 0;
        for (int i = 0; i < temp.length; i++) {
            while (k < temp[i]){
                data[k++] = i+min;
            }
        }
    }
}
