package com.fuqi.day0522;

import java.util.ArrayList;

/**
 * @Description:
 * @Author 傅琦
 * @Date 2019/5/22 15:47
 * @Version V1.0
 */
public class MultipleArray {

    public static void main(String[] args){
        int[] inputArray = {1,2,3,4,5};
        MultipleArray multipleArray = new MultipleArray();
        int[] result = multipleArray.multiply(inputArray);
        for (int number: result) {
            System.out.println(number);
        }
    }

    public int[] multiply(int[] A){
        if (A == null || A.length <= 1){
            return new int[0];
        }

        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int res = 1;
            for (int j = 0; j < A.length; j++) {
                if (j == i){
                    continue;
                }
                res *= A[j];
            }
            B[i] = res;
        }
        return B;
    }
}
