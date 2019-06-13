package com.fuqi.month05.day0524;

import java.util.Stack;

/**
 * @Description: 栈操作练习
 * @Author 傅琦
 * @Date 2019/5/24 10:57
 * @Version V1.0
 */
public class StackExercise {
    public static void main(String[] args){
        Stack<Stack<Integer>> result = new Stack<>();
        Stack<Integer> integerStack = new Stack<>();
        integerStack.add(1);
        integerStack.add(2);
        integerStack.add(3);
        result.add(integerStack);
        int number = integerStack.pop();
        int number1 = integerStack.pop();
        int number2 = integerStack.pop();
        System.out.println(result);
        System.out.println(result.isEmpty());
    }
}
