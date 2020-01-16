package com.fuqi.year2019.month11.day1121;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: LeetCode第15题——三数之和
 *
 * 思路：
 *
 * 1. 首先对数组进行排序，排序后固定一个数 nums[i]，再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，
 *    计算三个数的和sum 判断是否满足为 0，满足则添加进结果集
 * 2. 如果 nums[i]大于 0，则三数之和必然无法等于 0，结束循环
 * 3. 如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
 * 4. 当 sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
 * 5. 当 sum == 0 时，nums[R] == nums[R-1] 则会导致结果重复，应该跳过，R--
 *
 * 6. 时间复杂度：O(n^2)，n为数组长度
 * @Author 傅琦
 * @date 2019/11/21 10:13
 * @Version V1.0
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len < 3){ return ans; }
        // 排序
        Arrays.sort(nums);
        //开始遍历
        for (int i = 0; i < len; i++) {
            // 如果当前数大于0，则当前数以及其后续的数都无法满足三数之和等于0，因此就可以跳出循环了
            if (nums[i] > 0){ break; }

            // 去重
            if (i > 0 && nums[i] == nums[i-1]) { continue; }
            int left = i+1;
            int right = len - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[left+1]) { left++; }
                    while (left < right && nums[right] == nums[right-1]) { right--; }
                    left++;
                    right--;
                }else if (sum < 0) {
                    left++;
                }else {
                    right--;
                }
            }
        }

        return ans;
    }
}
