package com.fuqi.year2022.month12;

/**
 * @author FuQi
 * @date 2022/12/4 10:48
 * @description
 */
public class Solution06253 {
    public boolean isCircularSentence(String sentence) {
        // 题目所给条件sentence不会为空
        String[] words = sentence.split(" ");
        char start = words[0].charAt(0);
        char end = words[words.length-1].charAt(words[words.length-1].length() - 1);
        if (start != end) {
            return false;
        }
        for (int i = 1; i < words.length; i++) {
            char pre = words[i-1].charAt(words[i-1].length()-1);
            char cur = words[i].charAt(0);
            if (pre != cur) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution06253 solution06253 = new Solution06253();
        System.out.println(solution06253.isCircularSentence("leetcode exercises sound delightful"));
        System.out.println(solution06253.isCircularSentence("Leetcode exercises sound delightful"));
        System.out.println(solution06253.isCircularSentence("eetcode"));
        System.out.println(solution06253.isCircularSentence("Leetcode is cool"));
    }
}
