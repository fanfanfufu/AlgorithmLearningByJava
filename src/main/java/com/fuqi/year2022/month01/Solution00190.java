package com.fuqi.year2022.month01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author FuQi
 * @date 2022/1/17 22:44
 * @description
 */
public class Solution00190 {
    // you need treat n as an unsigned value
    // 01010101010101010101010101010101
    private static final int M1 = 0x55555555;
    // 00110011001100110011001100110011
    private static final int M2 = 0x33333333;
    // 00001111000011110000111100001111
    private static final int M4 = 0x0f0f0f0f;
    // 00000000111111110000000011111111
    private static final int M8 = 0x00ff00ff;

    public int reverseBits(int n) {
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }

    public int reverseBits1(int n) {
        char[] charArray = Integer.toBinaryString(n).toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = charArray.length-1; i >= 0; i--) {
            stringBuilder.append(charArray[i]);
        }
        return Integer.parseUnsignedInt(stringBuilder.toString(), 2);
    }

    public int reverseBits2(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
}
