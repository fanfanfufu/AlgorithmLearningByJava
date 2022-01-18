package com.fuqi.year2022.month01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author FuQi
 * @date 2022/1/18 22:47
 * @description
 */
public class Solution00539 {
    public static int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int[] minArray = new int[len];
        for (int i = 0; i < len; i++) {
            int timeInt = parseToInt(timePoints.get(i));
            minArray[i] = timeInt;
        }
        int ans = Integer.MAX_VALUE;
        Arrays.sort(minArray);
        for (int i = 1; i < minArray.length; i++) {
            ans = Math.min(ans, minArray[i] - minArray[i-1]);
        }
        // 循环完毕后，还需要检查首尾的时间差
        ans = Math.min(ans, minArray[0] + 1440 - minArray[len-1]);

        return ans;
    }

    private static int parseToInt(String timeStr) {
        String[] split = timeStr.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    public static void main(String[] args) {
        List<String> timePoints = Stream.of("12:12","00:13").collect(Collectors.toList());
        System.out.println(findMinDifference(timePoints));
    }
}
