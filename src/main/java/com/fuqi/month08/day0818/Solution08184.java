package com.fuqi.month08.day0818;

import java.util.*;

/**
 * @Description
 * @Team: 电子科技大学自动化研究所
 * @Author: 傅琦
 * @DateTime: 2019/8/18 11:28
 * @Version: V1.0
 */
public class Solution08184 {
    public String lastSubstring(String s) {
        if (s.trim().length() < 2){
            return s;
        }

        // 定义降序排列的map
        Map<Character, List<Integer>> map = new TreeMap<>(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return c2 - c1;
            }
        });

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.getOrDefault(c, new ArrayList<>()).add(i);
        }

        return s;
    }

    public static void main(String[] args) {
        //"xbylisvborylklftlkcioajuxwdhahdgezvyjbgaznzayfwsaumeccpfwamfzmkinezzwobllyxktqeibfoupcpptncggrdqbkji"
    }
}
