package com.fuqi.day0522;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Description: 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *               如果当前字符流没有存在出现一次的字符，返回#字符。
 * @Author 傅琦
 * @Date 2019/5/22 21:17
 * @Version V1.0
 */
public class FirstAppearingChar {

    HashMap<Character, Integer> map=new HashMap();
    ArrayList<Character> list=new ArrayList<>();

    /**
     * 使用一个HashMap来统计字符出现的次数，同时用一个ArrayList来记录输入流，
     * 每次返回第一个出现一次的字符都是在这个ArrayList（输入流）中的字符作为key去map中查找。
     * @param ch
     */
    // Insert one char from stringstream
    public void insert(char ch)
    {
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }else{
            map.put(ch,1);
        }

        list.add(ch);
    }

    // return the first appearence once char in current stringstream
    public char firstAppearingOnce()
    {
        char c='#';
        for(char key : list){
            if(map.get(key)==1){
                c=key;
                break;
            }
        }

        return c;
    }
}
