package com.fuqi.year2023.month05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/5/14 22:46
 * @description 与对应负数同时存在的最大正整数
 */
public class Solution02441 {
    public int findMaxK(int[] nums) {
        int ans = -1;
        Map<Integer, Boolean> numMap = new HashMap<>();
        for (int num : nums) {
            // 取当前数的正负反号的数
            int reverse = -num;
            // 判断反数是否包含在之前遍历过的数字中
            if (numMap.containsKey(reverse)) {
                ans = Math.max(ans, Math.abs(num));
            }
            numMap.put(num, true);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution02441 solution02441 = new Solution02441();
        int[] nums = new int[]{-1,10,6,7,-7,1};
        solution02441.findMaxK(nums);
    }
}
