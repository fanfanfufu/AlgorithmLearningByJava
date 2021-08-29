package com.fuqi.year2021.month08.day20210829;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无重复字符的最长子串
 * @author FuQi
 */
public class Solution00003 {
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int ans = 0;
        Queue<Character> window = new LinkedList<>();
        while (i < s.length()) {
            if (!window.contains(s.charAt(i))) {
                window.offer(s.charAt(i));
                i++;
                continue;
            }
            ans = Math.max(ans, (i-j));
            if (s.charAt(i-1) == s.charAt(i)) {
                window.clear();
                j = i;
            } else {
                while (window.contains(s.charAt(i))) {
                    window.poll();
                    j++;
                }
            }
            window.offer(s.charAt(i));
            i++;
        }
        ans = Math.max(ans, (i-j));

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
