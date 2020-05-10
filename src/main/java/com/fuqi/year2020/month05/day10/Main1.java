package com.fuqi.year2020.month05.day10;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 188周赛第一题
 * @Author: 傅琦
 * @DateTime: 2020/5/10 10:35
 * @Version: V1.0
 */
public class Main1 {
    public static void main(String[] args) {
        Main1 main1 = new Main1();
        int[] target = new int[]{1, 3};
        int n = 2;
        List<String> result = main1.buildArray(target, n);
        for (String str : result) {
            System.out.print(str + ", ");
        }
    }

    public List<String> buildArray(int[] target, int n) {
        int len = target.length;
        List<String> ans = new ArrayList<>();
        if (target[len - 1] > n){ return ans; }

        int i = 0;
        int j = 1;
        while (i < len && j <= n){
            if (target[i] == j){
                ans.add("Push");
                i++;
            }else if (target[i] > j){
                ans.add("Push");
                ans.add("Pop");
            }
            j++;
        }
        return ans;
    }
}
