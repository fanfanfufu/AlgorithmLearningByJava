package com.fuqi.year2023.month06;

import java.util.Scanner;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/1 20:31
 * @description
 */
public class SolutionTest03 {
    private static String[] intHexString = {"0000","0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001"};
    private static String[] wordHexString = {"1010", "1011", "1100", "1101", "1110", "1111"};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) {
            String hexString = in.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i < hexString.length(); i++) {
                char cur = hexString.charAt(i);
                if (cur >= '0' && cur <= '9') {
                    sb.append(intHexString[cur-'0']);
                } else {
                    sb.append(wordHexString[cur-'A']);
                }
            }
            System.out.println(parseToInt(sb.toString()));
        }
    }

    public static int parseToInt(String binaryStr) {
        int cnt = 0;
        int ans = 0;
        for (int i = binaryStr.length()-1; i >= 0; i--) {
            if (binaryStr.charAt(i) == '0') {
                cnt++;
                continue;
            }
            ans += (1 << cnt);
            cnt++;
        }

        return ans;
    }
}
