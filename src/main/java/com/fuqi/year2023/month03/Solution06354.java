package com.fuqi.year2023.month03;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/3/26 11:55
 * @description
 */
public class Solution06354 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k == 0) return 0;
        // 如果k小于1的数量，则说明完全能取到k个1，因此直接返回k
        if (k <= numOnes) return k;
        int sum = 0;
        // 先把所有的1取了
        sum += numOnes;
        k -= numOnes;
        // 如果剩余的k小于0的数量，则直接返回sum
        if (k <= numZeros) return sum;
        // if left zero num less than k, sum will decrease
        // 1. minus the numZeros
        k -= numZeros;
        sum -= k;

        return sum;
    }

    public static void main(String[] args) {
        Solution06354 solution06354 = new Solution06354();
        System.out.println(solution06354.kItemsWithMaximumSum(3, 2, 1, 6));
    }
}
