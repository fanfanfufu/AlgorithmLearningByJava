package com.fuqi.month09.字节跳动;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/9/15 16:20
 * @Version V1.0
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int maxTime = 0;
        for(int i = 0; i < arr.length; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            maxTime = Math.max(maxTime, arr[i][0]);
        }
        Arrays.sort(arr, (o1, o2)->o1[0] - o2[0]);

        //模拟
        int countTime = 1;
        int max = 0;
        int time = 1;
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        while(time <= maxTime){
            countTime++;
            if(arr[index][0] == time){
                while(arr[index][1] != 0){
                    arr[index][1]--;
                    queue.add(1);
                }
                index++;
            }
            max = Math.max(max, queue.size());
            if(!queue.isEmpty())
                queue.poll();
            time++;
        }

        if(!queue.isEmpty()){
            countTime += queue.size();
        }

        System.out.println(countTime + " " + max);
    }

}
