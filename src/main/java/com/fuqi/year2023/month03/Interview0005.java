package com.fuqi.year2023.month03;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/3/11 22:10
 * @description
 *
 * 给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
 *
 * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
 *
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 *
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 *
 *
 *
 * 输入: ["A","A"]
 *
 * 输出: []
 *
 */
public class Interview0005 {
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        int[] preSum = new int[n+1];
        for (int i = 0; i < n; i++) {
            // 转化的前缀和，遇到字母则+1，遇到数字则-1
            if (array[i].charAt(0)-'0' >= 0 && array[i].charAt(0) <= 9) {
                preSum[i+1] = preSum[i] - 1;
            } else {
                preSum[i+1] = preSum[i] + 1;
            }
        }
        int begin = 0, end = 0;
        Map<Integer, Integer> first = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer j = first.getOrDefault(preSum[i], -1);
            if (j < 0) first.put(preSum[i], i);
            else if (i-j > end-begin) {
                begin = j;
                end = i;
            }
        }

        String[] sub = new String[end-begin];
        System.arraycopy(array, begin, sub, 0, sub.length);

        return sub;
    }
}
