package com.fuqi.year2021.month08.day20210827;

/**
 * @author FuQi
 */
public class Solution344 {
    public static void reverseString(char[] s) {
        int i = 0, j = s.length-1;
        if (i == j) {
            return;
        }
        while (i < j) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] input = "Hannah".toCharArray();
        reverseString(input);
    }
}
