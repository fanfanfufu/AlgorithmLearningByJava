package com.fuqi.year2023.month06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/6/7 00:11
 * @description
 */
public class HuaWei0005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        in.nextLine();
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(findMaxMatchIndex(nums, target));
    }

    public static int findMaxMatchIndex(int[] nums, int target) {
        int maxVal = Integer.MIN_VALUE;
        int midDist = 0;
        int ansIndex = -1;
        int count = nums.length;
        for (int i = 0; i < count; i++) {
            if (nums[i] == 0) {
                int left = i-1, right = i+1;
                int leftCount = 0, rightCount = 0;
                while (left >= 0 && nums[left] == target && leftCount < maxVal - 1) {
                    leftCount++;
                    left--;
                }

                if (leftCount > 4) continue;

                rightCount = leftCount;
                while (right < count && nums[right] == target && rightCount < maxVal - 1) {
                    rightCount++;
                    right++;
                }

                int totalCount = leftCount + rightCount;
                int distToMid = Math.abs(i - count/2);
                if (totalCount > maxVal || (totalCount == maxVal && distToMid < midDist)) {
                    maxVal = totalCount;
                    ansIndex = i;
                    midDist = distToMid;
                }
            }
        }

        return ansIndex;
    }
}
