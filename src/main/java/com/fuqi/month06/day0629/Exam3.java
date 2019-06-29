package com.fuqi.month06.day0629;

import java.util.Arrays;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/6/30 0:22
 * @Version: V1.0
 */
public class Exam3 {
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, (log1, log2) -> log1[0] - log2[0]);

        int[] parents = new int[N];
        int[] count = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
            count[i] = 1;
        }

        for (int[] log: logs) {
            int p1 = getParent(parents, log[1]);
            int p2 = getParent(parents, log[2]);
            if (p1 != p2){
                parents[p1] = p2;
                int person = getParent(parents, p2);
                count[person] += count[p1];
                if (count[person] == N){
                    return log[0];
                }
            }
        }
        return -1;
    }

    private int getParent(int[] parents, int child){
        while (child != parents[child]){
            child = parents[child];
        }
        return child;
    }

    public static void main(String[] args) {
        int[][] logs = {{20190101,0,1}, {20190104,3,4}, {20190107,2,3}, {20190211,1,5}, {20190224,2,4},
                {20190301,0,3}, {20190312,1,2}, {20190322,4,5}};
        int N = 6;
        Exam3 exam3 = new Exam3();
        int res = exam3.earliestAcq(logs, N);
        System.out.println("res = " + res);
    }
}
