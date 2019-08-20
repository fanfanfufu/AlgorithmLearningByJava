package com.fuqi.month08.bilibili;

import java.util.Scanner;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/20 18:56
 * @Version V1.0
 */
public class Solution1 {
    private static String helper1(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length-1; i >= 0; i--) {
            sb.append(strs[i]);
            if (i > 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static String helper(String str) {
        String temp = new StringBuilder(str).reverse().toString()  + " ";
        int start = 0;
        int end = 0;
        char[] chars = temp.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                end = i;
            }else {
                for (int j = 0; j < (end-start+1)/2; j++) {
                    char ch = chars[start+j];
                    chars[start+j] = chars[end-j];
                    chars[end-j] = ch;
                }
                start = end + 2;
                end = end + 2;
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        System.out.println(helper1(strs));
//        String string = scanner.nextLine();
//        System.out.println(helper(string));

        scanner.close();
    }
}
