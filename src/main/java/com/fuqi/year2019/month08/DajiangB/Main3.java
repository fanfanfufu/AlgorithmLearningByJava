package com.fuqi.year2019.month08.DajiangB;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 *
 * 小W非常喜欢吃零食，经常都会去零食间里购买半价的零食吃，但是他为了控制自己的体重，因此会限制自己买零食的开销在某个数值以内。
 *
 * 但是小W有一个特别的爱好，他对于某些零食特别的喜欢，并且会对这些零食的喜爱成都进行排序。对于零食A和零食B，如果小W对零食A的喜爱程度大于对零食B的喜爱程度，那么每次拿零食的时候，一定会确保A的数目比B多。
 *
 * 现在零食间里有N种零食，假设每种零食都是取不完的，但小W每次都会刚好花完所有的开销，那么小W去取零食的时候应该有多少种可能的取法呢？
 *
 *
 * 输入
 * 输入包含多组测试数据，每组数组:
 *
 * 第一行：买零食的开销 V (V < 1000) 和 所有的零食种类数目 N (N < 200)。
 *
 * 第二行：第 i 个正整数表示第 i 种零食的价格 c_i (c_i < 1000)。
 *
 * 第三行：特别喜欢的零食的种类数 M (2 <= M <= N)
 *
 * 第四行：按照对 M 种零食的喜爱程度从高到低排序，第 i 种零食的喜爱程度会大于第 i + 1 种，保证不会形成环
 *
 *
 * 输出
 * 对于每组测试数据:
 *
 * 输出一个整数ans，表示在满足小W的特殊偏好的情况下，并且花光所有开销，有多少可能方案。
 *
 * （由于ans_i可能很大，因此最终结果 ans_i % 10000007）
 *
 *
 * 样例输入
 * 5 2
 * 1 2
 * 2
 * 2 1
 *
 *
 * 样例输出
 * 1
 *
 * 提示
 * 存在一种方案数(1,2)
 *
 *
 * @Author: 傅琦
 * @DateTime: 2019/8/6 19:47
 * @Version: V1.0
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int V = scanner.nextInt();
            int N = scanner.nextInt();
            int[][] cost = new int[N][2];
            for(int i = 0; i < N; i++){
                cost[i][0] = scanner.nextInt();
            }

            int M = scanner.nextInt();
            for(int i = 0; i < M; i++){
                cost[scanner.nextInt() - 1][1] = M - i + 1;
            }

            Arrays.sort(cost, (i1, i2) -> (i2[1] - i1[1]));
            int[][] dp = new int[N][V + 1];
            for(int i = 0; i < N; i++){
                Arrays.fill(dp[i], -1);
            }
            System.out.println(helper(dp, cost, 0, V, N, Integer.MAX_VALUE));
        }
        scanner.close();
    }

    private static int helper(int[][] dp, int[][] cost, int index, int rest, int N, int pre){
        if(index >= N) {
            return rest == 0 ? 1 : 0;
        }
        if(dp[index][rest] != -1) {
            return dp[index][rest];
        }
        int val = 0;
        for(int i = Math.min(pre - 1, rest / cost[index][0]); i >= 0; i--){
            val += helper(dp, cost, index + 1, rest - i * cost[index][0], N, i);
        }
        dp[index][rest] = val % 10000007;
        return dp[index][rest];
    }

    private static int helper1(int[][] dp, int[] cost, int index, int rest, int N, int pre){
        if (index >= N){
            return rest == 0 ? 1 : 0;
        }

        if (dp[index][rest] != -1){
            return dp[index][rest];
        }

        int val = 0;

        for (int i = Math.min(pre-1, rest / cost[index]); i >= 0; i--) {
            val += helper1(dp, cost, index+1, rest - i * cost[index], N, i);
        }

        dp[index][rest] = val & 10000007;
        return dp[index][rest];
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
//            int V = scanner.nextInt();
//            int N = scanner.nextInt();
//            int[] cost = new int[N];
//            for(int i = 0; i < N; i++){
//                cost[i] = scanner.nextInt();
//            }
//
//            int M = scanner.nextInt();
//            for(int i = 0; i < M; i++){
//                cost[scanner.nextInt() - 1][1] = M - i + 1;
//            }
//
//            Arrays.sort(cost, (i1, i2) -> (i2[1] - i1[1]));
//            int[][] dp = new int[N][V + 1];
//            for(int i = 0; i < N; i++){
//                Arrays.fill(dp[i], -1);
//            }
//            System.out.println(recursion(dp, cost, 0, V, N, Integer.MAX_VALUE));
//        }
//        scanner.close();
//    }
}
