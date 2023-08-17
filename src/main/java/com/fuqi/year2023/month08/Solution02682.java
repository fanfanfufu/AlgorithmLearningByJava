package com.fuqi.year2023.month08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/16 22:54
 * @description
 */
public class Solution02682 {
    public int[] circularGameLosers(int n, int k) {
        int[] users = new int[n];
        int i = 0, count = 1;
        while (true) {
            users[i]++;
            if (users[i] == 2) break;
            i = (i + k * count) % n;
            count++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (users[j] == 0) ans.add(j+1);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
