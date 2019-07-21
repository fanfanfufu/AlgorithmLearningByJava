package com.fuqi.month07.day0721;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/7/21 10:28
 * @Version: V1.0
 */
public class Exam1 {
    /**
     * 暴力解法
     * 时间复杂度O(n^2)，空间复杂度O(1)
     * @param dominoes
     * @return int
     */
    public int numEquivDominoPairs1(int[][] dominoes) {
        int count = 0;
        if (dominoes.length < 2){ return 0; }

        for (int i = 0; i < dominoes.length-1; i++) {
            int a = dominoes[i][0];
            int b = dominoes[i][1];

            for (int j = i+1; j < dominoes.length; j++) {
                int c = dominoes[j][0];
                int d = dominoes[j][1];
                if ((a == c && b == d) || (a == d && b == c)){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 解法二: 时间复杂度O(n),空间复杂度O(n)
     * 用一个Map存多米诺骨牌对的统计次数
     * 因为顺序颠倒认为是一对，所以课自定义顺序，将小的放在前面，大的放在后面，统计这对牌出现了多少次，即有多少对
     * @param dominoes
     * @return int
     */
    public int numEquivDominoPairs2(int[][] dominoes) {
        TreeMap<int[], Integer> map = new TreeMap<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });

        int res = 0;
        for (int i = 0; i < dominoes.length; i++) {
            int[] d = new int[2];
            d[0] = Math.min(dominoes[i][0], dominoes[i][1]);
            d[1] = Math.max(dominoes[i][0], dominoes[i][1]);

            res += map.getOrDefault(d, 0);
            map.put(d, map.getOrDefault(d, 0)+1);
        }
        return res;
    }
}
