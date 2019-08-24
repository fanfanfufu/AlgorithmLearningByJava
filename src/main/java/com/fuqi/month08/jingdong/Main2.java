package com.fuqi.month08.jingdong;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/24 20:28
 * @Version V1.0
 */
public class Main2 {
    private static void helper(int n, int[][] relations) {
        int[][] graph = new int[2*n][2*n];
        for (int[] relation : relations) {
            if (relation[0] <= n){
                graph[relation[0]-1][relation[1]-1] = 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < graph.length-1; i++) {
            for (int j = i+1; j < graph[0].length; j++) {
                if (graph[i][j] == 1){
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] relations = new int[m][2];
        for (int i = 0; i < m; i++) {
            relations[i][0] = scanner.nextInt();
            relations[i][1] = scanner.nextInt();
        }
        helper(n, relations);

        scanner.close();
    }
}
