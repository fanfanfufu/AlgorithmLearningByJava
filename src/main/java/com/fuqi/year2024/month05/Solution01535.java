package com.fuqi.year2024.month05;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/5/19 20:39
 * @description
 */
public class Solution01535 {
    public int getWinner(int[] arr, int k) {
        int mx = arr[0];
        int win = 0;
        for (int i = 0; i < arr.length && win < k; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
                win = 0;
            }
            win++;
        }

        return mx;
    }
}
