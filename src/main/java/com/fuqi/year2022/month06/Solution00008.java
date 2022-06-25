package com.fuqi.year2022.month06;

/**
 * @author FuQi
 * @date 2022/6/25 16:20
 * @description
 */
public class Solution00008 {
    public static int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        // 1. 去除空格
        int i = 0;
        while (i < len && chars[i] == ' ') {
            i++;
        }
        // 2. 扫描完空格后的极端情况判断处理
        if (i == len) {
            return 0;
        }
        // 3. 设置符号
        int sign = 1;
        if (chars[i] == '-') {
            sign = -1;
            i++;
        } else if (chars[i] == '+') {
            i++;
        }
        int res = 0, last = 0;
        while (i < len) {
            char c = chars[i];
            if (c < '0' || c > '9') {
                break;
            }
            int cur = c - '0';
            last = res;
            res= res * 10 + cur;
            if (last != res / 10) {
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            i++;
        }

        return res * sign;
    }

    public static void main(String[] args) {
//        System.out.println(myAtoi("2147483645"));
        int num = 2147483645;
        int ans = num * 10;
        System.out.println(ans);
        long res = num * 10L;
        System.out.println(res);
        System.out.println();
    }
}
