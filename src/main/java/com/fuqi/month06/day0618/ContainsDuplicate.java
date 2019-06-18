package com.fuqi.month06.day0618;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 判断数组中是否有重复数字，有就返回true，没有则返回false
 * @Team 电子科技大学自动化研究所
 * @Author 傅琦
 * @Date 2019/6/18 11:07
 * @Version V1.0
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])){
                set.add(nums[i]);
            }else {
                return true;
            }
        }
        return false;
    }
}
