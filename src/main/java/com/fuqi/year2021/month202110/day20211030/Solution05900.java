package com.fuqi.year2021.month202110.day20211030;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2021/10/30 23:00
 * @description
 */
public class Solution05900 {
    /**
     * 方法一: 暴力方法
     * 容易超时
     *
     * @param s 字符串:: "***|**|*****|**||**|*"
     * @param queries 查询取见数组
     * @return 查询结果
     */
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String substring = s.substring(queries[i][0], queries[i][1] + 1);
            int count = countPlates(substring);
            ans[i] = count;
        }

        return ans;
    }

    private static int countPlates(String substring) {
        int count = 0;
        int i = 0, j = substring.length()-1;
        while (i < j) {
            char left = substring.charAt(i);
            char right = substring.charAt(j);
            if ('*' == left && '*' == right) {
                i++;
                j--;
                continue;
            }
            if ('*' == left && '|' == right) {
                i++;
                continue;
            }
            if ('|' == left && '*' == right) {
                j--;
                continue;
            }
            // 两个都是 | 是中止循环
            break;
        }
        if (i < j) {
            String validString = substring.substring(i, j + 1);
            for (char ch : validString.toCharArray()) {
                if ('*' == ch) {
                    count++;
                }
            }
            return count;
        }

        return count;
    }

    public static void main(String[] args) {
//        String s = "***|**|*****|**||**|*";
        String s = "**|**|***|";
//        int[][] queries = new int[][]{{1,17}, {4,5}, {14,17}, {5,11}, {15,16}};
        int[][] queries = new int[][]{{2,5}, {5,9}};
//        String substring = s.substring(1, 18);
//        String substring = s.substring(4, 6);
//        String substring = s.substring(14, 18);
//        String substring = s.substring(5, 12);
//        String substring = s.substring(15,17);
//        int i = countPlates(substring);
//        System.out.println(i);

        int[] platesBetweenCandles = platesBetweenCandles(s, queries);
        Arrays.stream(platesBetweenCandles).forEach(System.out::println);
    }
}
