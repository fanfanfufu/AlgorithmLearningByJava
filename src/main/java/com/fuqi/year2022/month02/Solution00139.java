package com.fuqi.year2022.month02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author FuQi
 * @date 2022/2/26 16:36
 * @description
 */
public class Solution00139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Stream.of("leet", "code").collect(Collectors.toList());
        Solution00139 solution00139 = new Solution00139();
        System.out.println(solution00139.wordBreak(s, wordDict));
    }

    /**
     * 方法一：暴力的方式递归
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean result = false;
        if (s.equals("")) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            // 依次从前缀找字符串是否包含在wordDict中，如果有的，则递归处理后面部分的字符串
            if (wordDict.contains(s.substring(0, i+1))) {
                result = result || wordBreak1(s.substring(i+1), wordDict);
            }
        }

        return result;
    }

    /**
     * 方法二：记忆化递归
     * @param s
     * @param wordDict
     * @return
     */

    public boolean wordBreak2(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        return isContain(s, wordDict, map);
    }

    private boolean isContain(String s, List<String> wordDict, Map<String, Boolean> map) {
        if (s.equals("")) {
            return true;
        }
        if (map.containsKey(s)) {
            return false;
        }
        boolean result = false;
        for (int i = 0; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i+1))) {
                result = result || isContain(s.substring(i+1), wordDict, map);
                if (!result) {
                    map.put(s.substring(i+1), false);
                }
            }
        }

        return result;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
