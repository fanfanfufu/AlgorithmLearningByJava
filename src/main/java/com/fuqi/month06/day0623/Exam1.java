package com.fuqi.month06.day0623;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/6/23 10:32
 * @Version: V1.0
 */
public class Exam1 {
    public static void main(String[] args) {
        int[] input = {0,4,3,2,2,4,9,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        double[] res = sampleStats(input);
        for (double d: res) {
            System.out.print(d + " ");
        }
    }

    public static double[] sampleStats(int[] count) {
        double[] result = new double[5];
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        int len = 0;
        double sum = 0;
        int maxLen = 0;
        for (int i = 0; i < 256; i++) {
            if (count[i] == 0){
                continue;
            }
            len += count[i];
            min = Math.min(min, i);
            max = Math.max(max, i);
            sum = sum + i * count[i];
            if (count[i] > maxLen){
                maxLen = count[i];
                result[4] = i;
            }
        }

        if (len == 0){
            return result;
        }

        result[0] = min;
        result[1] = max;
        result[2] = sum / len;
        int mid = len / 2;
        for (int i = 0; i < 256; i++) {
            mid -= count[i];
            if (mid < 0){
                result[3] = i;
                break;
            }else if (mid == 0){
                if (len % 2 == 0){
                    double mid1 = i;
                    result[3] = (mid1 + mid1 + 1) / 2;
                }else {
                    result[3] = i+1;
                }
                break;
            }
        }

        return result;
    }
}
