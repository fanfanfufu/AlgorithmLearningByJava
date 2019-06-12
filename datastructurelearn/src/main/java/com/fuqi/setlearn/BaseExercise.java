package com.fuqi.setlearn;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author 傅琦
 * @Date 2019/5/28 15:46
 * @Version V1.0
 */
public class BaseExercise {
    public static void main(String[] args){
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(1);
        System.out.println(integers);
    }
}
