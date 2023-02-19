package com.fuqi.year2023.month02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FuQi
 * @date 2023/2/19 10:44
 * @description
 */
public class Solution06362 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0;
        List<int[]> sumList = new ArrayList<>(nums1.length + nums2.length);
        while (i < nums1.length || j < nums2.length) {
            if (i >= nums1.length) {
                sumList.add(nums2[j]);
                j++;
                continue;
            }
            if (j >= nums2.length) {
                sumList.add(nums1[i]);
                i++;
                continue;
            }
             if (nums1[i][0] > nums2[j][0]) {
                sumList.add(nums2[j]);
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                sumList.add(nums1[i]);
                i++;
            } else {
                sumList.add(new int[]{nums1[i][0], nums1[i][1]+nums2[j][1]});
                i++;
                j++;
            }
        }

        int[][] ans = new int[sumList.size()][2];
        for (int k = 0; k < sumList.size(); k++) {
            ans[k] = sumList.get(k);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution06362 solution06362 = new Solution06362();
        int[][] nums1 = new int[][]{{1,2},{2,3},{4,5}};
        int[][] nums2 = new int[][]{{1,4},{3,2},{4,1}};
        solution06362.mergeArrays(nums1, nums2);
        System.out.println();
    }
}
