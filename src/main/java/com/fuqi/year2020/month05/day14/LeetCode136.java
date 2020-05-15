package com.fuqi.year2020.month05.day14;

/**
 * @Description: 只出现一次的数字
 * @Author 傅琦
 * @date 2020/5/14 9:31
 * @Version V1.0
 */
public class LeetCode136 {
    public int singleNumber1(int[] nums){
        if (nums.length % 2 == 0){ return 0; }

        int i = 0, j = nums.length - 1, k = i+1;
        while (i < j){
            if (nums[i] == nums[j]){
                i++;
                j--;
                k = i+1;
            }else {
                while (k < j){
                    if (nums[i] == nums[k]){
                        int temp = nums[k];
                        nums[k] = nums[j];
                        nums[j] = temp;
                        break;
                    } else if (nums[k] == nums[j]) {
                        int temp = nums[k];
                        nums[k] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                    k++;
                }
            }
        }

        return nums[nums.length / 2];
    }

    public int singleNumber2(int[] nums) {
        int single = 0;
        for (int num :nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,3,1,2,2,4};
        LeetCode136 leetCode136 = new LeetCode136();
        System.out.println(leetCode136.singleNumber2(nums));
    }
}
