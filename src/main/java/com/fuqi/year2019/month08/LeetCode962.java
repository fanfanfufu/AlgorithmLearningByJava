package com.fuqi.year2019.month08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/8/26 15:25
 * @Version V1.0
 */
public class LeetCode962 {
    private static int helper1(int[] A) {
        int N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; i++) {
            B[i] = i;
        }

        Arrays.sort(B, (i, j) -> (((Integer) A[i]).compareTo(A[j])));

        int ans = 0;
        int m = N;
        for (int i : B) {
            ans = Math.max(ans, i-m);
            m = Math.min(m, i);
        }

        return ans;
    }

    private static int helper(int[] A) {
        int i = A.length - 1;
        while (i > 0){
            int left = 0;
            int right = i;

            while (right < A.length) {
                if (A[left] <= A[right]){
                    return right - left;
                } else {
                    left++;
                    right++;
                }
            }

            i--;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        System.out.println(helper(A));

        scanner.close();
    }
}
