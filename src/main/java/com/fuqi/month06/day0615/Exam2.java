package com.fuqi.month06.day0615;

import java.util.*;

/**
 * @Description: 前五科的均分
 *
 * 给你一个不同学生的分数列表，请按 学生的 id 顺序 返回每个学生 最高的五科 成绩的 平均分。
 * 对于每条 items[i] 记录， items[i][0] 为学生的 id，items[i][1] 为学生的分数。平均分请采用整数除法计算。
 *
 * 示例：
 * 输入：[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * 输出：[[1,87],[2,88]]
 * 解释：
 * id = 1 的学生平均分为 87。
 * id = 2 的学生平均分为 88.6。但由于整数除法的缘故，平均分会被转换为 88。
 *
 * @Author: 傅琦
 * @DateTime: 2019/6/15 22:43
 * @Version: V1.0
 */
public class Exam2 {
    public static void main(String[] args) {
        int[][] input = new int[][]{{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        Exam2 exam2 = new Exam2();
        int[][] res = exam2.highFive(input);
        for (int[] raw: res) {
            for (int num:raw) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public int[][] highFive(int[][] items) {
        // 先遍历输入，将数据按学生：前五科成绩，存起来
        Map<Integer, Queue<Integer>> map = new LinkedHashMap<>();
        for (int[] score: items) {
            if (!map.containsKey(score[0])){
                Queue<Integer> scoreHeap = new PriorityQueue<>(5, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer t1, Integer t2) {
                        return t2 -t1;
                    }
                });
                scoreHeap.offer(score[1]);
                map.put(score[0], scoreHeap);
            }else {
                map.get(score[0]).offer(score[1]);
            }
        }

        // 再遍历map，得到平均分，并输出结果
        int[][] result = new int[map.size()][2];
        int i = 0;
        for (Integer id: map.keySet()) {
            result[i][0] = id;
            Queue<Integer> five = map.get(id);
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += five.poll();
            }
            result[i][1] = sum / 5;
            i++;
        }

        return result;
    }
}
