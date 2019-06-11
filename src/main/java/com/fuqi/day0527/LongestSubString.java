package com.fuqi.day0527;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 求出给定字符串中最长的不重复的部分
 * @Author 傅琦
 * @Date 2019/5/27 9:29
 * @Version V1.0
 */
public class LongestSubString {
    public static void main(String[] args){
        LongestSubString lss = new LongestSubString();
//        String str1 = "abcabcbb";
//        int result1 = lss.maxSubString(str1);
//        System.out.println(result1);
//
//        String str2 = "bbbbbbb";
//        int result2 = lss.maxSubString(str2);
//        System.out.println(result2);
//
//        String str3 = "pwwkew";
//        int result3 = lss.maxSubString(str3);
//        System.out.println(result3);
//
//        String str4 = "anviaj";
//        int result4 = lss.maxSubString(str4);
//        System.out.println(result4);
//
//        String str5 = "abba";
//        int result5 = lss.maxSubString(str5);
//        System.out.println(result5);
//
//        String str6 = "tmmzuxt";
//        int result6 = lss.maxSubString(str6);
//        System.out.println(result6);
//
        String str7 = "wobgrovw";
        int result7 = lss.maxSubString(str7);
        System.out.println(result7);

//        String str8 = "alouzxilkaxkufsu";
//        int result8 = lss.maxSubString(str8);
//        System.out.println(result8);
    }

    public int lengthOfLongestSubString(String s){
        if (s == null || s.equals("")){
            return 0;
        }

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){

                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int maxSubString(String s){
        if (s == null || "".equals(s)){
            return 0;
        }

        char[] strings = s.toCharArray();
        int maxLen = 0, start = 0, end = 0;
        ArrayList<Character> chList = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            if (!chList.contains(strings[i])){
                chList.add(strings[i]);
                end++;
                maxLen = maxLen > (end-start) ? maxLen: (end-start);
            }else {
                if (strings[i-1] == strings[i]){
                    chList.clear();
                    start = 0;
                    end = 1;
                    chList.add(strings[i]);
                }else {
                    int index = chList.lastIndexOf(strings[i]);
                    start = start > index ? start: (index+1);
                    chList.add(strings[i]);
                    end++;
                    maxLen = maxLen > (end-start) ? maxLen: (end-start);
                }
            }
        }
        return maxLen;
    }
}
