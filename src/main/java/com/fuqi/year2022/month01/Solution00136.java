package com.fuqi.year2022.month01;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author FuQi
 * @date 2022/1/17 23:08
 * @description
 */
public class Solution00136 {
    public static int singleNumber1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int i = 0, j = len-1;
        while (i < j) {
            if (nums[i] == nums[j]) {
                // 如果刚好相等，则i,j相向而行
                i++;
                j--;
                continue;
            }
            // 不相等的话，则j往前移动
            int k = j-1;
            while (k > i) {
                if (nums[k] == nums[i]) {
                    // 如果找到与i出元素相等的元素，进行数据交换
                    int temp = nums[k];
                    nums[k] = nums[len-1-i];
                    nums[len-1-i] = temp;
                    break;
                }
                k--;
            }
            if (k == i) {
                return nums[i];
            }
            i++;
            j = len-1-i;
        }

        return nums[len/2];
    }

    public static int singleNumber2(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            if (numCount.containsKey(num)) {
                numCount.put(num, 2);
            } else {
                numCount.put(num, 1);
            }
        }
        for (Integer num : numCount.keySet()) {
            if (numCount.get(num) == 2) {
                continue;
            }
            return num;
        }

        return 0;
    }

    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            // 一直异或操作，因为只有一个单一的数，最终就会恢复到唯一的那个数
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println("res = " + singleNumber(nums));

        System.out.println("1 异或 1 = " + (1 ^ 1));
        System.out.println("1 异或 0 = " + (1 ^ 0));
        System.out.println("2 异或 2 = " + (2 ^ 2));
        System.out.println("2 异或 3 = " + (2 ^ 3));
        System.out.println("1 异或 7 = " + (1 ^ 7));
        System.out.println("3 异或 7 = " + (3 ^ 7));
    }
}
