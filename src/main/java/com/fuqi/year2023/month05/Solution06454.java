package com.fuqi.year2023.month05;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/21 21:48
 * @description
 */
public class Solution06454 {
    public String makeSmallestPalindrome(String s) {
        char[] array = s.toCharArray();
        int left = 0, right = array.length - 1;
        while (left < right) {
            if (array[left] == array[right]) {
                left++;
                right--;
                continue;
            }
            if (array[left] < array[right]) array[right] = array[left];
            else array[left] = array[right];
            left++;
            right--;
        }

        return new String(array);
    }

    /**
     * 代码优化：
     * 因为left与right两个指针的和都是固定的=长度-1
     * 所以可以只需要遍历left，right=n-1-left即可
     *
     * @param s
     * @return
     */
    public String makeSmallestPalindrome2(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            if (array[i] == array[n-1-i]) continue;
            if (array[i] < array[n-1-i]) array[n-1-i] = array[i];
            else array[i] = array[n-1-i];
        }

        return new String(array);
    }
}
