package com.fuqi.year2023.month02;

/**
 * @author FuQi
 * @date 2023/2/18 23:24
 * @description 会运算无法表达的最小数
 */
public class Solution06360 {
    public int minImpossibleOR(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] == 1 ? 2 : 1;

        int[] bitRecord = new int[32];
        for (int num : nums) {
            int bitLen = Integer.toBinaryString(num).length();
            if (num == (1 << (bitLen-1))) {
                // 如果num刚好是2的幂次，那么说明num是一个可达的数
                bitRecord[bitLen-1] = 1;
            }
            // 这种方式也能够判断num是否等于2的幂次
//            if ((num & (num-1)) == 0) bitRecord[bitLen-1] = 1;
        }

        for (int i = 0; i < bitRecord.length; i++) {
            if (bitRecord[i] == 1) continue;
            return 1 << i;
        }

        return 1;
    }

    /**
     * 优化空间复杂度
     *
     * @param nums
     * @return
     */
    public int minImpossibleOR2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] == 1 ? 2 : 1;

        int mask = 0;
        for (int num : nums) {
            // 满足这个条件的，说明num是2的幂次
            if ((num & (num-1)) == 0) mask |= num;
        }
        // 对mask进行取反
        mask = ~mask;

        return mask & -mask;
    }

    public static void main(String[] args) {
        Solution06360 solution06360 = new Solution06360();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        System.out.println(solution06360.minImpossibleOR(nums));;

        int mask = 23;
        System.out.println(Integer.toBinaryString(mask));
        System.out.println(Integer.toBinaryString(~mask));
        System.out.println(Integer.toBinaryString(-mask));
        System.out.println((~mask) & -(~mask));
    }
}
