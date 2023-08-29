package com.fuqi.year2023.month08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/8/28 22:29
 * @description
 */
public class Solution00057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) return new int[][]{newInterval};
        int i = 0;
        List<int[]> res = new ArrayList<>();
        while (i < n) {
            int nl = newInterval[0], nr = newInterval[1];
            int cl = intervals[i][0], cr = intervals[i][1];
            if (nl > cr) {
                // 如果插入区间的左端点大于当前区间的右端点，说明需要插入在当前区间的后方
                res.add(intervals[i]);
                i++;
                // 判断是否遍历到最后一个区间，是的话，则插入区间到最后
                if (i == n) res.add(newInterval);
                continue;
            }
            if (nr < cl) {
                // 如果需要插入的区间的右端点小于当前区间的左端点
                // 说明区间没有重合，那么插入的区间需要放在当前区间的前面
                res.add(newInterval);
                break;
            }
            // nl <= cr: 此时就可以计算插入之后新区间的左端点
            newInterval[0] = Math.min(nl, cl);
            // nr >= cl
            // 如果插入区间的右端点小于等于当前区间右端点
            if (nr <= cr) {
                newInterval[1] = cr;
                res.add(newInterval);
                i++;
                break;
            }
            // nr > cr: 插入区间包含了当前区间，因此直接遍历下一个区间
            i++;
            // 判断是否遍历到最后一个区间，是的话，则插入区间到最后
            if (i == n) res.add(newInterval);
        }
        int ansLen = res.size();
        // 如果原区间数组中还有剩余的区间
        if (i < n) {
            ansLen += (n - i);
        }
        int[][] ans = new int[ansLen][2];
        int j = 0;
        for (; j < res.size(); j++) ans[j] = res.get(j);
        for (; i < n; i++) {
            ans[j] = intervals[i];
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution00057 solution00057 = new Solution00057();
//        int[][] intervals = {{1, 3}, {6, 9}};
//        int[] newInterval = {2, 5};
//        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
//        int[] newInterval = {4, 8};
//        int[][] intervals = {};
//        int[] newInterval = {5,7};
//        int[][] intervals = {{1,5}};
//        int[] newInterval = {2,3};
//        int[][] intervals = {{1,5}};
//        int[] newInterval = {2,7};
        int[][] intervals = {{2, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {0,1};
        solution00057.insert(intervals, newInterval);
    }
}
