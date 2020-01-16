package com.fuqi.year2019.month08.theswordreferstooffer;

/**
 * @Description: 旋转数组的最小数字
 * @Author 傅琦
 * @date 2019/8/8 10:50
 * @Version V1.0
 */
public class Solution06 {
    public int minNumberInRotateArray(int [] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]){
                return array[i];
            }
        }
        return array[0];
    }

    public static void main(String[] args) {
        Solution06 solution06 = new Solution06();
        int[] input = {1,2,3,4,5};
        int res = solution06.minNumberInRotateArray(input);
        System.out.println("res = " + res);
    }
}
