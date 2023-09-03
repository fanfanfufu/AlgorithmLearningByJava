package com.fuqi.year2023.month09;

import java.util.Arrays;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/9/3 16:55
 * @description 消灭怪物的最大数量
 */
public class Solution01921 {
    /**
     * 贪心+排序
     * 用times数组记录每个怪物最晚可被消灭的时间
     * times数组升序排列
     * 遍历times数组，对于第i个时间节点上的元素，如果times[i] >= i，说明满足题意，因此统计到个数中
     * 否则说明不满足题意(怪物无法被消灭)，直接返回i即可
     *
     * @param dist
     * @param speed
     * @return
     */
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        if (n == 1) return 1;
        // get the monster's last reach time array
        int[] times = new int[n];
        for (int i = 0; i < n; i++) times[i] = (dist[i]-1) / speed[i];
        // sort the times array
        Arrays.sort(times);
        // calculate the answer
        for (int i = 0; i < n; i++) {
            if (times[i] < i) return i;
        }

        return n;
    }

    public static void main(String[] args) {
        Solution01921 solution01921 = new Solution01921();
        int[] dist = {1,1,2,3};
        int[] speed = {1,1,1,1};
        System.out.println(solution01921.eliminateMaximum(dist, speed));
    }
}
