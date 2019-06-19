package com.fuqi.month06.day0619;

import java.util.Scanner;

/**
 * @Description:
 * 如果一个字符串由两个相同字符串连接而成, 就称这个字符串是偶串。
 * 例如"xyzxyz"和"aaaaaa"是偶串,但是"ababab"和"xyzxy"却不是。
 * 牛牛现在给你一个只包含小写字母的偶串s,
 * 你可以从字符串s的末尾删除1和或者多个字符,
 * 保证删除之后的字符串还是一个偶串,
 * 牛牛想知道删除之后得到最长偶串长度是多少。
 *
 * 输入描述:
 * 输入包括一个字符串s,字符串长度length(2 ≤ length ≤ 200),保证s是一个偶串且由小写字母构成
 *
 * 输出描述:
 * 输出一个整数,表示删除之后能得到的最长偶串长度是多少。保证测试数据有非零解
 *
 * 输入例子1:
 * abaababaab
 *
 * 输出例子1:
 * 6
 *
 * @Author 傅琦
 * @Date 2019/6/19 19:26
 * @Version V1.0
 */
public class Exam1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();

        int len = input.length();
        for (int i = len - 2; i >= 0; i--) {
            if (isEvenString(input.substring(0, i))){
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean isEvenString(String s){
        int len = s.length();
        if (len % 2 == 1){
            return false;
        }
        int len1 = len / 2;
        for (int i = 0; i < len1; i++) {
            if (s.charAt(i) != s.charAt(len1+i)){
                return false;
            }
        }
        return true;
    }
}
