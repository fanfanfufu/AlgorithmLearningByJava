package com.fuqi.year2022.month12;

/**
 * @author FuQi
 * @date 2022/12/18 21:22
 * @description
 */
public class Solution06266 {
    /**
     * 递归版
     *
     * @param n
     * @return
     */
    public int smallestValue(int n) {
        int ans = 0, temp = n;
        for (int i = 2; temp > 1; i++) {
            // 从最小的质数开始遍历
            while (temp % i == 0) {
                // 如果temp能整除i，则一直重复操作知道temp无法整除i
                temp /= i;
                // 通过循环就能得到最小的能整除temp的质数之和
                ans += i;
            }
        }
        // 如果k恰好等于n，k即为所求，过程结束；否则继续递归
        return ans == n ? n : smallestValue(ans);
    }
}
