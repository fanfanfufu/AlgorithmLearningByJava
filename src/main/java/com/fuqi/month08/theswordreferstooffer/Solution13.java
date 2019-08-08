package com.fuqi.month08.theswordreferstooffer;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/8 11:26
 * @Version V1.0
 */
public class Solution13 {
    public void reOrderArray(int [] array){
        // 要保证相对位置不变，则排序要保证稳定性
        // 利用插入排序的思想
        int n = array.length;
        int k = 0;
        for (int i = 0; i < n; i++) {
            // 扫描到当前数是奇数
            if (array[i] % 2 == 1){
                int j = i;
                while (j > k){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    j--;
                }
                k++;
            }
        }
    }
}
