package com.fuqi.year2021.month12.day20211211;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FuQi
 * @date 2021/12/12 21:29
 * @description
 */
public class Solution05935 {
    /**
     * 采用动态规划的思路
     * 通过两个数组维护从左往右连续不增的天数，以及从右往左连续不减的天数
     *
     * @param security
     * @param time
     * @return
     */
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            // 如果当前的人数不高于前一天的人数，则在前一天的基础上+1，否则置为0
            if (security[i] <= security[i-1]) {
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 0;
            }
        }

        for (int i = n-2; i >= 0; i--) {
            if (security[i] <= security[i+1]) {
                // 如果当前的人数不高于后一天的人数，则在在后天统计的基础上+1，否则置为0
                right[i] = right[i+1] + 1;
            } else {
                right[i] = 0;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = time; i < n - time; i++) {
            // 同时满足左边连续time天人数非递增，右边人数非递减
            if (left[i] >= time && right[i] >= time) {
                // 等价于判断两个dp数组在该位置的累计天数是否都大于等于time
                ans.add(i);
            }
        }

        return ans;
    }
}
