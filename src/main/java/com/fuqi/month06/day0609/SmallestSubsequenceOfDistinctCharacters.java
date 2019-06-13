package com.fuqi.month06.day0609;

import java.util.HashSet;
import java.util.Stack;

/**
 * @Description: 返回文本的字典最小子序列，该子序列恰好包含文本的所有不同字符。
 *
 * Input: "cdadabcc"
 * Output: "adbc"
 *
 * Input: "abcd"
 * Output: "abcd"
 *
 * Input: "ecbacba"
 * Output: "eacb"
 *
 * Input: "leetcode"
 * Output: "letcod"
 *
 * @Author: 傅琦
 * @DateTime: 2019/6/9 21:50
 * @Version: V1.0
 */
public class SmallestSubsequenceOfDistinctCharacters {
    private static String smallestSubsequence(String text) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        int[] count = new int[26];
        for (int i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);
            count[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);
            while (!stack.isEmpty() && count[stack.peek() - 'a'] != 0 && c <= stack.peek() && !set.contains(c)) {
                set.remove(stack.peek());
                stack.pop();
            }
            if (!set.contains(c)) {
                stack.push(c);
                set.add(c);
            }
            count[c - 'a']--;
        }

        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args){
        String res = smallestSubsequence("ecbacbacc");
        System.out.println(res);
    }
}
