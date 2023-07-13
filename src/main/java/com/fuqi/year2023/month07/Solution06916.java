package com.fuqi.year2023.month07;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/7/2 11:03
 * @description
 */
public class Solution06916 {

    private boolean judgePrime(int num) {
        if (num <= 1) {
            return false;
        } else if (num == 2) {
            return true;
        } else if (num % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i <= Math.sqrt(num); i += 2) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 标记数字是质数还是合数
     * 0：没有遍历到
     * 1：质数
     * 2：合数
     */
    public static boolean[] notPrime;
    public static Set<Integer> primes;

    static {
        notPrime = new boolean[1000001];
        primes = new TreeSet<>();
        // 埃氏筛
        for (int i = 2; i < 1000001; i++) {
            if (!notPrime[i]) {
                primes.add(i);
                long m = (long) i * i;
                while (m < 1000001) {
                    notPrime[(int) m] = true;
                    m += i;
                }
            }
        }
    }

    public List<List<Integer>> findPrimePairs(int n) {
        if (n < 4) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int x : primes) {
            int y = n - x;
            if (y < x) break;
            if (!notPrime[y]) {
                List<Integer> pair = Stream.of(x, y).collect(Collectors.toList());
                ans.add(pair);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution06916 solution06916 = new Solution06916();
        solution06916.findPrimePairs(10);
    }
}
