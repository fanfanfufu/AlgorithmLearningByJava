package com.fuqi.month05.day0519;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 两数之和：
 * 求出给定数组中两个数之和位目标数的两数的index
 * @Author 傅琦
 * @Date 2019/5/19 20:55
 * @Version V1.0
 */
public class TwoSum {
    // 最优方法：一遍Hash表
    // 时间复杂度：O(n)
    // 空间复杂度：O(n)
    public int[] twoSum(int[] numbers, int target){
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if (numMap.containsKey(diff)){
                if (i < numMap.get(diff)){
                    return new int[]{i, numMap.get(diff)};
                }else {
                    return new int[]{numMap.get(diff), i};
                }
            }
            numMap.put(numbers[i], i);
        }
        throw new IllegalArgumentException("there's no number matches the condition.");
    }

    // 暴力解法：O(n^2)
    // 空间复杂度：O(1)
    public int[] forceMethod(int[] numbers, int target){
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] == target - numbers[j]){
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No tow sum solution");
    }
}
