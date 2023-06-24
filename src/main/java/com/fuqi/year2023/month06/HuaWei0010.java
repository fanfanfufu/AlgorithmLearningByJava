package com.fuqi.year2023.month06;

import java.util.Scanner;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/12 22:04
 * @description
 */
public class HuaWei0010 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().replace("[", "").replace("]", "").replace("\"", "").split(",");
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int len1 = result.length();
            int len2 = strs[i].length();
            int x = len1 - 1, y = len2 - 1;
            StringBuilder commonSuffix = new StringBuilder();
            while (x >= 0 && y >= 0) {
                if (result.charAt(x) == strs[i].charAt(y)) {
                    commonSuffix.append(result.charAt(x));
                }
                x--;
                y--;
            }
            if (commonSuffix.length() == 0) {
                System.out.println("");
                return;
            }
            result = commonSuffix.reverse().toString();
        }

        System.out.println(result);
    }
}
