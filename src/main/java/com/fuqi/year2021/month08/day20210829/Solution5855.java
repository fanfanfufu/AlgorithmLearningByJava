package com.fuqi.year2021.month08.day20210829;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 找到给定数字字符串数组中第k大的数字字符串
 * 每个字符串不会有前导0
 * 最长有100位
 * 比赛中不能用BigInteger
 * @author FuQi
 */
public class Solution5855 {
    public static String kthLargestNumber1(String[] nums, int k) {
        Arrays.sort(nums, (o1, o2) -> {
            BigInteger b1 = new BigInteger(o1);
            BigInteger b2 = new BigInteger(o2);
            return b2.compareTo(b1);
        });

        return nums[k-1];
    }

    public static String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (o1, o2) -> {
            if (o2.length() > o1.length()) {
                return 1;
            }
            if (o2.length() < o1.length()) {
                return -1;
            }
            return compareSameLengthNum(o1, o2, 0);
        });

        return nums[k-1];
    }

    /**
     * 比较相同长度数字字符串中数字的大小
     *
     * @param o1
     * @param o2
     * @param index
     * @return
     */
    private static int compareSameLengthNum(String o1, String o2, int index) {
        if (index == o1.length()) {
            return 0;
        }
        if (o2.charAt(index) > o1.charAt(index)) {
            return 1;
        }
        if (o2.charAt(index) < o1.charAt(index)) {
            return -1;
        }
        index++;
        return compareSameLengthNum(o1, o2, index);
    }

    public static void main(String[] args) {
        String[] nums = new String[]{"1", "2", "2"};
        int k = 1;
        System.out.println(kthLargestNumber(nums, k));
    }
}
