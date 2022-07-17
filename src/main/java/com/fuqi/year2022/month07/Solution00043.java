package com.fuqi.year2022.month07;

/**
 * @author FuQi
 * @date 2022/7/17 23:37
 * @description
 */
public class Solution00043 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m+n];
        // 从右往左模拟乘法计算法则进行计算
        for (int i = m-1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n-1; j >= 0; j--) {
                int y = num2.charAt(j)-'0';
                ansArr[i+j+1] += x*y;
            }
        }
        // 从右往左处理进位的问题
        for (int i = ansArr.length-1; i > 0; i--) {
            ansArr[i-1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        // 生成返回结果字符串
        StringBuilder ans = new StringBuilder();
        for (int i : ansArr) {
            if (i == 0 && ans.length() == 0) {
                continue;
            }
            ans.append(i);
        }

        return ans.toString();
    }
}
