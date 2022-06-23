package com.fuqi.year2022.month06;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author FuQi
 * @date 2022/6/22 21:44
 * @description x的平方根，采用二分法
 */
public class Solution00069 {
    public int mySqrt(int x) {
        if (x < 0) {
            return 0;
        }
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 0, right = x, ans = -1;
        while (left < right) {
            int mid = (left + right) / 2;
            if ((long) mid * mid > x) {
                right = mid;
            } else {
                left = mid+1;
                ans = mid;
            }
        }

        return ans;
    }

    /**
     * 牛顿迭代法
     *
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x < 0) {
            return 0;
        }
        if (x == 0 || x == 1) {
            return x;
        }
        double x0 = x;
        while (true) {
            double xi = (x0 + x/x0) * 0.5;
            if ((x0-xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }

        return (int) x0;
    }

    public static String maxNum (int[] source, String limit) {
        // 仅考虑输入是正常数据的时候
        // 1. 对source排序
        Arrays.sort(source);
        // 2. 构造一个记录构造出的每位取source下标的数组
        int[] ans = new int[limit.length()];
        for (int i = 0; i < limit.length(); i++) {
            int target = limit.charAt(i) - '0';
            // 使用二分查找source中不超过并且最接近当前数的数的下标
            int index = binarySearch(source, target);
            if (index == -1) {
                // target小于source中的任何一个
                // 往前回溯
                if (i == 0) {
                    // 在第一位遇到这种情况
                    Arrays.fill(ans, source.length-1);
                    ans[0] = -1;
                    break;
                }
                for (int j = i-1; j >= 0; j--) {
                    if (ans[j] > 0) {
                        ans[j]--;
                        break;
                    }
                    if (ans[j] == 0) {
                        ans[j] = source.length-1;
                        if (j == 0) {
                            ans[j] = -1;
                        }
                    }
                }
                ans[i] = source.length-1;
            }
            if (source[index] == target) {
                // 如果刚好找到相等的，则将下标放入
                ans[i] = index;
                continue;
            }
            // target大于source中的任何一个
            ans[i] = source.length-1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            if (i == 0 && ans[i] == -1) {
                continue;
            }
            sb.append(source[ans[i]]);
        }

        return sb.toString();
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int ans = -1;
        if (target < nums[0]) {
            return -1;
        }
        if (target > nums[right]) {
            return nums.length;
        }
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = nums[mid];
            if (target <= midVal) {
                ans = mid;
                right = mid-1;
            } else if (target > mid) {
                left = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,4,5};
        int target = 9;
        System.out.println(binarySearch(nums, target));
    }
}
