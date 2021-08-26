package com.fuqi.year2021.month08.day20210826;

/**
 * @author FuQi
 */
public class Solution283 {
    public static void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                i++;
                j++;
                continue;
            }
            while (i < nums.length) {
                if (nums[i] == 0) {
                    i++;
                    continue;
                }
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                break;
            }
            j++;
        }
        System.out.println("nums = " + nums.length);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,12};
        moveZeroes(nums);
    }
}
