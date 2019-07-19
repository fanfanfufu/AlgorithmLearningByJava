package com.fuqi.maplearn;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author 傅琦
 * @date 2019/7/10 15:10
 * @Version V1.0
 */
public class HashMapTest1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("张三", 20);
        map.put("李四", 20);
        map.put("李四", 25);
        System.out.println("map = " + map);

        Map<String, Integer> map2 = new HashMap<>(map);
        System.out.println("map2 = " + map2);
    }
}
