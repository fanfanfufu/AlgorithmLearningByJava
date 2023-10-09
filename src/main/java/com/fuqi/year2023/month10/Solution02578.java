package com.fuqi.year2023.month10;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/10/9 22:12
 * @description
 */
public class Solution02578 {
    public int splitNum(int num) {
        int[] arr = new int[10];
        int cnt = 0;
        while (num > 0) {
            arr[cnt] = num % 10;
            num /= 10;
            cnt++;
        }
        Arrays.sort(arr, 0, cnt);
        int num1 = 0, num2 = 0;
        int i = 0;
        while (i < cnt) {
            num1 = num1 * 10 + arr[i];
            i++;
            if (i >= cnt) break;
            num2 = num2 * 10 + arr[i];
            i++;
        }

        return num1 + num2;
    }
}
