package com.fuqi.day0520;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Description: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 * @Author 傅琦
 * @Date 2019/5/20 21:10
 * @Version V1.0
 */
public class FindNumsAppearOnce {

    public static void main(String[] args){
        int[] array = {2,4,3,6,3,2,5,5};
        int num1[] = new int[1];
        int num2[] = new int[1];

        FindNumsAppearOnce fnao = new FindNumsAppearOnce();
        fnao.findNumsAppearOnce(array, num1, num2);
    }

    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]){

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < array.length; i++){
            if(!hm.containsKey(array[i])){
                hm.put(array[i], 1);
            }else{
                hm.remove(array[i]);
            }
        }

        ArrayList<Integer> al = new ArrayList<>();
        al.addAll(hm.keySet());

        num1[0] = al.get(0);
        num2[0] = al.get(1);

        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
