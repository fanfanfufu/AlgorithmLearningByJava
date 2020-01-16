package com.fuqi.year2019.month08.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/21 18:59
 * @Version V1.0
 */
public class Main1 {
    private static void helper(String[] strs) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < strs.length; i++) {
            if ("A".equals(strs[i])) {
                ans.add("12");
                ans.add("34");
            }else if ("B".equals(strs[i])) {
                ans.add("AB");
                ans.add("CD");
            }else {
                ans.add(strs[i]);
            }
        }

        System.out.print(Integer.toHexString(ans.size()+1).toUpperCase());
        for (String str : ans) {
            System.out.print(" " + str);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String[] strs = string.trim().split(" ");
        if (strs.length == 0) {return;}
        helper(strs);

        scanner.close();
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String string = scanner.nextLine();
//        String[] strs = string.trim().split(" ");
//        if (strs.length == 0) {return;}
//        StringBuilder sb = new StringBuilder();
//        int count = 0;
//        for (int i = 1; i < strs.length; i++) {
//            char c = strs[i].charAt(0);
//            if (c == 'A'){
//                count += 2;
//                sb.append("12 34 ");
//            }else if (c == 'B') {
//                count += 2;
//                sb.append("AB CD ");
//            }else {
//                count++;
//                sb.append(c + " ");
//            }
//        }
//
//        String len = intToHex(count+1);
//        System.out.println(len + " " + sb.toString().trim());
//
//        scanner.close();
//    }

    private static String intToHex(int n) {
        StringBuilder sb = new StringBuilder();
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (n != 0){
            sb.append(chars[n % 16]);
            n /= 16;
        }

        return sb.reverse().toString();
    }
}

/**    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.next(), 16);
        if (len == 0) { System.out.println(0); }

        int outLen = 0;
        List<String> input = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String str = scanner.next();
            if ("A".equals(str)){
                input.add("12");
                input.add("34");
            }else if ("B".equals(str)) {
                input.add("AB");
                input.add("CD");
            }else {
                input.add(str);
            }
        }
        outLen = input.size()+1;
        //input.add(0, Integer.toHexString(outLen).toUpperCase());
        System.out.print(Integer.toHexString(outLen).toUpperCase());

        for (String str : input) {
            System.out.print(" " + str);
        }
    }*/
