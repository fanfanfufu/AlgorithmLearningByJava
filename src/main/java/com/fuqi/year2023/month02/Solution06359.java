package com.fuqi.year2023.month02;

/**
 * @author FuQi
 * @date 2023/2/18 22:58
 * @description
 */
public class Solution06359 {
    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        int[] bitArr = new int[10];
        for (char ch : numStr.toCharArray()) {
            bitArr[ch - '0']++;
        }
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < bitArr.length; i++) {
            if (bitArr[i] == 0) continue;
            int curMax = Integer.parseInt(numStr.replace(String.valueOf(i), "9"));
            maxNum = Math.max(maxNum, curMax);
            int curMin = Integer.parseInt(numStr.replace(String.valueOf(i), "0"));
            minNum = Math.min(minNum, curMin);
        }

        return maxNum-minNum;
    }

    public static void main(String[] args) {
        Solution06359 solution06359 = new Solution06359();
        System.out.println(solution06359.minMaxDifference(11891));
        System.out.println(solution06359.minMaxDifference(90));
    }
}
