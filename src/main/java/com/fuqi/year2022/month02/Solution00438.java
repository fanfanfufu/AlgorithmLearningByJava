package com.fuqi.year2022.month02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/2/11 22:47
 * @description
 */
public class Solution00438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) {
            return ans;
        }
        int[] pCharArr = new int[26];
        int[] sCharArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCharArr[p.charAt(i)-'a']++;
            sCharArr[s.charAt(i)-'a']++;
        }

        if (Arrays.equals(pCharArr, sCharArr)) {
            ans.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            sCharArr[s.charAt(i)-'a']++;
            sCharArr[s.charAt(i-p.length())-'a']--;

            if (Arrays.equals(pCharArr, sCharArr)) {
                ans.add(i-p.length()+1);
            }
        }

        return ans;
    }
}
