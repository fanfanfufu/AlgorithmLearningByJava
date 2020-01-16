package com.fuqi.year2019.month08.zhongxing;

import java.util.*;

/**
 * @Description:
 * @Author 傅琦
 * @date 2019/8/16 19:55
 * @Version V1.0
 */
public class Main1 {
    List<Integer> salaryFrequency(int num, int[] salaries){
        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < salaries.length; i++){
            if(!map.containsKey(salaries[i])){
                map.put(salaries[i], new int[]{salaries[i], i, 0});
            }
            map.get(salaries[i])[2] ++;
        }
        List<int[]> list = new ArrayList<>();
        list.addAll(map.values());
        Collections.sort(list, (i1, i2) -> {
            if(i1[2] != i2[2]) {
                return i2[2] - i1[2];
            }
            return i1[1] - i2[1];
        });
        List<Integer> res = new ArrayList<>();
        for(int[] arr : list){
            for(int j = 0; j < arr[2]; j++) {
                res.add(arr[0]);
            }
        }
        return res;
    }
}
