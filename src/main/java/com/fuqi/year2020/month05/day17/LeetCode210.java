package com.fuqi.year2020.month05.day17;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 课程表II
 * @Author: 傅琦
 * @DateTime: 2020/5/17 17:24
 * @Version: V1.0
 */
public class LeetCode210 {
    /**
     * 本题考查的是图的遍历
     * 方法一：BFS
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        if (numCourses == 0){ return new int[0]; }
        int[] inDegrees = new int[numCourses];
        // 建立入度表
        for (int[] p : prerequisites) {
            // 针对需要先修其他课程的课，先统计需要先修的课程的数量
            inDegrees[p[0]]++;
        }
        // 入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0){
                queue.offer(i);
            }
        }
        // 记录可以学完的课程数量
        int count = 0;
        int[] res = new int[numCourses];
        // 根据提供的先修课程的列表，删除入度为0的节点
        while (!queue.isEmpty()){
            int cur = queue.poll();
            res[count++] = cur;
            for (int[] p : prerequisites) {
                if (p[1] == cur){
                    inDegrees[p[0]]--;
                    if (inDegrees[p[0]] == 0){ queue.offer(p[0]); }
                }
            }
        }

        if (count == numCourses){ return res; }
        return new int[0];
    }
}
