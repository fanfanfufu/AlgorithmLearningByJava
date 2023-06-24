package com.fuqi.year2023.month06;

import java.util.Arrays;
import java.util.Scanner;

public class Solution062401 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] heights = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        in.close();
        System.out.println(getMaxArea(heights));
    }

    public static long getMaxArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0L;
        int left = 0, right = heights.length - 1;
        long ans = 0;
        while (left < right) {
            int len = right - left;
            int height = Math.min(heights[left], heights[right]);
            long curArea = (long) len * height;
            ans = Math.max(curArea, ans);
            if (heights[left] > heights[right]) {
                right--;
            } else if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
                left++;
            }
        }

        return ans;
    }
}
