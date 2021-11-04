package com.fuqi.year2021.month10.day20211030;

import java.util.Arrays;
import java.util.stream.Collectors;

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
    public static int[] platesBetweenCandles1(String s, int[][] queries) {
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

    /**
     * 借助前缀和
     *
     * @param s 字符串
     * @param queries 查询数组
     * @return int[]
     */
    public static int[] platesBetweenCandles2(String s, int[][] queries) {
        int n = s.length();

        // 1. 计算前缀和: 从1开始为i位置前的盘子的数量之和
        int[] sum = new int[n +1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = s.charAt(i-1) == '*' ? sum[i-1]+1 : sum[i-1];
        }
        // 2. 记录 I 的位置
        // before记录的是当前位置左边的最近的 | 的索引
        int[] before = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                before[i] = i;
            } else {
                before[i] = i == 0 ? -1 : before[i-1];
            }
        }
        // after记录的是当前位置右边边的最近的 | 的索引
        int[] after = new int[n];
        for (int i = n-1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                after[i] = i;
            } else {
                after[i] = i == n-1 ? n : after[i+1];
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] cur = queries[i];
            int left = after[cur[0]], right = before[cur[1]];
            if (left < right) {
                ans[i] = sum[right+1] - sum[left];
            } else {
                ans[i] = 0;
            }
        }

        return ans;
    }

    public static int[] platesBetweenCandles(String s, int[][] queries){
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] sum = new int[n + 1], before = new int[n], after = new int[n];
        for(int i = 1; i < n + 1; i++)
            sum[i] = chars[i - 1] == '*' ? sum[i - 1] + 1 : sum[i - 1];
        for(int i = 0, pre = -1; i < n; i++){
            if(chars[i] == '|') pre = i;
            before[i] = pre;
        }
        for(int i = n - 1, next = n; i >= 0; i--){
            if(chars[i] == '|') next = i;
            after[i] = next;
        }
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int[] cur = queries[i];
            int left = after[cur[0]], right = before[cur[1]];
            if(left >= right)
                res[i] = 0;
            else
                // 前缀和与索引是错位的
                res[i] = sum[right + 1] - sum[left];
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "***|**|*****|**||**|*";
//        String s = "**|**|***|";
        int[][] queries = new int[][]{{1,17}, {4,5}, {14,17}, {5,11}, {15,16}};
//        int[][] queries = new int[][]{{2,5}, {5,9}};
//        String substring = s.substring(1, 18);
//        String substring = s.substring(4, 6);
//        String substring = s.substring(14, 18);
//        String substring = s.substring(5, 12);
//        String substring = s.substring(15,17);
//        int i = countPlates(substring);
//        System.out.println(i);

        int[] platesBetweenCandles = platesBetweenCandles2(s, queries);
//        int[] platesBetweenCandles = platesBetweenCandles(s, queries);
        String collect = Arrays.stream(platesBetweenCandles).mapToObj(String::valueOf).collect(Collectors.joining(","));
        System.out.println("res = [" + collect + "]");
    }
}
