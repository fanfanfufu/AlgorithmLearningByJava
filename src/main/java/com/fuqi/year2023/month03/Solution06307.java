package com.fuqi.year2023.month03;

/**
 * @author FuQi
 * @date 2023/3/5 10:36
 * @description
 */
public class Solution06307 {
    public int passThePillow(int n, int time) {
        int left = 1, right = n;
        for (int i = 1; i <= time; i++) {
            if (right == n && left < right) {
                left++;
            } else if (left == n) {
                right--;
                left = 1;
            } else if (left == 1 && right > left) {
                right--;
            } else if (right == 1) {
                left++;
                right = n;
            }
        }

        return left == 1 ? right : left;
    }

    public static void main(String[] args) {
        Solution06307 solution06307 = new Solution06307();
        int n = 4, time = 6;
        System.out.println(solution06307.passThePillow(n ,time));
    }
}
