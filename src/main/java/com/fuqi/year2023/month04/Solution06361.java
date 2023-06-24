package com.fuqi.year2023.month04;

public class Solution06361 {
    public int diagonalPrime(int[][] nums) {
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i][i] > ans && isPrime(nums[i][i])) ans = Math.max(ans, nums[i][i]);
            if (nums[i][len - i - 1] > ans && isPrime(nums[i][len - i - 1])) ans = Math.max(ans, nums[i][len - i - 1]);
        }

        return ans;
    }

    /**
     * 判断一个非负整数是否是质数
     *
     * @param num 非负整数
     * @return boolean
     */
    private boolean isPrime(int num) {
        if (num < 2) return false;
        int i = 2;
        while (i * i <= num) {
            if (num % i == 0) return false;
            i++;
        }

        return true;
    }
}
