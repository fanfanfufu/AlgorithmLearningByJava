package com.fuqi.year2021.month08.day20210827;

/**
 * @author FuQi
 */
public class Solution557 {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        String[] reverseWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            char[] charArray = words[i].toCharArray();
            reverseString(charArray);
            String reverseWord = new String(charArray);
            reverseWords[i] = reverseWord;
        }

        return String.join(" ", reverseWords);
    }

    public static void reverseString(char[] s) {
        int i = 0, j = s.length-1;
        if (i == j) {
            return;
        }
        while (i < j) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
    }

    public static String reverseWords1(String s) {
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int curEnd = i;
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
            for (int j = i - 1; j >= curEnd; j--) {
                ans.append(s.charAt(j));
            }
            while (i < s.length() && s.charAt(i) == ' ') {
                ans.append(' ');
                i++;
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String reverseWords = reverseWords(s);
        System.out.println("res = " + reverseWords);
        String res = reverseWords1(s);
        System.out.println("res = " + res);
    }
}
