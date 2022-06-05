package com.fuqi.year2022;

/**
 * @author FuQi
 * @date 2022/6/5 21:24
 * @description
 */
public class Solution00415 {
    public static String addStrings(String num1, String num2) {
        int tenLag = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >=0 || tenLag != 0) {
            int x = i >= 0 ? num1.charAt(i)-'0' : 0;
            int y = j >= 0 ? num2.charAt(j)-'0' : 0;
            int bitSum = x + y + tenLag;
            ans.append(bitSum % 10);
            tenLag = bitSum / 10;
            i--;
            j--;
        }
        ans.reverse();

        return ans.toString();
    }

    public static void main(String[] args) {
        String num1 = "5";
        String num2 = "5";
        System.out.println(addStrings(num1, num2));
    }
}
