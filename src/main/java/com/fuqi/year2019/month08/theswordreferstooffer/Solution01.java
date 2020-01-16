package com.fuqi.year2019.month08.theswordreferstooffer;

/**
 * @Description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Author 傅琦
 * @date 2019/8/6 9:47
 * @Version V1.0
 */
public class Solution01 {
    /**
     * 方法一：逐行二分查找
     * 时间复杂度 O(nlogn)
     * @param target
     * @param array
     * @return Boolean
     */
    public boolean find1(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0){
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            int low = 0;
            int high = array[i].length - 1;
            int middle = 0;
            while (low <= high){
                middle = (low + high) / 2;
                if (array[i][middle] > target){
                    high = middle - 1;
                }else if (array[i][middle] < target){
                    low = middle + 1;
                }else {
                    return true;
                }
            }
        }

        return false;

    }

    /**
     * 方法二：从左上角或者右下角，这里选择从右下角开始搜索
     * 若目标大于当前数，则往下搜索，行数+1
     * 若目标小于当前数，则往左搜索，列数-1
     * 直到越界，没有搜索到则返回false
     * @param target
     * @param array
     * @return boolean
     */
    public static boolean find2(int target, int[][] array){
        if (array == null || array.length == 0 || array[0].length == 0){
            return false;
        }

        int row = 0;
        int col = array[0].length - 1;
        while (row < array.length && col >= 0){
            if (target == array[row][col]){
                return true;
            }else if (target > array[row][col]){
                row++;
            }else {
                col--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
        int target = 7;
        Solution01 solution01 = new Solution01();
//        boolean res = solution01.find1(target, array);
        boolean res = find2(target, array);
        System.out.println("res = " + res);
    }
}
