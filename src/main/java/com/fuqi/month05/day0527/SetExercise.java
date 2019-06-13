package com.fuqi.month05.day0527;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: Set练习
 * @Author 傅琦
 * @Date 2019/5/27 10:28
 * @Version V1.0
 */
public class SetExercise {
    public static void main(String[] args){
        Set<Character> characters = new HashSet<>();
        characters.add('a');
        characters.add('n');
        characters.add('v');
        characters.add('i');
        characters.add('a');
        characters.add('j');
        System.out.println(characters);
    }
}
