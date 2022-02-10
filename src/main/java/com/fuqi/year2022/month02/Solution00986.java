package com.fuqi.year2022.month02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/2/10 21:45
 * @description
 */
public class Solution00986 {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intervalList = new ArrayList<>();
        if (firstList.length == 0 || secondList.length == 0) {
            return intervalList.toArray(new int[0][2]);
        }
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int left = Math.max(firstList[i][0], secondList[j][0]);
            int right = Math.min(firstList[i][1], secondList[j][1]);
            if (left > right) {
                if (firstList[i][0] > secondList[j][1]) {
                    j++;
                } else {
                    i++;
                }
                continue;
            }
            intervalList.add(new int[]{left, right});
            if (firstList[i][1] == secondList[j][1]) {
                i++;
                j++;
                continue;
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
                continue;
            }
            // firstList[i][1] > secondList[j][1]
            j++;
        }

        return intervalList.toArray(new int[intervalList.size()][2]);
    }

    public static void main(String[] args) {

    }
}
