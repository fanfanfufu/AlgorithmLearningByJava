package com.fuqi.year2021.month08.day20210808;

/**
 * @author FuQi
 */
public class Solution1 {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String each : words) {
            sb.append(each);
            if (sb.toString().equals(s)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(Math.floor(7.0 / 2));
        System.out.println(7 / 2);
        System.out.println(1 / 2);
    }
}
