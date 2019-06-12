package com.fuqi.listlearn;

import java.util.ArrayList;

/**
 * @Description:
 * @Author 傅琦
 * @Date 2019/5/29 8:55
 * @Version V1.0
 */
public class ArrayListLearn {
    public static void main(String[] args){
        ArrayList<Integer> integers = new ArrayList<>(5);
        System.out.println(integers);

        ArrayList<String> strings = new ArrayList<>(3);
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        System.out.println(strings.remove(2));
    }
}
