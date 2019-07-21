package com.fuqi.month07.day0721;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/7/21 10:28
 * @Version: V1.0
 */
public class Exam4 {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int[] d = new int[4];
        int res = 0;
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 0; j < 4; j++) {
                res = Math.max(res, Math.abs(arr1[i] - arr1[d[j]])
                                   +Math.abs(arr2[i] - arr2[d[j]])
                                   +(i - d[j]));
                if (arr1[d[0]] - arr1[i] + arr2[d[0]] - arr2[i] + d[0] - i > 0) {
                    d[0] = i;
                }

                if (arr1[d[1]] - arr1[i] - arr2[d[1]] + arr2[i] + d[1] - i > 0) {
                    d[1] = i;
                }

                if (-arr1[d[2]] + arr1[i] + arr2[d[2]] - arr2[i] + d[2] - i > 0) {
                    d[2] = i;
                }

                if (-arr1[d[3]] + arr1[i] - arr2[d[3]] + arr2[i] + d[3] - i > 0) {
                    d[3] = i;
                }
            }
        }

        return res;
    }
}
