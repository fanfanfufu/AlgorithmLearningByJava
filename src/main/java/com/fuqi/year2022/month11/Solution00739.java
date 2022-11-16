package com.fuqi.year2022.month11;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author FuQi
 * @date 2022/11/16 23:36
 * @description 每日温度
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 */
public class Solution00739 {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return temperatures;
        }
        if (temperatures.length == 1) {
            return new int[1];
        }
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peekFirst()]) {
                Integer preIndex = stack.pollFirst();
                ans[preIndex] = i - preIndex;
            }
            stack.offerFirst(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution00739 solution00739 = new Solution00739();
        int[] input = new int[]{73,74,75,71,69,72,76,73};
        int[] ans = solution00739.dailyTemperatures(input);
        Arrays.stream(ans).forEach(System.out::println);
    }
}
