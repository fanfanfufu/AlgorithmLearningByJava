package com.fuqi.year2023.month01;

/**
 * @author FuQi
 * @date 2023/1/15 17:25
 * @description 整数反转
 */
public class Solution00007 {
    public int reverse(int x) {
        int y = 0;
        while (x != 0) {
            if (y > 214748364 || y < -214748364) return 0;
            y = y * 10 + x % 10;
            x = x / 10;
        }

        return y;
    }
}
