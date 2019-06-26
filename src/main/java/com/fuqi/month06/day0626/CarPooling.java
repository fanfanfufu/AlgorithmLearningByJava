package com.fuqi.month06.day0626;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/6/26 20:15
 * @Version V1.0
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        // 1. sort trips by start_location
        // 1. 先按出发点排序
        Arrays.sort(trips, new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[1] - i2[1];
            }
        });

        // 按下车点顺序创建一个优先队列
        Queue<int[]> theQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[2] - t2[2];
            }
        });

        for (int i = 0; i < trips.length; i++) {
            while (!theQueue.isEmpty() && theQueue.peek()[2] <= trips[i][1]) {
                // 2. remove dead trips
                capacity += theQueue.peek()[0];
                theQueue.poll();
            }
            // 3. update capacity
            capacity -= trips[i][0];
            theQueue.offer(trips[i]);
            if( capacity < 0 ) {
                return false;
            }
        }
        return true;
    }
}
