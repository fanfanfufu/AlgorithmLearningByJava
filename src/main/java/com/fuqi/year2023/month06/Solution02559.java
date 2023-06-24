package com.fuqi.year2023.month06;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/2 22:40
 * @description 统计范围内的元音字符串个数
 */
public class Solution02559 {
    /**
     * 基于前缀和的计算
     * 1。 先计算【0，i-1】范围内的元音字符串的累计个数（前缀和）
     * 2。 根据范围进行计算
     *
     * @param words
     * @param queries
     * @return
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSums = new int[n+1];
        for (int i = 0; i < n; i++) {
            int value = isVowelString(words[i]) ? 1 : 0;
            prefixSums[i+1] = prefixSums[i] + value;
        }
        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int start = queries[i][0], end = queries[i][1];
            ans[i] = prefixSums[end+1] - prefixSums[start];
        }

        return ans;
    }

    public boolean isVowelString(String word) {
        return isVowelLetter(word.charAt(0)) && isVowelLetter(word.charAt(word.length() - 1));
    }

    public boolean isVowelLetter(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
