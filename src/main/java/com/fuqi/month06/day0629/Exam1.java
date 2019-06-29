package com.fuqi.month06.day0629;

/**
 * @Description: 小于 K 的两数之和
 * @Author: 傅琦
 * @DateTime: 2019/6/29 22:32
 * @Version: V1.0
 */
public class Exam1 {
    public int twoSumLessThanK(int[] A, int K) {
        if (A.length < 2 || K < 2){ return -1; }

        int maxSum = -1;
        for (int i = 0; i < A.length - 1; i++) {
            int temp = K - A[i];
            for (int j = i+1; j < A.length; j++) {
                if (A[j] < temp){
                    int tempSum = A[i] + A[j];
                    maxSum = maxSum > tempSum ? maxSum : tempSum;
                }
            }
        }
        return maxSum;
    }
}
