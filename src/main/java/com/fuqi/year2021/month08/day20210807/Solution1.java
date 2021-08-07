package com.fuqi.year2021.month08.day20210807;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FuQi
 */
public class Solution1 {
    public static String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }
        List<Character> characters = new ArrayList<>();
        characters.add(s.charAt(0));
        characters.add(s.charAt(1));
        for (int i = 2; i < s.length(); i++) {
            char ch = s.charAt(i);
            int len = characters.size();
            if (characters.get(len-2) == ch && characters.get(len-1) == ch) {
                continue;
            }
            characters.add(ch);
        }

        StringBuilder res = new StringBuilder();
        characters.forEach(res::append);

        return res.toString();
    }

    public static void main(String[] args) {
        String input1 = "leeetcode";
        String input2 = "aaabaaaa";
        String input3 = "aab";
        String input4 = "ab";
        String input5 = "aa";

        System.out.println(makeFancyString(input1));
        System.out.println(makeFancyString(input2));
        System.out.println(makeFancyString(input3));
        System.out.println(makeFancyString(input4));
        System.out.println(makeFancyString(input5));
    }
}
