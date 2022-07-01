package com.fuqi.year2022.month07;


/**
 * @author FuQi
 * @date 2022/7/1 23:24
 * @description
 */
public class Solution00151 {
    public static String reverseWords(String s) {
        String[] wordArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = wordArr.length-1; i >= 0; i--) {
            if (wordArr[i].length() == 0) {
                continue;
            }
            sb.append(wordArr[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }
}
