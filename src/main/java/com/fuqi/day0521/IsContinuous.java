package com.fuqi.day0521;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Description: 判断一个数组中的所有数是否连续，是则输出true，不是则输出false。
 * 其中0，可以替代任意1-13的数字
 * @Author 傅琦
 * @Date 2019/5/21 19:28
 * @Version V1.0
 */
public class IsContinuous {

    public static void main(String args[]){
        int[] numbers = {0,3,1,6,4};
        IsContinuous isContinuous = new IsContinuous();
        boolean result = isContinuous.judgeContinuous(numbers);
        System.out.println(result);

    }

    public boolean judgeContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return false;
        }

        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int number: numbers) {
            if (number == 0){
                count++;
            }else {
                list.add(number);
            }
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer1, Integer integer2) {
                return integer1 - integer2;
            }
        });

        if (count == 0){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != list.get(0) + i){
                    return false;
                }
            }
            return true;
        }else if(count == 4){
            return true;
        }else{
            int sum = 0;
            for (int i = 1; i < list.size(); i++) {
                int diff = list.get(i) - list.get(i-1) - 1;
                sum += diff;
            }

            return sum == count;
        }
    }
}
