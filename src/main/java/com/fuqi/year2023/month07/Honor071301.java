package com.fuqi.year2023.month07;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 两数之和：
 * 输入一个已经升序排列的数组和一个target
 * 找出第一对和为target的数
 */
public class Honor071301 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        if (line1 == null || line1.length() == 0) {
            System.out.println("0 0 0");
            in.close();
            return;
        }
        int[] nums = Arrays.stream(line1.split(" ")).filter(str -> str.length() != 0).mapToInt(Integer::parseInt).toArray();

        int target = Integer.parseInt(in.nextLine());
        in.close();
        findSumTargetFirstPair(nums, target);
    }

    private static void findSumTargetFirstPair(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            System.out.println("0 0 0");
            return;
        }
        int n = nums.length;
        if (nums[0] >= target) {
            System.out.println("0 0 0");
            return;
        }
        if ((nums[0] + nums[1] > target) || (nums[n-2] + nums[n-1] < target)) {
            System.out.println("0 0 0");
            return;
        }
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
                continue;
            }
            if (sum < target) {
                left++;
                continue;
            }
            // sum == target
            System.out.println("1 " + nums[left] + " " + nums[right]);
            return;
        }
        // 便利结束都没有找到的话，输出没有找到的应有内容
        System.out.println("0 0 0");
    }
}
