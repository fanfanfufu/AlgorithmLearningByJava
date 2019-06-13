package com.fuqi.month06.day0613;

/**
 * @Description: 给出个整型数组，每个数对应的值可以理解为高度，求两个数之间所能容下的最大容量。相邻两数之间的长度为单位长度1。
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49(7*7)
 *
 * @Author 傅琦
 * @Date 2019/6/13 9:44
 * @Version V1.0
 */
public class ContainerWithMostWater {
    private static int maxArea(int[] height){
        if (height == null || height.length < 2){
            return 0;
        }

        int maxCapacity = 0;
        // 方法一：暴力解法
//        for (int i = 0; i < height.length-1; i++) {
//            int leftHeight = height[i];
//            for (int j = i+1; j < height.length; j++) {
//                int rightHeight = height[j];
//                int len = j-i;
//                int tempCapacity = len * Math.min(leftHeight, rightHeight);
//                maxCapacity = maxCapacity > tempCapacity ? maxCapacity : tempCapacity;
//            }
//        }
        // 方法二：双指针法
        int left = 0;
        int right = height.length-1;
        while (left < right){
            int tempCapacity = (right - left) * Math.min(height[left], height[right]);
            maxCapacity = maxCapacity > tempCapacity ? maxCapacity : tempCapacity;
            if (height[left] > height[right]){
                right--;
            }else {
                left++;
            }
        }

        return maxCapacity;
    }

    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        int res = maxArea(height);
        System.out.println(res);
    }
}
