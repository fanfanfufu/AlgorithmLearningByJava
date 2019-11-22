package com.fuqi.month11.day1122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/11/22 10:18
 * @Version: V1.0
 */
public class LeetCode967 {
    /**
     *
     * @param N 数的位数
     * @param K 相邻两位之间的差的绝对值
     * @return int[]
     */
    public int[] numsSameConsecDiff(int N, int K) {
        if (N < 1 || N > 9) { return null; }
        if (K < 0 || K > 9) { return null; }

        if (N == 1){
            int[] res = new int[10];
            for (int i = 0; i < res.length; i++) {
                res[i] = i;
            }
            return res;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            ans.addAll(helper(i, 1, K, N, temp));
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    /**
     * 递归地来构造满足要求的数
     * @param start 开始位
     * @param count 记录已经构造的位数
     * @param diff 差
     * @param N 目标位数
     * @param nums 已经构造的数的集合
     * @return List<Integer>
     */
    private List<Integer> helper(int start, int count, int diff, int N, List<Integer> nums) {

        List<Integer> res = new ArrayList<>();

        // 做差
        int a = start + diff;
        int b = start - diff;
        // 当b大于等于0时，才可以添到数的末尾
        if (b >= 0){
            // 如果已经构造的数的位数等于目标长度，即返回输入的集合
            if (count == N){ return nums; }
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num*10 + b);
            }
            // 递归构造下一位
            res.addAll(helper(b, count+1, diff, N, temp));
        }
        // 差为0的特殊情况
        if (a == b){ return res; }

        if (a < 10) {
            if (count == N){ return nums; }
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num*10 + a);
            }
            res.addAll(helper(a, count+1, diff, N, temp));
        }

        return res;
    }

    public static void main(String[] args) {
        LeetCode967 leetCode967 = new LeetCode967();
        int n = 1;
        int k = 2;
        int[] res = leetCode967.numsSameConsecDiff(n, k);
        System.out.println(res.length);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}
