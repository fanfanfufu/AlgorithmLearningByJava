package com.fuqi.year2022.month06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author FuQi
 * @date 2022/6/19 21:50
 * @description
 */
public class Solution00056 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 1) {
            return intervals;
        }
        // 1. 先将所有区间按照起点升序排列
        Arrays.sort(intervals, (a,b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        List<int[]> res = new ArrayList<>();
        int i = 1;
        int[] mergeInterval = new int[] {intervals[0][0], intervals[0][1]};
        while (i <= intervals.length) {
            int ml = mergeInterval[0];
            int mr = mergeInterval[1];
            if (i == intervals.length) {
                res.add(new int[]{ml, mr});
                break;
            }
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];
            // 如果合并区间的右边界小于当前区间的左边界，则将合并区间添加到结果集，
            // 然后使用当前区间作为合并区间，进行下一次循环
            if (mr < curLeft) {
                res.add(new int[]{ml, mr});
                mergeInterval = new int[] {curLeft, curRight};
                i++;
                continue;
            }
            // 到这里说明合并区间的右边界是大于等于当前区间的左边界了的
            // 如果合并区间的有边界小于当前区间的右边界，则使用当前区间的右边界作为新的合并区间的右边界
            if (mr < curRight) {
                mergeInterval[1] = curRight;
                i++;
                continue;
            }
            // 到这里，合并区间的右边界大于等于当前区间的右边界，直接进入下一次循环
            i++;
        }

        int[][] ans = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            ans[j][0] = res.get(j)[0];
            ans[j][1] = res.get(j)[1];
        }

        return ans;
    }

    public int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] nums = {{1,5}, {8,10}, {4,6}, {11,16}, {2,3}, {4,7}};
        Arrays.sort(nums, (a,b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        System.out.println("done");
    }
}
