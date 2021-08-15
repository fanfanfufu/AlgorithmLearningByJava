package com.fuqi.year2021.month08.day20210815;

import java.util.Arrays;

/**
 * @author FuQi
 */
public class Solution1 {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for (String each : patterns) {
            if (word.contains(each)) {
                ans++;
            }
        }
        return ans;
    }
}
