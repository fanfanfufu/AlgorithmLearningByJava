package com.fuqi.year2019.month08.bilibili;

import java.util.*;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/20 18:56
 * @Version V1.0
 */
public class Solution2 {
    private static String helper1(int[] numbers) {
        String str = "";
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int a = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int b = Integer.valueOf(numbers[j] + "" + numbers[i]);
                // a > b
                if (a > b) {
                    // 交换i,j位置上的数
                    numbers[i] = numbers[i] + numbers[j];
                    numbers[j] = numbers[i] - numbers[j];
                    numbers[i] = numbers[i] - numbers[j];
                }
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            str += String.valueOf(numbers[i]);
        }
        return str;
    }

    private static String helper2(int[] numbers) {
        if (numbers == null || numbers.length == 0) { return ""; }

        String res = null;
        int len = numbers.length;
        Arrays.sort(numbers);
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            String s = String.valueOf(numbers[i]);
            temp.add(s);
        }

        String str1 = temp.get(0);
        String str2 = null;
        for (int i = 1; i < len; i++) {
            str2 = temp.get(i);
            if ((str1+str2).compareTo(str2+str1) < 0) {
                res = str1+str2;
            }else {
                res = str2+str1;
            }
            str1 = res;
        }

        return res;
    }

    private static String helper(int[] numbers) {
        if (numbers == null || numbers.length == 0) { return ""; }
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });

        for (int i = 0; i < len; i++) {
            sb.append(str[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String[] strs = string.split(",");
        int[] numbers = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            numbers[i] = Integer.valueOf(strs[i]);
        }
        System.out.println(helper(numbers));

        scanner.close();
    }
}
