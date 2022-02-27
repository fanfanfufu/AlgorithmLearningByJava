package com.fuqi.year2022.month02;

/**
 * @author FuQi
 * @date 2022/2/27 17:02
 * @description
 */
public class Solution00201 {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }
}
