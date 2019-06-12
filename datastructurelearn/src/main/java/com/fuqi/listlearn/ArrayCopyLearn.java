package com.fuqi.listlearn;

/**
 * @Description: 数组复制函数的练习
 * @Author 傅琦
 * @Date 2019/5/29 9:38
 * @Version V1.0
 */
public class ArrayCopyLearn {
    public static void main(String[] args){
        Integer[] ints = {1,2,3,4,5,6,7,8,9};
        System.arraycopy(ints, 5, ints, 4, 4);
        ints[8] = null;
        System.out.println(ints.length);
    }
}
