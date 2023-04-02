package com.fuqi.year2023.month04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author fanfanfufu
 * @version 1.0
 * @date 2023/4/2 10:59
 * @description
 */
public class Solution06363 {
    public List<List<Integer>> findMatrix(int[] nums) {
        if (nums.length == 1) {
            List<Integer> row = Stream.of(nums[0]).collect(Collectors.toList());
            return Stream.of(row).collect(Collectors.toList());
        }
        Map<Integer, Long> countMap = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, Long> entry : countMap.entrySet()) {
            Long count = entry.getValue();
            Integer num = entry.getKey();
            int curSize = ans.size();
            if (curSize == 0) {
                for (int i = 0; i < count; i++) {
                    List<Integer> row = new ArrayList<>();
                    row.add(num);
                    ans.add(row);
                }
                continue;
            }
            if (curSize > count) {
                for (int i = 0; i < count; i++) {
                    ans.get(i).add(num);
                }
                continue;
            }
            // size <= count
            // 1. 先对原来的每一行添加当前的num
            for (List<Integer> row : ans) {
                row.add(num);
            }
            // 2. 再创建新的行，并添加当前的num
            for (int i = 0; i < count - curSize; i++) {
                List<Integer> row = new ArrayList<>();
                row.add(num);
                ans.add(row);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution06363 solution06363 = new Solution06363();
        int[] nums = {9,8,8,4,9,8,8,3,9};
        solution06363.findMatrix(nums);
    }
}
