package com.fuqi.year2019.month11.day1109;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/11/9 15:04
 * @Version V1.0
 */
public class LeetCode436 {
    /**
     * 暴力解法
     * @param intervals
     * @return
     */
    public int[] findRightInterval1(int[][] intervals) {
        if (intervals.length == 0) { return null; }
        if (intervals.length == 1) { return new int[]{-1}; }
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int minStart = Integer.MAX_VALUE;
            int minStartIndex = -1;
            for (int j = 0; j < intervals.length; j++) {
                if (i == j){ continue; }
                if (intervals[j][0] >= intervals[i][1] && intervals[j][0] < minStart){
                    minStart = intervals[j][0];
                    minStartIndex = j;
                }
            }
            res[i] = minStartIndex;

        }
        return res;
    }

    /**
     * 排序+扫描
     * @param intervals
     * @return
     */
    public int[] findRightInterval2(int[][] intervals) {
        if (intervals.length == 0) { return null; }
        if (intervals.length == 1) { return new int[]{-1}; }

        // 1.取出所有区间的起点，用Map存储
        int[] startPoints = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            startPoints[i] = intervals[i][0];
        }
        Arrays.sort(startPoints);
        int maxStart = startPoints[startPoints.length-1];

        // 2.遍历所有区间
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int endPoint = intervals[i][1];
            if (endPoint > maxStart) {
                res[i] = -1;
            }else {
                for (int j = 0; j < startPoints.length; j++) {
                    if (startPoints[j] >= endPoint){
                        for (int k = 0; k < intervals.length; k++) {
                            if (startPoints[j] == intervals[k][0]){
                                res[i] = k;
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }

        return res;
    }

    /**
     * 使用TreeMap现成的ceilingEntry
     * ceilingEntry()的功能时获得TreeMap中Key恰好比当前选择区间的结束点大的元素
     * @param intervals
     * @return int[]
     */
    public int[] findRightInterval3(int[][] intervals){
        TreeMap<Integer, Integer> starts = new TreeMap<>();
        int[] res = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            starts.put(intervals[i][0], i);
        }

        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> pos = starts.ceilingEntry(intervals[i][1]);
            res[i] = pos == null ? -1 : pos.getValue();
        }

        return res;
    }
}
