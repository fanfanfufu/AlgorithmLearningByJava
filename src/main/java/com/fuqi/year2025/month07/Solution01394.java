package com.fuqi.year2025.month07;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2025/7/5 23:30
 * @description
 */
public class Solution01394 {
    public int findLucky(int[] arr) {
        int[] count = new int[501];
        for (int num : arr) {
            count[num]++;
        }
        for (int i = 500; i >= 1; i--) {
            if (count[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
