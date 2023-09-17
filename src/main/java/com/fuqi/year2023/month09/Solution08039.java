package com.fuqi.year2023.month09;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/9/16 22:31
 * @description
 */
public class Solution08039 {
    public int minimumRightShifts(List<Integer> nums) {
        if (nums.size() == 1) return 0;
        int n = nums.size();

        // 最多右移n次
        for (int i = 0; i <= n; i++) {
            if (check(nums)) {
                return i;
            }
            rightShifts(nums);
        }

        return -1;
    }

    private void rightShifts(List<Integer> nums) {
        Integer lastNum = nums.get(nums.size() - 1);
        nums.remove(nums.size()-1);
        nums.add(0, lastNum);
    }

    private boolean check(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i-1)) continue;
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution08039 solution08039 = new Solution08039();
        List<Integer> list = Stream.of(5, 4, 3, 2, 1).collect(Collectors.toList());
        solution08039.minimumRightShifts(list);
    }
}
