package com.fuqi.year2021.month08.day20210822;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author FuQi
 */
public class Solution2 {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        if (n == 1 && nums.length == 1) {
            if ("0".equals(nums[0])) {
                return "1";
            } else {
                return "0";
            }
        }

        List<Integer> numsValue = new ArrayList<>();
        for (String numStr : nums) {
            Integer num = Integer.valueOf(numStr, 2);
            numsValue.add(num);
        }
        List<Integer> integerList = numsValue.stream().sorted().collect(Collectors.toList());
        int peak = (int) Math.pow(n, 2);
        String res = "";
        for (int i = 0; i < peak; i++) {
            if (!integerList.contains(i)) {
                res = Integer.toBinaryString(i);
                break;
            }
        }

        if (res.length() < n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n - res.length(); i++) {
                sb.append("0");
            }
            sb.append(res);
            res = sb.toString();
        }

        return res;
    }

    public static void main(String[] args) {
        String s = Integer.toBinaryString(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5 - s.length(); i++) {
            sb.append("0");
        }
        sb.append(s);
        s = sb.toString();
        System.out.println("s = " + s);
    }
}
