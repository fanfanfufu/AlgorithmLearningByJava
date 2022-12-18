package com.fuqi.year2022.month12;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2022/12/18 11:44
 * @description
 */
public class Solution06265 {
    public int similarPairs(String[] words) {
        boolean[][] wordsChar = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                if (wordsChar[i][ch - 'a']) continue;
                wordsChar[i][ch - 'a'] = true;
            }
        }

        int ans = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (Arrays.equals(wordsChar[i], wordsChar[j])) ans++;
            }
        }

        return ans;
    }

}
