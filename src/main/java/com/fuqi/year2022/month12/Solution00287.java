package com.fuqi.year2022.month12;

/**
 * @author FuQi
 * @date 2022/12/29 22:19
 * @description 寻找重复数
 */
public class Solution00287 {
    /**
     * 因为题目给定的输入：
     * nums.length == n+1
     * 1 <= nums[i] <= n
     * 且只有一个整数会出现多次
     *
     * 所以可以考虑将 nums[nums[i]] = nums[i]，如果nums[nums[j]] == nums[j]
     * 那么则直接返回nums[j]
     *
     * 该方式违背了题目不能修改原数组的要求
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int ans = nums[0];
        for (int i = 0; i <= n; i++) {
            // 如果当前位置的元素值等于索引值，那么则跳过
            if (i == nums[i]) continue;
            while (nums[i] != (i+1)) {
                int temp = nums[nums[i]];
                // 如果此时nums[nums[i]] == temp，就说明
                if (temp == nums[i]) return temp;
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }

        return ans;
    }

    /**
     * 快慢指针法
     * 时间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                slow = 0;
                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }
    }
}
