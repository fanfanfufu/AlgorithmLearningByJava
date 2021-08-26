package com.fuqi.year2021.month08.day20210826;

/**
 * @author FuQi
 */
public class Solution167 {
    /**
     * 暴力解法：O(n^n)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        int[] ans = new int[2];
        int i = 0;
        while (i < numbers.length - 1) {
            for (int j = 0; j < numbers.length; j++) {
                if (target == numbers[i] + numbers[j]) {
                    ans[1] = j+1;
                    break;
                }
            }
            if (ans[1] != 0) {
                ans[0] = i+1;
                break;
            }
            i++;
        }

        return ans;
    }

    /**
     * 优化:  二分查找 O(nlogn)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int another = target - numbers[i];
            int left = i+1, right = numbers.length;
            int j = findAnother(left, right, numbers, another);
            if (j != 0) {
                ans[0] = i + 1;
                ans[1] = j + 1;
            }
        }

        return ans;
    }

    private int findAnother(int left, int right, int[] nums, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return 0;
    }

    /**
     * 再优化：双指针O(n)
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum3(int[] numbers, int target) {
        int[] ans = new int[2];
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                ans[0] = i+1;
                ans[1] = j+1;
                return ans;
            }
            if (sum < target) {
                i++;
                continue;
            }
            j--;
        }

        return ans;
    }
}
