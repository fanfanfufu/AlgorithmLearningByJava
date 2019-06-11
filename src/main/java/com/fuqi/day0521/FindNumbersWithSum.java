package com.fuqi.day0521;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Description: 求出和为S的两个数字
 * 对应每个测试案例，输出两个数，小的先输出。
 * @Author 傅琦
 * @Date 2019/5/21 14:41
 * @Version V1.0
 */
public class FindNumbersWithSum {

    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int sum = 21;

        FindNumbersWithSum findNumbersWithSum = new FindNumbersWithSum();
        ArrayList<Integer> result = findNumbersWithSum.findNumbersWithSum(array, sum);
        System.out.println(result);
    }

    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int diff = sum - array[i];
            for (int j = i+1; j < array.length; j++) {
                ArrayList<Integer> temp = new ArrayList<>();
                if (array[j] == diff){
                    if (array[i] < array[j]){
                        temp.add(array[i]);
                        temp.add(array[j]);
                    }else {
                        temp.add(array[j]);
                        temp.add(array[i]);
                    }
                    arrayLists.add(temp);
                }
            }
        }

        System.out.println(arrayLists);
        System.out.println("==========================================");

        if (arrayLists.size() == 0){
            return new ArrayList<>();
        }else {
            Collections.sort(arrayLists, new Comparator<ArrayList<Integer>>() {
                @Override
                public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
                    int res1 = list1.get(0) * list1.get(1);
                    int res2 = list2.get(0) * list2.get(1);
                    return Integer.compare(res1, res2);
                }
            });

            System.out.println(arrayLists);

            return arrayLists.get(0);
        }
    }
}
