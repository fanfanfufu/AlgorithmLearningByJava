package com.fuqi.year2023.month07;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/6 23:12
 * @description
 */
public class Solution02178 {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if (finalSum % 2 == 1) return ans;
        for (long i = 2; i <= finalSum; i += 2) {
            ans.add(i);
            finalSum -= i;
        }
        ans.set(ans.size() - 1, ans.get(ans.size() - 1) + finalSum);

         return ans;
    }
}
