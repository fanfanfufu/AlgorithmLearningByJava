package com.fuqi.year2023.month03;

import java.util.Arrays;

/**
 * @author FuQi
 * @date 2023/3/4 22:32
 * @description
 */
public class Solution06312 {
    public int splitNum(int num) {
        char[] numArr = String.valueOf(num).toCharArray();
        Arrays.sort(numArr);
        StringBuilder leftStr = new StringBuilder();
        StringBuilder rightStr = new StringBuilder();
        int i = 0, j = 1;
        while (i < numArr.length || j < numArr.length) {
            if (i < numArr.length) leftStr.append(numArr[i]);
            i += 2;
            if (j < numArr.length) rightStr.append(numArr[j]);
            j += 2;
        }

        return Integer.parseInt(leftStr.toString()) + Integer.parseInt(rightStr.toString());
    }

    public static void main(String[] args) {
        Solution06312 solution06312 = new Solution06312();
        int num = 687;
        System.out.println(solution06312.splitNum(num));
    }
}
