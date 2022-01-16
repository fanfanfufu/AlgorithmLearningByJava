package com.fuqi.year2022.month01;

/**
 * @author FuQi
 * @date 2022/1/16 23:12
 * @description
 */
public class Solution00191 {
    public int hammingWeight1(int n) {
        char[] charArray = Integer.toBinaryString(n).toCharArray();
        int ans = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '1') {
                ans++;
            }
        }
        return ans;
    }

    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
