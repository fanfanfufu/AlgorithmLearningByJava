package com.fuqi.year2022.month10;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author FuQi
 * @date 2022/10/18 23:17
 * @description
 */
public class Solution00179 {
    public static void main(String[] args) {
        int[] arr = new int[]{30, 34, 12, 9, 6, 65, 22, 23, 21};

        Solution00179 solution00179 = new Solution00179();
        Assertions.assertEquals("9665343023222112", solution00179.largestNumber(arr));
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        List<String> numSortedList = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((num1, num2) -> (num2 + num1).compareTo(num1 + num2))
                .collect(Collectors.toList());
        if (numSortedList.get(0).equals("0")) {
            return "0";
        }

        return String.join("", numSortedList);
    }
}
