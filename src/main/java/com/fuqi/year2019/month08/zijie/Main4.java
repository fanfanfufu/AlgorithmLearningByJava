package com.fuqi.year2019.month08.zijie;

import java.util.Scanner;

/**
 * @Description: 4*4的格子里实现
 * @Author 傅琦
 * @date 2019/8/25 19:50
 * @Version V1.0
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int direct = scanner.nextInt();
        int[][] graph = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        helper(direct, graph);

        scanner.close();
    }

    private static void helper(int direct, int[][] graph){
        int i;
        switch (direct) {
            case 1:
                // 先求和
                i = 0;
                while (i < 4){
                    int j = 0;
                    while (j < 3){
                        if (graph[j][i] != 0 && graph[j][i] == graph[j+1][i]) {
                            graph[j][i] *= 2;
                            graph[j+1][i] = 0;
                        }
                        j++;
                    }
                    i++;
                }

                // 再移动
                i = 0;
                while (i < 4){
                    int j = 0;
                    while (j < 4){
                        if (graph[j][i] == 0){
                            int k = j+1;
                            while (k < 4){
                                if (graph[k][i] != 0){
                                    graph[j][i] = graph[k][i];
                                    graph[k][i] = 0;
                                    break;
                                }
                                k++;
                            }
                        }
                        j++;
                    }
                    i++;
                }
                break;
            case 2:
                i = 0;
                while (i < 4){
                    int j = 3;
                    while (j > 0){
                        if (graph[j][i] != 0 && graph[j][i] == graph[j-1][i]) {
                            graph[j][i] *= 2;
                            graph[j-1][i] = 0;
                        }
                        j--;
                    }
                    i++;
                }

                i = 0;
                while (i < 4){
                    int j = 3;
                    while (j >= 0){
                        if (graph[j][i] == 0){
                            int k = j-1;
                            while (k >= 0){
                                if (graph[k][i] != 0){
                                    graph[j][i] = graph[k][i];
                                    graph[k][i] = 0;
                                    break;
                                }
                                k--;
                            }
                        }
                        j--;
                    }
                    i++;
                }
                break;
            case 3:
                i = 0;
                while (i < 4){
                    int j = 0;
                    while (j < 3){
                        if (graph[i][j] != 0 && graph[i][j] == graph[i][j+1]) {
                            graph[i][j] *= 2;
                            graph[i][j+1] = 0;
                        }
                        j++;
                    }
                    i++;
                }

                i = 0;
                while (i < 4){
                    int j = 0;
                    while (j < 4){
                        if (graph[i][j] == 0){
                            int k = j+1;
                            while (k < 4){
                                if (graph[i][k] != 0){
                                    graph[i][j] = graph[i][k];
                                    graph[i][k] = 0;
                                    break;
                                }
                                k++;
                            }
                        }
                        j++;
                    }
                    i++;
                }
                break;
            case 4:
                i = 0;
                while (i < 4){
                    int j = 3;
                    while (j > 0){
                        if (graph[i][j] != 0 && graph[i][j] == graph[i][j-1]) {
                            graph[i][j] *= 2;
                            graph[i][j-1] = 0;
                        }
                        j--;
                    }
                    i++;
                }

                i = 0;
                while (i < 4){
                    int j = 3;
                    while (j >= 0){
                        if (graph[i][j] == 0){
                            int k = j-1;
                            while (k >= 0){
                                if (graph[i][k] != 0){
                                    graph[i][j] = graph[i][k];
                                    graph[i][k] = 0;
                                    break;
                                }
                                k--;
                            }
                        }
                        j--;
                    }
                    i++;
                }
                break;
        }

        for (int[] raw : graph) {
            for (int num : raw) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
