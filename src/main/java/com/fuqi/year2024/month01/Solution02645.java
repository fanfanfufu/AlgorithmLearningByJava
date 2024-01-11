package com.fuqi.year2024.month01;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2024/1/11 20:54
 * @description
 */
public class Solution02645 {
    /**
     * 如果当前字符小于等于前面字符说明它们一定不在同一组中，反之则一定在同一组中。
     * 因此如果我们知道了最终的组数，就可以直接计算需要添加的字符数量。
     * 而最终的组数，就等于所有满足后者字符小于等于前者字符的情况数再加 111
     *
     * @param word
     * @return
     */
    public int addMinimum(String word) {
        int n = word.length(), cnt = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) <= word.charAt(i - 1)) {
                cnt++;
            }
        }

        return cnt * 3 - n;
    }
}
