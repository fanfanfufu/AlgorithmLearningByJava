package com.fuqi.month08.DajiangB;

import java.util.Scanner;

/**
 * @Description:
 * 题目描述：
 * 有许多程序员都热爱玩游戏游戏，而小J自称为游戏王，曾玩过几百种游戏，几乎所有能玩到的游戏大作都玩遍了。
 * 随着时间的推移，他发觉已经没有游戏可以让他玩了！于是他想改玩一些古老的游戏，以成为真正的“游戏王”。
 * 他希望在接下来的一段时间内将过去出的游戏全部玩一遍，但是毕竟时间有限，因此他感到很苦恼。
 * 于是他给每个游戏标上一个成就值，同时估算了完成这些游戏所需要的时间。
 *
 * 现在他只有X天时间。而每个游戏一旦开始玩，至少需要玩一天才能够停下来。
 * 那么，他所玩完的游戏的成就值之和最大能达到多少呢？（每个游戏必须玩完才能取得成就值。）
 *
 * 第一行输入case数T（0<T<20）。对于每个case，第一行输入游戏的数目N(0<N<11)，总时间X(0<X<1000)用空格分隔。
 * 从第二行到第N+1行每行输入游戏的成就值Ai(0<Ai<10000)，所需要花费时间Bi(0<Bi<10000)。
 *
 * 2
 * 2 2
 * 10 1
 * 20 2
 * 3 4
 * 10 2
 * 18 3
 * 10 2
 *
 * 20
 * 20
 *
 * @Author: 傅琦
 * @DateTime: 2019/8/6 19:50
 * @Version: V1.0
 */
public class Main1 {

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int T = scanner.nextInt();
//        for (int i = 0; i < T; i++) {
//            int N = scanner.nextInt();
//            int X = scanner.nextInt();
//
//            int[] score = new int[N];
//            int[] cost = new int[N];
//
//            for (int j = 0; j < N; j++) {
//                score[j] = scanner.nextInt();
//                cost[j] = scanner.nextInt();
//            }
//
//            System.out.println(helper(N, X, score, cost));
//        }
//
//        scanner.close();
//    }
//
//    static int helper(int n, int C, int[] score, int[] cost){
//        int[] dp = new int[C+1];
//        for (int i = n-1; i >= 0; i--) {
//            for (int j = 0; j <= C; j++) {
//                dp[j] = (j + score[i] > C) ? dp[j] : Math.max(dp[j], dp[j + score[i]] + cost[i]);
//            }
//        }
//        return dp[0];
//    }

    static int dp(int n, int C, int[] w, int[] v){
        int[] dp = new int[C+1];
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j <= C; j++){
                //注意顺序
                dp[j] = (j + w[i] > C) ? dp[j] : Math.max(dp[j], dp[j + w[i]] + v[i]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T != 0){
            T--;
            int N = sc.nextInt();
            int X = sc.nextInt();
            int[] gain = new int[N];
            int[] cost = new int[N];
            for(int i = 0; i < N; i++){
                gain[i] = sc.nextInt();
                cost[i] = sc.nextInt();
            }
            System.out.println(dp(N, X, cost, gain));
        }

        sc.close();
    }
}
