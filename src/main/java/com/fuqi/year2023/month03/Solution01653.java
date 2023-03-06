package com.fuqi.year2023.month03;

/**
 * @author FuQi
 * @date 2023/3/6 22:51
 * @description 最少删除次数
 */
public class Solution01653 {
    public int minimumDeletions(String s) {
        int bCount = 0, ans = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') bCount++;
            else ans = Math.min(ans+1, bCount);
        }

        return ans;
    }
}
