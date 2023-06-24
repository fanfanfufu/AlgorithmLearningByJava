package com.fuqi.year2023.month05;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/7 16:40
 * @description 总持续时间可被 60 整除的歌曲
 */
public class Solution01010 {
    /**
     * 参考两数之和的思路，
     * 用一个长度为60的数组，记录当前元素对60取余数之后的值的次数
     * 结果就是累加60减去当前元素取余数之后的值的次数
     * 并且累加过之后，要更新当前元素取余数之后值的次数，+1
     *
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        int[] cnt = new int[60];
        for (int t : time) {
            if (t % 60 == 0) {
                ans += cnt[0];
                cnt[0]++;
                continue;
            }
            ans += cnt[60 - t % 60];
            // 上面两种情况可以合并成一行代码：可以兼顾当前元素值刚好是60的倍数的情况
//            ans += cnt[(60 - t % 60) % 60];
            // 更新当前元素取余之后的次数：+1操作
            cnt[t % 60]++;
        }

        return ans;
    }
}
