package com.fuqi.year2021.month11.day20211113;

/**
 * @author FuQi
 * @date 2021/11/13 22:44
 * @description
 */
public class Solution05910 {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (char ch : word1.toCharArray()) {
            arr1[ch-'a']++;
        }
        for (char ch : word2.toCharArray()) {
            arr2[ch-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (Math.abs(arr1[i] - arr2[i]) > 3) {
                return false;
            }
        }
        return true;
    }
}
