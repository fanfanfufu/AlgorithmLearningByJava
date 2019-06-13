package com.fuqi.month05.day0524;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * @Author 傅琦
 * @Date 2019/5/24 20:37
 * @Version V1.0
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if (num == null || size <= 0 || size > num.length){return new ArrayList<>();}

        Queue<Integer> window = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int max = num[0];
        if (size == num.length){
            for (int number: num) {
                max = max > number ? max: number;
            }
            result.add(max);
        }else {
            for (int i = 0; i < size; i++) {
                max = max > num[i] ? max: num[i];
                window.offer(num[i]);
            }
            result.add(max);

            for (int i = size; i < num.length; i++) {
                window.poll();
                window.offer(num[i]);
                if (window.contains(max)){
                    max = max > num[i] ? max: num[i];
                    result.add(max);
                }else {
                    max = 0;
                    for (int number: window) {
                        max = max > number ? max: number;
                    }
                    result.add(max);
                }
            }
        }
        return result;
    }
}
