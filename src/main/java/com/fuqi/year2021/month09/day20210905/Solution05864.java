package com.fuqi.year2021.month09.day20210905;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author FuQi
 */
public class Solution05864 {
    public static int numberOfWeakCharacters(int[][] properties) {
        // 第一个元素降序，第二个元素升序
        Arrays.sort(properties,(o1,o2)-> o1[0]==o2[0] ? o1[1]-o2[1]:o2[0]-o1[0]);
//        Arrays.sort(properties, (o1, o2) -> {
//            if (o1[0] < o2[0]) {
//                return 1;
//            }
//            if (o1[0] > o2[0]) {
//                return -1;
//            }
//            return Integer.compare(o1[1], o2[1]);
//        });

        int ans = 0;
        int max=-1;
        for (int i = 0; i < properties.length; i++) {
            if (max > properties[i][1]) {
                ans++;
            }
            max = Math.max(properties[i][1], max);
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[][] input = new int[][]{{5,5},{6,3},{3,6}};
        int[][] input = new int[][]{{1,5},{10,4},{4,3}};
//        int[][] input = new int[][]{{2,2},{3,3},{4,4}};
        int res = numberOfWeakCharacters(input);
        System.out.println("res = " + res);
    }
}
