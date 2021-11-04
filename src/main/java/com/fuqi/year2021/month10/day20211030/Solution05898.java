package com.fuqi.year2021.month10.day20211030;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author FuQi
 * @date 2021/10/30 22:33
 * @description
 */
public class Solution05898 {
    public static void main(String[] args) {
//        String[] arr = new String[]{"d","b","c","b","c","a"};
//        String[] arr = new String[]{"aaa", "aa", "a"};
        String[] arr = new String[]{"a","b","a"};
        System.out.println("ans = " + kthDistinct(arr, 3));
    }

    public static String kthDistinct(String[] arr, int k) {
        Map<String, Long> stringMap = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (String str : arr) {
            if (stringMap.get(str) == 1) {
                k--;
            }
            if (k == 0) {
                return str;
            }
        }

        return "";
    }
}
