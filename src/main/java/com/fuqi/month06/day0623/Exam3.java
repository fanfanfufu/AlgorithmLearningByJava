package com.fuqi.month06.day0623;

/**
 * @Description:
 * @Author: 傅琦
 * @DateTime: 2019/6/23 11:18
 * @Version: V1.0
 */
public class Exam3 {
    /**
     * 暴力解法
     * @param target
     * @param mountainArr
     * @return
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int i = 0;
        int len = mountainArr.length();
        while (i < len){
            if (mountainArr.get(i) == target){
                return i;
            }
            i++;
        }
        return -1;
    }
}

interface MountainArray {
    public int get(int index);
    public int length();
}
