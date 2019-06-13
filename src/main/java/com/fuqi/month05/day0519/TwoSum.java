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
}
