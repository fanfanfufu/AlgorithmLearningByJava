package com.fuqi.month11.day1121;

import java.util.Arrays;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/11/22 10:22
 * @Version: V1.0
 */
public class LeetCode923 {
    /**
     * 方法一：三指针法
     * @param A
     * @param target
     * @return
     */
    public int threeSumMulti1(int[] A, int target) {
        int MOD = 1_000_000_007;
        long ans = 0;
        Arrays.sort(A);

        for (int i = 0; i < A.length; ++i) {

            // 先求出减掉当前数所剩，那么问题可以化为求两数之和（和为target-A[i]）
            int T = target - A[i];
            int j = i+1, k = A.length - 1;

            while (j < k) {
                // These steps proceed as in a typical two-sum.
                if (A[j] + A[k] < T) {
                    j++;
                }
                else if (A[j] + A[k] > T) {
                    k--;
                }
                else if (A[j] != A[k]) {
                    // 此时A[j] + A[k] == T.
                    // 因为此时找到的是第一组满足条件的数，中间可能会存在与之相同的数，因此需要做统计
                    // 统计left指针右边有多少个与之相同的数 the number of A[j] == A[j+1] == A[j+2] == ...
                    int left = 1, right = 1;
                    while (j+1 < k && A[j] == A[j+1]) {
                        left++;
                        j++;
                    }
                    // 统计right指针左边有多少个与之相同的数 the number of A[k] == A[k-1] == A[k-2] == ...
                    while (k-1 > j && A[k] == A[k-1]) {
                        right++;
                        k--;
                    }

                    // 记录情况数，并统计
                    ans += left * right;
                    ans %= MOD;
                    j++;
                    k--;
                } else {
                    // 在特殊情况下，如果 A[j] == A[k]，比如最后剩下的 [4,4,4]，这里有 3 对。
                    // 一般情况下，如果 A[j] == A[k]，
                    // 对 (j,k)（满足 j < k 且 A[j] + A[k] == T），则可通过 M * (M-1) / 2 pairs来计算。
                    ans += (k-j+1) * (k-j) / 2;
                    ans %= MOD;
                    break;
                }
            }
        }

        return (int) ans;
    }

    /**
     * 数学公式法
     * @param A
     * @param target
     * @return
     */
    public int threeSumMulti2(int[] A, int target) {
        int MOD = 1_000_000_007;
        long[] count = new long[101];
        for (int x: A)
            count[x]++;

        long ans = 0;

        // All different
        for (int x = 0; x <= 100; ++x)
            for (int y = x+1; y <= 100; ++y) {
                int z = target - x - y;
                if (y < z && z <= 100) {
                    ans += count[x] * count[y] * count[z];
                    ans %= MOD;
                }
            }

        // x == y != z
        for (int x = 0; x <= 100; ++x) {
            int z = target - 2*x;
            if (x < z && z <= 100) {
                ans += count[x] * (count[x] - 1) / 2 * count[z];
                ans %= MOD;
            }
        }

        // x != y == z
        for (int x = 0; x <= 100; ++x) {
            if (target % 2 == x % 2) {
                int y = (target - x) / 2;
                if (x < y && y <= 100) {
                    ans += count[x] * count[y] * (count[y] - 1) / 2;
                    ans %= MOD;
                }
            }
        }

        // x == y == z
        if (target % 3 == 0) {
            int x = target / 3;
            if (0 <= x && x <= 100) {
                ans += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
                ans %= MOD;
            }
        }

        return (int) ans;
    }

    /**
     * 方法三：变种的三数之和
     * @param A
     * @param target
     * @return
     */
    public int threeSumMulti3(int[] A, int target) {
        int MOD = 1_000_000_007;

        // Initializing as long saves us the trouble of
        // managing count[x] * count[y] * count[z] overflowing later.
        long[] count = new long[101];
        int uniq = 0;
        for (int x: A) {
            count[x]++;
            if (count[x] == 1)
                uniq++;
        }

        int[] keys = new int[uniq];
        int t = 0;
        for (int i = 0; i <= 100; ++i)
            if (count[i] > 0)
                keys[t++] = i;

        long ans = 0;
        // Now, let's do a 3sum on "keys", for i <= j <= k.
        // We will use count to add the correct contribution to ans.

        for (int i = 0; i < keys.length; ++i) {
            int x = keys[i];
            int T = target - x;
            int j = i, k = keys.length - 1;
            while (j <= k) {
                int y = keys[j], z = keys[k];
                if (y + z < T) {
                    j++;
                } else if (y + z > T) {
                    k--;
                } else {  // # x+y+z == T, now calc the size of the contribution
                    if (i < j && j < k) {
                        ans += count[x] * count[y] * count[z];
                    } else if (i == j && j < k) {
                        ans += count[x] * (count[x] - 1) / 2 * count[z];
                    } else if (i < j && j == k) {
                        ans += count[x] * count[y] * (count[y] - 1) / 2;
                    } else {  // i == j == k
                        ans += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
                    }

                    ans %= MOD;
                    j++;
                    k--;
                }
            }
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        LeetCode923 leetCode923 = new LeetCode923();
        int[] input = new int[]{1,1,2,2,3,3,4,4,5,5};
        int target = 8;
        int res = leetCode923.threeSumMulti1(input, target);
        System.out.println(res);
    }
}
