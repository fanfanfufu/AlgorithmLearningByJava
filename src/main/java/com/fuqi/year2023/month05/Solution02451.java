package com.fuqi.year2023.month05;


import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/25 23:34
 * @description
 */
public class Solution02451 {
    public String oddString(String[] words) {
        int[] diffCommon = calculate(words[0]);
        int[] diffCur= calculate(words[1]);

        if (Arrays.equals(diffCommon, diffCur)) {
            for (int i = 2; i < words.length; i++) {
                diffCur = calculate(words[i]);
                if (Arrays.equals(diffCommon, diffCur)) continue;
                return words[i];
            }
        }

        return Arrays.equals(diffCommon, calculate(words[2])) ? words[1] : words[0];
    }

    private int[] calculate(String word) {
        int[] diff = new int[word.length()-1];
        for (int i = 1; i < word.length(); i++) {
            diff[i-1] = word.charAt(i) - word.charAt(i-1);
        }

        return diff;
    }
}
