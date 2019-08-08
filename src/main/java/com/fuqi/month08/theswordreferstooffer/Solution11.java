package com.fuqi.month08.theswordreferstooffer;

/**
 * @Description: 整数二进制表示中1的个数（负数用补码表示）
 * @Author 傅琦
 * @date 2019/8/8 11:16
 * @Version V1.0
 */
public class Solution11 {
    public int NumberOf1(int n){
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
