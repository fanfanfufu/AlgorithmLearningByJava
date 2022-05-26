package com.fuqi.year2021.month08.day20210829;

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
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (indexMap.containsKey(c)) {
                // 如果索引Map已经包含了重复的字符
                // 则计算重复字符与上一个最远不重复字符的索引大小，取索引最大，即离得最近的
                j = Math.max(indexMap.get(c) + 1, j);
            }
            ans = Math.max(ans, (i - j + 1));
            // 更新字符的位置索引
            indexMap.put(c, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        // 8
        System.out.println(lengthOfLongestSubstring("dvpedfqmt"));
        // 5
        System.out.println(lengthOfLongestSubstring("ckilbkd"));
        // 1
        System.out.println(lengthOfLongestSubstring(" "));
        // 1
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        // 3
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        // 3
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
