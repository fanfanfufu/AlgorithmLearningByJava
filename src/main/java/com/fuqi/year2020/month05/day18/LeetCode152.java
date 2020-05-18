package com.fuqi.year2020.month05.day18;

/**
 * @Description: 乘积最大的子数组
 * @Author 傅琦
 * @date 2020/5/18 10:50
 * @Version V1.0
 */
public class LeetCode152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0){ return 0; }
        if (nums.length == 1){ return nums[0]; }
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode152 leetCode152 = new LeetCode152();
        int[] nums = new int[]{2,3,0,4,5,2,-3};
        System.out.println(leetCode152.maxProduct(nums));
    }
}
