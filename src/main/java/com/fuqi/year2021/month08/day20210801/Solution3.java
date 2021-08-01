package com.fuqi.year2021.month08.day20210801;

/**
 * @author FuQi
 */
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(minimumPerimeter2(1L));
        System.out.println(minimumPerimeter2(13L));
        System.out.println(minimumPerimeter2(37L));
        System.out.println(minimumPerimeter2(61L));
        System.out.println(minimumPerimeter2(1000000000L));
    }

    /**
     * 方法一： 得出最直接的状态转移方程 dp[i] = dp[i-1] + 12 * i * i
     * @param neededApples
     * @return
     */
    public static long minimumPerimeter1(long neededApples) {
        long[] maxApples = new long[100000];
        for (int i = 1; i < 100000; i++) {
            long curMax = maxApples[i-1] + 12L * i * i;
            if (curMax >= neededApples) {
                return 8L * i;
            }
            maxApples[i] = curMax;
        }

        return 0L;
    }

    /**
     * 方法二：使用2个dp数组，一个记录最大的苹果数，一个记录增量
     * 状态转移方程为：
     * apple[i] = apple[i-1] + delta[i-1] + 12 * (2 * i - 1)
     * @param neededApples
     * @return
     */
    public static long minimumPerimeter2(long neededApples) {
        long[] maxApples = new long[100000];
        long[] delta = new long[100000];
        for (int i = 1; i < 100000; i++) {
            long curDelta = delta[i-1] + 12 * (2 * i - 1);
            long curMax = maxApples[i-1] + curDelta;
            if (curMax >= neededApples) {
                return 8L * i;
            }
            delta[i] = curDelta;
            maxApples[i] = curMax;
        }

        return 0L;
    }
}
