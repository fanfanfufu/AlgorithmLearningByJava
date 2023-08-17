package com.fuqi.year2021.month08.day20210829;

import org.junit.jupiter.api.Assertions;

import java.util.*;

/**
 * 无重复字符的最长子串
 * @author FuQi
 */
public class Solution00003 {
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int ans = 0;
        Deque<Character> window = new LinkedList<>();
        while (i < s.length()) {
            if (!window.contains(s.charAt(i))) {
                window.offerLast(s.charAt(i));
                i++;
                continue;
            }
            ans = Math.max(ans, (i-j));
            if (s.charAt(i-1) == s.charAt(i)) {
                window.clear();
                j = i;
            } else {
                while (window.contains(s.charAt(i))) {
                    window.pollFirst();
                    j++;
                }
            }
            window.offer(s.charAt(i));
            i++;
        }
        ans = Math.max(ans, (i-j));

        return ans;
    }

    /**
     * 更快的写法
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int ans = 0;
        // 存储每个不同字符的索引
        Map<Character, Integer> indexMap = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (indexMap.containsKey(c)) {
                // 如果索引Map已经包含了重复的字符
                // 则计算重复字符与上一个最远不重复字符的索引大小，取索引最大，即离得最近的
                // 这里为什么要比较取最大的，是为了防止有：
                // abba这种情况下只计算重复字符的最近索引加1时，left会倒退倒退
                left = Math.max(indexMap.get(c) + 1, left);
            }
            ans = Math.max(ans, (i - left + 1));
            // 更新字符的位置索引
            indexMap.put(c, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        // 8
//        Assertions.assertEquals(8, lengthOfLongestSubstring2("dvpedfqmt"));
//        // 5
//        Assertions.assertEquals(5, lengthOfLongestSubstring2("ckilbkd"));
//        // 1
//        Assertions.assertEquals(1, lengthOfLongestSubstring2(" "));
//        // 1
//        Assertions.assertEquals(1, lengthOfLongestSubstring2("bbbbbb"));
//        // 3
//        Assertions.assertEquals(3, lengthOfLongestSubstring2("pwwkew"));
        // 3
        Assertions.assertEquals(3, lengthOfLongestSubstring2("abcabcbb"));
    }
}
