package com.fuqi.month07.day0714;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/7/14 10:29
 * @Version: V1.0
 */
public class Exam1 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1010];
        // 1. 计数
        for (int num : arr1) {
            count[num] ++;
        }

        int[] res = new int[arr1.length];
        int index = 0;
        // 2. 按照数在数组2中出现的顺序填充res
        for (int i = 0; i < arr2.length; i++) {
            while (count[arr2[i]] > 0){
                res[index++] = arr2[i];
                count[arr2[i]]--;
            }
        }

        // 3. 将剩余的数按升序填充
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0){
                res[index++] = i;
                count[i]--;
            }
        }

        return res;
    }
}
