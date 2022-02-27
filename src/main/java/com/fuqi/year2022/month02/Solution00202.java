package com.fuqi.year2022.month02;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FuQi
 * @date 2022/2/27 21:25
 * @description
 */
public class Solution00202 {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    private int getNext(int n) {
        int total = 0;
        while (n != 0) {
            int i = n % 10;
            n /= 10;
            total += (i * i);
        }

        return total;
    }


}
