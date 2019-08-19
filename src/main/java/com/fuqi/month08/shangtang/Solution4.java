package com.fuqi.month08.shangtang;

import java.util.*;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/19 20:25
 * @Version V1.0
 */
public class Solution4 {
    private static void helper(int[] arr){
        int len = arr.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] count = new int[3005];
        for (int i = 0; i < len; i++) {
            map.put(arr[i], new HashSet<>());
            count[arr[i]]++;
        }

        for (int i = 0; i < len; i++) {
            if (!map.get(arr[i]).isEmpty()){
                continue;
            }

            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }

                double val = Math.sqrt(arr[i] + arr[j]);
                if (val == Math.floor(val)){
                    map.get(arr[i]).add(arr[j]);
                }
            }
        }

        int res = 0;
        for(int key: map.keySet()) {
            count[key]--;
            res += recursion(arr, key, 0, count, map);
            count[key]++;
        }
        System.out.println(res);
    }

    private static int recursion(int[] arr, int val, int index, int[] count, Map<Integer, Set<Integer>> map) {
        if (index == arr.length-1) {
            return 1;
        }
        int res = 0;
        for (Integer next: map.get(val)) {
            if (count[next] == 0){
                continue;
            }
            count[next]--;
            res += recursion(arr, next, index+1, count, map);
            count[next]++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        helper(arr);
        scanner.close();
    }
}
