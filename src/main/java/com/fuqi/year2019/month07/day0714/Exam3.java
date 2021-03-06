package com.fuqi.year2019.month07.day0714;

/**
 * @Description: 表现良好的最长时间段
 * @Author: 傅琦
 * @DateTime: 2019/7/14 10:30
 * @Version: V1.0
 */
public class Exam3 {
    public int longestWPI(int[] hours) {
        int tiredCount = 0;
        int relaxCount = 0;

        int sum = 0;

        int[] dp = new int[hours.length+1];
        dp[0] = 0;

        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8){
                tiredCount++;
            }else {
                relaxCount++;
            }

            if (tiredCount > relaxCount){
                int temp = tiredCount + relaxCount;
                sum = Math.max(sum, temp);
            }
        }
        return 0;
    }
}
