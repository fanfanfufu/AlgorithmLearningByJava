package com.fuqi.year2022.month01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author FuQi
 * @date 2022/1/23 22:02
 * @description 三数之和：相向双指针
 */
public class Solution00015 {
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 排除极端情况
        if (nums == null || nums.length < 3) {
            return ans;
        }
        // 排序
        Arrays.sort(nums);
        int len = nums.length;
        // 再排除极端情况
        if (nums[0] > 0 || nums[len-1] < 0) {
            return ans;
        }
        // 遍历，再在当前元素之后的区间中寻找满足条件的另外两个数，要注意去重
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                // 如果当前数大于0，则后面比它大的数与之无法组成为0的组合，因此后续无需再遍历
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                // 这里需要去重
                continue;
            }
            int left = i+1;
            int right = len-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Stream.of(nums[i], nums[left], nums[right]).collect(Collectors.toList()));
                    // 去重操作
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else R--;
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int n = nums.length;
        if (n < 3) return ans;
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[n-1] < 0) return ans;
        for (int i = 0; i < n-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int x = nums[i];
            // 如果当前数与之后的最小的两个数之和大于0，则往后的三数之和都是大于0的，因此直接中止循环
            if (x + nums[i+1] + nums[i+2] > 0) break;
            // 如果当前数与之后的最大的两个数之和小于0，则往后的三数之后都是小于0的，因此需要遍历下一个数
            if (x + nums[n-1] + nums[n-2] < 0) continue;
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = x + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Stream.of(nums[i], nums[left], nums[right]).collect(Collectors.toList()));
                    left++;
                    while (left < right && nums[left] == nums[left-1]) left++;
                    right--;
                    while (left < right && nums[right] == nums[right+1]) right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(threeSum2(new int[]{-1,0,1,2,-1,-4}));
    }
}
