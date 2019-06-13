package com.fuqi.month06.day0604;

import java.util.Arrays;

/**
 * @Description: 两个整型数组A、B，找出A中有，而B中没有的数
 * @Author 傅琦
 * @Date 2019/6/5 10:29
 * @Version V1.0
 */
public class TwoArrayDiff {
    public static void main(String[] args){
        int[] arrA = {1,2,3,4,5,6,7,8,9};
        int[] arrB = {2,3,5,6,8};
        find(arrA, arrB);
    }

    private static void find(int[] arrA, int[] arrB){
        int[] count = new int[arrA.length];
        Arrays.fill(count, 0, count.length-1, 1);
        for (int i = 0; i < arrA.length; i++) {
            for (int b: arrB) {
                if (arrA[i] == b){
                    count[i] = 0;
                    break;
                }
            }
        }

        for (int i = 0; i < arrA.length; i++) {
            if (count[i] == 1){
                System.out.print(arrA[i] + " ");
            }
        }
    }
}
