package com.fuqi.year2021.month11.day20211104;

/**
 * @author FuQi
 * @date 2021/11/4 22:26
 * @description 判断平方数, 最好不借助内置函数
 */
public class Solution00367 {
    public boolean isPerfectSquare(int num) {
        int left=0, right=num;
        while (left <= right) {
            int mid = (right - left)/2 + left;
            long square = (long) mid * mid;
            if (square > num) {
                right = mid-1;
            } else if (square < num){
                left = mid+1;
            } else {
                return true;
            }
        }

        return false;
    }
}
