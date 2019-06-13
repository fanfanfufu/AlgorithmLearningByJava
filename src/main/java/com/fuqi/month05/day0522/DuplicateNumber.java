package com.fuqi.month05.day0522;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Description:
 * @Author 傅琦
 * @Date 2019/5/22 15:08
 * @Version V1.0
 */
public class DuplicateNumber {

    public static void main(String[] args){
        int[] numbers = {2,4,2,1,4};
        int len = numbers.length;
        int[] duplication = new int[1];
        DuplicateNumber duplicateNumber = new DuplicateNumber();
        boolean res = duplicateNumber.duplicate(numbers, len, duplication);
        System.out.println("result is: " + res);
    }

    public boolean duplicate(int[] numbers, int length, int[] duplication){
        if (numbers == null || length < 2){
            duplication = null;
            return false;
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int number: numbers) {
            if (!(list1.contains(number))){
                list1.add(number);
            }else {
                list2.add(number);
            }
        }

        if (list2.size() == 0){
            return false;
        }else {
            Random random = new Random();
            int index = random.nextInt(list2.size());
            duplication[0] = list2.get(index);
            System.out.println(duplication[0]);
            return true;
        }
    }

    /**
     * 该函数只是找到第一个重复的数字
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate2(int[] numbers, int length, int[] duplication){
        if (numbers == null || length < 2){
            duplication = null;
            return false;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int number: numbers) {
            if (!(list.contains(number))){
                list.add(number);
            }else {
                duplication[0] = number;
                return true;
            }
        }
        return false;
    }
}
